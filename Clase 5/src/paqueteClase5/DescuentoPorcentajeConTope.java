package paqueteClase5;

public class DescuentoPorcentajeConTope extends Descuento{

	private double topeMaximo;
	
	public DescuentoPorcentajeConTope(double topeMaximo)
	{
		this.topeMaximo=topeMaximo;
	
	}
	
	@Override
	public void setPorcentajeADescontar(double nuevoPorcentaje) {
		if(nuevoPorcentaje>topeMaximo)
		{
			System.out.println("Alcamzado tope maximo.");
			super.setPorcentajeADescontar(topeMaximo);
		}
		else super.setPorcentajeADescontar(nuevoPorcentaje);
	}
	
}
