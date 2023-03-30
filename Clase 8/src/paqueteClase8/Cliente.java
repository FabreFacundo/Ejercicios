package paqueteClase8;

public class Cliente {

	private int idCliente;
	private DocumentoIdentidad documento;
	private Carrito carro;
	public Cliente(String tipo,String nombre,String apellido,String nacionalidad,String genero,long numero,int id, Carrito carro)
	{
		documento=new DocumentoIdentidad(tipo, numero, nombre, apellido, nacionalidad, genero);
		this.carro=carro;
		idCliente=id;
	}
	
	public DocumentoIdentidad getIdentidad() {return documento;}
	public int getId() {return idCliente;}
	public int getCarroAsignado() {return carro.getId();}
}
