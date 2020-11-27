package br.edu.ifpb.dominio;

import br.edu.ifpb.geradorId.GeradorId;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {
    private  ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private ArrayList<Quarto> quartos = new ArrayList<Quarto>();
    private ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
    private ArrayList<Hospedagem> hospedagens = new ArrayList<Hospedagem>();

    private GeradorId geradorId;

    public Hotel(GeradorId geradorId) {
        this.geradorId = geradorId;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }

    public ArrayList<Hospede> getHospedes() {
        return hospedes;
    }

    public ArrayList<Hospedagem> getHospedagens() {
        return hospedagens;
    }

    public GeradorId getGeradorId() {
        return geradorId;
    }

    public void setGeradorId(GeradorId geradorId) {
        this.geradorId = geradorId;
    }

    public void adicionarFuncionario(Funcionario funcionario){
        funcionario.setId(geradorId.obterProximoId(this));
        funcionarios.add(funcionario);
        System.out.println(("Funcionário cadastrado com sucesso\n"));
    }

    public void adicionarQuarto(Quarto quarto){
        quarto.setId(geradorId.obterProximoId(this));
        quartos.add(quarto);
        System.out.println(("Quarto cadastrado com sucesso\n"));
    }

    public void adicionarHospede(Hospede hospede){
        hospede.setId(geradorId.obterProximoId(this));
        hospedes.add(hospede);
        System.out.println(("Hospede cadastrado com sucesso\n"));
    }

    public void adicionarHospedagem(Hospedagem hospedagem){
        hospedagem.setId(geradorId.obterProximoId(this));
        hospedagens.add(hospedagem);
        System.out.println(("Hospedagem cadastrado com sucesso\n"));
    }
    public void removerFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
        System.out.println(("Funcionário removido com sucesso\n"));
    }

    public void removerQuarto(Quarto quarto){
        quartos.remove(quarto);
        System.out.println(("Quarto removido com sucesso\n"));
    }

    public void removerHospede(Hospede hospede){
        hospedes.remove(hospede);
        System.out.println(("Hospede removido com sucesso\n"));
    }
}
