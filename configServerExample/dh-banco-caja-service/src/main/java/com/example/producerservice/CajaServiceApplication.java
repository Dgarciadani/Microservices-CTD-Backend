package com.example.producerservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CajaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CajaServiceApplication.class, args);
	}

}

@RestController
class CajaController {
	@Value("${cantidad_maxima_efectivo}")
	private int maxEfectivoCaja;
	
	@Value("${denominaciones_billete}")
	private int[] denominacionesBillete;
	
	@RequestMapping(method = RequestMethod.GET, path ="/caja/info")
	public Map<String, String> message() {
		Map<String, String> response = new HashMap<>();
		
		response.put("Cantidad maxima de efectivo por caja",String.valueOf(maxEfectivoCaja));

		int i = 1;
		for (int domain:denominacionesBillete) {
			response.put("denominacion " + i, String.valueOf(domain));
			i++;
		}

		return response;
	}
}