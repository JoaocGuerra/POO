package br.edu.ifpb;

import java.sql.SQLOutput;
import java.util.*;

import br.edu.ifpb.Comparador.ComparadorAnimalNome;
import br.edu.ifpb.Interfaces.*;
import br.edu.ifpb.Interfaces.TemCuriosidade;
import br.edu.ifpb.dominio.*;
import br.edu.ifpb.exceptions.ZooException;

public class MenuPrincipal extends ObterValor {

	private static final String LS = System.lineSeparator();

	private Zoologico zoo;

	private Scanner sc;

	public MenuPrincipal(Zoologico zoo, Scanner sc) {
		this.zoo = zoo;
		this.sc = sc;
	}

	public Zoologico getZoo() {
		return zoo;
	}

	public void setZoo(Zoologico zoo) {
		this.zoo = zoo;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public boolean exibirMenu() throws ZooException {

		int opcao = 0;
		String menu = "";
		menu += "====================================" + LS;
		menu += "Menu Principal - Aplicação Zoológico" + LS;
		menu += "====================================" + LS;
		menu += ++opcao + ". Listar Animais" + LS;
		menu += ++opcao + ". Adicionar Leão" + LS;
		menu += ++opcao + ". Adicionar Cobra" + LS;
		menu += ++opcao + ". Adicionar Zebra" + LS;
		menu += ++opcao + ". Adicionar Tigre" + LS;
		menu += ++opcao + ". Remover Animal" + LS;
		menu += ++opcao + ". Sobre a aplicação" + LS;
        menu += ++opcao + ". Tem Curiosidade" + LS;
		menu += ++opcao + ". Sair" + LS;

		while (true) {
			System.out.println(menu);
			int opcaoEscolhida = obterOpcaoEscolhida("Digite uma opção: ");
			switch (opcaoEscolhida) {
				case 1:
					ListarAnimais la = new ListarAnimais( zoo );
					la.exibirMenu();
					break;
				case 2:
                    AdicionarLeao al = new AdicionarLeao( zoo );
					al.exibirMenu();
					break;
				case 3:
                    AdicionaCobra ac = new AdicionaCobra( zoo );
                    ac.exibirMenu();
					break;
				case 4:
					AdicionarZebra az = new AdicionarZebra( zoo );
					az.exibirMenu();
					break;
				case 5:
					AdicionarTigre at = new AdicionarTigre( zoo );
					at.exibirMenu();
					break;
				case 6:
				    RemoverAnimal ra = new RemoverAnimal( zoo );
				    ra.exibirMenu();
					break;
				case 7:
				    Sobre s = new Sobre( zoo );
				    s.exibirMenu();
					break;
                case 8:
                    TemCuriosidade tc = new TemCuriosidade( zoo );
                    tc.exibirMenu();
                    break;
				case 9:
					// Sair do programa
					return false;
				default:
					System.out.println();
					System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
					System.out.println();
					break;
			}
		}
	}


//	private void removerAnimal() throws ZooException {
//		String menu = "";
//		menu += "====================================" + LS;
//		menu += "Remover Animal - Aplicação Zoológico" + LS;
//		menu += "====================================" + LS;
//		System.out.println(menu);
//
//		Collection<Animal> animais = this.zoo.getAnimais();
//		if (animais.isEmpty()) {
//			System.out.println("Não há animais para remover!");
//			return;
//		}
//
//		for (Animal animal : animais) {
//			System.out.println(animal);
//		}
//		Long id = obterValorLong("Escolha o id do Animal a ser removido: ");
//		this.zoo.removerAnimal(id);
//
//		System.out.println();
//		System.out.println("Animal removido com sucesso!");
//		System.out.println();
//	}

//    private void adicionarTigre() throws ZooException {
//        String menu = "";
//        menu += "====================================" + LS;
//        menu += "Adicionar Tigre - Aplicação Zoológico" + LS;
//        menu += "====================================" + LS;
//        System.out.println(menu);
//
//        String nome = obterValorString("Informe o nome: ");
//        Boolean ehFeroz = obterValorBoolean("Informe se a Tigre é feroz (Sim ou Não): ");
//        Tigre animal = new Tigre(nome, ehFeroz);
//        this.zoo.adicionarAnimal(animal);
//
//        System.out.println();
//        System.out.println("Tigre adicionado com sucesso!");
//        System.out.println();
//    }

//	private void adicionarZebra() throws ZooException {
//		String menu = "";
//		menu += "====================================" + LS;
//		menu += "Adicionar Zebra - Aplicação Zoológico" + LS;
//		menu += "====================================" + LS;
//		System.out.println(menu);
//
//		String nome = obterValorString("Informe o nome: ");
//		Integer quantidadeListras = obterValorInteger("Informe a quantidade de listras: ");
//		Zebra animal = new Zebra(nome, quantidadeListras);
//		this.zoo.adicionarAnimal(animal);
//
//		System.out.println();
//		System.out.println("Zebra adicionada com sucesso!");
//		System.out.println();
//	}

//	private void adicionarCobra() throws ZooException {
//		String menu = "";
//		menu += "====================================" + LS;
//		menu += "Adicionar Cobra - Aplicação Zoológico" + LS;
//		menu += "====================================" + LS;
//		System.out.println(menu);
//
//		String nome = obterValorString("Informe o nome: ");
//		Boolean ehVenenosa = obterValorBoolean("Informe se a cobra é venenosa (Sim ou Não): ");
//		Cobra animal = new Cobra(nome, ehVenenosa);
//		this.zoo.adicionarAnimal(animal);
//
//		System.out.println();
//		System.out.println("Cobra adicionada com sucesso!");
//		System.out.println();
//	}

//	private void adicionarLeao() throws ZooException {
//		String menu = "";
//		menu += "====================================" + LS;
//		menu += "Adicionar Leão - Aplicação Zoológico" + LS;
//		menu += "====================================" + LS;
//		System.out.println(menu);
//
//		String nome = obterValorString("Informe o nome: ");
//		Integer tamanhoDaJuba = obterValorInteger("Informe o tamanho da juba (em cm): ");
//		Leao animal = new Leao(nome, tamanhoDaJuba);
//		this.zoo.adicionarAnimal(animal);
//
//		System.out.println();
//		System.out.println("Leão adicionado com sucesso!");
//		System.out.println();
//	}

//	private void listarAnimais() throws ZooException {
//        Collection<Animal> animais = this.zoo.getAnimais();
//        if (animais.isEmpty()) {
//            System.out.println("Nenhum animal encontrado!");
//        }else{
//            while (true) {
//                String menu = "";
//                menu += "====================================" + LS;
//                menu += "Listar Animais - Aplicação Zoológico" + LS;
//                menu += "====================================" + LS;
//                menu += "1 . Listar Animais" + LS;
//                menu += "2 . Listar Animais Ordenados pelo Nome" + LS;
//                menu += "3 . Listar Quantidade de Animais por Espécies " + LS;
//                menu += "4 . Voltar" + LS;
//                System.out.println(menu);
//
//                int opcaoEscolhida = obterOpcaoEscolhida("Digite uma opção: ");
//
//                switch (opcaoEscolhida) {
//                    case 1:
//                        for (Animal animal : animais) {
//                            imprimir(animal);
//                        }
//                        System.out.println("Quantidade total de animais: " + animais.size());
//
//                        System.out.println();
//                        break;
//
//                        case 2:
//                            List<Animal> animaisOrdenados = new ArrayList<>(animais);
//                            Collections.sort(animaisOrdenados, new ComparadorAnimalNome());
//
//                            for (Animal animal : animaisOrdenados) {
//                                imprimir(animal);
//                            }
//                            System.out.println("Quantidade total de animais: " + animais.size());
//
//                            System.out.println();
//                        break;
//
//                        case 3:
//                            int qtd_leao = 0;
//                            int qtd_cobra = 0;
//                            int qtd_zebra = 0;
//                            int qtd_tigre = 0;
//                            for (Animal animal : animais) {
//                                if (animal instanceof Leao){
//                                    qtd_leao++;
//                                }
//                                else if(animal instanceof Cobra){
//                                    qtd_cobra++;
//                                }
//                                else if(animal instanceof Zebra){
//                                    qtd_zebra++;
//                                }
//                                else if(animal instanceof Tigre){
//                                    qtd_tigre++;
//                                }
//                            }
//                            System.out.println("Quantidade de Leões: " + qtd_leao +
//                                               "\nQuantidade de Cobras: " + qtd_cobra +
//                                               "\nQuantidade de Zebras: " + qtd_zebra +
//                                               "\nQuantidade de Tigres: " + qtd_tigre);
//
//                            break;
//                        case 4:
//                            return;
//
//                        default:
//                        System.out.println();
//                        System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
//                        System.out.println();
//                        break;
//                }
//            }
//        }
//    }


//	private void sobre() {
//		String menu = "";
//		menu += "====================================" + LS;
//		menu += "Sobre - Aplicação Zoológico" + LS;
//		menu += "====================================" + LS;
//		System.out.println(menu);
//
//		imprimir(this.zoo);
//		System.out.println();
//	}

//    private void temCuriosidade() throws ZooException {
//        String menu = "";
//        menu += "====================================" + LS;
//        menu += "Tem Curiosidade - Aplicação Zoológico" + LS;
//        menu += "====================================" + LS;
//        menu += "1. Curiosidade do Leão" + LS;
//        menu += "2. Curiosidad da Cobra" + LS;
//        menu += "3. Curiosidade da Zebra" + LS;
//        menu += "4. Curiosidade do Tigre" + LS;
//        menu += "5. Curiosidade do Zoológico" + LS;
//        menu += "6. Voltar" + LS;
//        while (true) {
//            System.out.println(menu);
//            int opcaoEscolhida = obterOpcaoEscolhida("Digite uma opção: ");
//            switch (opcaoEscolhida) {
//                case 1:
//                    Leao l = new Leao();
//                    System.out.println(l.recuperarCuriosidade());
//                    break;
//                case 2:
//                    Cobra c = new Cobra();
//                    System.out.println(c.recuperarCuriosidade());
//                    break;
//                case 3:
//                    Zebra z = new Zebra();
//                    System.out.println(z.recuperarCuriosidade());
//                    break;
//                case 4:
//                    Tigre t = new Tigre();
//                    System.out.println(t.recuperarCuriosidade());
//                    break;
//                case 5:
//                    System.out.println(this.zoo.recuperarCuriosidade());
//                    break;
//                case 6:
//                    return;
//                default:
//                    System.out.println();
//                    System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
//                    System.out.println();
//                    break;
//            }
//        }
//
//
//    }

}
