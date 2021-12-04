package br.com.alura.rh.service.promocao;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;

public class PromocaoService {
	
	public void promover (Funcionario funcionario, boolean metaBatida) {
		
		Cargo cargoAtual = funcionario.getDadosPessoais().getCargo();
		
		if (Cargo.GERENTE == cargoAtual) {
			throw new ValidacaoException("gerente nao pode ser promovido");
		}
		
		if (metaBatida) {
			Cargo novoCargo = cargoAtual.getProximoCargo();
			funcionario.promover(novoCargo);
		} else {
			throw new ValidacaoException("funcionario nao atingiu a meta");
		}
		
	}

}
