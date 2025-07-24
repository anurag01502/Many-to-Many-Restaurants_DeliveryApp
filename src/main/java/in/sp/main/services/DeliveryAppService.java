package in.sp.main.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import in.sp.main.dto.DeliveryAppDTO;


public interface DeliveryAppService {

	
	
	
	@Transactional
	DeliveryAppDTO insertDeliveryAppWithRestaurant(DeliveryAppDTO deliveryAppDTO);

	
	@Transactional
	List<DeliveryAppDTO> findAllApps();
		
	@Transactional
	DeliveryAppDTO findAppById(long id);
	
	@Transactional
	DeliveryAppDTO findAppAndRestaurantById(long app_id,long restaurant_id );
	
	@Transactional
	void deleteAllApps();
	
	
	@Transactional
	void deleteAppById(long id);
	
	@Transactional
	public DeliveryAppDTO updateAppByPut(DeliveryAppDTO updatedAppDTO,long id);
	
	
	@Transactional
	DeliveryAppDTO updateAppByPatch(DeliveryAppDTO deliveryAppDTO);
	
	
}
