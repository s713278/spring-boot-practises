package com.srtech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srtech.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
