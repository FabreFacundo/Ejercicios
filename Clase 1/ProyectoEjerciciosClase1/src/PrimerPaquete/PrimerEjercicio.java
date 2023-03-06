package PrimerPaquete;

public class PrimerEjercicio {

	public static void main(String[] args) 
	{
			
		int ValorInicial=5;
		int ValorFinal=14;
		boolean ParImpar= true; // Si es True muestra impares si es False muestra pares
		
		// Ejercicio 1 parte A
		
		System.out.println("Ejercicio 1 parte A");
		
		while(ValorInicial<=ValorFinal)
		{
			System.out.print(ValorInicial+" ");
			ValorInicial++;
		}
		
		System.out.print("\n"); // dejo un espacio 
		
		ValorInicial=5; // Asigno 5 al valor de la variable
		
		// Ejercicio 1 Parte B
		
		System.out.println("Ejercicio 1 parte B");
		
		 while(ValorInicial<=ValorFinal)
		{
		 	if((ValorInicial%2)==0) // Si el resto da 0 es valor es par y lo muestro en pantalla 
		 	{ 
		 		System.out.print(ValorInicial+" ");
		 	}
			ValorInicial++;
		}	
		 
		System.out.print("\n"); // dejo un espacio 
			
		ValorInicial=5; // Asigno 5 al valor de la variable
			
		// Ejercicio 1 Parte C	
			
		System.out.println("Ejercicio 1 parte C Estado de la variable de eleccion: "+ ParImpar);
			
		 while(ValorInicial<=ValorFinal)
		{ 
		 	if((ValorInicial%2)==0 && !ParImpar) // Si resto igual a 0, es par, y si el booleano ParImpar es falso (negado) muestra Pares.
		 	{ 
		 		System.out.print(ValorInicial+" ");
		 	}
		 	if((ValorInicial%2)!=0 && ParImpar) // Si resto distinto 0, es impar, y si el booleano ParImpar es verdadero muestra impares.
		 	{
		 		System.out.print(ValorInicial+" ");	
		 	}
		 	
		 	ValorInicial++;
		 	
		}	
		 
		 System.out.print("\n"); // dejo un espacio
		 
		 ValorInicial=5; // Asigno 5 al valor de la variable
		 
		 // Ejercicio 1 parte D
		 
		 System.out.println("Ejercicio 1 parte D");
		 for(int i=ValorFinal;i>=ValorInicial;i--)
		 {
				if((i%2)==0) // Si el resto da 0 es valor es par y lo muestro en pantalla 
			 	{ 
			 		System.out.print(i+" ");
			 	}
		 }
		 
	}
	
	//
	

}
