package paqueteClase3;

public class Ejercicio1ParteA {
	
	
	public static void main(String[] Args)
	{
		int cantidadDeVeces=0;
		String palabra = "Ornitorringo";
		char letra='o';
		
		for(int i=0;i<palabra.length();i++)
		{
			if(palabra.charAt(i)==letra)
			{
				cantidadDeVeces++;
			}
		}
		
		System.out.println("En la palabra \""+ palabra+"\" la letra \""+letra+"\" se encuentra "+cantidadDeVeces +" veces." );
		
	}
}
