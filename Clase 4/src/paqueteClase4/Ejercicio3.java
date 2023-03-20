package paqueteClase4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] Args) 
	{
		String ruta="C:\\Users\\Facu\\Desktop\\Curso Java\\Programas\\listaNombres.txt";
		String nombres="Juan,Pedro,Maria,Claudia,Roman,Gaston,Pepe,Lorena,Jazmin,Carlos";
		escribirNombres(ruta,nombres);
	}
	
	public static void escribirNombres(String ruta,String nombres)
	{
		
		String[] listaNombres;
		Path rutaArchivo =Paths.get(ruta);
		if(nombres.contains(","))
		{
			listaNombres=nombres.split(",");
		}
		else if(nombres.contains(" "))
		{
			listaNombres=nombres.split(" ");
		}
		else
		{
			listaNombres=null;
		}
		
		if(listaNombres==null || !(listaNombres.length>0 && listaNombres.length<=10))
		{
			Scanner entrada= new Scanner(System.in);
			System.out.println("Por favor ingrese 10 nombres a continuacion separados por \",\".");	
			listaNombres=entrada.next().split(",");
			entrada.close();
		}
		if(listaNombres.length>10)
		{
			System.out.println("Error, ingreso mas de 10 nombres");
			return;
		}
		try
		{
			if(Files.exists(rutaArchivo))
			{
				Scanner entrada = new Scanner(System.in);
				System.out.println("El archivo ubicado en: "+ruta+" ya existe,\ndesea eliminarlo y crear uno nuevo? s/n?");
				if(entrada.next().toLowerCase().equals("s"))
				{
					Files.deleteIfExists(rutaArchivo);
					rutaArchivo = Files.createFile(rutaArchivo);
					System.out.println("Se ha creado exitosamente el archivo.");
				}
				else
				{
					System.out.println("los nombres se escribiran despues del contenido del archivo existente, esta seguro? s/n?");
					if(entrada.next().toLowerCase().equals("n"))
					{
						Files.deleteIfExists(rutaArchivo);
						rutaArchivo = Files.createFile(rutaArchivo);
						System.out.println("Se ha creado exitosamente el archivo.");
					}
				}
				entrada.close();
			}
			else
			{
				rutaArchivo = Files.createFile(rutaArchivo);
				System.out.println("Se ha creado exitosamente el archivo en: "+ruta+".");
			}
			for(int i=0;i<listaNombres.length;i++)
			{
				Files.writeString(rutaArchivo,listaNombres[i]+"\n",StandardOpenOption.APPEND);	
			}
			for (String nombre : Files.readAllLines(rutaArchivo))
			{
				System.out.println(nombre);
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		
	}
	
}
