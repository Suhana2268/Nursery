package com.ec.onlineplantnursery.planter.repository;

import com.ec.onlineplantnursery.planter.entity.Planter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomPlanterRepositoryImpl implements CustomPlanterRepository{
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Planter> viewPlanter(String shape) {
		
		Query q = entityManager.createQuery("from Planter where planterShape=:abc");
		q.setParameter("abc", shape);
		return q.getResultList();
		
	}

}
