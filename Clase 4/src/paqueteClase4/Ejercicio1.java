package paqueteClase4;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args)
	{
		parteA(59,1,108,'a');
		parteB();
		parteC(33,44,39,'d'); // Para que te pida los datos por consola se tiene que pasar tres 0, o un char que no sea ni 'a' ni 'd'
	}					      // Ya que no dimos sobrecarga de metodos lo hice asi.
	public static void parteA(int num1,int num2,int num3, char orden)
	{
		ordenarMostrarNumeros(new int[]{num1,num2,num3},orden);	
	}
	
	public static void parteB()
	{
		
		int[] numeros=new int[3];
		char orden;
		char terminado='n';
		do {
			Scanner entrada=new Scanner(System.in);	
			for(int i=0;i<numeros.length;i++)
			{
				System.out.println("Por favor ingrese un numero, faltan: "+(numeros.length-i));
				try {
					numeros[i]=entrada.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Error, el tipo de dato no corresponde al tipo numerico entero, vuelva a intantar");
					terminado='e';
					break;
				}
			}
			if(terminado=='e') 
			{
				terminado='n';
				continue;
			}
			System.out.println("Por favor ingrese 'a' para ordenarlos de forma ascendente o 'd' para ordenarlos decrecientemente");
			orden=entrada.next().charAt(0);
			if(orden!='a' && orden!='d') continue;
			ordenarMostrarNumeros(numeros,orden);
			terminado='t';	
			entrada.close();
		}while(terminado!='t');
		
	}
	public static void parteC(int num1, int num2, int num3, char orden)
	{
		 if((num1==0&&num2==0&&num3==0)||(orden!='a'&&orden!='d'))
		{
			parteB();
		}
		else
		{
			parteA(num1,num2,num3,orden);
		}
	}
	static void ordenarMostrarNumeros(int[] aOrdenar,char orden)
	{
		int aux1;
		boolean ordenado=false;
		while(!ordenado)
		{
			for(int i=0;i<aOrdenar.length;i++)
			{
				if(i<aOrdenar.length-1)
				{
					if(orden=='a')
					{
						if(aOrdenar[i]>aOrdenar[i+1]&&aOrdenar[i]!=aOrdenar[i+1])
						{
							aux1=aOrdenar[i];
							aOrdenar[i]=aOrdenar[i+1];
							aOrdenar[i+1]=aux1;
						}
					}
					if(orden=='d')
					{
						if(aOrdenar[i]<aOrdenar[i+1]&&aOrdenar[i]!=aOrdenar[i+1])
						{
							aux1=aOrdenar[i];
							aOrdenar[i]=aOrdenar[i+1];
							aOrdenar[i+1]=aux1;
						}
					}
				}
			}
			for(int i=0;i<aOrdenar.length;i++)
			{
				if(i<aOrdenar.length-1)
				{
					if(orden=='a')
					{
						if(aOrdenar[i]>aOrdenar[i+1]&&aOrdenar[i]!=aOrdenar[i+1])
						{
							ordenado=false;
							break;
						}	
						else
						{
							ordenado=true;
						}
					}
					if(orden=='d')
					{
						if(aOrdenar[i]<aOrdenar[i+1]&&aOrdenar[i]!=aOrdenar[i+1])
						{
							ordenado=false;
							break;
						}	
						else
						{
							ordenado=true;
						}
					}
				}
				else
				{
					if(orden=='a')
					{
						ordenado= ordenado && (aOrdenar[i]>=aOrdenar[i-1]);
					}
					if(orden=='d')
					{
						ordenado= ordenado && (aOrdenar[i]<=aOrdenar[i-1]);
					}
				}
			}
	   }
		for(int i=0;i<aOrdenar.length;i++)
		{
			System.out.println(aOrdenar[i]);
		}
	}
}
