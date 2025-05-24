package br.com.luisbrb.desafio.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class NoticiaAreaTematica {
    private Integer id;
    private Integer idNoticia;
    private Integer idAreaTematica;
}