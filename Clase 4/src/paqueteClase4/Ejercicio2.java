package paqueteClase4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Ejercicio2 {
	public static void main(String[] args) 
	{
		
		cuentaArchivo("../ListaNumeros.txt",'+');
		
	}
	
	public static void cuentaArchivo(String ruta,char operacion)
	{
		double suma=0;
		double producto=1;
		Path rutaArchivo=Paths.get(ruta);	
		try
		{		
			for (String numero : Files.readAllLines(rutaArchivo))
			{
				switch(operacion)
				{
					case '+':
						suma+=Double.parseDouble(numero);
						break;
	
					case '*':
						producto*=Double.parseDouble(numero);
						break;
					default:
							System.out.println("Error en la eleccion de operacion");
							return;		
				}
				
			}
			
			switch(operacion)
			{
			case '+':
				System.out.println("La sumatoria da: " + suma);
				break;

			case '*':
				System.out.println("El producto da: " + producto);
				break;
			
			}
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
			return;
		}
	}

}
