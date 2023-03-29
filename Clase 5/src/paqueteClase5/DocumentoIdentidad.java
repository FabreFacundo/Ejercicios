package paqueteClase5;

public class DocumentoIdentidad {
	private String tipo="";
	private long numeroDocumento;
	private String nombre;
	private String apellido;
	private String nacionalidad;
	private String genero;
	
	
	public DocumentoIdentidad(String tipo, long numero,String nombre, String apellido, String nacionalidad, String genero)
	{
		this.tipo=tipo;
		numeroDocumento=numero;
		this.nombre=nombre;
		this.apellido=apellido;
		this.nacionalidad=nacionalidad;
		this.genero=genero;
	}
	
	public String getTipo() {return tipo;}
	public String getNombre() {return nombre;}
	public String getApelldio() {return apellido;}
	public String getNacionalidad() {return nacionalidad;}
	public String getGenero() {return genero;}
	public long getNumero() {return numeroDocumento;}
	public void mostrarDocumento()
	{
		System.out.println("Tipo documento: "+tipo+" Nro: "+numeroDocumento);
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+apellido);
		System.out.println("Nacionalidad: "+nacionalidad);
		System.out.println("Genero: "+genero);
	}

	
	
}
