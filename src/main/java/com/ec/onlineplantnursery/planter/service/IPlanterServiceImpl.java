package com.ec.onlineplantnursery.planter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.dto.PlanterDTO;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.repository.IPlanterRepository;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;


@Service
public class IPlanterServiceImpl implements IPlanterService
{

	@Autowired
	private IPlanterRepository planterRepo;
	
	@Autowired
	IPlantRepository plantRepo;
	
	@Autowired
	ISeedRepository seedRepo;
	
	
	

	public IPlanterServiceImpl() {
		super();
	}
	
	
	

	public IPlanterServiceImpl(IPlanterRepository planterRepo, IPlantRepository plantRepo, ISeedRepository seedRepo) {
		super();
		this.planterRepo = planterRepo;
		this.plantRepo = plantRepo;
		this.seedRepo = seedRepo;
	}




	public IPlanterServiceImpl(ISeedRepository seedRepo) {
		super();
		this.seedRepo = seedRepo;
	}




	public IPlanterServiceImpl(IPlantRepository plantRepo) {
		super();
		this.plantRepo = plantRepo;
	}




	public IPlanterServiceImpl(IPlanterRepository planterRepo) {
		super();
		this.planterRepo = planterRepo;
	}



	/*Method Name:addPlanter
	 *Parameters:Planter
	 *ReturnType:Planter
	 *Author Name:Tripura
	 *Created Date: 23/05/2021 */
	@Override
	public Planter addPlanter(Planter planter) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		Optional<Plant> p = plantRepo.findById(planter.getPlant().getPlantId());
		Optional<Seed> s = seedRepo.findById(planter.getSeed().getSeedId());
		if(p.isPresent() == true && s.isPresent() == true) {
			return planterRepo.save(planter);
		}
		throw new ResourceNotFoundException();
	}

	/*Method Name:updatePlanter
	 *Parameters:Planter
	 *ReturnType:Planter
	 *Author Name:Tripura
	 *Created Date: 24/05/2021 */
	@Override
	public Planter updatePlanter(Planter planter) throws ResourceNotFoundException{
		Optional<Planter> pl = planterRepo.findById(planter.getPlanterId());
		if(pl.isPresent()) {
			Planter p = planterRepo.findById(planter.getPlanterId()).get();
			p.setPlanterheight(planter.getPlanterheight());
			p.setPlanterCapacity(planter.getPlanterCapacity());
			p.setDrinageHoles(planter.getDrinageHoles());
			p.setPlanterColor(planter.getPlanterColor());
			p.setPlanterShape(planter.getPlanterShape());
			p.setPlanterStock(planter.getPlanterStock());
			p.setPlanterCost(planter.getPlanterCost());
			return planterRepo.save(p);
		}
		throw new ResourceNotFoundException();
	}

	/*Method Name:deletePlanter
	 *Parameters:planterId
	 *ReturnType:Planter
	 *Author Name:Tripura
	 *Created Date: 24/05/2021 */
	@Override
	public Planter deletePlanter(int planterId) throws ResourceNotFoundException{
		Optional<Planter> pl = planterRepo.findById(planterId);
		if(pl.isPresent() == false) {
			throw new ResourceNotFoundException("No Planter found with the Id");
		}
		
		planterRepo.deleteById(planterId);
		return pl.get();
	}

	/*Method Name:viewPlanter
	 *Parameters:planterId
	 *ReturnType:Planter
	 *Author Name:Tripura
	 *Created Date: 23/05/2021 */
	@Override
	@Transactional
	public Planter viewPlanter(int planterId) throws ResourceNotFoundException {
		Optional<Planter> pl = planterRepo.findById(planterId);
		if(pl.isPresent() == false) {
			throw new ResourceNotFoundException("No Planter found with the Id");
		}
		return planterRepo.findById(planterId).get();
	}

	/*Method Name:viewPlanter
	 *Parameters:planterShape
	 *ReturnType:List<Planter>
	 *Author Name:Tripura
	 *Created Date: 25/05/2021 */
	@Override
	public List<Planter> viewPlanter(String planterShape) throws ResourceNotFoundException{
		Optional<List<Planter>> plist = planterRepo.viewPlanter(planterShape);
		if(!plist.isPresent() == false) {
			return plist.get();
		}
		throw new ResourceNotFoundException();
	}

	/*Method Name:viewAllPlanters
	 *Parameters:No parameters
	 *ReturnType:List<Planter>
	 *Author Name:Tripura
	 *Created Date: 23/05/2021 */
	@Override
	public List<Planter> viewAllPlanters() {
		// TODO Auto-generated method stub
		return planterRepo.findAll();
	}

	/*Method Name:viewAllPlanters
	 *Parameters:minCost,maxCost
	 *ReturnType:List<Planter>
	 *Author Name:Tripura
	 *Created Date: 24/05/2021 */
	@Override
	public List<Planter> viewAllPlanters(int minCost, int maxCost)throws ResourceNotFoundException {
		Optional<List<Planter>> planter = planterRepo.getPlantersByRange(minCost, maxCost);
		if(planter.isPresent() == true) {
			return planter.get();
		}
		throw new ResourceNotFoundException();
	}
		
}

