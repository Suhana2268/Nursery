package com.ec.onlineplantnursery.repository;

import java.util.List;

import com.ec.onlineplantnursery.entity.Product;

public interface CustomProductRepository {
	List<Product> searchProduct(String text);
}