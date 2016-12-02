package teste;

import modelo.CalculadoraDeTaxa;
import modelo.CalculadoraDeTaxaTipoA;
import modelo.Transferencia;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadoraDeTaxaTipoATeste {

	@Test
	public void deveCalcularTaxa() {
		BigDecimal valorDaTransferencia = new BigDecimal("100");
		
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(valorDaTransferencia);

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoA();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = valorDaTransferencia.multiply(new BigDecimal("0.03")).add(new BigDecimal("2"));
		assertTrue(obtido.compareTo(esperado) == 0);
	}
}
