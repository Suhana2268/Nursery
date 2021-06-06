package com.ec.onlineplantnursery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentMatchers;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;
import com.ec.onlineplantnursery.plant.service.IPlantService;
import com.ec.onlineplantnursery.plant.service.IPlantServiceImpl;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.repository.CustomPlanterRepository;
import com.ec.onlineplantnursery.planter.repository.IPlanterRepository;
import com.ec.onlineplantnursery.planter.service.IPlanterServiceImpl;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;
import com.ec.onlineplantnursery.seed.service.ISeedService;
import com.ec.onlineplantnursery.seed.service.ISeedServiceImpl;

@SpringBootTest
public class PlanterServiceImplTest {

	IPlanterRepository planterRepo;
	IPlantRepository plantRepo;
	ISeedRepository seedRepo;
	private static IPlanterServiceImpl planterService;
	private static IPlantServiceImpl plantService;
	private static ISeedServiceImpl seedService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit()
	{
		planterRepo = mock(IPlanterRepository.class); // test through approach 2
		planterService = new  IPlanterServiceImpl(planterRepo); 	// Approach 2
		plantRepo = mock(IPlantRepository.class);
		plantService = new IPlantServiceImpl(plantRepo);
		seedRepo = mock(ISeedRepository.class);
		seedService = new ISeedServiceImpl(seedRepo);
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}

	
	@Test
	@Disabled
	@DisplayName("Test-Save Planter")
	void testSavePlanter() throws ResourceNotFoundException {
		Plant plant = new Plant(1, 4, 13, "Aloe", "Once a week", "medicinal", "easy", "20 C", "Succulent", "This is a stemless or very short-stemmed plant", "wide", 200);
		Seed seed = new Seed(1,"Al","Morning", "Twice a day", "easy","25 C","Monocotyledonous", "This seed is a small embryonic plant",200,300,2000);
		//plant.setPlantId(1);
		//seed.setSeedId(1);
		
		//plantRepo.save(plant);
		
		Planter input = new Planter(105,12,3,2,23,"Round",45,30, plant, seed);
		//Planter savedInput = new Planter(105,12,3,2,23,"Round",45,30, plant, seed);
		
		//Planter input = mock(Planter.class);
		
		when(planterRepo.save(input)).thenReturn(input);
		when(planterRepo.save(ArgumentMatchers.any(Planter.class))).thenReturn(input);
		
		
		Planter result = planterService.addPlanter(input);
		//verify(planterRepo).save(input);
		assertEquals(input, result);
		
		

	}


	@Test
	//@Disabled
	@DisplayName("Test-Get All Planters , Args:- No Args to pass")
	void testGetAllPlanters() {


		List<Planter> pList = mock(List.class); 
		//when() and 	//thenReturn()
		when(planterRepo.findAll()).thenReturn(pList);
		//call the actual method
		List<Planter> outputOrderList = planterService.viewAllPlanters();
		assertEquals(pList, outputOrderList);

	}

	@Test
	//@Disabled
	@DisplayName("Test-Get Planter by Id , Args:- Passing PlanterId")
	void testViewPlanterById() throws ResourceNotFoundException{

		int input = 52;
		Planter planter = mock(Planter.class);
		Optional<Planter> optional = Optional.of(planter);
		when(planterRepo.findById(input)).thenReturn(optional);
		Optional<Planter> output = Optional.of(planterService.viewPlanter(input));
		
		//verify(planterRepo).findById(input);
		assertEquals(optional, output);

	}
	
	@Test
	public void testViewPlanterByIdException() {
		
		int input = 20;
		when(planterRepo.findById(input)).thenReturn(Optional.ofNullable(null));
		Executable executable = ()->planterService.viewPlanter(input);
		assertThrows(ResourceNotFoundException.class, executable);
	}

	@Test
	//@Disabled
	@DisplayName("Test-Get Planter by Planter Shape , Args:- Passing planterShape")
	void testViewPlanterByShape() throws ResourceNotFoundException {


		String planterShape = "square";
		
		Plant plant = new Plant(1, 4, "wide", "Rose", "Once a week", "medicinal", "easy", "20 C", "Succulent", "This is a stemless or very short-stemmed plant", 13, 200);
	    Seed seed = new Seed(2, "Money", "One week", "Once a day", "easy", "20ºC", "Monocotyledonous", "This seed is a small embryonic plant", 20, 100.0, 1000);
	    
	    Planter planter = new Planter(102, 11, 2, 2, 2, "square", 5, 110, plant, seed);
		List<Planter> pList = new ArrayList<>();
		pList.add(planter);
		when(planterRepo.viewPlanter(planterShape)).thenReturn(Optional.of(pList));
		//Executable executable = ()->planterService.viewPlanter(planterShape);
		//assertThrows(ResourceNotFoundException.class, executable);
		
		List<Planter> outputOrderList = planterService.viewPlanter(planterShape);
		assertEquals(pList, outputOrderList);

	}
	
