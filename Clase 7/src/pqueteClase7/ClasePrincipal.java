package pqueteClase7;




public class ClasePrincipal {
	
	static Carrito[] carritos= new Carrito[3];
	static Cliente[] clientes= new Cliente[3];
	static Producto[] productos= new Producto[3];
	static String ruta="../TicketCompra1.txt";

	
	public static void main(String[] args) {

			DescuentoFijo dF=new DescuentoFijo(2000);
			DescuentoPorcentajeConTope dP=new DescuentoPorcentajeConTope(50);
			dP.setValorADescontar(25);
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
			
			mostrarCompra(clientes[0],dP);
			dP.setValorADescontar(100);
			mostrarCompra(clientes[0],dP);
			mostrarCompra(clientes[1],dF);

	}
	
	public static void mostrarCompra(Cliente c,Descuento d)
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
		if(d!=null)
		{
			System.out.println(d.getTipo()+": $"+d.aplicarDescuento(carroAsignado.precioCompra()));			
		}
		
	}
	
 	
}
