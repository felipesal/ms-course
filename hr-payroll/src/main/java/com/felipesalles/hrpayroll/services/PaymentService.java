package com.felipesalles.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.felipesalles.hrpayroll.entities.Payment;
import com.felipesalles.hrpayroll.entities.Worker;
import com.felipesalles.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, Integer days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", Long.toString(workerId));
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(
				worker.getName(), 
				worker.getDailyIncome(), 
				days
				);
	}
}