	@Test
	public void testViewPlanterByShapeException() {
		
		String planterShape = "star";
		when(planterRepo.viewPlanter(planterShape)).thenReturn(Optional.ofNullable(null));
		Executable executable = ()->planterService.viewPlanter(planterShape);
		assertThrows(ResourceNotFoundException.class, executable);
	}

	@Test
	//@Disabled
	@DisplayName("Test-Get Planter by range , Args:- minCost, maxCost")
	void testViewPlanterByRange() throws ResourceNotFoundException {


		int minCost = 100;
		int maxCost = 150;
		
		Plant plant = new Plant(1, 4, "wide", "Rose", "Once a week", "medicinal", "easy", "20 C", "Succulent", "This is a stemless or very short-stemmed plant", 13, 200);
	    Seed seed = new Seed(2, "Money", "One week", "Once a day", "easy", "20ºC", "Monocotyledonous", "This seed is a small embryonic plant", 20, 100.0, 1000);
	    
		
		Planter planter = new Planter(102, 11, 2, 2, 2, "square", 5, 110, plant, seed);
		List<Planter> pList = new ArrayList<>();
		pList.add(planter);
		when(planterRepo.getPlantersByRange(minCost,maxCost)).thenReturn(Optional.of(pList));
		//call the actual method 
		//Executable executable = ()->planterService.viewAllPlanters(minCost,maxCost);
		//assertThrows(ResourceNotFoundException.class, executable);
				
		List<Planter> outputOrderList = planterService.viewAllPlanters(minCost, maxCost);
		assertEquals(pList, outputOrderList);
		
	}
	
	@Test
	public void testPlanterByRangeException() {
		
		
		int minCost = 2000;
		int maxCost = 10000;
		when(planterRepo.getPlantersByRange(minCost,maxCost)).thenReturn(Optional.ofNullable(null));
		Executable executable = ()->planterService.viewAllPlanters(minCost, maxCost);
		assertThrows(ResourceNotFoundException.class, executable);
	}

	@Test
	//@Disabled
	@DisplayName("Test-Delete Planter , Args:- pass planterId")
	void testDeletePlanter() throws ResourceNotFoundException {
		
		

		Seed sinput = new Seed("Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);
		
		Planter input = new Planter(1,12,3,2,23,"Round",45,30,null,sinput);
		
		when(planterRepo.findById(input.getPlanterId())).thenReturn(Optional.of(input));
		Planter output = planterService.deletePlanter(input.getPlanterId());
		verify(planterRepo).deleteById(input.getPlanterId());
		assertEquals(input, output);
		
	}
	
	
	@Test
	public void testDeletePlanterException() {
		//Seed sinput = new Seed("Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
			//	"This seed is a small embryonic plant",250,300,2000);
		
		Planter input = mock(Planter.class);
		
		when(planterRepo.findById(123)).thenReturn(Optional.of(input));
		Executable executable = ()->planterService.deletePlanter(input.getPlanterId());
		assertThrows(ResourceNotFoundException.class, executable);
	}

	@Test
	//@Disabled
	@DisplayName("Test-Update Planter , Args:- Pass Planter")
	void testUpdatePlanter() throws ResourceNotFoundException {
		
		//Plant plant = new Plant(1, 4, "wide", "Rose", "Once a week", "medicinal", "easy", "20 C", "Succulent", "This is a stemless or very short-stemmed plant", 13, 200);
	    //Seed seed = new Seed(2, "Money", "One week", "Once a day", "easy", "20ºC", "Monocotyledonous", "This seed is a small embryonic plant", 20, 100.0, 1000);
	    
	    Planter input = new Planter(102, 11, 2, 2, 2, "square", 5, 110);//, plant, seed);
	    
	    when(planterRepo.save(input)).thenReturn(input);
	    
	    Planter input1 = new Planter(102, 13, 2, 2, 2, "square", 5, 130);
	    
	    when(planterRepo.findById(input1.getPlanterId())).thenReturn(Optional.of(input1));
		
		Planter output = planterService.updatePlanter(input);
		verify(planterRepo).save(input1);
		assertEquals(input, output);

	}
	
	@Test
	public void testUpdatePlanterException() {
		
		Planter input = mock(Planter.class);
		
		when(planterRepo.findById(123)).thenReturn(Optional.of(input));
		Executable executable = ()->planterService.updatePlanter(input);
		assertThrows(ResourceNotFoundException.class, executable);
	}

}