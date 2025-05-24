package br.com.luisbrb.desafio.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.luisbrb.desafio.spring.model.NoticiaAreaTematica;
import br.com.luisbrb.desafio.spring.repository.NoticiaAreaTematicaRepository;

@RestController
@RequestMapping("/api/noticiaAreaTematica")
public class NoticiaAreaTematicaController {

    @Autowired
    NoticiaAreaTematicaRepository repository;

    @GetMapping("/todos")
    public List<NoticiaAreaTematica> adquirirTodos() {
        return repository.adquirir();
    }

    @PostMapping("/criar")
    public void criar(@RequestBody NoticiaAreaTematica model) {
        repository.inserir(model);
    }

    @PostMapping("/remover")
    public void remover(@RequestBody NoticiaAreaTematica model) {
        repository.remover(model.getId());
    }

    @PostMapping("/atualizar")
    public void atualizar(@RequestBody NoticiaAreaTematica model) {
        repository.atualizar(model);
    }
}