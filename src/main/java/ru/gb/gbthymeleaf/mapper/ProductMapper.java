package ru.gb.gbthymeleaf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.gbthymeleaf.dto.ProductDto;
import ru.gb.gbthymeleaf.entity.Manufacturer;
import ru.gb.gbthymeleaf.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "title", source = "product.title")
    ProductDto toDto(Product product, Manufacturer manufacturer);
}
