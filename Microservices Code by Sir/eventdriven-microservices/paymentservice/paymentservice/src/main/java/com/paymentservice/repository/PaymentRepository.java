package com.paymentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String>{
	
	@Query("FROM Payment where orderId=?1")
	public List<Payment> findPaymentByOrderId(String orderId);

}
