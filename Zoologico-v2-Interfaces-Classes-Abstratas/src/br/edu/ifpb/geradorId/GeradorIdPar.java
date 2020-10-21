package br.edu.ifpb.geradorId;

import br.edu.ifpb.dominio.Animal;
import br.edu.ifpb.dominio.Zoologico;

import java.io.Serializable;
import java.util.Collection;

public class GeradorIdPar extends GeradorIdSequencial implements GeradorId, Serializable {
    GeradorIdSequencial gerador  = new GeradorIdSequencial();

    @Override
    public Long obterProximoId(Zoologico zoo) {
        Long maiorId = gerador.getMaiorId(zoo.getAnimais());
        Long proximoId;
        if (maiorId == -1) {
             proximoId = maiorId + 1;
        }
        else{
             proximoId = maiorId + 2;
        }
        return proximoId;
    }


}
