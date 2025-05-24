package br.com.luisbrb.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.luisbrb.desafio.model.AreaTematica;
import br.com.luisbrb.desafio.repository.AreaTematicaRepository;

@RestController
@RequestMapping("/api/areaTematica")
public class AreaTematicaController {

    @Autowired
    AreaTematicaRepository areaTematicaRepository;

    @GetMapping("/todos")
    public List<AreaTematica> adquirirTodos() {
        return areaTematicaRepository.adquirir();
    }

    @PostMapping("/criar")
    public void criar(@RequestBody AreaTematica areaTematica) {
        areaTematicaRepository.inserir(areaTematica);
    }

    @PostMapping("/remover")
    public void remover(@RequestBody AreaTematica areaTematica) {
        areaTematicaRepository.remover(areaTematica.getId());
    }

    @PostMapping("/atualizar")
    public void atualizar(@RequestBody AreaTematica areaTematica) {
        areaTematicaRepository.atualizar(areaTematica);
    }
}