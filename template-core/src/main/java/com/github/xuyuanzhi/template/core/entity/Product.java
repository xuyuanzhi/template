package com.github.xuyuanzhi.template.core.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("INV_PRODUCT")
@Data
public class Product extends BaseEntity {
	
	private String name;
	
	private String sku;
	
	private String url;
	
	private String imageUrl;
	
	private BigDecimal price;
	
	private String description;
	
	private Long views;
	
	private Long stars;
	
	public String getWebImageUrl() {
		if (imageUrl.startsWith("http://") || imageUrl.startsWith("https://")) {
			return imageUrl;
		} else {
			return "/image/" + imageUrl;
		}
	}
}
