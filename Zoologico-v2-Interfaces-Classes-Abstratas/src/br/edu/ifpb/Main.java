package br.edu.ifpb;

import java.util.Scanner;

import br.edu.ifpb.armazenamento.Armazenamento;
import br.edu.ifpb.armazenamento.ArmazenamentoEmXml;
import br.edu.ifpb.dominio.Zoologico;
import br.edu.ifpb.exceptions.ZooException;
import br.edu.ifpb.geradorId.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Armazenamento armazenamento = null;
//		armazenamento = new ArmazenamentoEmArquivoBinario("zoo.ser");
//		armazenamento = new ArmazenamentoEmJson("zoo.json");
//		armazenamento = new ArmazenamentoEmXml("zoo.xml");

		
		GeradorId geradorId = null;
//		geradorId = new GeradorIdNanotime();
//		geradorId = new GeradorIdSequencial();
//		geradorId = new GeradorIdImpar();
        geradorId = new GeradorIdPar();

//		Zoologico zoo = armazenamento.recuperar(geradorId);
		Zoologico zoo = new Zoologico(geradorId);
		Scanner sc = new Scanner(System.in);
		MenuPrincipal menu = new MenuPrincipal(zoo, sc);
		
		boolean continuarExecucao = true;
		while (continuarExecucao) {
			try {
				continuarExecucao = menu.exibirMenu();
			} catch(ZooException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
	}
	
}
