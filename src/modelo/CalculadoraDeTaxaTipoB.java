package modelo;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class CalculadoraDeTaxaTipoB implements CalculadoraDeTaxa {

	@Override
	public BigDecimal calcularTaxaDa(Transferencia transferencia) {
		long dias = transferencia.getDataDoCadastro().until(transferencia.getDataDoAgendamento(), ChronoUnit.DAYS);

		if (dias > 30) {
			return new BigDecimal("8");
		} else {
			return new BigDecimal("10");
		}
	}

}
