package in.sp.main.dto;

import java.util.Set;


public class DeliveryAppDTO {

	
	private long app_id;
   	private String app_name;
	private float rating;
	private Set<RestaurantDTO> restaurants;
	
	public Set<RestaurantDTO> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Set<RestaurantDTO> restaurants) {
		this.restaurants = restaurants;
	}



	public long getApp_id() {
		return app_id;
	}


	public void setApp_id(long app_id) {
		this.app_id = app_id;
	}

	public String getApp_name() {
		return app_name;
	}



	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}



	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}
	
}
