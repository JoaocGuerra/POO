package br.edu.ifpb.Comparador;

import br.edu.ifpb.dominio.Animal;

import java.util.Comparator;

public class ComparadorAnimalNome implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
       String animal1 = o1.getNome();
       String animal2 = o2.getNome();
       return animal1.compareTo(animal2);
    }
}
