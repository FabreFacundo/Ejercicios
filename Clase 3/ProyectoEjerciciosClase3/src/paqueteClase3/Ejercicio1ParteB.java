package paqueteClase3;

public class Ejercicio1ParteB {
	
public static void main(String[] Args)
{
	int num1=1,num2=4,num3=5;
	char orden='a';

	int[] resultado=new int[3];
	
	if(num1>num2)
	{
		if(num1<num3)
		{
			
			if(orden=='d')
			{
				resultado= new int[] {num3,num1,num2};
			}
			else if(orden=='a')
			{
				resultado= new int[] {num2,num1,num3};
			}
		}
		else if(num2>num3)
		{
			

			if(orden=='d')
			{
				resultado= new int[] {num1,num2,num3};
			}
			else if(orden=='a')
			{
				resultado= new int[] {num3,num2,num1};
			}
		}
	}
	else 
	{
		if(num2<num3)
		{
			

			if(orden=='d')
			{
				resultado= new int[] {num3,num2,num1};
			}
			else if(orden=='a')
			{
				resultado= new int[] {num1,num2,num3};
			}
		}
		else if(num1>num3)
		{
		

			if(orden=='d')
			{
				resultado= new int[] {num2,num1,num3};
			}
			else if(orden=='a')
			{
				resultado= new int[] {num3,num1,num2};
			}
		}
		
	}

	for(int i=0;i<resultado.length;i++)
	{
		System.out.print(resultado[i]+" ");
	}
}
}
