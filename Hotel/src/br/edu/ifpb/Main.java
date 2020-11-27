package br.edu.ifpb;

import br.edu.ifpb.Armazenamento.Armazenamento;
import br.edu.ifpb.Armazenamento.armazenamentoBin;
import br.edu.ifpb.dominio.Hotel;
import br.edu.ifpb.geradorId.GeradorId;
import br.edu.ifpb.geradorId.GeradorIdSequencial;

public class Main {

    public static void main(String[] args){
        GeradorId geradorId = new GeradorIdSequencial();
        Hotel hotel= null;
        Armazenamento armazenamento = new armazenamentoBin();
        hotel = armazenamento.recuperar(geradorId);
        MenuPrincipal mp =  new MenuPrincipal(hotel);
        mp.exibirMenu();
        armazenamento.armazenar(hotel);
    }
}
