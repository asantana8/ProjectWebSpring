package com.santana.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santana.myfirstproject.entities.Product;
import com.santana.myfirstproject.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	ProductRepository productRepsoitory;
	
	@GetMapping
	public ResponseEntity<List<Product>> findlAll(){
		return ResponseEntity.ok().body(productRepsoitory.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findlById(@PathVariable Long id){
		return ResponseEntity.ok().body(productRepsoitory.findById(id).get());
	}

}
