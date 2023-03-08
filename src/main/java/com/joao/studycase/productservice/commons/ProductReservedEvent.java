package com.joao.studycase.productservice.commons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductReservedEvent {

    private String productId;
    private String orderId;
    private String userId;
    private Integer quantity;
}
