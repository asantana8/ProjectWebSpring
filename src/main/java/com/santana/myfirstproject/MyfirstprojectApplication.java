package com.santana.myfirstproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santana.myfirstproject.entities.Category;
import com.santana.myfirstproject.entities.Product;
import com.santana.myfirstproject.repositories.CategoryRepository;
import com.santana.myfirstproject.repositories.ProductRepository;

@SpringBootApplication
public class MyfirstprojectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyfirstprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// carga categorias
		Category cat1 = new Category(1L, "Eletronics");
		Category cat2 = new Category(2L, "Books");
		Category cat3 = new Category(3L, "Informatica");

		// carga produtos
		Product p1 = new Product(1L, "TV", 2500.20, cat1);
		Product p2 = new Product(2L, "SENHOR DOS ANEIS", 2500.20, cat2);
		Product p3 = new Product(3L, "TORRADEIRA", 2500.20, cat1);
		Product p4 = new Product(4L, "BIBLIA SAGRADA", 2500.20, cat2);

		// associando produtos a categorias
		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat1.getProducts().addAll(Arrays.asList(p2, p4));

		// salvar tudo
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		categoryRepository.save(cat3);

	}

}
