package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transferencia {

	private Conta origem;
	private Conta destino;
	private BigDecimal valor;
	private BigDecimal taxa;
	private LocalDate dataDoAgendamento;
	private LocalDate dataDoCadastro;
	private Tipo tipo;

	public Conta getOrigem() {
		return origem;
	}

	public void setOrigem(Conta origem) {
		this.origem = origem;
	}

	public Conta getDestino() {
		return destino;
	}

	public void setDestino(Conta destino) {
		this.destino = destino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public LocalDate getDataDoAgendamento() {
		return dataDoAgendamento;
	}

	public void setDataDoAgendamento(LocalDate dataDoAgendamento) {
		this.dataDoAgendamento = dataDoAgendamento;
	}

	public LocalDate getDataDoCadastro() {
		return dataDoCadastro;
	}

	public void setDataDoCadastro(LocalDate dataDoCadastro) {
		this.dataDoCadastro = dataDoCadastro;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
