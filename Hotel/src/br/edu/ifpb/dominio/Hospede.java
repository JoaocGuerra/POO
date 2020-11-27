package br.edu.ifpb.dominio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hospede extends Pessoa {
    private Date dataNascimento;

    public Hospede(Date dataNascimento,Long id, String nome, long cpf) {
        super(id,nome,cpf);
        setDataNascimento(dataNascimento);
    }

    public String getDataNascimento() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = df.format(dataNascimento);
        return dataStr;
    }

    private void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Hospede" + super.toString() +
                "\nData de Nascimento: " + getDataNascimento() +
                "\n";
    }
}
