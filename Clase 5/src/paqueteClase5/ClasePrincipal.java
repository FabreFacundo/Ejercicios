package paqueteClase5;

import java.util.Calendar; //para aplicar el descuento de temporadaa sirve
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ClasePrincipal {
	static Calendar fechaActual= Calendar.getInstance();
	static Carrito carro;
	static String ruta="../TicketCompra1.txt";
	static DescuentoPorTemporada dO=new DescuentoPorTemporada("otoño", 15.5);
	static PreciosCuidados pC= new PreciosCuidados("cremigal,porcomagro", 5.5);
	
	public static void main(String[] args) {

		hacerCompra();
		
	}
	

	static void mostrarPrecioNeto(Carrito carro)
	{
		System.out.println(carro.precioCompra());
	}
 	static public boolean leerTicket(String ruta)
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
 	static void hacerCompra()
 	{	
 		if(!leerTicket(ruta))return;
 		double precio=0;
 		System.out.println("Comprador/ra: Buen dia quisiera llevar..");
 		for(ItemCarrito iC:carro.getItems())
 		{
 			System.out.println(iC.getCantidad()+" "+iC.getProducto().getUnidadPeso()+" "+iC.getProducto().getNombreCompleto());
 		}
 		precio=carro.precioCompra();
 		System.out.println("Vendedor/ra: Buen dia, serian: "+precio);
 		System.out.println("Vendedor/ra: aplicando los precios cuidados de "+pC.getPorcentaje()+"%");
 		precio=pC.aplicarDescuento(carro);
 		System.out.println("Vendedor/ra: te quedaria en $"+precio);
 		System.out.println("Vendedor/ra:tambien podes aprovechar nuestro descuento otoñal del "+dO.getPorcentaje()+"%");
 		precio=dO.aplicarDescuento(fechaActual, precio);
 		System.out.println("Vendedor/ra: serian en total en $"+precio);
 		System.out.println("Comprador/ra: Servite *le da la tarjeta*");
 		System.out.println("Vendedor/ra: aqui tiene su tarjeta, que tenga buen dia!");
 		System.out.println("Comprador/ra: Hasta luego!");
 		
 	}
}
