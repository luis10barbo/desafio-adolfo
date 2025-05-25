package br.com.luisbrb.desafio.spring.model.tabelas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class NoticiaAreaTematica {
    private Integer id;
    private Integer idNoticia;
    private Integer idAreaTematica;
}