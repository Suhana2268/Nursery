package com.ec.onlineplantnursery.planter.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.ec.onlineplantnursery.dto.PlanterDTO;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.planter.entity.Planter;

public interface IPlanterService {
	Planter addPlanter(@Valid Planter planter) throws ResourceNotFoundException;

	Planter updatePlanter(Planter planter) throws ResourceNotFoundException;

	Planter deletePlanter(int planterId) throws ResourceNotFoundException;

	Planter viewPlanter(int planterId) throws ResourceNotFoundException;

	List<Planter> viewPlanter(String planterShape) throws ResourceNotFoundException;

	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlanters(int minCost, int maxCost) throws ResourceNotFoundException;
}
