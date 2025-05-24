package br.com.luisbrb.desafio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.luisbrb.desafio.spring.model.AreaTematica;
import br.com.luisbrb.desafio.spring.model.OrgaoInstitucional;
import br.com.luisbrb.desafio.spring.repository.AreaTematicaRepository;
import br.com.luisbrb.desafio.spring.repository.OrgaoInstitucionalRepository;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DesafioApplication.class, args);
		OrgaoInstitucionalRepository repo = context.getBean(OrgaoInstitucionalRepository.class);
		repo.inserir(new OrgaoInstitucional(null, "Detran"));
		context.getBean(AreaTematicaRepository.class).inserir(new AreaTematica(null, "Detran"));
	}
}
