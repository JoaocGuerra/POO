package br.edu.ifpb.Interfaces;

import br.edu.ifpb.dominio.*;
import br.edu.ifpb.exceptions.ZooException;

public class TemCuriosidade extends ObterValor {
    public TemCuriosidade(Zoologico zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean exibirMenu() throws ZooException {
        String menu = "";
        menu += "====================================" + LS;
        menu += "Tem Curiosidade - Aplicação Zoológico" + LS;
        menu += "====================================" + LS;
        menu += "1. Curiosidade do Leão" + LS;
        menu += "2. Curiosidad da Cobra" + LS;
        menu += "3. Curiosidade da Zebra" + LS;
        menu += "4. Curiosidade do Tigre" + LS;
        menu += "5. Curiosidade do Zoológico" + LS;
        menu += "6. Voltar" + LS;
        while (true) {
            System.out.println(menu);
            int opcaoEscolhida = obterOpcaoEscolhida("Digite uma opção: ");
            switch (opcaoEscolhida) {
                case 1:
                    Leao l = new Leao();
                    System.out.println(l.recuperarCuriosidade());
                    break;
                case 2:
                    Cobra c = new Cobra();
                    System.out.println(c.recuperarCuriosidade());
                    break;
                case 3:
                    Zebra z = new Zebra();
                    System.out.println(z.recuperarCuriosidade());
                    break;
                case 4:
                    Tigre t = new Tigre();
                    System.out.println(t.recuperarCuriosidade());
                    break;
                case 5:
                    System.out.println(this.zoo.recuperarCuriosidade());
                    break;
                case 6:
                    return false;
                default:
                    System.out.println();
                    System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
                    System.out.println();
                    break;
            }
            return false;
        }
    }
}
