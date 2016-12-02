package modelo;

public class Conta {

	private Integer numero;
	private Integer digito;

	public Conta(Integer numero, Integer digito) {
		this.numero = numero;
		this.digito = digito;
	}

	public String getNumeroFormatado() {
		return numero + "-" + digito;
	}
	
}
