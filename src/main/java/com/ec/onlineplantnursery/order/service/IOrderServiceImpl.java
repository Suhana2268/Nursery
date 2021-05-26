package com.ec.onlineplantnursery.order.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.customer.entity.Customer;

import com.ec.onlineplantnursery.customer.service.ICustomerServiceImpl;
import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.order.repository.CustomOrderRepository;
import com.ec.onlineplantnursery.order.repository.CustomOrderRepositoryImpl;
import com.ec.onlineplantnursery.order.repository.IOrderRepository;

import com.ec.onlineplantnursery.planter.entity.Planter;

import com.ec.onlineplantnursery.planter.service.IPlanterServiceImpl;


@Service
public class IOrderServiceImpl implements IOrderService{
	
	@Autowired
	IOrderRepository orderRep;
	@Autowired
	IPlanterServiceImpl planterService;
	@Autowired
	ICustomerServiceImpl custService;
	
	
	
	
	public IOrderServiceImpl() {
		super();
	}
	
	

	public IOrderServiceImpl(ICustomerServiceImpl custService) {
		super();
		this.custService = custService;
	}
	



	public IOrderServiceImpl(IOrderRepository orderRep) {
		super();
		this.orderRep = orderRep;
	}
	
	
	



	public ICustomerServiceImpl getCustService() {
		return custService;
	}



	public void setCustService(ICustomerServiceImpl custService) {
		this.custService = custService;
	}



	@Override
	public Order addOrder(Order order) {
		
		Customer cust = custService.viewCustomer(order.getCustId());
		List<Planter> pList = planterService.viewAllPlanters();
		List<Integer> pId = order.getId();
		List<Planter> orderedPlanters = new ArrayList<Planter>();
		double cost = 0, cost1 =0;
		for(Planter p : pList) {
			for(int id : pId) {
				if(p.getPlanterId() == id) {
					orderedPlanters.add(p);
				}
			}
		}
		
		for(Planter p : orderedPlanters) {
			if(p.getPlant() != null) {
				cost += p.getPlant().getPlantCost();
			}
			else if(p.getSeed() != null) {
				cost += p.getSeed().getSeedsCost();
			}
			else {
				cost += cost += p.getPlant().getPlantCost() + p.getSeed().getSeedsCost();
			}
			
			cost1 += p.getPlanterCost();
		}
		
		order.setCustomer(cust);
		order.setPlanters(orderedPlanters);
		order.setTotalCost(cost+cost1);
		orderRep.save(order);
		
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		
		int id = order.getBookingOrderId();
		Optional<Order> or = orderRep.findById(id);
		if(or.isPresent()) {
			Order ord = or.get();
			ord.setCustomer(order.getCustomer());
			//ord.setOrderDate(order.getOrderDate());
			ord.setQuantity(order.getQuantity());
			ord.setTotalCost(order.getTotalCost());
			ord.setBookingOrderId(order.getBookingOrderId());
			ord.setTransactionMode(order.getTransactionMode());
			return orderRep.save(ord);
		}
		return null;
	}

	@Override
	public Order deleteOrder(int orderId) {
		
		Order o = orderRep.findById(orderId).get();
		orderRep.delete(o);
		return o;
	}

	@Override
	public Order viewOrder(int orderId) {
		
		return orderRep.findById(orderId).get();
	}

	@Override
	public List<Order> viewAllOrders() {
		
		return orderRep.findAll();
	}

	@Override
	public List<Planter> viewPlanterByOrderId(int orderId) {
		
		return orderRep.getPlanterByOrderId(orderId);
	}

	
	
}
