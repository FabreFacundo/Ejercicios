package pqueteClase7;

public class Descuento {
	private double porcentajeADescontar;
	
	public double getPorcentaje() {return porcentajeADescontar;}
	public void setPorcentajeADescontar(double nuevoPorcentaje)
	{
		if(nuevoPorcentaje<0) porcentajeADescontar=0;
		else porcentajeADescontar=nuevoPorcentaje;
		
	}
	
	public double aplicarDescuento(double precio)
	{
		double precioConDescuento=precio-(precio*(porcentajeADescontar/100));
		if(precioConDescuento<0) return 0;
		return precioConDescuento;
		
	}
	
}
