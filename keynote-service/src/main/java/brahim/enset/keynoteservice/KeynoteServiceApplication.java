package brahim.enset.keynoteservice;

import brahim.enset.keynoteservice.dtos.KeynoteDTO;
import brahim.enset.keynoteservice.services.KeynoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeynoteServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeKeynotes(KeynoteService keynoteService) {
		return args -> {
			// Créer des enregistrements à ajouter en utilisant le Builder
			KeynoteDTO keynote1 = KeynoteDTO.builder()
					.firstName("Brahim")
					.lastName("NAJI")
					.email("brahim@example.com")
					.function("CEO")
					.build();

			KeynoteDTO keynote2 = KeynoteDTO.builder()
					.firstName("Mohammed")
					.lastName("SALHI")
					.email("Mohammed@example.com")
					.function("CTO")
					.build();

			KeynoteDTO keynote3 = KeynoteDTO.builder()
					.firstName("Ahmed")
					.lastName("HAJJI")
					.email("ahmed@example.com")
					.function("CMO")
					.build();

			keynoteService.saveKeynote(keynote1);
			keynoteService.saveKeynote(keynote2);
			keynoteService.saveKeynote(keynote3);
		};
	}


}
