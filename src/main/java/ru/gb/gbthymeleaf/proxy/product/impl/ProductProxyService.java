package ru.gb.gbthymeleaf.proxy.product.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.gb.gbthymeleaf.dao.ProductDao;
import ru.gb.gbthymeleaf.entity.Product;
import ru.gb.gbthymeleaf.proxy.product.ProductProxyMapper;
import ru.gb.gbthymeleaf.proxy.product.Proxy;
import ru.gb.gbthymeleaf.proxy.product.entity.ProductProxy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductProxyService implements Proxy {
    private Map<Long, ProductProxy> cachedProductById;
    private final ProductDao productDao;
    private final ProductProxyMapper mapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public ProductProxy save(ProductProxy productProxy) {
        var productById = getCache();
        var savedProductProxy = saveProduct(productProxy);

        productById.put(savedProductProxy.getId(), savedProductProxy);
        return productById.get(savedProductProxy.getId());
    }

    private ProductProxy saveProduct(ProductProxy productProxy) {
        if (productProxy.getId() != null) {
            Optional<Product> productOptional = productDao.findById(productProxy.getId());
            if (productOptional.isPresent()) {
                Product productFromDB = productOptional.get();
                productFromDB.setTitle(productProxy.getTitle());
                productFromDB.setManufactureDate(productProxy.getManufactureDate());
                productFromDB.setStatus(productProxy.getStatus());
                productFromDB.setCost(productProxy.getCost());

                var proxyProduct = mapper.toProxy(productDao.save(productFromDB));

                kafkaTemplate.send("gb-topic", "Product update successfully");
                return proxyProduct;
            }
        }

        var proxyProduct = mapper.toProxy(productDao.save(mapper.toModel(productProxy)));

        kafkaTemplate.send("gb-topic", "Product create successfully");
        return proxyProduct;
    }

    @Override
    public ProductProxy findById(Long id) {
        return getCache().get(id);
    }

    @Override
    public List<ProductProxy> findAll() {
        return getCache().values().stream().toList();
    }

    @Override
    public void deleteById(Long id) {
        try {
            productDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("No such id in DB: " + e.getMessage());
        }

        getCache().remove(id);
        kafkaTemplate.send("gb-topic", "Product delete successfully");
    }

    private Map<Long, ProductProxy> getCache() {
        if (cachedProductById == null) {
            cachedProductById = initCache();
        }

        return cachedProductById;
    }

    private Map<Long, ProductProxy> initCache() {
        return productDao.findAll().stream()
                .collect(Collectors.toMap(
                        Product::getId,
                        mapper::toProxy
                ));
    }
}
