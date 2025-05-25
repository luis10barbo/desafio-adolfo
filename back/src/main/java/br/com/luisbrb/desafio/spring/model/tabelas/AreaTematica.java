package br.com.luisbrb.desafio.spring.model.tabelas;

// package br.com.luisbrb.desafio.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class AreaTematica {
    private Integer id;
    private String titulo; 
}
