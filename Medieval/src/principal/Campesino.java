package principal;

public class Campesino extends Personaje {
	private String herramienta;
	private int cosechaRecolectada;

	public Campesino(String nombre, int nivel, int puntosVida, String herramienta, int cosechaRecolectada) {
		super(nombre, nivel, puntosVida);
		this.herramienta = herramienta;
		this.cosechaRecolectada = cosechaRecolectada;
	}

	@Override
	public void play() {
		if (this.herramienta.equalsIgnoreCase("Azada")) {
			this.cosechaRecolectada=cosechaRecolectada+5;
		}else if(this.herramienta.equalsIgnoreCase("Hoz")) {
			this.cosechaRecolectada=cosechaRecolectada+3;
			
		}else {
			System.out.println("No hay cosecha recolectada");
		}
		
	}
	
	public void venderCosecha() {
		int dinero=cosechaRecolectada*100;
		System.out.println("dinero recaudado: " + dinero);
		System.out.println("cosecha recogida: " + (cosechaRecolectada=0));
		cosechaRecolectada=0;
		
	}
}
