package in.sp.main.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.dto.RestaurantDTO;
import in.sp.main.repository.RestaurantRepository;
import in.sp.main.services.RestaurantService;

@RestController
public class RestaurantController {

	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	
	@GetMapping("/restaurants")
	public List<RestaurantDTO> getAllRestaurants()
	{
		return restaurantService.getAllRestaurants();
	}
	
	
	@GetMapping("/restaurant")	
	public List<RestaurantDTO> getRestaurantByName(@RequestParam String restaurant_name)
	{
		return restaurantService.findRestaurantByName(restaurant_name);
	}
	
	@DeleteMapping("/restaurant/{id}")
	public ResponseEntity<String> deleteRestaurantById(@PathVariable long id)
	{
		boolean deleted= restaurantService.deleteRestaurantById(id);
		
		
		if(deleted)
		{
			return ResponseEntity.ok("Restaurtant deleted successfully!!");
		}
		
		return ResponseEntity.ok("This Restaurant does not exist");
	}
	
	@PutMapping("/restaurant")
	public ResponseEntity<RestaurantDTO> updateRestaurantByPut(@RequestBody RestaurantDTO restaurantDTO)
	{
		
		
		restaurantService.updateRestaurantBYPut(restaurantDTO);
		
		
		
		return ResponseEntity.ok(restaurantDTO);
	}
	

	@PatchMapping("/restaurant")
	public ResponseEntity<RestaurantDTO> updateRestaurantByPatch(@RequestBody RestaurantDTO restaurantDTO)
	{
		
		
		restaurantService.updateRestaurantByPatch(restaurantDTO);
		
		return ResponseEntity.ok(restaurantDTO);
	}
	
	
}
