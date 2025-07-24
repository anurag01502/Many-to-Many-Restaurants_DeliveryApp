package in.sp.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.dto.RestaurantDTO;
import in.sp.main.entities.DeliveryApp;
import in.sp.main.entities.Restaurant;
import in.sp.main.mapper.RestaurantMapper;
import in.sp.main.repository.RestaurantRepository;

@Service
public class RestaurantServiceImp implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	   @Override

	    public RestaurantDTO updateRestaurantBYPut(RestaurantDTO restaurantDTO) {

	        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantDTO.getRestaurant_id());
	        Restaurant restaurant;

	        if (optionalRestaurant.isPresent()) {
	            // Update existing restaurant
	            restaurant = optionalRestaurant.get();
	        } else {
	            // Create new restaurant
	            restaurant = new Restaurant();
	            restaurant.setRestaurant_id(restaurantDTO.getRestaurant_id()); // Only if not auto-generated
	        }

	        // Set/update fields
	        restaurant.setRestaurant_name(restaurantDTO.getRestaurant_name());
	        restaurant.setRating(restaurantDTO.getRating());
	        restaurant.setLocation(restaurantDTO.getLocation());
	        restaurant.setContact_number(restaurantDTO.getContact_number());

	        // Save and return
	        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
	        return RestaurantMapper.toDTO(savedRestaurant, false);
	    }

	   @Override
	   public RestaurantDTO updateRestaurantByPatch(RestaurantDTO restaurantDTO) {
		
	        Restaurant updateRestaurant = restaurantRepository.findById(restaurantDTO.getRestaurant_id()).orElseThrow(() -> new RuntimeException("Restaurant not found"));;
	     
	       // RestaurantDTO updateRestaurantDTO = RestaurantMapper.toDTO(updateRestaurant, false);
	        
	        
	        if(restaurantDTO.getContact_number()!=0)
	        {
	        	updateRestaurant.setContact_number(restaurantDTO.getContact_number());
	        }
	        if(restaurantDTO.getLocation()!=null)
	        {
	        	updateRestaurant.setLocation(restaurantDTO.getLocation());
	        }
	        if(restaurantDTO.getRating()!=0)
	        {
	        	updateRestaurant.setRating(restaurantDTO.getRating());
	        }
		   
	        if(restaurantDTO.getRestaurant_name()!=null)
	        {
	        	updateRestaurant.setRestaurant_name(restaurantDTO.getRestaurant_name());
	        }
	        
	    
	        
	        Restaurant savedRestaurant = restaurantRepository.save(updateRestaurant);
	        return RestaurantMapper.toDTO(savedRestaurant, false);
	   }

	   @Override
	   public List<RestaurantDTO> getAllRestaurants() {
		
		  List<Restaurant> restaurants = restaurantRepository.findAll();
		  
		  
		  List<RestaurantDTO> restaurantDTOs = new ArrayList<>();
		   
		  
		  for(Restaurant restaurant:restaurants)
		  {
			  restaurantDTOs.add(RestaurantMapper.toDTO(restaurant, true));
		  }
		return restaurantDTOs;
	   }

	   @Override
	   public List<RestaurantDTO> findRestaurantByName(String restaurant_name) {
		
		   List<Restaurant> restaurants = restaurantRepository.findAll();
		   List<RestaurantDTO> restaurantDTOs = new ArrayList<>();
		   
		   for(Restaurant restaurant:restaurants)
		   {
			   
			   if(restaurant.getRestaurant_name().equals(restaurant_name))
			   {
			   restaurantDTOs.add(RestaurantMapper.toDTO(restaurant, false));
			   break;
			   }
		   }
		   
		   
		return restaurantDTOs;
	   }

	   @Override
	   public boolean deleteRestaurantById(long id) {
		
		   
		   
		   if(restaurantRepository.existsById(id))
		   {
			   
			   Restaurant restaurant=restaurantRepository.findById(id).get();
			   
			   
			   for(DeliveryApp app:restaurant.getDelivery_apps())
			   {
				   app.getRestaurants().remove(restaurant);
			   }
			   
			 restaurant.getDelivery_apps().clear();
			  			   
			   
			   restaurantRepository.deleteById(id);
			   return true;
		   }
		
		   return false;
	   }



}
