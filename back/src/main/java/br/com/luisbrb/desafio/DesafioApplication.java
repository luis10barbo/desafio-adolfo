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
		OrgaoInstitucionalRepository repo = context.getBean(OrgaoInstitucionalRepository.class);
		int idOrgaoInstitucional1 = repo.inserir(new OrgaoInstitucional(null, "Detran"));
		int idOrgaoInstitucional2 = repo.inserir(new OrgaoInstitucional(null, "Outro"));
		int idAreaTematica = context.getBean(AreaTematicaRepository.class).inserir(new AreaTematica(null, "Detran"));
        byte[] image1 = Files.readAllBytes(Paths.get("./placeholder/1.jpg"));
        byte[] image2 = Files.readAllBytes(Paths.get("./placeholder/3.jpg"));
        byte[] image3 = Files.readAllBytes(Paths.get("./placeholder/4.jpg"));

		Noticia noticia = new Noticia(null, "Tutoria com apoio de IA no Senar Goiás: suporte inteligente e eficas para alunos", null, 8, "Luis", image1);
		Noticia noticia2 = new Noticia(null, "Avanços na Agricultura de Precisão com IA no Campo", null, 6, "Ana Silva", image1);
		Noticia noticia3 = new Noticia(null, "Senar Goiás lança plataforma de ensino com IA integrada", null, 7, "Carlos Souza", image2);
		
		NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
		int idNoticia = noticiaRepository.inserir(noticia);
		int idNoticia2 = noticiaRepository.inserir(noticia2);
		int idNoticia3 = noticiaRepository.inserir(noticia3);

		noticiaRepository.inserir(new Noticia(null, "Produtores rurais inovam com uso de drones inteligentes", null, 5, "Fernanda Lima", image3));
		noticiaRepository.inserir(new Noticia(null, "Capacitação tecnológica transforma o agronegócio goiano", null, 9, "Marcos Pereira", image1));
		noticiaRepository.inserir(new Noticia(null, "Como a inteligência artificial está otimizando a pecuária", null, 8, "Juliana Rocha", image2));
		noticiaRepository.inserir(new Noticia(null, "Senar oferece cursos gratuitos de IA aplicada ao campo", null, 6, "Ricardo Almeida", image3));
		noticiaRepository.inserir(new Noticia(null, "Transformação digital no agronegócio: desafios e soluções", null, 7, "Patrícia Gomes", image1));
		noticiaRepository.inserir(new Noticia(null, "Uso de sensores inteligentes melhora produtividade rural", null, 5, "Thiago Fernandes", image2));
		noticiaRepository.inserir(new Noticia(null, "IA e Big Data revolucionam a gestão agrícola em Goiás", null, 8, "Camila Ribeiro", image3));
		noticiaRepository.inserir(new Noticia(null, "Tecnologia e sustentabilidade: o futuro do agro", null, 9, "Bruno Costa", image1));



		context.getBean(NoticiaAreaTematicaRepository.class).inserir(new NoticiaAreaTematica(null, idNoticia, idAreaTematica));
		context.getBean(NoticiaOrgaoInstitucionalRepository.class).inserir(new NoticiaOrgaoInstitucional(null, idNoticia, idOrgaoInstitucional1));
		context.getBean(NoticiaOrgaoInstitucionalRepository.class).inserir(new NoticiaOrgaoInstitucional(null, idNoticia, idOrgaoInstitucional2));


	}
}
