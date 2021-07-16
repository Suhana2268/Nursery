package com.ec.onlineplantnursery.service;

import java.util.List;

import com.ec.onlineplantnursery.entity.Order;
import com.ec.onlineplantnursery.entity.Planter;
import com.ec.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;

public interface IOrderService {
	Order addOrder(Order order) throws ResourceNotFoundException;
	Order updateOrder(Order order) throws ResourceNotFoundException;
	Order deleteOrder(int orderId) throws ResourceNotFoundException;
	Order viewOrder(int  orderId) throws OrderIdNotFoundException;
	List<Order> viewAllOrders();
	List<Planter> viewPlanterByOrderId(int id) throws ResourceNotFoundException;
	
}
