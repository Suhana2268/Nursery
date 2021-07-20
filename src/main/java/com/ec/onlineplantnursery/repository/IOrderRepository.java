package com.ec.onlineplantnursery.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ec.onlineplantnursery.entity.Order;
import com.ec.onlineplantnursery.entity.Product;
import com.ec.onlineplantnursery.entity.User;

public interface IOrderRepository extends JpaRepository<Order, Integer>, CustomOrderRepository {
	/**@Query("select p.plantCost from Plant p where p.plantId in(Select pl.plant.plantId from Planter pl where pl.planterId =:planterId)")
	 double findPlantCostByPlanterId(@Param("planterId") Integer planterId);
	
	@Query("select s.seedsCost from Seed s where s.seedId in(Select pl.seed.seedId from Planter pl where pl.planterId =:planterId)")
	double findSeedCostByPlanterId(@Param("planterId") Integer planterId);
	
	**/
	@Query("select p.cost from Product p where p.pId =: pId")
	double findPlantCostByProductId(@Param("pId") Integer pId);
	
	@Query("select o from Order as o where orderStatus = '0' and userId =:id")
	List<Order> findCartById(@Param("id") Integer id);
	
	
	@Query("select p from Product as p where pId =(select o.pId from Order as o where o.orderStatus = '0' and userId =:id)")
	List<Product> findproductByCart(@Param("id") Integer id);

}
