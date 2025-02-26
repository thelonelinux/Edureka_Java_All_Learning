package com.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.orderservice.entity.Order;
import com.paymentservice.entity.Payment;
import com.paymentservice.repository.PaymentRepository;

@Component
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@JmsListener(destination="order_created_event")
	public void receiveOrderData(@Payload Order order) {
		
		try {
			Thread.sleep(200);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		//processs payment, invoke 3rd party payment gateway
		//paymentgateway response is success or failure
		boolean paymentGatewaySuccessResponse = true;
		if(paymentGatewaySuccessResponse) {
			Payment payment = new Payment();
			payment.setPaymentId(System.currentTimeMillis()+"");
			payment.setOrderId(order.getOrderId());
			payment.setPaymentDate(new java.sql.Date(new java.util.Date().getTime()));
			paymentRepository.save(payment);
			jmsTemplate.convertAndSend("payment_created_event", order);
			
		}
		
	}
	
	@JmsListener(destination="inventory_failed_event")
	public void receiveInventortFailedEvent(@Payload Order order) {
		
		try {
			Thread.sleep(200);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		Payment payment = paymentRepository.findPaymentByOrderId(order.getOrderId()).get(0);
		//cancel the payment, send payment cancellation to paymengateway
		paymentRepository.delete(payment);
		jmsTemplate.convertAndSend("payment_failed_event",order);
		
	}
	
	

}
