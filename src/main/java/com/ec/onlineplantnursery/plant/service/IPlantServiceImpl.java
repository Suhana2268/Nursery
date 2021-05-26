package com.ec.onlineplantnursery.plant.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;


@Service
public class IPlantServiceImpl implements IPlantService{

	@Autowired
	IPlantRepository plantRepo;
	
	
	
	public IPlantServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Plant addPlant(Plant plant) {
		// TODO Auto-generated method stub
		plantRepo.save(plant);
		return plant;

	}

	@Override
	public Plant updatePlant(Plant plant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plant deletePlant(Plant plant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plant viewPlant(int plantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plant viewPlant(String commonName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plant> viewAllPlants() {
		// TODO Auto-generated method stub
		return plantRepo.findAll();
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) {
		// TODO Auto-generated method stub
		return plantRepo.findAll();
	}


}
