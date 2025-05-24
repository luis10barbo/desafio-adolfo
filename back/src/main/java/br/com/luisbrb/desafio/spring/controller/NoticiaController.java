package br.com.luisbrb.desafio.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.luisbrb.desafio.spring.model.Noticia;
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
}