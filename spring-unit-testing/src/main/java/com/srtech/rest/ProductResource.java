package com.srtech.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srtech.entity.Product;
import com.srtech.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/products")
@Slf4j
@Tag(name = "Products", description = "Manage Product Catalog")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@Operation(summary = "Get Products", tags = {"Products"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", 
            description = "The Products are returned successfully",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Product.class))))
    })
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>>  getProducts() {
		List<Product> products = productService.getProducts();
		log.debug("products {}",products);

		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}

	@GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProduct(@PathVariable Integer productId) {
		Product product = productService.getProduct(productId);
		log.debug("products {}",product);
		return product;
	}
}
