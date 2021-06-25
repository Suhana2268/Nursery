package com.ec.onlineplantnursery.service;

import java.util.List;

import com.ec.onlineplantnursery.entity.Planter;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;

public interface IPlanterService {
	Planter addPlanter(Planter planter) throws ResourceNotFoundException;

	Planter updatePlanter(Planter planter) throws ResourceNotFoundException;

	Planter deletePlanter(Planter planter) throws ResourceNotFoundException;

	Planter viewPlanter(int planterId) throws ResourceNotFoundException;

	List<Planter> viewPlanter(String planterShape) throws ResourceNotFoundException;

	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlanters(double minCost, double maxCost) throws ResourceNotFoundException;
}
