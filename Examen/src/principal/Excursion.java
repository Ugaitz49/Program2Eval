package principal;

public class Excursion {
	private String codigo;
	private Destino destino;
	private int numParticipantes;
	private int distanciaRecorrida;
	private int duracionExcursion;
	public static final int maxParticipantes = 25;
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public int getNumParticipantes() {
		return numParticipantes;
	}

	public void setNumParticipantes(int numParticipantes) {
		this.numParticipantes = numParticipantes;
	}

	public int getDistanciaRecorrida() {
		return distanciaRecorrida;
	}

	public void setDistanciaRecorrida(int distanciaRecorrida) {
		this.distanciaRecorrida = distanciaRecorrida;
	}

	public int getDuracionExcursion() {
		return duracionExcursion;
	}

	public void setDuracionExcursion(int duracionExcursion) {
		this.duracionExcursion = duracionExcursion;
	}

	public Excursion(String codigo, Destino destino, int numParticipantes, int distanciaRecorrida,
			int duracionExcursion) {
		super();
		this.codigo = codigo;
		if (destino == null) {
			this.destino = destino.INDEFINIDO;
		} else {
			this.destino = destino;
		}
		this.numParticipantes = numParticipantes;
		this.distanciaRecorrida = distanciaRecorrida;
		this.duracionExcursion = duracionExcursion;
	}

	@Override
	public String toString() {
		return "Excursion [codigo=" + codigo + ", destino=" + destino + ", numParticipantes=" + numParticipantes
				+ ", distanciaRecorrida=" + distanciaRecorrida + ", duracionExcursion=" + duracionExcursion + "]";
	}

	public boolean grupoCompleto() {
		return numParticipantes >= maxParticipantes;
	}

	public double obtenerVelocidadMedia() {
		return distanciaRecorrida / duracionExcursion;
	}

}
