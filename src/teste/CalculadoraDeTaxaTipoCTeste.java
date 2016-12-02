package teste;

import modelo.CalculadoraDeTaxa;
import modelo.CalculadoraDeTaxaTipoC;
import modelo.Transferencia;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadoraDeTaxaTipoCTeste {

	@Test
	public void deveCalcularTaxaParaAgendamentoDeMaisDe30Dias() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100"));
		
		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(31));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoC();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = new BigDecimal("1.2");
		assertTrue(obtido.compareTo(esperado) == 0);
	}
	
	@Test
	public void deveCalcularTaxaParaAgendamentoDeMaisDe25Dias() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100"));
		
		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(26));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoC();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = new BigDecimal("2.1");
		assertTrue(obtido.compareTo(esperado) == 0);
	}
	
	@Test
	public void deveCalcularTaxaParaAgendamentoDeMaisDe20Dias() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100"));
		
		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(21));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoC();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = new BigDecimal("4.3");
		assertTrue(obtido.compareTo(esperado) == 0);
	}
	
	@Test
	public void deveCalcularTaxaParaAgendamentoDeMaisDe15Dias() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100"));
		
		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(16));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoC();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = new BigDecimal("5.4");
		assertTrue(obtido.compareTo(esperado) == 0);
	}
	
	@Test
	public void deveCalcularTaxaParaAgendamentoDeMaisDe10Dias() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100"));
		
		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(11));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoC();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = new BigDecimal("6.7");
		assertTrue(obtido.compareTo(esperado) == 0);
	}
	
	@Test
	public void deveCalcularTaxaParaAgendamentoDeMaisDe5Dias() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100"));
		
		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(6));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoC();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = new BigDecimal("7.4");
		assertTrue(obtido.compareTo(esperado) == 0);
	}
	
	@Test
	public void deveCalcularTaxaParaAgendamentoDeAte5Dias() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100"));
		
		LocalDate agora = LocalDate.now();
		when(transferencia.getDataDoCadastro()).thenReturn(agora);
		when(transferencia.getDataDoAgendamento()).thenReturn(agora.plusDays(5));

		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaTipoC();
		BigDecimal obtido = calculadora.calcularTaxaDa(transferencia);

		BigDecimal esperado = new BigDecimal("8.3");
		assertTrue(obtido.compareTo(esperado) == 0);
	}
}
