package in.sp.main.services;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.sp.main.dto.DeliveryAppDTO;
import in.sp.main.dto.RestaurantDTO;
import in.sp.main.entities.DeliveryApp;
import in.sp.main.entities.Restaurant;
import in.sp.main.mapper.DeliveryAppMapper;
import in.sp.main.mapper.RestaurantMapper;
import in.sp.main.repository.DeliveryAppRepository;

@Service
public class DeliveryAppServiceImp implements DeliveryAppService {

	@Autowired
	DeliveryAppRepository deliveryAppRepository;
	
	@Autowired
	RestaurantService restaurantService;
	
	
	@Override
	public DeliveryAppDTO insertDeliveryAppWithRestaurant(DeliveryAppDTO deliveryAppDTO) {
		
		
		DeliveryApp deliveryApp = DeliveryAppMapper.toEntity(deliveryAppDTO);
		DeliveryApp insertDeliveryApp = deliveryAppRepository.save(deliveryApp);
		
		
		
		
		return DeliveryAppMapper.toDTO(insertDeliveryApp, true);
	}


	@Override
	public List<DeliveryAppDTO> findAllApps() {
		
		
		List<DeliveryApp> deliveryApps = deliveryAppRepository.findAll();
		
		
		List<DeliveryAppDTO> deliveryAppDTOs = deliveryApps.stream().map(app-> DeliveryAppMapper.toDTO(app, true)).collect(Collectors.toList());
		
		
		return deliveryAppDTOs;
	}


	@Override
	public DeliveryAppDTO findAppById(long id) {
		
		 DeliveryApp deliveryApp = deliveryAppRepository.findById(id).get();
		
		DeliveryAppDTO deliveryAppMapper = DeliveryAppMapper.toDTO(deliveryApp,true);
		 
		 
		return deliveryAppMapper;
	}


	@Override
	public DeliveryAppDTO findAppAndRestaurantById(long app_id, long restaurant_id) {

	    DeliveryApp deliveryApp = deliveryAppRepository.findById(app_id).orElse(null);
	    if (deliveryApp == null) {
	        return null; // or throw an exception
	    }

	    // Filter to get only the desired restaurant
	    Set<Restaurant> filteredRestaurants = new LinkedHashSet<>();
	    for (Restaurant restaurant : deliveryApp.getRestaurants()) {
	        if (restaurant.getRestaurant_id() == restaurant_id) {
	            filteredRestaurants.add(restaurant);
	            break;
	        }
	    }

	    // Replace the original set with the filtered one
	    deliveryApp.setRestaurants(filteredRestaurants);

	    // Now map to DTO
	    DeliveryAppDTO deliveryAppDTO = DeliveryAppMapper.toDTO(deliveryApp, true);

	    return deliveryAppDTO;
	}


	@Override
	public void deleteAllApps() {
		
		
		
		deliveryAppRepository.deleteAll();
		
	}


	@Override
	public void deleteAppById(long id) {
		
		
		
		DeliveryApp deliveryApp =  deliveryAppRepository.findById(id).get();
		
	  	DeliveryAppDTO deliveryAppDTO =  DeliveryAppMapper.toDTO(deliveryApp, true);
		
		if(deliveryAppRepository.existsById(id))
		{
		deliveryAppRepository.deleteById(deliveryAppDTO.getApp_id());
		
		}
		
	}

	@Override
	public DeliveryAppDTO updateAppByPut(DeliveryAppDTO updatedAppDTO, long id) {
	    
	    Optional<DeliveryApp> optionalDeliveryApp = deliveryAppRepository.findById(id);

	    DeliveryApp deliveryApp;

	    if (!optionalDeliveryApp.isPresent()) {
	        // Create new record if not found
	        DeliveryApp newDelApp = DeliveryAppMapper.toEntity(updatedAppDTO);
	        newDelApp.setApp_id(id); // Ensure ID is preserved
	        newDelApp = deliveryAppRepository.save(newDelApp);
	        return DeliveryAppMapper.toDTO(newDelApp, true);
	    }

	    // Update existing record
	    deliveryApp = optionalDeliveryApp.get();
	    deliveryApp.setApp_name(updatedAppDTO.getApp_name());
	    deliveryApp.setRating(updatedAppDTO.getRating());

	    // Update restaurant list from DTO
	    Set<Restaurant> updatedRestaurants = new LinkedHashSet<>();
	    if (updatedAppDTO.getRestaurants() != null) {
	        for (RestaurantDTO restaurantDTO : updatedAppDTO.getRestaurants()) {
	            Restaurant updatedRestaurant = RestaurantMapper.toEntity(restaurantDTO);
	            // optional: if you want to persist restaurant update individually
	            restaurantService.updateRestaurantBYPut(restaurantDTO);
	            updatedRestaurants.add(updatedRestaurant);
	        }
	    }

	    deliveryApp.setRestaurants(updatedRestaurants);
	    deliveryApp = deliveryAppRepository.save(deliveryApp);

	    return DeliveryAppMapper.toDTO(deliveryApp, true);
	}


	@Override
	public DeliveryAppDTO updateAppByPatch(DeliveryAppDTO deliveryAppDTO) {
		
		
	    DeliveryApp existingApp = deliveryAppRepository.findById(deliveryAppDTO.getApp_id())
	            .orElseThrow(() -> new RuntimeException("DeliveryApp not found with id: " + deliveryAppDTO.getApp_id()));
		
		DeliveryAppDTO updatedeliveryAppDTO = DeliveryAppMapper.toDTO(existingApp, true); 
		Set<RestaurantDTO> restaurantDTOs = new LinkedHashSet<>();
		
		
	
			
			if(deliveryAppDTO.getApp_name()!=null)
			{
				updatedeliveryAppDTO.setApp_name(deliveryAppDTO.getApp_name());
			}
			if(deliveryAppDTO.getRating()!=0.0f)
			{
				updatedeliveryAppDTO.setRating(deliveryAppDTO.getRating());
			}
			if(!deliveryAppDTO.getRestaurants().isEmpty())
			{
				
				
				for(RestaurantDTO restaurantDTO:deliveryAppDTO.getRestaurants())
				{
					
					RestaurantDTO restaurant = restaurantService.updateRestaurantByPatch(restaurantDTO);
					restaurantDTOs.add(restaurant);
					
				}
				
			}
			
				
		updatedeliveryAppDTO.setRestaurants(restaurantDTOs);
		deliveryAppRepository.save(DeliveryAppMapper.toEntity(updatedeliveryAppDTO));
		
		return updatedeliveryAppDTO;
	}




}
