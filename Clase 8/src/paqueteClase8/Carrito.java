package paqueteClase8;


import java.util.ArrayList;

public class Carrito {

	private ArrayList<ItemCarrito> items;
	private int idCarrito;
	
	public Carrito(int id)
	{
		idCarrito=id;
		items = new ArrayList<ItemCarrito>();
	}	
	public void agregarAlCarrito(ItemCarrito item){items.add(item);}
	public void quitarDelCarrito(ItemCarrito item)
	{
		items.remove(item);
	}
	public double precioCompra()
	{
		double total=0;
		for(ItemCarrito item : items)
		{
			total+=item.precioTotal();
		}
		return total;
	}
	public int getId() {return idCarrito;}
	public ArrayList<ItemCarrito> getItems() {return items;}
}
