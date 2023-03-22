package paqueteClase5;


import java.util.Calendar;

public class DescuentoPorTemporada extends Descuento {
	private Calendar fechaInicio=Calendar.getInstance();
	private Calendar fechaFin=Calendar.getInstance();
	private String estacion;

	public DescuentoPorTemporada(String estacion,double porcentaje)
	{
		this.estacion=estacion.toLowerCase();
		switch(this.estacion) {
		case "invierno":
			fechaInicio.set(2023,5,20);
			fechaFin.set(2023,8,21);
			break;
		case "verano":
			fechaInicio.set(2022,11,20);
			fechaFin.set(2023,2,21);
			break;
		case "primavera":
			fechaInicio.set(2023,8,20);
			fechaFin.set(2023,11,21);
			break;
		case "otoño":
			fechaInicio.set(2023,2,20);
			fechaFin.set(2023,05,21);
			break;
		}
		setPorcentajeADescontar(porcentaje);
	}
	public double aplicarDescuento(Calendar fecha,double precio)
	{
			if(fecha.after(fechaInicio)&&fecha.before(fechaFin))
			{
				return aplicarDescuento(precio);
			}
			else
			{
				System.out.println("Fuera de temporada!");
				return precio;
			}
	}
	public double aplicarDescuento(Calendar fecha,Producto producto)
	{	
		
			double precio=producto.getPrecioUnitario();
			if(fecha.after(fechaInicio)&&fecha.before(fechaFin))
			{
				return aplicarDescuento(precio);
			}
			else
			{
				System.out.println("Fuera de temporada!");
				return precio;
			}
	}
	public double aplicarDescuento(Calendar fecha,ItemCarrito item)
	{
			
			double precio=item.precioTotal();
			if(fecha.after(fechaInicio)&&fecha.before(fechaFin))
			{
				return aplicarDescuento(precio);
			}
			else
			{
				System.out.println("Fuera de temporada!");
				return precio;
			}
	}
	public double aplicarDescuento(Calendar fecha,Carrito carrito)
	{
			
			double precio=carrito.precioCompra();
			if(fecha.after(fechaInicio)&&fecha.before(fechaFin))
			{
				return aplicarDescuento(precio);
			}
			else
			{
				System.out.println("Fuera de temporada!");
				return precio;
			}
	
	
	}
}
