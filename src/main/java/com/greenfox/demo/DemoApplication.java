package com.greenfox.demo;

import com.greenfox.demo.Model.Todo;
import com.greenfox.demo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		todoRepository.save(new Todo("Nesze"));
//		todoRepository.save(new Todo("Valami"));
//		todoRepository.save(new Todo("Akarmi"));
//		todoRepository.save(new Todo("Barmi"));
	}
}
