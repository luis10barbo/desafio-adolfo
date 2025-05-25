package br.com.luisbrb.desafio.spring.model.tabelas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrgaoInstitucional {
    Integer id;
    String titulo;
}
