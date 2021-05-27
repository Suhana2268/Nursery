package com.ec.onlineplantnursery.plant.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
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

	

	public IPlantServiceImpl(IPlantRepository plantRepo) {
		super();
		this.plantRepo = plantRepo;
	}



	@Override
	@Transactional
	public Plant addPlant(Plant plant) {
		
		plantRepo.save(plant);
		return plant;

	}

	@Override
	public Plant updatePlant(Plant plant) {
		Optional<Plant> existingPlant = plantRepo.findById(plant.getPlantId());
        Plant p = null;
        if(existingPlant.isPresent()) {
        	p = existingPlant.get();
        	p.setPlantId(plant.getPlantId());
            p.setPlantCost(plant.getPlantCost());
            p.setPlantDescription(plant.getPlantDescription());
            p.setPlantHeight(plant.getPlantHeight());
            p.setPlantSpread(plant.getPlantSpread());
            p.setPlantsStock(plant.getPlantsStock());
            p.setTypeOfPlant(plant.getTypeOfPlant());
            p.setBloomTime(plant.getBloomTime());
            p.setCommonName(plant.getCommonName());
            p.setDifficultyLevel(plant.getDifficultyLevel());
            p.setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
            p.setTemparature(plant.getTemparature());
           
    		plantRepo.save(p);
        }
		return p;
		
	}

	@Override
	public Plant deletePlant(int plantId) {
		Optional<Plant> plant = plantRepo.findById(plantId);
		plantRepo.deleteById(plantId);	
		return plant.get();
	}

	@Override
	public Optional<Plant> viewPlant(int plantId) {
		// TODO Auto-generated method stub
		
		return plantRepo.findById(plantId);
	}

	@Override
	public Optional<Plant> viewPlant(String commonName) throws ResourceNotFoundException {
		Optional<Plant> p = plantRepo.viewPlant(commonName);
		
		if(p.isEmpty()) throw new ResourceNotFoundException(commonName);

		
		return p;
	}

	@Override
	public List<Plant> viewAllPlants() {
		// TODO Auto-generated method stub
		return plantRepo.findAll();
	}

	@Override
	public Optional<List<Plant>> viewAllPlants(String typeOfPlant) throws ResourceNotFoundException {
		Optional<List<Plant>> pList = plantRepo.viewAllPlants(typeOfPlant);
		
		if(pList==null || pList.isEmpty()) {
			throw new ResourceNotFoundException(typeOfPlant);
		}

		
		return plantRepo.viewAllPlants(typeOfPlant);
	}



}
