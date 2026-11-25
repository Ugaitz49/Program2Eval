package principal;

import java.io.PrintStream;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcursionCultural excursionCultural= new ExcursionCultural("1",Destino.CIUDAD,25,150,10,true);
		System.out.println(excursionCultural.toString());
		System.out.println(excursionCultural.calcularPrecio());
		ExcursionCultural excurCultural= new ExcursionCultural("2",Destino.CIUDAD,25,150,10,false);
		System.out.println(excursionCultural.toString());
		System.out.println(excursionCultural.calcularPrecio());
		
		ExcursionBuceo excursionBuceo= new ExcursionBuceo("2",Destino.PLAYA,23,150,10,false,6,false);
		System.out.println(excursionBuceo.toString());
		System.out.println(excursionBuceo.calcularPrecio());
		
		ExcursionBuceo excursionBuceo2= new ExcursionBuceo("2",Destino.PLAYA,30,150,10,false,6,true);
		System.out.println(excursionBuceo2.toString());
		System.out.println(excursionBuceo2.calcularPrecio());
		
		ExcursionAventura excursionAventura= new ExcursionAventura("2",Destino.PLAYA,23,150,10,Nivel.EXTREMO);
		System.out.println(excursionBuceo2.toString());
		System.out.println(excursionBuceo2.calcularPrecio());
	}

}
