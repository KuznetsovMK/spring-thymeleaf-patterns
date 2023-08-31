package ru.gb.gbthymeleaf.proxy.product;

import org.mapstruct.Mapper;
import ru.gb.gbthymeleaf.entity.Product;
import ru.gb.gbthymeleaf.proxy.product.entity.ProductProxy;

@Mapper(componentModel = "spring")
public abstract class ProductProxyMapper {
    public abstract ProductProxy toProxy(Product product);

    public abstract Product toModel(ProductProxy product);
}
