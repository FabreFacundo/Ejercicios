package paqueteClase3;

public class Ejercicio1ParteC {
	
	public static void main (String[] Args)
	{
		int[] numeros= {5,3,8,9,6,99,66,55,44,88,99,77,54,55,2,5,6,7,4,5};
		int suma=0,valorBase=22;
		
		if(numeros.length>1)
		{
			for(int i=0; i<numeros.length;i++)
			{
				if(numeros[i]>valorBase)
				{
					suma+=numeros[i];
				}
			}
		}
		else if(numeros.length==1)
		{
			suma=numeros[1];
		}
		else
		{
			System.out.println("El vector esta vacio");
			return;
		}
		System.out.println("El resultado es: "+suma);
	}

}
