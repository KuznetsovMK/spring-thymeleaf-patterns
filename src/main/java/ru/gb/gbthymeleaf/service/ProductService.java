package ru.gb.gbthymeleaf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.gbthymeleaf.entity.Product;
import ru.gb.gbthymeleaf.proxy.product.ProductProxyMapper;
import ru.gb.gbthymeleaf.proxy.product.impl.ProductProxyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductProxyService productProxyService;
    private final ProductProxyMapper mapper;

    public Product save(Product product) {
        return mapper.toModel(productProxyService.save(mapper.toProxy(product)));
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return mapper.toModel(productProxyService.findById(id));
    }

    public List<Product> findAll() {
        return productProxyService.findAll().stream()
                .map(mapper::toModel)
                .toList();
    }

    public void deleteById(Long id) {
        productProxyService.deleteById(id);
    }
}
