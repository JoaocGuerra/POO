package br.edu.ifpb.Interfaces;

import br.edu.ifpb.dominio.Tigre;
import br.edu.ifpb.dominio.Zoologico;
import br.edu.ifpb.exceptions.ZooException;

public class AdicionarTigre extends ObterValor {
    public AdicionarTigre(Zoologico zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean exibirMenu() throws ZooException {
        String menu = "";
        menu += "====================================" + LS;
        menu += "Adicionar Tigre - Aplicação Zoológico" + LS;
        menu += "====================================" + LS;
        System.out.println(menu);

        String nome = obterValorString("Informe o nome: ");
        Boolean ehFeroz = obterValorBoolean("Informe se a Tigre é feroz (Sim ou Não): ");
        Tigre animal = new Tigre(nome, ehFeroz);
        this.zoo.adicionarAnimal(animal);

        System.out.println();
        System.out.println("Tigre adicionado com sucesso!");
        System.out.println();
        return false;
    }
}
