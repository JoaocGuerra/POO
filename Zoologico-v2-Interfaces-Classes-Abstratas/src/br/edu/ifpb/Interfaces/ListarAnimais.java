package br.edu.ifpb.Interfaces;

import br.edu.ifpb.Comparador.ComparadorAnimalNome;
import br.edu.ifpb.dominio.*;
import br.edu.ifpb.exceptions.ZooException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class ListarAnimais extends ObterValor {

    public ListarAnimais(Zoologico zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean exibirMenu() {
            Collection<Animal> animais = this.zoo.getAnimais();
            if (animais.isEmpty()) {
                System.out.println("Nenhum animal encontrado!");
            }else{
                while (true) {
                    String menu = "";
                    menu += "====================================" + LS;
                    menu += "Listar Animais - Aplicação Zoológico" + LS;
                    menu += "====================================" + LS;
                    menu += "1 . Listar Animais" + LS;
                    menu += "2 . Listar Animais Ordenados pelo Nome" + LS;
                    menu += "3 . Listar Quantidade de Animais por Espécies " + LS;
                    menu += "4 . Voltar" + LS;
                    System.out.println(menu);

                    int opcaoEscolhida = obterOpcaoEscolhida("Digite uma opção: ");


                    switch (opcaoEscolhida) {
                        case 1:
                            for (Animal animal : animais) {
                                imprimir(animal);
                            }
                            System.out.println("Quantidade total de animais: " + animais.size());

                            System.out.println();
                            break;

                        case 2:
                            List<Animal> animaisOrdenados = new ArrayList<>(animais);
                            Collections.sort(animaisOrdenados, new ComparadorAnimalNome());

                            for (Animal animal : animaisOrdenados) {
                                imprimir(animal);
                            }
                            System.out.println("Quantidade total de animais: " + animais.size());

                            System.out.println();
                            break;

                        case 3:
                            int qtd_leao = 0;
                            int qtd_cobra = 0;
                            int qtd_zebra = 0;
                            int qtd_tigre = 0;
                            for (Animal animal : animais) {
                                if (animal instanceof Leao){
                                    qtd_leao++;
                                }
                                else if(animal instanceof Cobra){
                                    qtd_cobra++;
                                }
                                else if(animal instanceof Zebra){
                                    qtd_zebra++;
                                }
                                else if(animal instanceof Tigre){
                                    qtd_tigre++;
                                }
                            }
                            System.out.println("Quantidade de Leões: " + qtd_leao +
                                    "\nQuantidade de Cobras: " + qtd_cobra +
                                    "\nQuantidade de Zebras: " + qtd_zebra +
                                    "\nQuantidade de Tigres: " + qtd_tigre);

                            break;
                        case 4:
                            return false;

                        default:
                            System.out.println();
                            System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
                            System.out.println();
                            break;
                    }
                }
            }
        return false;
    }
}
