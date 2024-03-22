package org.example.onlineshop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;
    private String productName;
    private BigDecimal price;

}
