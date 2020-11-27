package br.edu.ifpb.dominio;

import java.io.Serializable;

public abstract class Quarto implements Serializable {
    private long id;
    private Integer numero;
    private Integer andar;
    private Integer qtdMaxPessoas;

    public Quarto(long id, Integer numero, Integer andar, Integer qtdMaxPessoas) {
        setId(id);
        setNumero(numero);
        setAndar(andar);
        setQtdMaxPessoas(qtdMaxPessoas);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public Integer getQtdMaxPessoas() {
        return qtdMaxPessoas;
    }

    public void setQtdMaxPessoas(Integer qtdMaxPessoas) {
        this.qtdMaxPessoas = qtdMaxPessoas;
    }

    @Override
    public String toString() {
        return "\nId: " + id +
                "\nNúmero: " + numero +
                "\nAndar: " + andar +
            "\nQuantidade máxima de pessoas: " + qtdMaxPessoas + "\n";
    }
}
