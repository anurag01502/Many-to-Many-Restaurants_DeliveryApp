package in.sp.main.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="delivery_app")
public class DeliveryApp {

	public DeliveryApp(){}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long app_id;
	
	
	@Column
   	private String app_name;
	
	@Column
	private float rating;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="Apps_Restaurents",joinColumns = @JoinColumn(name="app_id"), inverseJoinColumns = @JoinColumn(name="restaurant_id"))
	private Set<Restaurant> restaurants;

	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}


	public void setRestaurants(Set<Restaurant> restaurants) {
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
