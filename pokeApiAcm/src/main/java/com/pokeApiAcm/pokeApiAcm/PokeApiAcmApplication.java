package com.pokeApiAcm.pokeApiAcm;

import com.pokeApiAcm.pokeApiAcm.services.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokeApiAcmApplication implements CommandLineRunner {

	private PokeService pokeService;

	public PokeApiAcmApplication(@Autowired PokeService pokeService) {
		this.pokeService = pokeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PokeApiAcmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		pokeService.getPokeByName("ditto");
	}
}
