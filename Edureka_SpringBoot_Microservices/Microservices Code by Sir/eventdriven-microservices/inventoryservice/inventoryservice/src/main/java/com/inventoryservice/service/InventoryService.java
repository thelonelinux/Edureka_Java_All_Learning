package com.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.inventoryservice.entity.Inventory;
import com.inventoryservice.repository.InventoryRepository;
import com.orderservice.entity.Order;

@Component
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	JmsTemplate jmsTemplate;

	@JmsListener(destination = "payment_created_event")
	public void receiveOrderData(@Payload Order order) {

		try {
			Thread.sleep(200);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			Inventory inventory = new Inventory();
			List<Inventory> inventoryList = inventoryRepository.findInventoryByProductId(order.getProductId());
			int quantity = inventoryList.get(0).getQuantity();
			if (quantity <= 0) {
				throw new Exception("Inventory not found");
			}
			quantity = quantity - 1;
			inventory.setQuantity(quantity);
			inventory.setProductId(inventoryList.get(0).getProductId());
			inventory.setInventoryId(inventoryList.get(0).getInventoryId());
			inventoryRepository.save(inventory);
			jmsTemplate.convertAndSend("inventory_updated_event", order);
		} catch (Exception ex) {
			ex.printStackTrace();
			
			//send failed event to exception queue
			order.setOrderStatus(ex.getMessage());
			jmsTemplate.convertAndSend("inventory_failed_event", order);
		}

	}

}
