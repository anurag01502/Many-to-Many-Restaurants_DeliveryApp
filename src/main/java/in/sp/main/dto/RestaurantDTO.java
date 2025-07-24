package in.sp.main.dto;

import java.util.Set;


public class RestaurantDTO {


	private long restaurant_id;
   	private String restaurant_name;
	private float rating;
	private String location;
	private long contact_number;
	private Set<DeliveryAppDTO> delivery_apps;
	public Set<DeliveryAppDTO> getDelivery_apps() {
		return delivery_apps;
	}


	public void setDelivery_apps(Set<DeliveryAppDTO> delivery_apps) {
		this.delivery_apps = delivery_apps;
	}


	public long getRestaurant_id() {
		return restaurant_id;
	}


	public void setRestaurant_id(long restaurant_id) {
		this.restaurant_id = restaurant_id;
	}


	public String getRestaurant_name() {
		return restaurant_name;
	}


	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public long getContact_number() {
		return contact_number;
	}


	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}
	
	
	
}
