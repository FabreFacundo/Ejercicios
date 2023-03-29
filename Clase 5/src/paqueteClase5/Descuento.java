package paqueteClase5;

public class Descuento {
	private double valorADescontar;
	private String tipo;
	
	public double getValorADescontar() {return valorADescontar;}
	public String getTipo() {return tipo;}
	public void setValorADescontar(double nuevoValor)
	{
		if(nuevoValor<0) valorADescontar=0;
		else valorADescontar=nuevoValor;
		
	}
	public void setTipoDescuento(String tipo)
	{
		this.tipo=tipo;
	}
	
	public double aplicarDescuento(double precio)
	{
		double precioConDescuento=precio-(precio*(valorADescontar/100));
		if(precioConDescuento<0) return 0;
		return precioConDescuento;
		
	}
	
}
