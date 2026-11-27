package principal;

public class Soldado extends Personaje {
	private String arma;
	private int armadura;

	public Soldado(String nombre, int nivel, int puntosVida, String arma, int armadura) {
		super(nombre, nivel, puntosVida);
		this.arma = arma;
		this.armadura = armadura;
	}

	@Override
	public void play() {
		int danio = 0;
		if (arma.equalsIgnoreCase("Lanza")) {
			danio = 5;
			System.out.println(danio);
		}

		else if (arma.equalsIgnoreCase("Espada Larga")) {
			danio = 6;
			System.out.println(danio);
		}
	}

	@Override
	public void recibirDanio(int danio) {
		if (this.arma.equalsIgnoreCase("Lanza")) {
			this.armadura = armadura - 5;
			System.out.println("Te queda " + armadura + " de armadura");
		}

		else if (this.arma.equalsIgnoreCase("Espada Larga")) {
			this.armadura = armadura - 6;
		} else
			System.out.println("Te queda" + armadura + " de armadura");
	}
}
