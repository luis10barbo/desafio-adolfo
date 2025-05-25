package br.com.luisbrb.desafio.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.luisbrb.desafio.spring.model.tabelas.NoticiaOrgaoInstitucional;
import br.com.luisbrb.desafio.spring.repository.NoticiaOrgaoInstitucionalRepository;

@RestController
@RequestMapping("/api/noticiaOrgaoInstitucional")
public class NoticiaOrgaoInstitucionalController {

    @Autowired
    NoticiaOrgaoInstitucionalRepository repository;

    @GetMapping("/todos")
    public List<NoticiaOrgaoInstitucional> adquirirTodos() {
        return repository.adquirir();
    }

    @PostMapping("/criar")
    public void criar(@RequestBody NoticiaOrgaoInstitucional model) {
        repository.inserir(model);
    }

    @PostMapping("/remover")
    public void remover(@RequestBody NoticiaOrgaoInstitucional model) {
        repository.remover(model.getId());
    }

    @PostMapping("/atualizar")
    public void atualizar(@RequestBody NoticiaOrgaoInstitucional model) {
        repository.atualizar(model);
    }
}