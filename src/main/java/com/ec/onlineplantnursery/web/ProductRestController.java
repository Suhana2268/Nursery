package com.ec.onlineplantnursery.web;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.responseDto.ProductResponseDto;
import com.ec.onlineplantnursery.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/onlinenursery/product")
@Api(value = "Online Nursery Store")
@CrossOrigin(origins = {"http://localhost:9093", "http://localhost:4200"}, allowedHeaders="*")
public class ProductRestController {
	
	Logger log = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	ProductService productService;

	@Autowired
	private ModelMapper modelMapper;
	
	@ApiOperation(value = "Product Get mapping to fetch all products", response = List.class)
	@GetMapping("/products")
	public List<ProductResponseDto> viewAllProducts() throws ResourceNotFoundException {

		log.info("inside Get all products information");
		
		return productService.viewAllProducts().stream()
				.map(product -> modelMapper.map(product, ProductResponseDto.class)).collect(Collectors.toList());

	}
	
	@ApiOperation(value = "product get mapping to view products by name", response = ProductResponseDto.class)
	@GetMapping("/search/{text}")
	public List<ProductResponseDto> searchProduct(@PathVariable String text) throws ResourceNotFoundException {

		log.info("inside Get all products by product name");

		return productService.searchProduct(text).stream()
				.map(product -> modelMapper.map(product, ProductResponseDto.class)).collect(Collectors.toList());

	}

}