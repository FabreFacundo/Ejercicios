package paqueteClase5;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ClasePrincipal {
	static Carrito carro;
	static String ruta="../TicketCompra1.txt";

	
	public static void main(String[] args) {

			mostrarPrecio();		
	}
	
	public static void mostrarPrecio()
	{
		if(leerTicket(ruta))
		{
			System.out.println(carro.precioCompra());
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
