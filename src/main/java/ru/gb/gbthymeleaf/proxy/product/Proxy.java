package ru.gb.gbthymeleaf.proxy.product;

import ru.gb.gbthymeleaf.entity.Product;
import ru.gb.gbthymeleaf.proxy.product.entity.ProductProxy;

import java.util.List;

public interface Proxy {

    ProductProxy save(ProductProxy product);

    ProductProxy findById(Long id);

    List<ProductProxy> findAll();

    void deleteById(Long id);
}
