package br.com.luisbrb.desafio.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ResultadoPaginado<T> {
    T resultado; 
    boolean temProximaPagina;
    int offsetProximaPagina;
}
