package br.edu.ifpb;

import br.edu.ifpb.dominio.Funcionario;
import br.edu.ifpb.dominio.Hospede;
import br.edu.ifpb.dominio.Hotel;
import br.edu.ifpb.dominio.Quarto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public abstract class ObterValores {
    private Scanner sc = new Scanner(System.in);

    protected Long obterLong(String mensagem){
        String numero;
        Long numero1 = null;

        while (numero1 == null){
            try {
                System.out.print(mensagem);
                numero = sc.next();
                numero1 = Long.parseLong(numero);
            }catch (NumberFormatException e){
                System.out.println("\nDigite um valor válido");
            }
        }
        return numero1;
    }

    protected String obterString(String mensagem){
        String string = null;


        while (string == null){
            System.out.print(mensagem);
            string = sc.next();
        }
        return string;
    }

    protected Integer obterInteger(String mensagem){
        String numero;
        Integer numero1 = null;

        while (numero1 == null){
            try {
                System.out.print(mensagem);
                numero = sc.next();
                numero1 = Integer.parseInt(numero);
            }catch (NumberFormatException e){
                System.out.println("\nDigite um valor válido");
            }
        }
        return numero1;
    }

    protected Boolean obterBoolean(String mensagem){
        String numero;
        Boolean aBoolean = null;

        while (aBoolean == null){
                System.out.print(mensagem);
                numero = sc.next();
            if (numero.equalsIgnoreCase("sim")) {
                aBoolean = true;
            }

            else {
                aBoolean = false;
            }
        }
        return aBoolean;
    }

    protected Double obterDouble(String mensagem){
        String numero;
        Double numero1 = null;

        while (numero1 == null){
            try {
                System.out.print(mensagem);
                numero = sc.next();
                numero1 = Double.parseDouble(numero);
            }catch (NumberFormatException e){
                System.out.println("\nDigite um valor válido");
            }
        }
        return numero1;
    }

    protected Date obterDate(String mensagem){
        String data;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = null;
        while (dataNascimento == null){
            try {
                System.out.print(mensagem);
                data = sc.next();
                dataNascimento = df.parse(data);
            } catch (ParseException e) {
                System.out.println("\nData inválida");
            }
        }
        return dataNascimento;
    }

    protected Quarto quartoOk(Hotel hotel){
        Collection<Quarto> quartos = hotel.getQuartos();
        Quarto quarto = null;
        while (quarto == null){
            Long id = this.obterLong("Insira o id do quarto:");
            for (Quarto quarto1: quartos){
                if(quarto1.getId() == id){
                    quarto = quarto1;
                }
            }
            if (quarto == null){
                System.out.println("\nId inválido");
            }
        }
        return quarto;
    }

    protected Funcionario funcionarioOk(Hotel hotel){
        Collection<Funcionario> funcionarios = hotel.getFuncionarios();
        Funcionario funcionario = null;
        while (funcionario == null){
            Long id = this.obterLong("Insira o id do funcionário:");
            for (Funcionario funcionario1: funcionarios){
                if(funcionario1.getId().equals(id)){
                    funcionario = funcionario1;
                }
            }
            if (funcionario == null){
                System.out.println("\nId inválido");
            }
        }
        return funcionario;
    }

    protected Hospede hospedeOk(Hotel hotel){
        Collection<Hospede> hospedes = hotel.getHospedes();
        Hospede hospede = null;
        while (hospede == null){
            Long id = this.obterLong("Insira o id do hospede:");
            for (Hospede hospede1: hospedes){
                if(hospede1.getId().equals(id)){
                    hospede = hospede1;
                }
            }
            if (hospede == null){
                System.out.println("\nId inválido");
            }
        }
        return hospede;
    }


}
