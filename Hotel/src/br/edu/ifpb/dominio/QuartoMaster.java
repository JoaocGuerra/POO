package br.edu.ifpb.dominio;

public class QuartoMaster extends Quarto {
    private Boolean temHidromassagem;
    private Boolean temVistaMar;

    public QuartoMaster(Boolean temHidromassagem, Boolean temVistaMar,Long id, Integer numero, Integer andar, Integer qtdMaxPessoas) {
        super(id, numero, andar, qtdMaxPessoas);
        setTemHidromassagem(temHidromassagem);
        setTemVistaMar(temVistaMar);
    }

    public Boolean getTemHidromassagem() {
        return temHidromassagem;
    }

    public void setTemHidromassagem(Boolean temHidromassagem) {
        this.temHidromassagem = temHidromassagem;
    }

    public Boolean getTemVistaMar() {
        return temVistaMar;
    }

    public void setTemVistaMar(Boolean temVistaMar) {
        this.temVistaMar = temVistaMar;
    }

    @Override
    public String toString() {
        return "Tipo: Quarto Master\n" +
                "Tem Hidromassagem? " + temHidromassagem +
                "\nTem vista para o Mar? " + temVistaMar + super.toString();
    }
}
