package br.edu.ifpb.dominio;

import java.io.Serializable;

public class Hospedagem implements Serializable {
    private Long id;
    private Quarto quarto;
    private Funcionario funcionario;
    private Hospede hospede;
    private Double valor;
    private Periodo periodo;

    public Hospedagem(Long id, Quarto quarto, Funcionario funcionario, Hospede hospede, Double valor, Periodo periodo) {
        setId(id);
        setQuarto(quarto);
        setFuncionario(funcionario);
        setHospede(hospede);
        setValor(valor);
        setPeriodo(periodo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Hospedagem\n" +
                "Id: " + id +
                "\n" + quarto +
                "\nFuncionário: " + funcionario +
                "\nHospede: " + hospede +
                "\nValor: " + valor +
                "\nPeríodo: " + periodo +
                "\n";
    }
}
