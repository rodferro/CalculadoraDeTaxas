package teste;

import modelo.CalculadoraDeTaxa;
import modelo.CalculadoraDeTaxaTipoB;
import modelo.Transferencia;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadoraDeTaxaTipoBTeste {

	@Test
	public void deveCalcularTaxaParaAgendamentoDeAte30Dias() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100"));
		
		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(30));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoB();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = new BigDecimal("10");
		assertTrue(obtido.compareTo(esperado) == 0);
	}
	
	@Test
	public void deveCalcularTaxaParaAgendamentoDeMaisDe30Dias() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100"));
		
		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(31));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoB();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = new BigDecimal("8");
		assertTrue(obtido.compareTo(esperado) == 0);
	}
}
