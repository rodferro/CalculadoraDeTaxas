package modelo;

public enum Tipo {
	A(new CalculadoraDeTaxaTipoA()),
	B(new CalculadoraDeTaxaTipoB()),
	C(new CalculadoraDeTaxaTipoC()),
	D(new CalculadoraDeTaxaTipoD());
	
	private Tipo(CalculadoraDeTaxa calculadora) {
		this.calculadora = calculadora;
	}
	
	private CalculadoraDeTaxa calculadora;

	public CalculadoraDeTaxa getCalculadora() {
		return calculadora;
	}
	
}
