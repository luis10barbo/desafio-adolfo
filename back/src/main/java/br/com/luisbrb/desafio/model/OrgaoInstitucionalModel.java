package br.com.luisbrb.desafio.model;

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
public class OrgaoInstitucionalModel {
    Integer id;
    String titulo;
}
