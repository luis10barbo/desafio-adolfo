package br.com.luisbrb.desafio.spring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.luisbrb.desafio.spring.model.ResultadoPaginado;
import br.com.luisbrb.desafio.spring.model.tabelas.Noticia;
import br.com.luisbrb.desafio.spring.repository.NoticiaRepository;

@RestController
@RequestMapping("/api/noticia")
public class NoticiaController {

    @Autowired
    NoticiaRepository noticiaRepository;

    @GetMapping("/todos")
    public List<Noticia> adquirirTodos() {
        return noticiaRepository.adquirir();
    }

    @PostMapping("/criar")
    public void criar(@RequestBody Noticia noticia) {
        noticiaRepository.inserir(noticia);
    }

    @PostMapping("/remover")
    public void remover(@RequestBody Noticia noticia) {
        noticiaRepository.remover(noticia.getId());
    }

    @PostMapping("/atualizar")
    public void atualizar(@RequestBody Noticia noticia) {
        noticiaRepository.atualizar(noticia);
    }

    @GetMapping("/adquirir")
    public ResultadoPaginado<List<Noticia>> adquirir(
        @RequestParam("areasTematicas") int[] areasTematicas, 
        @RequestParam("orgaosInstitucionais") int[] orgaosInstitucionais, 
        @RequestParam("offset") int offset, 
        @RequestParam(name = "dateStart", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
        @RequestParam(name = "dateEnd", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        return noticiaRepository.adquirir(areasTematicas, orgaosInstitucionais, offset, startDate, endDate);
    }

    @GetMapping("/imagem")
    public ResponseEntity<Object> imagem(@RequestParam("id") int id) {
        byte[] imagemBytes = noticiaRepository.adquirirImagemNoticia(id);

        if (imagemBytes == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imagemBytes);
    }
}