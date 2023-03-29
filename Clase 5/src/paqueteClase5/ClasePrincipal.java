package paqueteClase5;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ClasePrincipal {
	static Carrito carro;
	static Carrito[] carritos= new Carrito[3];
	static Cliente[] clientes= new Cliente[3];
	static Producto[] productos= new Producto[3];
	static String ruta="../TicketCompra.txt";

	
	public static void main(String[] args) {

			productos[0]=new Producto("Jhonny Walker","Etiqueta Negra",10300.25,1,"Lts");
			productos[1]=new Producto("Cremigal","Queso Sardo",189.90,150,"g");
			productos[2]=new Producto("Rosamonte","Yerba",1250,1,"Kg");
			carritos[0]=new Carrito(2,0);
			carritos[1]=new Carrito(2,20);
			carritos[2]=new Carrito(2,50);
			clientes[0]=new Cliente("DNI","Guillermo","Rodriguez","Mexicano","Hombre",16288356,0,carritos[0]);
			clientes[1]=new Cliente("DNI","Romina","Loreto","Argentina","Mujer",38698852,1,carritos[1]);
			clientes[2]=new Cliente("DNI","Jimena","Oliver","Argentina","No Binario",40899741,2,carritos[2]);
			carritos[0].agregarAlCarrito(new ItemCarrito(productos[0],3));
			carritos[0].agregarAlCarrito(new ItemCarrito(productos[2],1));
			carritos[1].agregarAlCarrito(new ItemCarrito(productos[1],3));
			carritos[1].agregarAlCarrito(new ItemCarrito(productos[2],2));
			carritos[2].agregarAlCarrito(new ItemCarrito(productos[0],1));
			carritos[2].agregarAlCarrito(new ItemCarrito(productos[1],1));
			
			mostrarCompra(clientes[0]);
			System.out.println();
			if(leerTicket(ruta))
			{
				System.out.println("Su ticket:\n");
				
				System.out.println("Cantidad\t\tMarca\t\tProducto\t\tPrecio/unidad\t\tSubtotal");
				for(ItemCarrito item : carro.getItems())
				{
					if(item==null)continue;
					System.out.println(item.getCantidad()+"x\t\t"+item.getProducto().getMarca()+"\t\t"+item.getProducto().getNombre()+"\t\t$"+ item.getProducto().getPrecioUnitario()+"\t\t$"+item.precioTotal());	
				}
				System.out.println("Un total de: $"+carro.precioCompra());
					
			}

	}
	
	public static void mostrarCompra(Cliente c)
	{
		Carrito carroAsignado=null;
		System.out.println("El cliente: ");
		c.getIdentidad().mostrarDocumento();
		System.out.println(" ");
		System.out.println("Cuyo numero de carrito es: "+c.getCarroAsignado());
		System.out.println(" ");
		System.out.println("Ha hecho la siguiente compra: ");
		System.out.println(" ");
		for(Carrito carrito : carritos)
		{
			if(carrito.getId()==c.getCarroAsignado()) carroAsignado=carrito;
		}
		if(carroAsignado==null)
		{
			System.out.println("No se pudo encontrar el carrito asignado!");
			return;
		}
		System.out.println("Cantidad\t\tMarca\t\tProducto\t\tPrecio/unidad\t\tSubtotal");
		for(ItemCarrito item : carroAsignado.getItems())
		{
			System.out.println(item.getCantidad()+"x\t\t"+item.getProducto().getMarca()+"\t\t"+item.getProducto().getNombre()+"\t\t$"+ item.getProducto().getPrecioUnitario()+"\t\t$"+item.precioTotal());	
		}
		System.out.println("Un total de: $"+carroAsignado.precioCompra());
		
		
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
				carro= new Carrito(cantItems,100);
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
