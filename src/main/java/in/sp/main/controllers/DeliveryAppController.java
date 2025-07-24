package in.sp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.dto.DeliveryAppDTO;
import in.sp.main.repository.DeliveryAppRepository;
import in.sp.main.services.DeliveryAppService;


@RestController
public class DeliveryAppController {

	@Autowired
	DeliveryAppRepository deliveryAppRepository;
	
	@Autowired
	DeliveryAppService deliveryAppService;
	
	
	@PostMapping("/delivery_app")
	public DeliveryAppDTO insertDeliveryAppWithRestaurant(@RequestBody DeliveryAppDTO deliveryAppDTO)
	{
		
		return deliveryAppService.insertDeliveryAppWithRestaurant(deliveryAppDTO);
	}
	
	
	@GetMapping("/delivery_app")
	public ResponseEntity<List<DeliveryAppDTO>> getAllApps()
	{
		 List<DeliveryAppDTO> deliveryAppDTOs =  deliveryAppService.findAllApps();
		return ResponseEntity.ok(deliveryAppDTOs);
	}
	
	@GetMapping("/delivery_app/{id}")
	public ResponseEntity<DeliveryAppDTO> getAppById(@PathVariable long id)
	{
		
		DeliveryAppDTO deliveryAppDTO =deliveryAppService.findAppById(id);
		
		return ResponseEntity.ok().body(deliveryAppDTO);
	}
	
	
	
	
	@GetMapping("/delivery_app/{app_id}/restaurant/{restaurant_id}")	
	public ResponseEntity<DeliveryAppDTO> getAppAndRestaurantById(@PathVariable long app_id,@PathVariable long restaurant_id )
	{
		DeliveryAppDTO deliveryAppDTO = deliveryAppService.findAppAndRestaurantById(app_id, restaurant_id);
		
		return ResponseEntity.ok().body(deliveryAppDTO);
		
	}
	
	
	@DeleteMapping("/delivery_app")	
	public ResponseEntity<Void> deleteAllApps()
	{
		
		if(!deliveryAppRepository.findAll().isEmpty())
		{
			deliveryAppService.deleteAllApps();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/delivery_app/{id}")
	public ResponseEntity<Void> deleteAppById(@PathVariable long id)
	{
		
		if(deliveryAppRepository.existsById(id))
		{
			deliveryAppService.deleteAppById(id);
		}
		
		return ResponseEntity.noContent().build();
	}	
	
	@PutMapping("/delivery_app/{id}")
	public ResponseEntity<DeliveryAppDTO> updateDeliveryAppByIdwithPut(@RequestBody DeliveryAppDTO deliveryAppDTO,@PathVariable long id)
	{
		
		
		
	
		 DeliveryAppDTO deliveryAppUpdated =deliveryAppService.updateAppByPut( deliveryAppDTO,id);
		
		
		
		return ResponseEntity.ok(deliveryAppUpdated);
		
		
	}
	
	
	@PatchMapping("/delivery_app")
	public ResponseEntity<DeliveryAppDTO> updateDeliveryAppByIdwithPatch(@RequestBody DeliveryAppDTO deliveryAppDTO)
	{
		
		DeliveryAppDTO deliveryAppUpdated = deliveryAppService.updateAppByPatch(deliveryAppDTO);
		
		return ResponseEntity.ok(deliveryAppUpdated);
		
	}	
	
	
	
	
}
