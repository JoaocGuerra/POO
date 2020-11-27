package br.edu.ifpb.dominio;

public class Funcionario extends Pessoa {
    private Double salario;

    public Funcionario(Double salario,Long id, String nome, Long cpf) {
        super(id,nome,cpf);
        setSalario(salario);
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario" + super.toString() +
                "\nSalario: " + salario +
                "\n";
    }
}
