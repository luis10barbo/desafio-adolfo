package br.com.luisbrb.desafio.spring.repository.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;

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

public class RepositoryTestData {
    public static void criarDadosExemplo(ConfigurableApplicationContext context) throws IOException {
		OrgaoInstitucionalRepository repoOrgaoInstitucional = context.getBean(OrgaoInstitucionalRepository.class);
		AreaTematicaRepository repoAreaTematicaRepository = context.getBean(AreaTematicaRepository.class);
		NoticiaAreaTematicaRepository noticiaAreaTematicaRepository = context.getBean(NoticiaAreaTematicaRepository.class);
		NoticiaOrgaoInstitucionalRepository noticiaOrgaoInstitucionalRepository = context.getBean(NoticiaOrgaoInstitucionalRepository.class);
		NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);

        byte[] image1 = Files.readAllBytes(Paths.get("./placeholder/1.jpg"));
        byte[] image2 = Files.readAllBytes(Paths.get("./placeholder/3.jpg"));
        byte[] image3 = Files.readAllBytes(Paths.get("./placeholder/4.jpg"));

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

		int idNoticia12 = noticiaRepository.inserir(new Noticia(null,
			"Plataformas digitais impulsionam a comercialização agrícola no Brasil",
			Timestamp.valueOf("2025-05-12 09:30:00"), 7, "Renato Silva", image1));

		int idNoticia13 = noticiaRepository.inserir(new Noticia(null,
			"Embrapa desenvolve IA para previsão de safra mais precisa",
			Timestamp.valueOf("2025-05-18 11:20:00"), 8, "Carla Mendes", image2));

		int idNoticia14 = noticiaRepository.inserir(new Noticia(null,
			"Sebrae orienta produtores sobre uso de tecnologia sustentável",
			Timestamp.valueOf("2025-05-21 15:10:30"), 6, "Juliano Costa", image3));

		int idNoticia15 = noticiaRepository.inserir(new Noticia(null,
			"Sensores climáticos ajudam agricultores a reduzir perdas",
			Timestamp.valueOf("2025-05-24 10:55:20"), 7, "Fernanda Lopes", image2));

		int idNoticia16 = noticiaRepository.inserir(new Noticia(null,
			"Agricultura brasileira adota IA para gestão hídrica eficiente",
			Timestamp.valueOf("2025-05-17 08:25:15"), 8, "Marcelo Oliveira", image1));

		int idNoticia17 = noticiaRepository.inserir(new Noticia(null,
			"Ministério da Agricultura apoia startups de AgTech no país",
			Timestamp.valueOf("2025-05-14 13:05:45"), 9, "Aline Souza", image3));

		int idNoticia18 = noticiaRepository.inserir(new Noticia(null,
			"SENAI Goiás lança laboratório de inovação voltado ao agro",
			Timestamp.valueOf("2025-05-22 16:00:00"), 7, "Lucas Martins", image2));

		int idNoticia19 = noticiaRepository.inserir(new Noticia(null,
			"IF Goiano promove workshop sobre IA no agronegócio",
			Timestamp.valueOf("2025-05-20 09:15:00"), 8, "Patrícia Silva", image3));

		int idNoticia20 = noticiaRepository.inserir(new Noticia(null,
			"Uso de geotecnologia transforma mapeamento agrícola no Brasil",
			Timestamp.valueOf("2025-05-09 10:40:10"), 9, "Bruno Carvalho", image1));

		int idNoticia21 = noticiaRepository.inserir(new Noticia(null,
			"Blockchain traz mais segurança para cooperativas agrícolas",
			Timestamp.valueOf("2025-05-23 14:25:00"), 7, "Lívia Santos", image2));

		int idNoticia22 = noticiaRepository.inserir(new Noticia(null,
			"Sebrae investe em formação para produtores digitais",
			Timestamp.valueOf("2025-05-11 11:30:30"), 5, "Ricardo Gonçalves", image3));

		int idNoticia23 = noticiaRepository.inserir(new Noticia(null,
			"IA aplicada à pecuária aumenta produtividade no Brasil",
			Timestamp.valueOf("2025-05-19 09:45:00"), 8, "Camila Souza", image1));

		int idNoticia24 = noticiaRepository.inserir(new Noticia(null,
			"Senai Goiás capacita jovens em tecnologias para o agro",
			Timestamp.valueOf("2025-05-18 13:50:00"), 6, "Thiago Ribeiro", image2));

		int idNoticia25 = noticiaRepository.inserir(new Noticia(null,
			"Embrapa apresenta drones autônomos para monitoramento rural",
			Timestamp.valueOf("2025-05-25 15:30:00"), 9, "Vanessa Mendes", image3));

		int idNoticia26 = noticiaRepository.inserir(new Noticia(null,
			"IA ajuda na previsão de demanda do mercado agrícola",
			Timestamp.valueOf("2025-05-15 08:20:00"), 7, "Eduardo Almeida", image1));

		int idNoticia27 = noticiaRepository.inserir(new Noticia(null,
			"Agricultura urbana no Brasil cresce com uso de tecnologia",
			Timestamp.valueOf("2025-05-16 10:10:00"), 6, "Roberta Lima", image2));

		int idNoticia28 = noticiaRepository.inserir(new Noticia(null,
			"Gestão agrícola eficiente reduz desperdício nas fazendas",
			Timestamp.valueOf("2025-05-22 12:05:00"), 8, "Felipe Barbosa", image3));

		int idNoticia29 = noticiaRepository.inserir(new Noticia(null,
			"Ministério da Agricultura investe em biotecnologia sustentável",
			Timestamp.valueOf("2025-05-24 09:35:00"), 9, "Isabela Fernandes", image2));

		int idNoticia30 = noticiaRepository.inserir(new Noticia(null,
			"Cooperativas agrícolas adotam IA para logística inteligente",
			Timestamp.valueOf("2025-05-13 14:45:00"), 7, "Gustavo Pereira", image1));

		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia12, idGestaoAgricola));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia13, idAgroTech));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia14, idSustentabilidade));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia15, idAgroTech));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia16, idSustentabilidade));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia17, idInovacao));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia18, idInovacao));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia19, idEducacaoRural));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia20, idGestaoAgricola));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia21, idGestaoAgricola));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia22, idEducacaoRural));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia23, idAgroTech));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia24, idEducacaoRural));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia25, idAgroTech));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia26, idGestaoAgricola));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia27, idSustentabilidade));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia28, idGestaoAgricola));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia29, idSustentabilidade));
		noticiaAreaTematicaRepository.inserir(new NoticiaAreaTematica(null, idNoticia30, idInovacao));

		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia12, idMapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia13, idEmbrapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia14, idSebrae));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia15, idEmbrapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia16, idMapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia17, idMapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia18, idSenai));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia19, idIfGoiano));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia20, idIfGoiano));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia21, idSebrae));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia22, idSebrae));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia23, idEmbrapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia24, idSenai));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia25, idEmbrapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia26, idMapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia27, idMapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia28, idMapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia29, idMapa));
		noticiaOrgaoInstitucionalRepository.inserir(new NoticiaOrgaoInstitucional(null, idNoticia30, idSebrae));
	};
}
