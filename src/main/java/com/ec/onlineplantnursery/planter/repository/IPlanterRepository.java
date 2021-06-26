package com.ec.onlineplantnursery.planter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ec.onlineplantnursery.planter.entity.Planter;

public interface IPlanterRepository extends JpaRepository<Planter, Integer>, CustomPlanterRepository {
	@Query("select SUM(p.plantCost) from Plant p where p.plantId =(Select pl.plant.plantId from Planter pl where pl.planterId =:planterId)")
	double findPlantCostByPlanterId(@Param("planterId") Integer planterId);
}
