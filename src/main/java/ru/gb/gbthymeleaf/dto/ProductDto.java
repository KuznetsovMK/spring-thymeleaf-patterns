package ru.gb.gbthymeleaf.dto;

import lombok.Builder;
import lombok.Data;
import ru.gb.gbthymeleaf.entity.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ProductDto {
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
    private ManufacturerDto manufacturer;
}
