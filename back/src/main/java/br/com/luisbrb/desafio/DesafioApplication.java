package br.com.luisbrb.desafio;
import java.sql.Timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.luisbrb.desafio.spring.model.tabelas.AreaTematica;
import br.com.luisbrb.desafio.spring.model.tabelas.Noticia;
import br.com.luisbrb.desafio.spring.model.tabelas.NoticiaAreaTematica;
import br.com.luisbrb.desafio.spring.model.tabelas.NoticiaOrgaoInstitucional;
import br.com.luisbrb.desafio.spring.model.tabelas.OrgaoInstitucional;
import br.com.luisbrb.desafio.spring.repository.AreaTematicaRepository;
import br.com.luisbrb.desafio.spring.repository.NoticiaAreaTematicaRepository;
import br.com.luisbrb.desafio.spring.repository.NoticiaOrgaoInstitucionalRepository;
import br.com.luisbrb.desafio.spring.repository.NoticiaRepository;
import br.com.luisbrb.desafio.spring.repository.OrgaoInstitucionalRepository;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DesafioApplication.class, args);
		criarDadosExemplo(context);
	}

	public static void criarDadosExemplo(ConfigurableApplicationContext context) {
		OrgaoInstitucionalRepository repo = context.getBean(OrgaoInstitucionalRepository.class);
		int idOrgaoInstitucional1 = repo.inserir(new OrgaoInstitucional(null, "Detran"));
		int idOrgaoInstitucional2 = repo.inserir(new OrgaoInstitucional(null, "Outro"));
		int idAreaTematica = context.getBean(AreaTematicaRepository.class).inserir(new AreaTematica(null, "Detran"));
		int idNoticia = context.getBean(NoticiaRepository.class).inserir(new Noticia(null, "Tutoria com apoio de IA no Senar Goiás: suporte inteligente e eficas para alunos", new Timestamp(0), 8));
		context.getBean(NoticiaAreaTematicaRepository.class).inserir(new NoticiaAreaTematica(null, idNoticia, idAreaTematica));
		context.getBean(NoticiaOrgaoInstitucionalRepository.class).inserir(new NoticiaOrgaoInstitucional(null, idNoticia, idOrgaoInstitucional1));
		context.getBean(NoticiaOrgaoInstitucionalRepository.class).inserir(new NoticiaOrgaoInstitucional(null, idNoticia, idOrgaoInstitucional2));

		context.getBean(NoticiaRepository.class).inserir(new Noticia(null, "Outra noticia sem orgao ou area tematica", new Timestamp(0), 8));

	}
}
