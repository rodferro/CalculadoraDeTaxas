package modelo;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class CalculadoraDeTaxaTipoC implements CalculadoraDeTaxa {

	@Override
	public BigDecimal calcularTaxaDa(Transferencia transferencia) {
		long dias = transferencia.getDataDoCadastro().until(transferencia.getDataDoAgendamento(), ChronoUnit.DAYS);
		
		String taxa;

		if (dias > 30) {
			taxa = "0.012";
		} else if (dias > 25) {
			taxa = "0.021";
		} else if (dias > 20) {
			taxa = "0.043";
		} else if (dias > 15) {
			taxa = "0.054";
		} else if (dias > 10) {
			taxa = "0.067";
		} else if (dias > 5) {
			taxa = "0.074";
		} else {
			taxa = "0.083";
		}

		return transferencia.getValor().multiply(new BigDecimal(taxa));
	}

}
