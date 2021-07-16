package com.ec.onlineplantnursery.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.entity.Planter;

@Service
public class CustomOrderRepositoryImpl implements CustomOrderRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Planter> getPlanterByOrderId(int idOrder) {
		Query q = entityManager.createQuery("select planters from Order as ord where ord.bookingOrderId =: b");
		q.setParameter("b", idOrder);
		return q.getResultList();

	}

	@Override
	public double calculateCost(int productId) {
		Query q = entityManager.createQuery("select p.plantCost from Plant p where p.pId =: pId");
		q.setParameter("pId", productId);
		return q.getFirstResult();
	}

//	/*
//	 * @Override public double totalCost(int planterId) { Query q =
//	 * entityManager.createQuery(
//	 * "select p.plantCost from Plant p where plantId in(Select pl.plant.plantId from Planter pl where planterId =:abc)"
//	 * ); q.setParameter("abc", planterId); return q.getFirstResult(); }
//	 */

}
