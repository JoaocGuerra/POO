package br.edu.ifpb.Interfaces;

import br.edu.ifpb.dominio.Zoologico;
import br.edu.ifpb.exceptions.ZooException;

public class Sobre extends ObterValor {
    public Sobre(Zoologico zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean exibirMenu() throws ZooException {
        String menu = "";
        menu += "====================================" + LS;
        menu += "Sobre - Aplicação Zoológico" + LS;
        menu += "====================================" + LS;
        System.out.println(menu);

        imprimir(this.zoo);
        System.out.println();
        return false;
    }
}
