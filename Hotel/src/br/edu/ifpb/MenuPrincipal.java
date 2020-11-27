package br.edu.ifpb;

import br.edu.ifpb.dominio.*;
import java.util.*;

public  class MenuPrincipal extends ObterValores{

    private static final String LS = System.lineSeparator();
    private Hotel hotel;
    public MenuPrincipal(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean exibirMenu(){
        int opcao = 0;
        String menu = "";
        menu += "================================" + LS;
        menu += "Menu Principal - Aplicação Hotel" + LS;
        menu += "================================" + LS;
        menu += ++opcao + ". Adicionar Quarto" + LS;
        menu += ++opcao + ". Adcionar Funcionário" + LS;
        menu += ++opcao + ". Adicionar Hóspede" + LS;
        menu += ++opcao + ". Adicionar Hospedagem" + LS;
        menu += ++opcao + ". Listar Quartos" + LS;
        menu += ++opcao + ". Listar Funcionários" + LS;
        menu += ++opcao + ". Listar Hóspedes" + LS;
        menu += ++opcao + ". Listar Hospedagens" + LS;
        menu += ++opcao + ". Relatório de Funcionários com  respectiva" +
                "renda gerada em suas hospedagens realizadas" + LS;
        menu += ++opcao + ". Relatório de Hóspedes com quantidade de vezes" +
                "que cada hóspede se hospedou(quantidade)" + LS;
        menu += ++opcao + ". Relatório de Hóspedes com soma dos valores" +
                "que ele teve no hotel(valor R$)" + LS;
        menu += ++opcao + ". Realizar Remoção" + LS;

        menu += ++opcao + ". Sair" + LS;

        while (true) {
            System.out.println(menu);
            int opcaoEscolhida = this.obterInteger("Insira a opção: ");
            switch (opcaoEscolhida) {
                case 1:
                    adicionarQuarto();
                    break;
                case 2:
                    adicionarFuncionario();
                    break;
                case 3:
                    adicionarHospede();
                    break;
                case 4:
                    adicionarHospedagem();
                    break;
                case 5:
                    listarQuartos();
                    break;
                case 6:
                    listarFuncionarios();
                    break;
                case 7:
                    listarHospedes();
                    break;
                case 8:
                    listarHospedagens();
                    break;
                case 9:
                    relatorioFuncionarios();
                    break;
                case 10:
                    relatorioHospede();
                    break;
                case 11:
                    relatorioHospedeQtd();
                    break;
                case 12:
                    remover();
                    break;
                case 13:
                    // Sair do programa
                    return false;
                default:
                    System.out.println();
                    System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
                    System.out.println();
                    break;
            }
        }
    }

    private void adicionarQuarto(){
        int opcao = 0;
        String menu = "";
        menu += "================================" + LS;
        menu += "       Adicionar Quarto" + LS;
        menu += "================================" + LS;
        menu += ++opcao + ". Adicionar Quarto Master" + LS;
        menu += ++opcao + ". Adcionar Quarto Simples" + LS;
        menu += ++opcao + ". Sair" + LS;
        while (true) {
            System.out.println(menu);
            int opcaoEscolhida = this.obterInteger("Insira a opção: ");
            switch (opcaoEscolhida) {
                case 1:
                    boolean hm = this.obterBoolean("Tem Hidromassagem? (sim ou nao)");
                    boolean vm = this.obterBoolean("Tem Vista para o mar? (sim ou nao)" );
                    Long IdM = this.hotel.getGeradorId().obterProximoId(this.hotel);
                    Integer numeroM = this.obterInteger("Insira o número do quarto:");
                    Integer andarM = this.obterInteger("Insira o andar do quarto:");
                    Integer qtdMaxPessoasM = this.obterInteger("Insira a quantidade máxima do quarto:");
                    QuartoMaster quartoMaster = new QuartoMaster(hm,vm,IdM,numeroM,andarM,qtdMaxPessoasM);
                    this.hotel.adicionarQuarto(quartoMaster);
                    break;
                case 2:
                    boolean ehd = this.obterBoolean("Eh duplo? (sim ou nao)");
                    boolean tac = this.obterBoolean("Tem Ar-Condicionado? (sim ou nao)");
                    Long IdS = this.hotel.getGeradorId().obterProximoId(this.hotel);
                    Integer numeroS = this.obterInteger("Insira o número do quarto:");
                    Integer andarS = this.obterInteger("Insira o andar do quarto:");
                    Integer qtdMaxPessoasS = this.obterInteger("Insira a quantidade máxima do quarto:");
                    QuartoSimples quartoSimples = new QuartoSimples(ehd,tac,IdS,numeroS,andarS,qtdMaxPessoasS);
                    this.hotel.adicionarQuarto(quartoSimples);
                    break;
                case 3:
                    // Sair do programa
                    return;
                default:
                    System.out.println();
                    System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
                    System.out.println();
                    break;
            }
        }
    }

    private void adicionarFuncionario(){
        Long Id = this.hotel.getGeradorId().obterProximoId(this.hotel);
        Double salario = this.obterDouble("Insira o salário do funcionário:");
        String nome = this.obterString("Insira o nome do funcionário:");
        Long cpf = this.obterLong("Insira o cpf do funcionário:");
        Funcionario funcionario = new Funcionario(salario,Id,nome,cpf);
        this.hotel.adicionarFuncionario(funcionario);
    }

    private void adicionarHospede(){
        Date dataNascimento  = this.obterDate("Insira a data: (dd/MM/yyyy): ");
        Long Id = this.hotel.getGeradorId().obterProximoId(this.hotel);
        String nome = this.obterString("Insira o nome do Hospede:");
        long cpf = this.obterLong("Insira o cpf do Hospede:");
        Hospede hospede = new Hospede(dataNascimento,Id,nome,cpf);
        this.hotel.adicionarHospede(hospede);
    }

    private void adicionarHospedagem() {
        if (this.hotel.getFuncionarios().isEmpty() ){
            System.out.println("Nenhum Funcionário\nNão é possível adicionar hospedagem");
        }
        else if(this.hotel.getQuartos().isEmpty() ){
            System.out.println("Nenhum Quarto\nNão é possível adicionar hospedagem");
        }
        else if(this.hotel.getHospedes().isEmpty()){
            System.out.println("Nenhum Hóspede\nNão é possível adicionar hospedagem");
        }
        else {
            Long id = this.hotel.getGeradorId().obterProximoId(this.hotel);
            listarQuartos();

            Quarto quarto = this.quartoOk(this.hotel);
            listarFuncionarios();
            Funcionario funcionario = this.funcionarioOk(hotel);

            listarHospedes();
            Hospede hospede= this.hospedeOk(hotel);

            Double valor= this.obterDouble("Insira o valor da hospedagem: ");
            Date dataInicial  = this.obterDate("Insira a data inicial: (dd/MM/yyyy): ");
            Date dataFinal  = this.obterDate("Insira a data final: (dd/MM/yyyy): ");
            if(dataInicial.after(dataFinal)){
                System.out.println("\nData inicial é posterior a data final\n"+
                        "Não foi possível adicionar hospedagem!");
            }
            else {
                Periodo periodo = new Periodo(dataInicial,dataFinal);
                Collection<Hospedagem> hospedagens = this.hotel.getHospedagens();
                if (hospedagens.isEmpty()){
                    Hospedagem hospedagem = new Hospedagem(id,quarto,funcionario,hospede,valor,periodo);
                    this.hotel.adicionarHospedagem(hospedagem);
                }
                else {
                    for (Hospedagem hospedagem: hospedagens){
                        if(hospedagem.getQuarto().getId() == (quarto.getId())){
                            if(     hospedagem.getPeriodo().getDataInicial().before(periodo.getDataInicial()) && hospedagem.getPeriodo().getDataFinal().after(periodo.getDataFinal()) ||
                                    hospedagem.getPeriodo().getDataInicial().after(periodo.getDataInicial()) && hospedagem.getPeriodo().getDataFinal().before(periodo.getDataFinal()) ||
                                    hospedagem.getPeriodo().getDataInicial().after(periodo.getDataInicial()) && hospedagem.getPeriodo().getDataFinal().after(periodo.getDataFinal())  ||
                                    hospedagem.getPeriodo().getDataInicial().before(periodo.getDataInicial()) && hospedagem.getPeriodo().getDataFinal().before(periodo.getDataFinal())||
                                    hospedagem.getPeriodo().getDataInicial().equals(periodo.getDataFinal()) || hospedagem.getPeriodo().getDataFinal().equals(periodo.getDataInicial())||
                                    hospedagem.getPeriodo().getDataInicial().equals(periodo.getDataInicial()) || hospedagem.getPeriodo().getDataFinal().equals(periodo.getDataFinal())){
                                System.out.println("\nPeríodo coincide com outra hospedagem\n" +
                                        "Não foi possível adicionar hospedagem!");
                                return;
                            }

                        }
                    }
                    Hospedagem hospedagem = new Hospedagem(id,quarto,funcionario,hospede,valor,periodo);
                    this.hotel.adicionarHospedagem(hospedagem);
                }
            }
        }
    }

    private void listarQuartos(){
        Collection<Quarto> quartos = this.hotel.getQuartos();
        if(quartos.isEmpty()){
            System.out.println("\nNenhum quarto encontrado!\n");
        }
        else{
            String menu = "";
            menu += "================================" + LS;
            menu += "       Listar Quartos" + LS;
            menu += "================================" + LS;
            System.out.println(menu);
            for (Quarto quarto : quartos){
                System.out.println(quarto);
            }
        }
    }

    private void listarFuncionarios(){
        Collection<Funcionario> funcionarios = this.hotel.getFuncionarios();
        if(funcionarios.isEmpty()){
            System.out.println("\nNenhum funcionário encontrado!\n");
        }
        else{
            String menu = "";
            menu += "================================" + LS;
            menu += "       Listar Funcionários" + LS;
            menu += "================================" + LS;
            System.out.println(menu);
            for(Funcionario funcionario: funcionarios){
                System.out.println(funcionario);
            }
        }
    }

    private void listarHospedes(){
        Collection<Hospede> hospedes = this.hotel.getHospedes();
        if(hospedes.isEmpty()){
            System.out.println("\nNenhum hospede encontrado!\n");
        }
        else {
            String menu = "";
            menu += "================================" + LS;
            menu += "       Listar Hospedes" + LS;
            menu += "================================" + LS;
            System.out.println(menu);
            for(Hospede hospede: hospedes){
                System.out.println(hospede);
            }
        }
    }

    private void listarHospedagens(){
        Collection<Hospedagem> hospedagens = this.hotel.getHospedagens();
        if(hospedagens.isEmpty()){
            System.out.println("\nNenhum hospedagem encontrada!\n");
        }
        else {
            String menu = "";
            menu += "================================" + LS;
            menu += "       Listar Hospedagens" + LS;
            menu += "================================" + LS;
            System.out.println(menu);
            for(Hospedagem hospedagem: hospedagens){
                System.out.println(hospedagem);
            }
        }
    }

    private void relatorioFuncionarios(){
        Collection<Funcionario> funcionarios = this.hotel.getFuncionarios();
        if(funcionarios.isEmpty()){
            System.out.println("Nenhum funcionário para relatar\n");
        }
        else {
            Collection<Hospedagem> hospedagens = this.hotel.getHospedagens();

            Map<Funcionario, Double> mapa = new HashMap<Funcionario, Double>();
            double renda = 0.0;

            String menu = "";
            menu += "================================" + LS;
            menu += "    Relatório de Funcionários   " + LS;
            menu += "================================" + LS;
            System.out.println(menu);

            for (Funcionario funcionario: funcionarios){
                for (Hospedagem hospedagem: hospedagens){
                    if(hospedagem.getFuncionario().getId().equals(funcionario.getId())){
                        renda += hospedagem.getValor();
                    }
                }
                mapa.put(funcionario,renda);
                renda = 0.0;
            }

            for (Funcionario funcionario: funcionarios){
                System.out.print(funcionario);
                System.out.println("Renda gerada:" + mapa.get(funcionario) + "\n");
            }
        }
    }

    private void relatorioHospede(){
        Collection<Hospede> hospedes = this.hotel.getHospedes();
        if(hospedes.isEmpty()){
            System.out.println("Nenhum hóspede para relatar\n");
        }
        else{
            Collection<Hospedagem> hospedagens = this.hotel.getHospedagens();
            Map<Hospede, Integer> mapa = new HashMap<Hospede, Integer>();
            int qtd_Hospedagens = 0;

            String menu = "";
            menu += "===================================" + LS;
            menu += "Relatório de Hospedagens do Hóspede" + LS;
            menu += "===================================" + LS;
            System.out.println(menu);

            for(Hospede hospede: hospedes){
                for(Hospedagem hospedagem: hospedagens){
                    if(hospedagem.getHospede().getId().equals(hospede.getId())){
                        qtd_Hospedagens ++;
                    }
                }
                mapa.put(hospede,qtd_Hospedagens);
                qtd_Hospedagens = 0;
            }
            for(Hospede hospede: hospedes){
                System.out.println(hospede);
                System.out.println("Quantidade de hospedagens:" + mapa.get(hospede) + "\n");

            }
        }

    }

    private void relatorioHospedeQtd(){
        Collection<Hospede> hospedes = this.hotel.getHospedes();
        if(hospedes.isEmpty()){
            System.out.println("Nenhum hóspede para relatar\n");
        }
        else{
            Collection<Hospedagem> hospedagens = this.hotel.getHospedagens();

            Map<Hospede, Double> mapa = new HashMap<Hospede, Double>();
            double soma_valores = 0.0;

            String menu = "";
            menu += "===================================" + LS;
            menu += "Relatório de Hospedagens do Hóspede" + LS;
            menu += "===================================" + LS;
            System.out.println(menu);

            for(Hospede hospede: hospedes){
                for(Hospedagem hospedagem: hospedagens){
                    if(hospedagem.getHospede().getId().equals(hospede.getId())){
                        soma_valores += hospedagem.getValor();
                    }
                }
                mapa.put(hospede,soma_valores);
                soma_valores = 0;
            }

            for(Hospede hospede: hospedes){
                System.out.println(hospede);
                System.out.println("Soma dos valores: " + mapa.get(hospede) + "\n");

            }
        }
    }

    private void remover(){
        int opcao = 0;
        String menu = "";
        menu += "================================" + LS;
        menu += "        Menu de Remoção         " + LS;
        menu += "================================" + LS;
        menu += ++opcao + ". Remover Quarto" + LS;
        menu += ++opcao + ". Remover Funcionário" + LS;
        menu += ++opcao + ". Remover Hóspede" + LS;
        menu += ++opcao + ". Sair" + LS;
        while (true) {
            System.out.println(menu);
            int opcaoEscolhida = this.obterInteger("Insira a opção: ");
            switch (opcaoEscolhida) {
                case 1:
                    Collection<Quarto> quartos = this.hotel.getQuartos();
                    if (quartos.isEmpty()) {
                        System.out.println("Nenhum quarto encontrado");
                    } else {
                        listarQuartos();
                        Quarto quarto = this.quartoOk(this.hotel);
                        Collection<Hospedagem> hospedagens = this.hotel.getHospedagens();
                        if (hospedagens.isEmpty()) {
                            this.hotel.removerQuarto(quarto);
                        } else {
                            boolean b = true;
                            for (Hospedagem hospedagem : hospedagens) {
                                if (hospedagem.getQuarto().getId() == quarto.getId()) {
                                    b = false;
                                }
                            }
                            if (b) {
                                this.hotel.removerQuarto(quarto);
                                System.out.println("Quarto removido com sucesso!\n");
                            }
                            else {
                                System.out.println("Quarto ocupado\nNão foi possivel remover o quarto\n");
                            }
                        }
                    }
                    break;
                case 2:
                    if (this.hotel.getFuncionarios().isEmpty()) {
                        System.out.println("Nenhum funcionário encontrado");
                    } else {
                        listarFuncionarios();
                        Funcionario funcionario = this.funcionarioOk(this.hotel);
                        Collection<Hospedagem> hospedagens = this.hotel.getHospedagens();
                        if (hospedagens.isEmpty()) {
                            this.hotel.removerFuncionario(funcionario);
                        } else {
                            boolean b = true;
                            for (Hospedagem hospedagem : hospedagens) {
                                if (hospedagem.getFuncionario().getId().equals(funcionario.getId())) {
                                    b = false;
                                }
                            }
                            if (b) {
                                this.hotel.removerFuncionario(funcionario);
                                System.out.println("Funcionário removido com sucesso!\n");
                            }
                            else{
                                System.out.println("Funcionário ocupado\nNão foi possível remover o funcionário\n");
                            }
                        }
                    }
                    break;
                case 3:
                    if (this.hotel.getHospedes().isEmpty()) {
                        System.out.println("Nenhum hóspede encontrado");
                    } else {
                        listarHospedes();
                        Hospede hospede = this.hospedeOk(this.hotel);
                        Collection<Hospedagem> hospedagens = this.hotel.getHospedagens();
                        if (hospedagens.isEmpty()) {
                            this.hotel.removerHospede(hospede);
                        } else {
                            boolean b = true;
                            for (Hospedagem hospedagem : hospedagens) {
                                if (hospedagem.getHospede().getId().equals(hospede.getId())) {
                                    b = false;
                                }
                            }
                            if (b) {
                                this.hotel.removerHospede(hospede);
                                System.out.println("Hóspede removido com sucesso!\n");
                            }
                            else{
                                System.out.println("Hóspede ocupado\nNão foi possível remover o hóspede\n");
                            }
                        }
                    }
                    break;
                case 4:
                    // Sair do programa
                    return;
                default:
                    System.out.println();
                    System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
                    System.out.println();
                    break;
            }
        }
    }
}


