package in.sp.main.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Restaurant")
public class Restaurant {

	public Restaurant(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long restaurant_id;
	
	
	@Column
   	private String restaurant_name;
	
	
	@Column
	private float rating;
	
	
	@Column
	private String location;
	
	@Column
	private long contact_number;
	
	@ManyToMany(mappedBy = "restaurants")
	private Set<DeliveryApp> delivery_apps;

	public Set<DeliveryApp> getDelivery_apps() {
		return delivery_apps;
	}

	public void setDelivery_apps(Set<DeliveryApp> delivery_apps) {
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
