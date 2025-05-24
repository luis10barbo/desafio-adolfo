package br.com.luisbrb.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luisbrb.desafio.model.OrgaoInstitucional;
import br.com.luisbrb.desafio.repository.OrgaoInstitucionalRepository;

@RestController
@RequestMapping("/api/orgaoInstitucional")
public class OrgaoInstitucionalController {

    @Autowired OrgaoInstitucionalRepository orgaoInstitucionalRepository;

    @GetMapping("/todos")
    public List<OrgaoInstitucional> adquirirTodos() {
        return orgaoInstitucionalRepository.adquirir();
    }  

    @PostMapping("/criar")
    public void criar(@RequestBody OrgaoInstitucional orgaoInstitucionalModel) {
        orgaoInstitucionalRepository.inserir(orgaoInstitucionalModel);
    }

    @PostMapping("/remover")
    public void remover(@RequestBody OrgaoInstitucional orgaoInstitucionalModel) {
        orgaoInstitucionalRepository.remover(orgaoInstitucionalModel.getId());
    }

    @PostMapping("/atualizar")
    public void atualizar(@RequestBody OrgaoInstitucional orgaoInstitucionalModel) {
        orgaoInstitucionalRepository.atualizar(orgaoInstitucionalModel);
    }
}
