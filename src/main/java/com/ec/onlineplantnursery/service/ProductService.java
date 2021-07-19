package com.ec.onlineplantnursery.service;


import java.util.List;

import com.ec.onlineplantnursery.entity.Product;

public interface ProductService {
	List<Product> viewAllProducts();

	List<Product> searchProduct(String text);

}