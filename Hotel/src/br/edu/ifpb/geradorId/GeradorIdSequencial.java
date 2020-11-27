package br.edu.ifpb.geradorId;

import br.edu.ifpb.dominio.*;

import java.io.Serializable;
import java.util.ArrayList;

public class GeradorIdSequencial implements GeradorId, Serializable {

	@Override
	public Long obterProximoId(Hotel hotel) {
		Long maiorId = getMaiorId(hotel.getFuncionarios(),hotel.getQuartos(),hotel.getHospedes(),hotel.getHospedagens());
		Long proximoId = maiorId + 1;
		return proximoId;
	}


	public Long getMaiorId(ArrayList<Funcionario> funcionarios,	ArrayList<Quarto> quartos,ArrayList<Hospede> hospedes,ArrayList<Hospedagem> hospedagens) {
		Long maiorId = -1L;

		for (Funcionario funcionario : funcionarios) {
			maiorId = Math.max(maiorId, funcionario.getId());
		}

		for (Quarto quarto : quartos) {
			maiorId = Math.max(maiorId, quarto.getId());
		}

		for (Hospede hospede : hospedes) {
			maiorId = Math.max(maiorId, hospede.getId());
		}

		for (Hospedagem hospedagem : hospedagens) {
			maiorId = Math.max(maiorId, hospedagem.getId());
		}
		return maiorId;
	}
}
