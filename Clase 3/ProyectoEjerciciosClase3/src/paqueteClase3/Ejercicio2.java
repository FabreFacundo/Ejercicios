package paqueteClase3;

public class Ejercicio2 {

	public static void main(String[] Args)
	{
	
		String[] listaNombres= "Juan,Pedro,Maria,Claudia,Roman,Gaston,Pepe,Lorena,Jazmin,Carlos".split(",");
		if(listaNombres.length>10)
		{
			System.out.println("Error, ingreso mas de 10 nombres");
			
			return;
		}
		for(int i=0;i<listaNombres.length;i++)
		{
			System.out.println(i+": "+listaNombres[i]);
		}
		
	}
	
}
