package br.edu.ifpb.dominio;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Periodo implements Serializable {
    private Date dataInicial;
    private Date dataFinal;

    public Periodo(Date dataInicial, Date dataFinal) {
        setDataInicial(dataInicial);
        setDataFinal(dataFinal);
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }


    public String getDataInicialSTR() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = df.format(dataInicial);
        return dataStr;
    }

    private void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinalSTR() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = df.format(dataFinal);
        return dataStr;
    }

    private void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
        return "Data Inicial: " + getDataInicialSTR() +
                " ## Data Final: " + getDataFinalSTR() +
                "\n";
    }
}
