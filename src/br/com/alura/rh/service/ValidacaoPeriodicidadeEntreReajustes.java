package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {

	@Override
	public void validar(Funcionario funcionario, BigDecimal aumento) {
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		long mesesDesdeUtimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);

		if (mesesDesdeUtimoReajuste < 6) {
			throw new ValidacaoException("Reajuste nao pode ser aplicado antes de 6 meses do ultimo reajuste");
		}

	}

}
