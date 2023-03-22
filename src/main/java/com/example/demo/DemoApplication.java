package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Condidat;
import com.example.demo.repository.CondidatRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner start(CondidatRepository repo) {
		return args -> {
			Stream.of(Condidat.builder().fistName("Rihab").build(),
					Condidat.builder().fistName("test").build())
					.forEach(candidat -> {
						repo.save(candidat);
					});
			repo.findAll().forEach(s -> System.out.println(s.getFistName()));

		};

	}

}
