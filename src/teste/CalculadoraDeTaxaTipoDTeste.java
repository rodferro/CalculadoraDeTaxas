package teste;

import modelo.CalculadoraDeTaxa;
import modelo.CalculadoraDeTaxaTipoD;
import modelo.Transferencia;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadoraDeTaxaTipoDTeste {

	@Test
	public void deveCalcularTaxaParaValorDeMaisDe120000() {
		BigDecimal valorDaTransferencia = new BigDecimal("120001");
		
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(valorDaTransferencia);

		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(31));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoD();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = valorDaTransferencia.multiply(new BigDecimal("0.012"));
		assertTrue(obtido.compareTo(esperado) == 0);
	}

	@Test
	public void deveCalcularTaxaParaValorDeMaisDe25000() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("25001"));

		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(31));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoD();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = new BigDecimal("8");
		assertTrue(obtido.compareTo(esperado) == 0);
	}

	@Test
	public void deveCalcularTaxaParaValorDeAte25000() {
		BigDecimal valorDaTransferencia = new BigDecimal("25000");
		
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(valorDaTransferencia);

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoD();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = valorDaTransferencia.multiply(new BigDecimal("0.03")).add(new BigDecimal("2"));
		assertTrue(obtido.compareTo(esperado) == 0);
	}
}
