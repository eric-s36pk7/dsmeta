package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController { // Controller é a classe responsavel por implementar a api, disponibilizando os endpoints para o frontend acessar o backend

	@Autowired
	private SaleService service;
	
	@GetMapping
	public List<Sale> findSales(){
		return service.findSales();
	}
	
}
