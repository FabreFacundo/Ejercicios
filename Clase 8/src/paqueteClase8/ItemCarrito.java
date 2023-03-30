package paqueteClase8;

public class ItemCarrito {
	
	private Producto pr;
	private int cant;
	private int lugareEnCarrito;
	
	public ItemCarrito(Producto producto,int cantidad)
	{
		pr=producto;
		cant=cantidad;
	}
	public Producto getProducto() {return pr;}
	public double precioTotal() {return pr.getPrecioUnitario()*cant;}
	public int getCantidad() {return cant;}
	public int getLugarEnCarrito() {return lugareEnCarrito;}
	public void setLugarEnCarrito(int lugarEnCarrito)
	{
		this.lugareEnCarrito=lugarEnCarrito;
	}
}
