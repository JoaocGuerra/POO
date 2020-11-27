package br.edu.ifpb.dominio;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    private Long id;
    private String nome;
    private long cpf;

    public Pessoa(Long id, String nome, long cpf) {
        setId(id);
        setNome(nome);
        setCpf(cpf);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nId: " + id +
                "\nNome: " + nome +
                "\nCpf: " + cpf ;
    }
}
