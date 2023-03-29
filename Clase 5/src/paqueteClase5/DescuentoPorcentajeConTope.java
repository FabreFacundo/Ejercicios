package paqueteClase5;

public class DescuentoPorcentajeConTope extends Descuento{

	private double topeMaximo;
	
	public DescuentoPorcentajeConTope(double topeMaximo)
	{
		this.topeMaximo=topeMaximo;
	}
	
	@Override
	public void setValorADescontar(double nuevoValor) {
		if(nuevoValor>topeMaximo) 
		{
			setTipoDescuento("Descuento porcentual de %"+topeMaximo);
			super.setValorADescontar(topeMaximo);
		}
		else 
		{
			setTipoDescuento("Descuento porcentual de %"+nuevoValor);
			super.setValorADescontar(nuevoValor);
		}
	}
	
}
