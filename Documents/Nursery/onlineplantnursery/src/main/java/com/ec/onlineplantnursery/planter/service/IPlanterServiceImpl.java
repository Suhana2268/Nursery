package com.ec.onlineplantnursery.planter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.PlantRepository;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.repository.PlanterRepository;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.SeedRepository;

@Service
public class IPlanterServiceImpl implements IPlanterService {
	
	@Autowired
	PlanterRepository repo;
	
	@Autowired
	PlantRepository prepo;
	
	@Autowired
	SeedRepository srepo;
	
	@Override
	public Planter addPlanter(Planter planter, int plantId, int seedId) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		if(plantId != 0) {
			Plant p = prepo.findById(plantId).get();
			if(p != null) {
				planter.setPlants(p);
			}
			if(p == null){
				throw new ResourceNotFoundException();
			}
		}
		if(seedId != 0) {
			Seed s = srepo.findById(seedId).get();
			if(s != null) {
				planter.setSeeds(s);
			} 
			if(s == null) {
				throw new ResourceNotFoundException();
			}
		}
		repo.save(planter);
		return planter;
	}

	@Override
	public Planter updatePlanter(Planter planter) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		Planter p = repo.findById(planter.getPlanterId()).get();
		if(p != null) {
			p.setPlanterheight(planter.getPlanterheight());
			p.setPlanterCapacity(planter.getPlanterCapacity());
			p.setDrinageHoles(planter.getDrinageHoles());
			p.setPlanterColor(planter.getPlanterColor());
			p.setPlanterShape(planter.getPlanterShape());
			p.setPlanterStock(planter.getPlanterStock());
			p.setPlanterCost(planter.getPlanterCost());
			return repo.save(p);
		}
		throw new ResourceNotFoundException();
	}

	@Override
	public Planter deletePlanter(int planterId) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		//boolean isDel = true;
		Planter p = repo.findById(planterId).get();
		if(p != null) {
			repo.deleteById(planterId);
			return p;
		}
		throw new ResourceNotFoundException();
		
	}

	@Override
	public Planter viewPlanter(int planterId) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		Planter p = repo.findById(planterId).get();
		if(p != null) {
			return p;
		}
		throw new ResourceNotFoundException();
	}

	
	@Override
	public List<Planter> viewPlanter(String planterShape) throws ResourceNotFoundException{
		List<Planter> plist = repo.viewPlanter(planterShape);
		if(plist.size() > 0) {
			return plist;
		}
		throw new ResourceNotFoundException();
	}
	
	
	@Override
	public List<Planter> viewAllPlanters() throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		List<Planter> plist = repo.findAll();
		if(plist.size() > 0) {
			return plist;
		}
		throw new ResourceNotFoundException();
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		List<Planter> planterList = new ArrayList<Planter>();
		for(Planter planter : repo.findAll()) {
			if(planter.getPlanterCost() >= minCost && planter.getPlanterCost() <= maxCost) {
				planterList.add(planter);
			}
		}
		if(planterList.size() > 0) {
			return planterList;
		}
		throw new ResourceNotFoundException();
	}

}
