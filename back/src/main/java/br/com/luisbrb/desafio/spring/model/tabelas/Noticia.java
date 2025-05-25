package br.com.luisbrb.desafio.spring.model.tabelas;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
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