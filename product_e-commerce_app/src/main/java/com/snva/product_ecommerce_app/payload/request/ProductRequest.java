package com.snva.product_ecommerce_app.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest
{
	private String name;
	private long price;
    private String description;
    private String category;
    private String imageUrl;
}
