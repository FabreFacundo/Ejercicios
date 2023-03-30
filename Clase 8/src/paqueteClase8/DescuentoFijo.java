package paqueteClase8;



import paqueteExcepciones.CarritoVacioException;
import paqueteExcepciones.ResultadoNegativoException;

public class DescuentoFijo extends Descuento {

	
	
	public DescuentoFijo(double descuento)
	{
		setValorADescontar(descuento);
		setTipoDescuento("Descuento fijo de $"+descuento);
	}
	@Override
	public double aplicarDescuento(double precio) throws CarritoVacioException,ResultadoNegativoException {
		if(precio==0) throw new CarritoVacioException(this);
		if(precio-getValorADescontar()<0)throw new ResultadoNegativoException(this);
		return precio-getValorADescontar();

	}
	
}
