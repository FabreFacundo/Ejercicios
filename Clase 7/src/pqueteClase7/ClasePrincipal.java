package pqueteClase7;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ClasePrincipal {
	
	static Carrito carro;
	static String ruta="../TicketCompra1.txt";

	
	public static void main(String[] args) {

			DescuentoFijo dF=new DescuentoFijo(50);
			DescuentoPorcentajeConTope dP=new DescuentoPorcentajeConTope(50);
			dP.setPorcentajeADescontar(25);
			
			mostrarPrecio(null);
			mostrarPrecio(dF);	
			mostrarPrecio(dP);	
	}
	
	public static void mostrarPrecio(Descuento descuento)
	{
		if(leerTicket(ruta))
		{
			if(descuento==null)
			{
				System.out.println(carro.precioCompra()); 
			}
			else
			{
				System.out.println(descuento.aplicarDescuento(carro.precioCompra()));
			}
			
		}
	}
	
  public static boolean leerTicket(String ruta)
	{
		Path ticket=Paths.get(ruta);
		if(!Files.exists(ticket))
		{
			System.out.println("El arhivo al que intenta acceder: \""+ruta+"\" no se encuentra disponible, o no existe.");
			return false;
		}
		else
		{	
			try 
			{
				
				String[] contLinea;
				int cantItems=Files.readAllLines(ticket).size()-1;
				Producto pr;
				carro= new Carrito(cantItems);
				for(String linea : Files.readAllLines(ticket))
				{
					if(linea.contains("-"))continue;
					contLinea=linea.split("\t");	
					try {
					pr=new Producto(contLinea[3],contLinea[4],Double.parseDouble(contLinea[5]),Double.parseDouble(contLinea[1]),contLinea[2]);
					carro.agregarAlCarrito(new ItemCarrito(pr,Integer.parseInt(contLinea[0])));
					}catch(NumberFormatException e)
					{
						System.out.println(e.getMessage());
						return false;
					}
				}
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
				return false;
			}
			return true;
		}
	}
 	
}
