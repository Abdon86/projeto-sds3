package com.devsuperior.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleReposytory;
import com.devsuperior.dsvendas.repositories.SellerReposytory;

@Service
public class SaleService {

	@Autowired
	private SaleReposytory reposytory;

	@Autowired
	private SellerReposytory sellerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = reposytory.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}

}
