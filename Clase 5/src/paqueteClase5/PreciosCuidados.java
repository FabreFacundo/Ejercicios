package paqueteClase5;

public class PreciosCuidados extends Descuento{
	
	private String[] marcas;
	
	public PreciosCuidados(String marcas,double porcentaje)
	{
		if(marcas.contains(" "))
		{
			this.marcas=marcas.split(" ");
		}
		else if(marcas.contains(","))
		{
			this.marcas=marcas.split(",");
		}
		else
		{
			System.out.println("Error al crear el descuento!");
			return;
		}
		setPorcentajeADescontar(porcentaje);
	}
	public PreciosCuidados(String[] marcas,double porcentaje)
	{
		this.marcas=marcas;
		setPorcentajeADescontar(porcentaje);
	}
	public double aplicarDescuento(String marca,double precio)
	{
		boolean alcanzada=false;
		for (String m : marcas) {
			
			if(m.toLowerCase().equals(marca.toLowerCase()))
			{
				alcanzada=true;
				break;
			}
		}
		if(alcanzada)
		{
			System.out.println("La marca: "+marca+" se encuentra dentro del programa Precios Cuidados");
			return this.aplicarDescuento(precio);
		}
		else
		{
			System.out.println("La marca: "+marca+" no se encuentra dentro del programa Precios Cuidados");
			return precio;
		}
	
	}
	public double aplicarDescuento(Producto producto)
	{
		boolean alcanzada=false;
		double precio= producto.getPrecioUnitario();
		String marca = producto.getMarca();
		for (String m : marcas) {
			
			if(m.toLowerCase().equals(marca.toLowerCase()))
			{
				alcanzada=true;
				break;
			}
		}
		if(alcanzada)
		{
			System.out.println("La marca: "+marca+" se encuentra dentro del programa Precios Cuidados");
			return this.aplicarDescuento(precio);
		}
		else
		{
			System.out.println("La marca: "+marca+" no se encuentra dentro del programa Precios Cuidados");
			return precio;
		}
	
	}
	public double aplicarDescuento(ItemCarrito item)
	{
		boolean alcanzada=false;
		double precio= item.precioTotal();
		String marca=item.getProducto().getMarca();
		for (String m : marcas) {
			
			if(m.toLowerCase().equals(marca.toLowerCase()))
			{
				alcanzada=true;
				break;
			}
		}
		if(alcanzada)
		{
			System.out.println("La marca: "+marca+" se encuentra dentro del programa Precios Cuidados");
			precio=(aplicarDescuento(item.getProducto().getPrecioUnitario()))*item.getCantidad();
			return precio;
		}
		else
		{
			System.out.println("La marca: "+marca+" no se encuentra dentro del programa Precios Cuidados");
			return precio;
		}
	}
	public double aplicarDescuento(Carrito carrito)
	{
		String marca;
		boolean alcanzada=false;
		double precio=0;
		ItemCarrito[] items=carrito.getItems();
		for(int i=0;i<items.length;i++)
		{
			if(items[i]==null)continue;
			alcanzada=false;
			marca=items[i].getProducto().getMarca();
			for (String m : marcas) {
				
				if(m.toLowerCase().equals(marca.toLowerCase()))
				{
					alcanzada=true;
					break;
				}
			}
			if(alcanzada)
			{
				System.out.println("La marca: "+marca+" se encuentra dentro del programa Precios Cuidados");
				precio+=(aplicarDescuento(items[i].getProducto().getPrecioUnitario()))*items[i].getCantidad();
			}
			else
			{
				
				System.out.println("La marca: "+marca+" no se encuentra dentro del programa Precios Cuidados");
			    precio+=items[i].precioTotal();
			}
		}
		return precio;
		
	}
}
