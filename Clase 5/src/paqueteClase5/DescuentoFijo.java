package paqueteClase5;

public class DescuentoFijo extends Descuento {

	
	
	public DescuentoFijo(double descuento)
	{
		setValorADescontar(descuento);
		setTipoDescuento("Descuento fijo de $"+descuento);
	}
	@Override
	public double aplicarDescuento(double precio) {
		if(precio-getValorADescontar()<0) return 0;
		return precio-getValorADescontar();

	}
	
}
