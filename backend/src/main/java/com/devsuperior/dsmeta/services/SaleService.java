package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) { //Pageable é uma classe do String
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()); //Criando uma variavel com o dia atual
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);// condicao ternaria, se minDate for vazio, considerar a data de um ano atras
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate); // condicao ternaria, se o maxDate for vazio, considerar a data de hoje
		
		return repository.findSales(min, max, pageable); 
	}
	
}
