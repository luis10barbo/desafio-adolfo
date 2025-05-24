package br.com.luisbrb.desafio.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class NoticiaOrgaoInstitucional {
    private Integer id;
    private Integer idNoticia;
    private Integer idOrgaoInstitucional;
}