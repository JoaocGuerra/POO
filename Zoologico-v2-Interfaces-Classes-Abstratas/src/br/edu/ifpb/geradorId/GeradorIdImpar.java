package br.edu.ifpb.geradorId;


import br.edu.ifpb.dominio.Zoologico;

import java.io.Serializable;


public class GeradorIdImpar extends GeradorIdSequencial implements GeradorId, Serializable {
    GeradorIdSequencial gerador  = new GeradorIdSequencial();

    @Override
    public Long obterProximoId(Zoologico zoo) {
        Long maiorId = gerador.getMaiorId(zoo.getAnimais());
        Long proximoId = maiorId + 2;
        return proximoId;
    }

}
