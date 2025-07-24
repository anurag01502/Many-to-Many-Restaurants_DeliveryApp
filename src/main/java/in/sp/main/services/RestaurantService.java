package in.sp.main.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import in.sp.main.dto.RestaurantDTO;

public interface RestaurantService {

	@Transactional
	public RestaurantDTO updateRestaurantBYPut(RestaurantDTO restaurantDTO);
	
	@Transactional
	List<RestaurantDTO> getAllRestaurants();
	
	
	@Transactional
	public RestaurantDTO updateRestaurantByPatch(RestaurantDTO restaurantDTO);
	
	@Transactional
	List<RestaurantDTO> findRestaurantByName(String restaurant_name);
	
	
	@Transactional
	boolean deleteRestaurantById(long id);
	
}
