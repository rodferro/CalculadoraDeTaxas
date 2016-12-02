package modelo;

import java.math.BigDecimal;

public class CalculadoraDeTaxaTipoD implements CalculadoraDeTaxa {

	@Override
	public BigDecimal calcularTaxaDa(Transferencia transferencia) {
		if (transferencia.getValor().compareTo(new BigDecimal("120000")) > 0) {
			return new CalculadoraDeTaxaTipoC().calcularTaxaDa(transferencia);
		} else if (transferencia.getValor().compareTo(new BigDecimal("25000")) > 0) {
			return new CalculadoraDeTaxaTipoB().calcularTaxaDa(transferencia);
		} else {
			return new CalculadoraDeTaxaTipoA().calcularTaxaDa(transferencia);
		}
	}

}
