package paqueteClase5;

public class DescuentoFijo extends Descuento {

	private double descuento;
	
	public DescuentoFijo(double descuento)
	{
		this.descuento=descuento;
	}
	@Override
	public double aplicarDescuento(double precio) {
		if(precio-descuento<0) return 0;
		return precio-descuento;

	}
	
}
