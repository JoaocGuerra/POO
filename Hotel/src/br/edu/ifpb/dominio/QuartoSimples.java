package br.edu.ifpb.dominio;

public class QuartoSimples extends Quarto{
    private Boolean ehDuplo;
    private Boolean temArCondicionado;

    public QuartoSimples(Boolean ehDuplo, Boolean temArCondicionado, Long id, Integer numero, Integer andar, Integer qtdMaxPessoas) {
        super(id,numero,andar,qtdMaxPessoas);
        setEhDuplo(ehDuplo);
        setTemArCondicionado(temArCondicionado);
    }

    public Boolean getEhDuplo() {
        return ehDuplo;
    }

    public void setEhDuplo(Boolean ehDuplo) {
        this.ehDuplo = ehDuplo;
    }

    public Boolean getTemArCondicionado() {
        return temArCondicionado;
    }

    public void setTemArCondicionado(Boolean temArCondicionado) {
        this.temArCondicionado = temArCondicionado;
    }

    @Override
    public String toString() {
        return "Quarto Simples" +
                "\nEh Duplo? " + ehDuplo +
                "\nTem Ar-Condicionado? " + temArCondicionado +
                super.toString();
    }
}
