package pqueteClase7;

public class Carrito {

	private ItemCarrito[] items;
	private int indice=0;
	private int indiceLibre=0;
	private boolean lugarLibre=false;
	
	
	public Carrito(int tamaño)
	{
		items=new ItemCarrito[tamaño];
	}	
	public void agregarAlCarrito(ItemCarrito item)
	{
		if(indice>=items.length)
		{
			System.out.println("Carrito lleno!");
			return;
		}
		if(lugarLibre)
		{
			items[indiceLibre]=item;
			item.setLugarEnCarrito(indiceLibre);
			lugarLibre=false;
		}
		else
		{
			items[indice]=item;
			item.setLugarEnCarrito(indice);
		}
		
		
		indice++;
	}
	public void quitarDelCarrito(ItemCarrito item)
	{
		items[item.getLugarEnCarrito()]=null;
		indiceLibre=item.getLugarEnCarrito();
		lugarLibre=true;
	}
	public double precioCompra()
	{
		double total=0;
		for(int i=0;i<items.length;i++)
		{
			if(items[i]==null) continue;
			total+=(items[i].precioTotal());
		}
		return total;
	}
	public ItemCarrito[] getItems() {return items;}
}
