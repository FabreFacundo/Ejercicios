package paqueteClase8;

public class Producto {
	private String marca="Sin datos";
	private String nombre="Sin datos";
	private double precioUnitario=0;
	private double peso=0;
	private String unidadPeso="kg";
	
	
 	public Producto(String marca,String nombre,double precioUnitario,double peso,String unidadPeso)
	{
 	 		this.marca=marca;
 			this.nombre=nombre;
 			this.precioUnitario=precioUnitario;
 			this.peso=peso;
 			this.unidadPeso=unidadPeso;
	}
	public String getMarca() {return marca;}
	public String getNombre() {return nombre;}
	public String getNombreCompleto() {return marca+" "+nombre;}
	public double getPrecioUnitario() {return precioUnitario;}
	public double getPeso() {return peso;}
	public String getUnidadPeso() {return peso+unidadPeso;}
	public void setPrecioUnitario(double nuevoPrecio)
	{
		if(nuevoPrecio<0) precioUnitario=0;
		else precioUnitario=nuevoPrecio;
	}
	public void mostrarProducto()
	{
		System.out.println("Nombre: "+nombre+" Marca: "+marca+"\n"+"Precio x1: $"+precioUnitario+" Peso: "+peso+"Kg");
	}
	
}
