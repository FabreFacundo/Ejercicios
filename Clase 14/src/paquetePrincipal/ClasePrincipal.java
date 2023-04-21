package paquetePrincipal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ClasePrincipal {
	static Scanner entrada=new Scanner(System.in);
	static String[] datosBDD;
	static boolean conectado=false;
	public static void main(String[] args) {
		int opcion;
		
		do {
			try {
				System.out.println("Bienvenidos al practico de la clase 14\n"
						+ "1) Crear conexion con la base de datos.\n"
						+ "2) Agregar un nuevo empleado.\n"
						+ "3) Modificar datos de un empleado.\n"
						+ "4) Eliminar departamento.\n"
						+ "5) Mostrar empleados por departamento.\n"
						+ "6) Mostrar departamentos alfabeticamente.\n"
						+ "7) Salir.\n"
						+ "-Ingrese una de las opciones listadas arriba: ");
				opcion=entrada.nextInt();
				entrada.nextLine();
				switch(opcion)
				{
				case 1:
					conectarse();
					break;
				case 2:
					ingresarDatos();
					break;
				case 3:
					modificarNacionalidad();
					break;
				case 4:
					eliminarDepartamento();
					break;
				case 5:
					mostrarEmpleados();
					break;
				case 6:
					mostrarDepartamentos();
					break;
				case 7:
					System.out.println("Saliendo...");
					return;
				}
				
			}catch(InputMismatchException e)
			{
				System.out.println("Por favor, solo ingrese valores numericos");
			}
			
		}while(true);
	}
	public static void ingresarDatos()
	{
		if(datosBDD==null || !conectado)
		{
			System.out.println("-Por favor cree primero la conexion con la base de datos.");
			return;
		}
		String[] datos= new String[5];
		System.out.println("-Ingrese DNI: ");
		datos[0]=entrada.nextLine();
		System.out.println("-Ingrese Nombre: ");
		datos[1]=entrada.nextLine();
		System.out.println("-Ingrese Apellido: ");
		datos[2]=entrada.nextLine();
		System.out.println("-Ingrese Nacionalidad: ");
		datos[3]=entrada.nextLine();
		System.out.println("Ingrese departamento (nombre): ");
		datos[4]=entrada.nextLine();
		String consulta="INSERT INTO empleados (DNI,Nombre,Apellido,Nacionalidad,idDepartamento) VALUES "
				+"("+datos[0]+",'"+datos[1]+"','"+datos[2]+"','"+datos[3]+"',("+
				"SELECT idDepartamento FROM departamentos WHERE NombreDepartamento='"+datos[4]+"'))";
		ComunicacionSQL.generarConsultaDeModificacion(consulta);
		
	}
	
	public static void modificarNacionalidad()
	{
		if(datosBDD==null || !conectado)
		{
			System.out.println("-Por favor cree primero la conexion con la base de datos.");
			return;
		}
		System.out.println("-Ingrese el id del empleado: ");
		String id=entrada.nextLine();
		System.out.println("-Ingrese la nueva nacionalidad del empleado: ");
		String Nacionalidad=entrada.nextLine();
		String consulta="UPDATE empleados SET Nacionalidad='"+Nacionalidad+"' WHERE idEmpleado="+id;
		ComunicacionSQL.generarConsultaDeModificacion(consulta);
	}
	
	public static void eliminarDepartamento()
	{
		if(datosBDD==null || !conectado)
		{
			System.out.println("-Por favor cree primero la conexion con la base de datos.");
			return;
		}
		System.out.println("-Ingrese el id del departamento: ");
		String id=entrada.nextLine();
		String consulta="DELETE FROM departamentos WHERE idDepartamento="+id;
		ComunicacionSQL.generarConsultaDeModificacion(consulta);
	}
	
	public static void mostrarEmpleados()
	{
		if(datosBDD==null || !conectado)
		{
			System.out.println("-Por favor cree primero la conexion con la base de datos.");
			return;
		}
		System.out.println("-Ingrese el nombre del departamento deseado: ");
		String departamento=entrada.nextLine();
		String consulta="SELECT DNI,Nombre,Apellido,Nacionalidad,NombreDepartamento FROM empleados"
				+ " INNER JOIN departamentos ON empleados.idDepartamento=departamentos.idDepartamento"
				+ " WHERE empleados.idDepartamento=(SELECT idDepartamento FROM departamentos WHERE NombreDepartamento='"+departamento+"')";
		try {
			ResultSet resultado= ComunicacionSQL.generarConsultaDeSeleccion(consulta);
			System.out.println("\nDNI\tNombre\tApellido\tNacionalidad\tDepartamento\n");
			while(resultado.next())
			{
				int dni=resultado.getInt("DNI");
				String nombre=resultado.getString("Nombre");
				String apellido=resultado.getString("Apellido");
				String nacionalidad=resultado.getString("Nacionalidad");
				String dpto=resultado.getString("NombreDepartamento");
				System.out.println(dni+"\t"+nombre+"\t"+apellido+"\t"+nacionalidad+"\t"+dpto+"\n");
				
			}
		}catch(SQLException e)
		{
			System.out.println("-Error con el ResultSet");
		}
	}
	
	public static void mostrarDepartamentos()
	{
		if(datosBDD==null || !conectado)
		{
			System.out.println("-Por favor cree primero la conexion con la base de datos.");
			return;
		}
		String consulta="SELECT * FROM departamentos ORDER BY NombreDepartamento";
		try {
			ResultSet resultado= ComunicacionSQL.generarConsultaDeSeleccion(consulta);
			System.out.println("\nNombreDepartamento\n");
			while(resultado.next())
			{
				String nombre=resultado.getString("NombreDepartamento");
				System.out.println(nombre+"\n");
				
			}
		}catch(SQLException e)
		{
			System.out.println("-Error con el ResultSet");
		}
	}
	public static void conectarse()
	{
		datosBDD= new String[5];
		System.out.println("-Ingrese el Driver a utilizar: ");
		datosBDD[0]=entrada.nextLine();
		System.out.println("-Ingrese la conexion (localHost) a utilizar: ");
		datosBDD[1]=entrada.nextLine();
		System.out.println("-Ingrese la base de datos a utilizar: ");
		datosBDD[2]=entrada.nextLine();
		System.out.println("-Ingrese el usuario: ");
		datosBDD[3]=entrada.nextLine();
		System.out.println("Ingrese la contrasenia: ");
		datosBDD[4]=entrada.nextLine();
		conectado=ComunicacionSQL.crearConexionConBDD(datosBDD[0], datosBDD[1], datosBDD[2], datosBDD[3], datosBDD[4]);
		
	}
}
