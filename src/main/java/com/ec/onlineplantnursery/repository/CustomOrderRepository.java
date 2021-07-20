package com.ec.onlineplantnursery.repository;

import java.util.List;

import com.ec.onlineplantnursery.entity.Order;
import com.ec.onlineplantnursery.entity.Planter;
import com.ec.onlineplantnursery.entity.Product;
import com.ec.onlineplantnursery.entity.User;

public interface CustomOrderRepository {

	public List<Planter> getPlanterByOrderId(int orderId);
	public double calculateCost(int productId);
	public List<Order> displayOrders(User user);


}
