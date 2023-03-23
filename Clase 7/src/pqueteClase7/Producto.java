package pqueteClase7;

public class Producto {
	private String marca="Sin datos";
	private String nombre="Sin datos";
	private double precioUnitario=0;
	private double peso=0;
	private String unidadPeso="kg";
	private static int stock=0;
	private static Producto[] inventario= new Producto[3];
	
 	public Producto(String marca,String nombre,double precioUnitario,double peso,String unidadPeso)
	{
 		
 		this.marca=marca;
		this.nombre=nombre;
		this.precioUnitario=precioUnitario;
		this.peso=peso;
		this.unidadPeso=unidadPeso;
		int check=chekearInventario(marca, nombre, precioUnitario, peso, unidadPeso);
 		if(check==-1)
 		{
 			if(stock==inventario.length)
 	 		{
 	 			System.out.println("Alcanzado la cantidad maxima de productos!");
 	 			return;
 	 		}
 			inventario[stock]=this;
 			stock++;
 		}
 		else
 		{
 			inventario[check]=this;
 		}
 		
	
	}
	public String getMarca() {return marca;}
	public String getNombre() {return nombre;}
	public String getNombreCompleto() {return marca+" "+nombre;}
	public double getPrecioUnitario() {return precioUnitario;}
	public double getPeso() {return peso;}
	public String getUnidadPeso() {return peso+unidadPeso;}
	public static int getStock() {return stock;}
	public void setPrecioUnitario(double nuevoPrecio)
	{
		if(nuevoPrecio<0) precioUnitario=0;
		else precioUnitario=nuevoPrecio;
	}
	public void mostrarProducto()
	{
		System.out.println("Nombre: "+nombre+" Marca: "+marca+"\n"+"Precio x1: $"+precioUnitario+" Peso: "+peso+"Kg");
	}
	public int chekearInventario(String marca,String nombre,double precioUnitario,double peso,String unidadPeso)
	{
		int encontrado=-1;
		for(int i=0; i<inventario.length;i++)
 		{
 			if(inventario[i]==null)continue;
 			if(inventario[i].getMarca().equals(marca) && inventario[i].getNombre().equals(nombre) && inventario[i].getPrecioUnitario()==precioUnitario && inventario[i].getPeso()==peso && inventario[i].getUnidadPeso().equals(peso+unidadPeso))
 			{
 				
				encontrado=i;
				break;
 			}
 		}
		return encontrado;
	}
	
}
