package com.ec.onlineplantnursery.service;

import java.util.List;

import com.ec.onlineplantnursery.entity.Seed;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.requestDto.SeedRequestDto;

public interface ISeedService {
	Seed addSeed(Seed seed);


	Seed deleteSeed(Seed seed) throws SeedIdNotFoundException;

	Seed viewSeed(int seedId) throws SeedIdNotFoundException;

	Seed viewSeed(String commonName) throws ResourceNotFoundException;

	List<Seed> viewAllSeeds();

	List<Seed> viewAllSeeds(String typeOfSeed) throws ResourceNotFoundException;

	
	List<Seed> viewAllSeed(String sort);

	SeedRequestDto updateSeed(SeedRequestDto seed) throws SeedIdNotFoundException;}
