package com.snva.product_ecommerce_app.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse 
{
    private String errorMessage;
    private String errorCode;
}
