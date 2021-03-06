package br.edu.ifpb.geradorId;

import java.util.Collection;

import br.edu.ifpb.dominio.Animal;
import br.edu.ifpb.dominio.Zoologico;

public class GeradorIdSequencial implements GeradorId {

	@Override
	public Long obterProximoId(Zoologico zoo) {
		Long maiorId = getMaiorId(zoo.getAnimais());
		Long proximoId = maiorId + 1;
		return proximoId;
	}


	public Long getMaiorId(Collection<Animal> animais) {
		Long maiorId = -1L;

		for (Animal animal : animais) {
			maiorId = Math.max(maiorId, animal.getId());
		}

		return maiorId;
	}
}
