package paquetePrincipal;

import java.sql.*;

public class ComunicacionSQL {
	private static Connection cnct;
	private static Statement sentenciaSQL;
	public static boolean crearConexionConBDD(String Driver,String localHost,String BDD,String user,String cont)
	{
		try {
				if(cnct==null || cnct.isClosed())
				cnct=DriverManager.getConnection(Driver+"://localhost:"+localHost+"/"+BDD,user,cont);
				return true;
		}catch(SQLException e)
		{
			System.out.println("-Error al intentar crear la conexion con la base de datos: "+localHost+":"+BDD+"\n"
					+e.getErrorCode()+"\n"+e.getMessage());
			return false;
		}
	}
	
	public static ResultSet generarConsultaDeSeleccion(String consulta)
	{
		try {
		sentenciaSQL=cnct.createStatement();
		ResultSet resultado=sentenciaSQL.executeQuery(consulta);
		 return resultado;
		}catch(SQLException e)
		{
			System.out.println("-Error en la consulta: \n\""+consulta.toUpperCase()+"\"\n"
					+e.getErrorCode()+"\n"+e.getMessage());
			return null;
		}
	}
	
	public static void generarConsultaDeModificacion(String consulta)
	{
		int nroFilasAfectadas;
		try {
			sentenciaSQL=cnct.createStatement();
			nroFilasAfectadas=sentenciaSQL.executeUpdate(consulta);
			System.out.println("Se han afectado: "+nroFilasAfectadas+" filas.");
			}catch(SQLException e)
			{
				System.out.println("-Error en la consulta: \n\""+consulta.toUpperCase()+"\"\n"
						+e.getErrorCode()+"\n"+e.getMessage());
			}
	}
	
}
