package br.edu.ifpb.dominio;

public class Tigre extends Animal{
    private static final long serialVersionUID = 1L;

    private Boolean ehFeroz;

    public Tigre(){
        super("");
    }

    public Tigre(String nome, Boolean ehFeroz) {
        super(nome);
        this.ehFeroz = ehFeroz;
    }

    public Boolean getEhFeroz() {
        return ehFeroz;
    }

    public void setEhFeroz(Boolean ehFeroz) {
        this.ehFeroz = ehFeroz;
    }

    @Override
    public String toString() {
        return "Tigre [ehFeroz=" + ehFeroz + ", toString()=" + super.toString() + "]";
    }

    @Override
    public void validarValores() {
        // Nada a validar
    }

    @Override
    public String obterRepresentacaoTextual() {
        String texto = "";
        texto += "Tipo: Tigre" + LS;
        texto += "Id: " + getId() + LS;
        texto += "Nome: " + getNome() + LS;
        texto += "É Feroz? " + getEhFeroz() + LS;
        return texto;
    }

    @Override
    public String recuperarCuriosidade() {
        String texto = "";
        texto += "==========================================" + LS;
        texto += "Curiosidade do Tigre - Aplicação Zoológico" + LS;
        texto += "==========================================" + LS;
        texto += " Um tigre adulto chega a medir 100 centímetros de altura, 2,60 metros de comprimento e pesa cerca de 320 quilos." + LS;
        return texto;
    }
}
