package principal;

public class Main {

	public static void main(String[] args) {
		Personaje[] arrayDeTodo = new Personaje[3];
		arrayDeTodo[0] = new Mago("Ugaitz", 5, 55, 10, Tipo.FUEGO);
		arrayDeTodo[1] = new Soldado("Ugaitz", 5, 55, "lanza", 35);
		arrayDeTodo[2] = new Campesino("Ugaitz", 5, 55, "hoz", 20);
		
		System.out.println(arrayDeTodo [0]instanceof Mago);
		System.out.println(arrayDeTodo [1]instanceof Soldado);
		System.out.println(arrayDeTodo [2]instanceof Campesino);

//		
//		Personaje personaje=new Personaje("Ugaitz", 5, 55);
//		personaje.presentarse();	
//		
//		Mago mago=new Mago("Ugaitz", 5, 55, 10, Tipo.FUEGO);
//		mago.play();
//		mago.presentarse();
//		
//		Soldado soldado=new Soldado("Ugaitz", 5, 55, "lanza", 35);
//		soldado.play();
//		soldado.recibirDanio(0);
//		
//		Campesino campesino=new Campesino ("Ugaitz", 5, 55, "hoz", 20);
//		campesino.play();
//		campesino.venderCosecha();
	}

}
