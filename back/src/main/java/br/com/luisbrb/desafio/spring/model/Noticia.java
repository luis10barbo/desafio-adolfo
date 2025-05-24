package br.com.luisbrb.desafio.spring.model;


import java.sql.Timestamp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class Noticia {
    private Integer id;
    private String titulo; 
    private Timestamp atualizadoEm;
    private int minutosLeitura;
}