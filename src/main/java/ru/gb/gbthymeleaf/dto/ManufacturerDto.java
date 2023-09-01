package ru.gb.gbthymeleaf.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ManufacturerDto {
    private Long id;
    private String title;
}
