package br.com.luisbrb.desafio.spring.model.interfaces;

import java.util.List;

public interface QueriesViaObjeto<T> {

    public Integer inserir(T model);

    public List<T> adquirir();

    public void atualizar(T model);
}
