package br.edu.ifpb.Armazenamento;

import br.edu.ifpb.dominio.Hotel;
import br.edu.ifpb.geradorId.GeradorId;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Armazenamento {
    public Hotel recuperar(GeradorId geradorId) ;

    public void armazenar(Hotel hotel);
}
