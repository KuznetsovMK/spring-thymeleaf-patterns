package ru.gb.gbthymeleaf.proxy.product.entity;

import lombok.Builder;
import lombok.Data;
import ru.gb.gbthymeleaf.entity.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ProductProxy {
    private Long id;
    private String title;
    private BigDecimal cost;
    private LocalDate manufactureDate;
    private int version;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
    private Status status;
}
