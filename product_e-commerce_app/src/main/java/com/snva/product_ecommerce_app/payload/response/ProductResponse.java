package com.snva.product_ecommerce_app.payload.response;

import lombok.Data;

@Data
public class ProductResponse {
    private long productId;
    private String name;
	private long price;
    private String description;
    private String category;
    private String imageUrl;
}
