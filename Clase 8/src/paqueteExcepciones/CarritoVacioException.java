package paqueteExcepciones;

import paqueteClase8.Descuento;

public class CarritoVacioException extends Exception {
	private final Descuento descuento;
	public CarritoVacioException(Descuento descuento)
	{
		this.descuento=descuento;
	}
	@Override
	public String getMessage() {
		return "El carrito esta vacio!";
	}
}
