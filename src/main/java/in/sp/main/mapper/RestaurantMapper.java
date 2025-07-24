package in.sp.main.mapper;

import java.util.stream.Collectors;

import in.sp.main.dto.RestaurantDTO;
import in.sp.main.entities.Restaurant;

public class RestaurantMapper {

    public static RestaurantDTO toDTO(Restaurant restaurant, boolean includeDeliveryApps) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setRestaurant_id(restaurant.getRestaurant_id());
        dto.setRestaurant_name(restaurant.getRestaurant_name());
        dto.setLocation(restaurant.getLocation());
        dto.setContact_number(restaurant.getContact_number());
        dto.setRating(restaurant.getRating());

        if (includeDeliveryApps && restaurant.getDelivery_apps() != null) {
            dto.setDelivery_apps(
                restaurant.getDelivery_apps().stream()
                    .map(app -> DeliveryAppMapper.toDTO(app, false)) // prevent circular nesting
                    .collect(Collectors.toSet())
            );
        }

        return dto;
    }

    public static Restaurant toEntity(RestaurantDTO dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurant_id(dto.getRestaurant_id());
        restaurant.setRestaurant_name(dto.getRestaurant_name());
        restaurant.setLocation(dto.getLocation());
        restaurant.setContact_number(dto.getContact_number());
        restaurant.setRating(dto.getRating());

        if(dto.getDelivery_apps()!=null)
        {
        	restaurant.setDelivery_apps(dto.getDelivery_apps().stream().map(r-> DeliveryAppMapper.toEntity(r)).collect(Collectors.toSet()));
        }

        return restaurant;
    }
}
