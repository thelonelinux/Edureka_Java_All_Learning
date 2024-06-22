package com.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.orderservice.entity.Order;
import com.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	
	public String createOrder(Order order) {
		order.setOrderId(System.currentTimeMillis()+"");
		order.setOrderStatus("pending");
		orderRepository.save(order);
		jmsTemplate.convertAndSend("order_created_event", order);
		return "order creation is in progress "+order.getOrderId();
	}
	
	@JmsListener(destination="inventory_updated_event")
	public void confirmOrder(@Payload Order order) {
		try {
			Thread.sleep(200);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		//update order status to confirmed
		order.setOrderStatus("confirmed");
		orderRepository.save(order);
		//invoke notification service to send confirmed order
	}
	
	@JmsListener(destination="payment_failed_event")
	public void receivePaymentFailure(@Payload Order order) {
		try {
			Thread.sleep(200);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		//update order status to cancelled/exception message
		order.setOrderStatus(order.getOrderStatus());
		orderRepository.save(order);
		//invoke notification service to send cancelled order
	}
	

}
