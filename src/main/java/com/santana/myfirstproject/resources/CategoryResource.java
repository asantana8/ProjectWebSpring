package com.santana.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santana.myfirstproject.entities.Category;
import com.santana.myfirstproject.repositories.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	CategoryRepository categoryRep;
	
	@GetMapping
	public ResponseEntity<List<Category>> findlAll(){
		return ResponseEntity.ok().body(categoryRep.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findlById(@PathVariable Long id){
		return ResponseEntity.ok().body(categoryRep.findById(id).get());
	}

}
