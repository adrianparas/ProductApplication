package com.snva.product_ecommerce_app.exception;

import lombok.Getter;

@Getter
public class InvalidProductException extends Exception {

    private String errorCode;

    public InvalidProductException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
