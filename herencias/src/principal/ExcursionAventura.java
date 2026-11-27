package principal;

public class ExcursionAventura extends Excursion {
	private Nivel nivel;

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "ExcursionAventura [nivel=" + nivel + "]";
	}

	public ExcursionAventura(String codigo, Destino destino, int numeroParticipantes, double distanciaRecorrida,
			double duracion, Nivel nivel) {
		super(codigo, destino, numeroParticipantes, distanciaRecorrida, duracion);
		this.nivel = nivel;
	}

	public Nivel nivel(String nivel) {
		if (nivel != null) {
			switch (nivel.trim().toUpperCase()) {

			case "BAJO":
				return Nivel.BAJA;
			case "MEDIO":
				return Nivel.MEDIA;
			case "ALTO":
				return Nivel.EXTREMO;
			default:
				return Nivel.BAJA;
			}
		}
		return null;

	
	}
	
	@Override
	public double calcularPrecio() {
		if(nivel == nivel.MEDIA) {
			return super.calcularPrecio()+super.calcularPrecio()+150;

		}
		if(nivel == nivel.EXTREMO) {
			return super.calcularPrecio()+super.calcularPrecio()+300;

		}
		return 0;
	}
	
}
