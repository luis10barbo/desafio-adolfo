package br.com.luisbrb.desafio;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(DesafioApplication.class, args);
		criarDadosExemplo(context);
	}

	public static void criarDadosExemplo(ConfigurableApplicationContext context) throws IOException {
		OrgaoInstitucionalRepository repoOrgaoInstitucional = context.getBean(OrgaoInstitucionalRepository.class);
		AreaTematicaRepository repoAreaTematicaRepository = context.getBean(AreaTematicaRepository.class);
		NoticiaAreaTematicaRepository noticiaAreaTematicaRepository = context.getBean(NoticiaAreaTematicaRepository.class);
		NoticiaOrgaoInstitucionalRepository noticiaOrgaoInstitucionalRepository = context.getBean(NoticiaOrgaoInstitucionalRepository.class);
		NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);

		int idOrgaoInstitucional1 = repoOrgaoInstitucional.inserir(new OrgaoInstitucional(null, "Detran"));
		int idOrgaoInstitucional2 = repoOrgaoInstitucional.inserir(new OrgaoInstitucional(null, "Outro"));
		int idAreaTematica = repoAreaTematicaRepository.inserir(new AreaTematica(null, "Detran"));
        byte[] image1 = Files.readAllBytes(Paths.get("./placeholder/1.jpg"));
        byte[] image2 = Files.readAllBytes(Paths.get("./placeholder/3.jpg"));
        byte[] image3 = Files.readAllBytes(Paths.get("./placeholder/4.jpg"));

		Noticia noticia = new Noticia(null, "Tutoria com apoio de IA no Senar Goiás: suporte inteligente e eficas para alunos", null, 8, "Luis", image1);
		Noticia noticia2 = new Noticia(null, "Avanços na Agricultura de Precisão com IA no Campo", null, 6, "Ana Silva", image1);
		Noticia noticia3 = new Noticia(null, "Senar Goiás lança plataforma de ensino com IA integrada", null, 7, "Carlos Souza", image2);
		
		int idNoticia = noticiaRepository.inserir(noticia);

		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia, idAreaTematica));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia, idOrgaoInstitucional1));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia, idOrgaoInstitucional2));

		int idEmbrapa = repoOrgaoInstitucional.inserir(new OrgaoInstitucional(null, "Embrapa"));
		int idMapa = repoOrgaoInstitucional.inserir(new OrgaoInstitucional(null, "Ministério da Agricultura"));
		int idSebrae = repoOrgaoInstitucional.inserir(new OrgaoInstitucional(null, "Sebrae"));
		int idSenai = repoOrgaoInstitucional.inserir(new OrgaoInstitucional(null, "SENAI Goiás"));
		int idIfGoiano = repoOrgaoInstitucional.inserir(new OrgaoInstitucional(null, "IF Goiano"));

		int idAgroTech = repoAreaTematicaRepository.inserir(new AreaTematica(null, "AgroTech"));
		int idSustentabilidade = repoAreaTematicaRepository.inserir(new AreaTematica(null, "Sustentabilidade"));
		int idEducacaoRural = repoAreaTematicaRepository.inserir(new AreaTematica(null, "Educação Rural"));
		int idGestaoAgricola = repoAreaTematicaRepository.inserir(new AreaTematica(null, "Gestão Agrícola"));
		int idInovacao = repoAreaTematicaRepository.inserir(new AreaTematica(null, "Inovação no Agro"));


		int idNoticia4 = noticiaRepository.inserir(new Noticia(null,
			"Embrapa lança sistema de IA para monitoramento de solos no Brasil",
			Timestamp.valueOf("2025-05-14 09:30:00"), 7, "Rafael Souza", image2));

		int idNoticia5 = noticiaRepository.inserir(new Noticia(null,
			"Ministério da Agricultura investe em drones para fiscalizar áreas rurais",
			Timestamp.valueOf("2025-05-20 14:10:45"), 6, "Luciana Costa", image3));

		int idNoticia6 = noticiaRepository.inserir(new Noticia(null,
			"Sebrae oferece capacitação gratuita em tecnologia para pequenos produtores",
			Timestamp.valueOf("2025-05-18 10:25:37"), 5, "Gabriel Lima", image1));

		int idNoticia7 = noticiaRepository.inserir(new Noticia(null,
			"SENAI Goiás implementa IA em cursos técnicos voltados ao agronegócio",
			Timestamp.valueOf("2025-05-23 16:45:12"), 8, "Fernanda Oliveira", image2));

		int idNoticia8 = noticiaRepository.inserir(new Noticia(null,
			"IF Goiano desenvolve sensores inteligentes para monitoramento de plantações",
			Timestamp.valueOf("2025-05-10 08:50:00"), 9, "Bruno Martins", image3));

		int idNoticia9 = noticiaRepository.inserir(new Noticia(null,
			"Inteligência Artificial ajuda no combate às pragas nas lavouras brasileiras",
			Timestamp.valueOf("2025-05-25 11:15:20"), 8, "Juliana Mendes", image1));

		int idNoticia10 = noticiaRepository.inserir(new Noticia(null,
			"Uso de blockchain garante rastreabilidade na cadeia produtiva agrícola",
			Timestamp.valueOf("2025-05-15 15:40:33"), 7, "Thiago Barbosa", image2));

		int idNoticia11 = noticiaRepository.inserir(new Noticia(null,
			"Agricultura regenerativa ganha força no Brasil com apoio de IA",
			Timestamp.valueOf("2025-05-19 09:05:22"), 9, "Patrícia Ferreira", image3));

		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia4, idGestaoAgricola));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia5, idInovacao));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia6, idEducacaoRural));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia7, idAgroTech));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia8, idAgroTech));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia9, idSustentabilidade));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia10, idGestaoAgricola));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia11, idSustentabilidade));

		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia4, idEmbrapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia5, idMapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia6, idSebrae));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia7, idSenai));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia8, idIfGoiano));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia9, idEmbrapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia10, idMapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia11, idEmbrapa));
	}
}
