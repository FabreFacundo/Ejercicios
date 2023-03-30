package paqueteClase8;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import paqueteExcepciones.CarritoVacioException;
import paqueteExcepciones.ResultadoNegativoException;



public class ClasePrincipal {
	static Carrito carro;
	static String ruta="../TicketCompraGrande.txt";

	
	public static void main(String[] args) {
		

		DescuentoFijo dF=new DescuentoFijo(2000);
		DescuentoPorcentajeConTope dP=new DescuentoPorcentajeConTope(50);
		mostrarCompra(dP,30);
		System.out.println();
		mostrarCompra(dF,100000);
			
	}
	public static void mostrarCompra(Descuento d,double valor)
	{
		d.setValorADescontar(valor);
		if(leerTicket(ruta))
		{
			System.out.println("Su ticket:\n");
			System.out.println("Cantidad\t\tMarca\t\tProducto\t\tPrecio/unidad\t\tSubtotal");
			for(ItemCarrito item : carro.getItems())
			{
				System.out.println(item.getCantidad()+"x\t\t"+
				item.getProducto().getMarca()+"\t\t"+
				item.getProducto().getNombre()+"\t\t$"+
				item.getProducto().getPrecioUnitario()+"\t\t$"+
				item.precioTotal());	
			}
			
			System.out.println("Un total de: $"+carro.precioCompra());
			
			try {
				if(d!=null)
				System.out.println(d.getTipo()+" queda: $"+d.aplicarDescuento(carro.precioCompra()));
			}catch(CarritoVacioException e)
			{
				System.out.println(e.getMessage());
			}catch(ResultadoNegativoException e)
			{
				System.out.println(e.getMessage());
			}
		} 

	}
		
  public static boolean leerTicket(String ruta)
	{
			try 
			{
				Path ticket=Paths.get(ruta);
				String[] contLinea;
				Producto pr;
				carro= new Carrito(1);
				for(String linea : Files.readAllLines(ticket))
				{
					if(linea.contains("-"))continue;
					contLinea=linea.split("\t");	
					pr=new Producto(
							contLinea[3],
							contLinea[5],
							Double.parseDouble(contLinea[6]),
							Double.parseDouble(contLinea[2]),
							contLinea[3]);
					carro.agregarAlCarrito(new ItemCarrito(pr,Integer.parseInt(contLinea[0])));
				}
			}catch(NoSuchFileException e)
			{
				System.out.println("No se encontro el archivo en la ruta especificada \""+ruta+"\".\n"+e);
				return false;
			}catch(NumberFormatException e)
			{
				System.out.println("Error al querer convertir el valor.\n"+e);
				return false;
			}
			catch(IOException e)
			{
				System.out.println("Error del sistema de lectura de archivos.\n"+e);
				return false;
			}
			return true;
	}
 	
}
