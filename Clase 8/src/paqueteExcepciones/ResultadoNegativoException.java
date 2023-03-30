package paqueteExcepciones;

import paqueteClase8.Descuento;

public class ResultadoNegativoException extends Exception {
	private final Descuento descuento;
	public ResultadoNegativoException(Descuento descuento)
	{
		this.descuento=descuento;
	}
	@Override
	public String getMessage() {
		return "El resultado del descuento es negativo!";
	}
}
