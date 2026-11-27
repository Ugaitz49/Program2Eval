package principal;

public class Mago extends Personaje {

	private int hechizos;
	private Tipo ataque;

	public Mago(String nombre, int nivel, int puntosVida, int hechizos, Tipo ataque) {
		super(nombre, nivel, puntosVida);
		this.hechizos = hechizos;
		this.ataque = ataque;
	}

	public void meditar(int cantidad) {
		hechizos += cantidad;

	}

	@Override
	public void play() {
		if (hechizos > 10) {
			hechizos--;
			System.out.println("Ataque Mágico: "+ ataque);
		}

		if (hechizos == 0) {
			System.out.println("No tienes ningun hechizo");
		}

	}

	@Override
	public void presentarse() {

		super.presentarse();
		System.out.println("Hechizos: " + this.hechizos + " Ataque: " + this.ataque);
	}
}
