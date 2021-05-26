package com.ec.onlineplantnursery.planter.repository;

import java.util.List;

import com.ec.onlineplantnursery.planter.entity.Planter;

public interface CustomPlanterRepository {
	List<Planter> viewPlanter(String planterShape);
}
