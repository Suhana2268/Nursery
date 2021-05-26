package com.ec.onlineplantnursery.seed.service;

import java.util.List;


import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.order.repository.IOrderRepository;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;

@Service
public class ISeedServiceImpl implements ISeedService{
	
	@Autowired
	ISeedRepository seedRepo;
	
	
	
	public ISeedServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Seed addSeed(Seed seed) {
		// TODO Auto-generated method stub
		seedRepo.save(seed);
		return seed;
	}

	@Override
	public Seed updateSeed(Seed seed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed deleteSeed(Seed seed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed viewSeed(int seedId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed viewSeed(String commonName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seed> viewAllSeeds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) {
		// TODO Auto-generated method stub
		return null;
	}
}
