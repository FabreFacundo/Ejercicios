package PrimerPaquete;



public class SegundoEjercicio {

	public static void main(String[] args) {
		
		float ingresosTotales=72386.50f;
		int cantVeEntreTresYCinco=0; // Cantidad de vehiculos con antiguedad entre 3 y 5 años.
		int cantVeMenorTres=1;       // Cantidad de vehiculos con antiguedad menor a 3 años.
		int cantidadInmuebles=1;
		boolean bienesDeLujo=true;
		
		
		
		if((ingresosTotales>=572386.50f) || ((cantVeEntreTresYCinco+cantVeMenorTres)>=3)||(cantidadInmuebles>=3)||(bienesDeLujo))
		{
			System.out.println("La persona pertenece al sector de ingresos altos");
		}
		else if((ingresosTotales<572386.50f && ingresosTotales>=163539f) || (cantVeMenorTres==1)||(cantidadInmuebles==2) )
		{
			System.out.println("La persona pertenece al sector de ingresos medios");
		}
		else
		{
			System.out.println("La persona pertenece al sector de ingresos bajos");
		}
	}

}
