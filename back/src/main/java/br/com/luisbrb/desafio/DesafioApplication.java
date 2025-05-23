package br.com.luisbrb.desafio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.luisbrb.desafio.model.OrgaoInstitucionalModel;
import br.com.luisbrb.desafio.repository.OrgaoInstitucionalRepository;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DesafioApplication.class, args);
		OrgaoInstitucionalRepository repo = context.getBean(OrgaoInstitucionalRepository.class);
		repo.inserir(new OrgaoInstitucionalModel(null, "Teste"));
	}

	@Autowired
  JdbcTemplate jdbcTemplate;

}
