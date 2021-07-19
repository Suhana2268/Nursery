package com.ec.onlineplantnursery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ec.onlineplantnursery.entity.Plant;
import com.ec.onlineplantnursery.entity.Planter;
import com.ec.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.repository.IPlantRepository;
import com.ec.onlineplantnursery.service.IPlantServiceImpl;

import java.util.Optional;

@SpringBootTest
class PlantServiceImplTest {

	IPlantRepository plantRepo;
	private static IPlantServiceImpl plantService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit() {
		plantRepo = mock(IPlantRepository.class);
		plantService = new IPlantServiceImpl(plantRepo);
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd() throws Exception {
		ac.close();
	}

	@Test
	@DisplayName("Test-save plant")
	void testSavePlant() {
		Plant input = mock(Plant.class);

		when(plantRepo.save(input)).thenReturn(input);
		Plant result = plantService.addPlant(input);
		verify(plantRepo).save(input);
		assertEquals(input, result);
	}

	@Test
	@DisplayName("test- get all Plants")
	void testGetAllPlants() {

		Plant input1 = mock(Plant.class);
		Plant input2 = mock(Plant.class);
		List<Plant> pList = new ArrayList<>();
		pList.add(input1);
		pList.add(input2);

		when(plantRepo.findAll()).thenReturn(pList);
		List<Plant> outputList = plantService.viewAllPlants();
		verify(plantRepo).findAll();
		assertIterableEquals(pList, outputList);
	}

	@Test
	@DisplayName("Test-Get plant by id")
	void testviewPlantById() throws PlantIdNotFoundException {

		Plant expected = mock(Plant.class);

		Optional<Plant> p = Optional.of(expected);
		when(plantRepo.findById(1)).thenReturn(p);
		Plant output = plantService.viewPlant(1);
		verify(plantRepo).findById(1);
		assertEquals(expected, output);
	}

	@Test
	@DisplayName("Test-Get plant by name")
	void testViewPlantByName() throws ResourceNotFoundException {
		Plant input = mock(Plant.class);

		String commonName = "Ice Plant";
		when(plantRepo.viewPlant(commonName)).thenReturn(input);
		Plant plant = plantService.viewPlant(commonName);
		verify(plantRepo).viewPlant(commonName);
		assertEquals(plant, input);
	}

	@Test
	@DisplayName("Test-Get Plant by type")
	void testViewPlantByTypeOfPlant() throws ResourceNotFoundException {

		Plant input1 = mock(Plant.class);
		Plant input2 = mock(Plant.class);
		List<Plant> plantList = new ArrayList<>();
		plantList.add(input1);
		plantList.add(input2);

		String typeOfPlant = "Fruit Plant";
		when(plantRepo.viewAllPlants(typeOfPlant)).thenReturn(plantList);
		List<Plant> outputList = plantService.viewAllPlants(typeOfPlant);
		verify(plantRepo).viewAllPlants(typeOfPlant);
		assertIterableEquals(plantList, outputList);
	}

	@Test
	@DisplayName("Test-Exception for Update plant")
	void testUpdatePlant() throws NoSuchElementException, PlantIdNotFoundException {
		Plant input = mock(Plant.class);

		Plant update = mock(Plant.class);
		Optional<Plant> optionalPlant = Optional.of(input);

		when(plantRepo.findById(input.getpId())).thenReturn(optionalPlant);
		when(plantRepo.save(update)).thenReturn(update);
		Plant result = plantService.updatePlant(update);
		assertEquals(update, result);

	}
	

	
	
	@Test 
	@DisplayName("Test-Exception for get plant by name")
	void testViewPlantByNameException() {
		Plant input = mock(Plant.class);
		String commonName = "abc";
		try {
			when(plantRepo.viewPlant(commonName)).thenReturn(input);
			Plant output = plantService.viewPlant(commonName);
			assertNotNull(output);
		}
		catch(ResourceNotFoundException e) {
			
		}
	}


	@Test
	@DisplayName("Test-Exception for get plant by type")
	void testViewPlantByTypeOfPlantException() throws ResourceNotFoundException{
		
		Plant input1 = mock(Plant.class);
		Plant input2 = mock(Plant.class);
		
		List<Plant> plantList = new ArrayList<>();
		plantList.add(input1);
		plantList.add(input2);
		String typeOfPlant = "Flower Plant";
		try {
			when(plantRepo.viewAllPlants(typeOfPlant)).thenReturn(plantList);
			List<Plant> plantListOutput = plantService.viewAllPlants(typeOfPlant);
			assertNotNull(plantListOutput);
		}
		catch (ResourceNotFoundException e) {
		}
			
	}
	
	

}// end