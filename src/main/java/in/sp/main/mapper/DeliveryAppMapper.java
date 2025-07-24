package in.sp.main.mapper;


import java.util.stream.Collectors;

import in.sp.main.dto.DeliveryAppDTO;
import in.sp.main.entities.DeliveryApp;

public class DeliveryAppMapper {

    public static DeliveryAppDTO toDTO(DeliveryApp deliveryApp, boolean includeRestaurants) {
        DeliveryAppDTO dto = new DeliveryAppDTO();
        dto.setApp_id(deliveryApp.getApp_id());
        dto.setApp_name(deliveryApp.getApp_name());
        dto.setRating(deliveryApp.getRating());

        if (includeRestaurants && deliveryApp.getRestaurants() != null) {
            dto.setRestaurants(
                deliveryApp.getRestaurants().stream()
                    .map(r -> RestaurantMapper.toDTO(r, false)) // avoid infinite loop
                    .collect(Collectors.toSet())
            );
        }

        return dto;
    }


    public static DeliveryApp toEntity(DeliveryAppDTO dto) {
        DeliveryApp deliveryApp = new DeliveryApp();
        deliveryApp.setApp_id(dto.getApp_id());
        deliveryApp.setApp_name(dto.getApp_name());
        deliveryApp.setRating(dto.getRating());
       
        if(dto.getRestaurants()!=null)
        {
        	
        	deliveryApp.setRestaurants(dto.getRestaurants().stream().map(r->RestaurantMapper.toEntity(r)).collect(Collectors.toSet()));
        }

        return deliveryApp;
    }
}
