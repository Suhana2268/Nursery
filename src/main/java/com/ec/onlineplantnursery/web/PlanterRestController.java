package com.ec.onlineplantnursery.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.onlineplantnursery.dto.PlanterDTO;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.service.IPlanterService;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api/planter")
@Api(value = "Online Nursery Store",description = "Various api works on Planter inventory management")

public class PlanterRestController {

		Logger log = org.slf4j.LoggerFactory.getLogger(PlanterRestController.class);

		
		@Autowired
		IPlanterService planterService;
		
		@Autowired
		private ModelMapper modelMapper;
		
		/*Method Name:insertPlanter
		 *Parameters:Planter
		 *ReturnType:Planter
		 *Author Name:Tripura
		 *Created Date: 23/05/2021 */
		@ApiOperation(value = "planter post mapping." , response = Planter.class)
		@PostMapping("/insert")
		public ResponseEntity<PlanterDTO> insertPlanter(@RequestBody @Valid PlanterDTO planter) throws ResourceNotFoundException {
			log.info("inside insert planter");
			Planter planter1 = modelMapper.map(planter, Planter.class);
			Planter planter2 = planterService.addPlanter(planter1);
			PlanterDTO planteResponse = modelMapper.map(planter2, PlanterDTO.class);
			return new ResponseEntity<PlanterDTO>(planteResponse, HttpStatus.OK);
		}
		
		/*Method Name:updatePlanter
		 *Parameters:Planter
		 *ReturnType:Planter
		 *Author Name:Tripura
		 *Created Date: 24/05/2021 */
		
		@ApiOperation(value = "planter put mapping to update planter. " , response = Planter.class)
		@PutMapping("/update")
		public Planter updatePlanter(@RequestBody Planter planter) throws ResourceNotFoundException{
			log.info("inside update planter");
			return planterService.updatePlanter(planter);
		}

		/*Method Name:deletePlanter
		 *Parameters:planterId
		 *ReturnType:Planter
		 *Author Name:Tripura
		 *Created Date: 24/05/2021 */
		@ApiOperation(value = "planter delete mapping to delete planter" , response = Planter.class)
		@DeleteMapping("/delete/{planterId}")
		public Planter deletePlanter(@PathVariable int planterId) throws ResourceNotFoundException//through id
		{
			log.info("inside delete planter by id");
			return planterService.deletePlanter(planterId);
		}
		
		/*Method Name:viewPlanter
		 *Parameters:Planter
		 *ReturnType:Planter
		 *Author Name:Tripura
		 *Created Date: 23/05/2021 */
		@ApiOperation(value = "planter get mapping to view planter by id" , response = Planter.class)
		@GetMapping("/view/{planterId}")
		public Planter viewPlanter(@PathVariable int planterId) throws ResourceNotFoundException
		{
			log.info("inside Get planter by planter id");
			return planterService.viewPlanter(planterId);
		}

		/*Method Name:viewAllPlanters
		 *Parameters:No parameters
		 *ReturnType:List<Planter>
		 *Author Name:Tripura
		 *Created Date: 23/05/2021 */
		@ApiOperation(value = "Planter Get mapping to fetch all planters" , response = List.class)
		@GetMapping("/planters/all")
		public List<Planter> viewAllPlanters() throws ResourceNotFoundException{
			log.info("inside Get all planters information");
			return planterService.viewAllPlanters();
		}

		/*Method Name:updatePlanter
		 *Parameters:minCost, maxCost
		 *ReturnType:List<Planter>
		 *Author Name:Tripura
		 *Created Date: 24/05/2021 */
		@ApiOperation(value = "planter get mapping to view all planter whose cost is between the given range" , response = Planter.class)
		@GetMapping("/planters/cost/range/{minCost}/{maxCost}")
		public List<Planter> viewAllPlanters(@PathVariable int minCost, @PathVariable int maxCost) throws ResourceNotFoundException{ 
			log.info("inside Get all planters  whose cost is between the given range");
			return planterService.viewAllPlanters(minCost, maxCost);
		}
		
		/*Method Name:viewPlanter
		 *Parameters:plantershape
		 *ReturnType:List<Planter>
		 *Author Name:Tripura
		 *Created Date: 25/05/2021 */
		@ApiOperation(value = "planter get mapping to view planters by shape" , response = Planter.class)
		@GetMapping("/planters/Shape/{planterShape}")
		public List<Planter> viewPlanter(@PathVariable String planterShape) throws ResourceNotFoundException{ 
			log.info("inside Get all planters by planter shape");
			return planterService.viewPlanter(planterShape);
		}

}
