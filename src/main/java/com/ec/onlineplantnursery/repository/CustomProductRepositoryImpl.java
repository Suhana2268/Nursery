package com.ec.onlineplantnursery.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.onlineplantnursery.entity.Product;

public class CustomProductRepositoryImpl implements CustomProductRepository{

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Product> searchProduct(String text) {
		String lowercase = text.toLowerCase();
		String firstUpper = "";
		firstUpper += Character.toUpperCase(lowercase.charAt(0));
		firstUpper += lowercase.substring(1);
		Query q = entityManager.createQuery("from Product p where p.commonName LIKE CONCAT('%',:lc ,'%') or p.commonName LIKE CONCAT('%', :firstUC, '%')");
		q.setParameter("lc", lowercase);
		q.setParameter("firstUC", firstUpper);
		return q.getResultList();

	}

}