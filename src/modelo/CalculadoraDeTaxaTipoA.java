package modelo;

import java.math.BigDecimal;

public class CalculadoraDeTaxaTipoA implements CalculadoraDeTaxa {

	@Override
	public BigDecimal calcularTaxaDa(Transferencia transferencia) {
		BigDecimal percentual = transferencia.getValor().multiply(new BigDecimal("0.03"));
		return new BigDecimal("2").add(percentual);
	}

}
