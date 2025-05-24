package br.com.luisbrb.desafio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.luisbrb.desafio.model.OrgaoInstitucional;
import br.com.luisbrb.desafio.repository.OrgaoInstitucionalRepository;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DesafioApplication.class, args);
		OrgaoInstitucionalRepository repo = context.getBean(OrgaoInstitucionalRepository.class);
		repo.inserir(new OrgaoInstitucional(null, "Teste"));
		System.out.println(repo.adquirir().toString());
		repo.atualizar(new OrgaoInstitucional(1, "Luis"));
		System.out.println(repo.adquirir().toString());
	}
}
