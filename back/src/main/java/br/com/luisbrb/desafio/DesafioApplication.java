package br.com.luisbrb.desafio;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import br.com.luisbrb.desafio.spring.repository.utils.RepositoryTestData;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(DesafioApplication.class, args);
		RepositoryTestData.criarDadosExemplo(context);
	}

	
}
