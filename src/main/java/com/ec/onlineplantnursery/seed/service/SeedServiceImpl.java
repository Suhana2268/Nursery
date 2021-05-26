package com.ec.onlineplantnursery.seed.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;

@Service
public class SeedServiceImpl implements ISeedService{

	
	@Autowired
	ISeedRepository repo;
	
	public SeedServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SeedServiceImpl(ISeedRepository  repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}

	@Override
	@Transactional
	public Seed addSeed(Seed seed) {
		repo.save(seed);
		return seed;
	}

	@Override
	@Transactional
	public Seed updateSeed(Seed seed) throws ResourceNotFoundException {
		Optional<Seed> os = repo.findById(seed.getSeedId());
		if(os.isEmpty()) {
	    	   throw new ResourceNotFoundException();
	    }
		
       Seed s = repo.findById(seed.getSeedId()).get();
       
       s.setBloomTime(seed.getBloomTime());
       s.setCommonName(seed.getCommonName());
       s.setDifficultyLevel(seed.getDifficultyLevel());
       s.setSeedsCost(seed.getSeedsStock());
       s.setSeedsDescription(seed.getSeedsDescription());
       s.setSeedsPerPacket(seed.getSeedsPerPacket());
       s.setSeedsStock(seed.getSeedsStock());
       s.setTemparature(seed.getTemparature());
       s.setTypeOfSeeds(seed.getTypeOfSeeds());
       s.setWatering(seed.getWatering());

		return repo.save(s);
	}

	@Override
	@Transactional
	public Seed deleteSeed(int seed) {
		// TODO Auto-generated method stub
		Seed s = repo.findById(seed).get();
		repo.delete(s);
		return s;
	}

	@Override
	public Seed viewSeed(int seedId) throws SeedIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Seed> s = repo.findById(seedId);
		if(s.isEmpty()) {
			throw new SeedIdNotFoundException(seedId);
		}
		return repo.findById(seedId).get();
	}

	@Override
	public Seed viewSeed(String commonName) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		return repo.getSeedByCommonName(commonName);
	}

	@Override
	public List<Seed> viewAllSeeds() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeeds) throws ResourceNotFoundException{
		return repo.getSeedsByTypeOfSeed(typeOfSeeds);
	}

}