package br.com.fmbordignon.hands_on.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}


//só pra salvar kkk
//curl -X POST localhost:8080/api/v1/book -H 'Content-Type: application/json' -d '{"name": "nome"}'