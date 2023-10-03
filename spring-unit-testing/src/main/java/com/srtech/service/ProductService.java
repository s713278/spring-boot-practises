package com.srtech.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srtech.entity.Product;
import com.srtech.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		Iterator<Product> iter = productRepository.findAll().iterator();
		List<Product> list = new ArrayList<>();
		while (iter.hasNext()) {
			list.add(iter.next());
		}
		log.debug("Products Size :"+list.size());
		return list;
	}

	public Product getProduct(Integer uuid) {
		Optional<Product> op=productRepository.findById(uuid);
		return op.get();
	}
}
