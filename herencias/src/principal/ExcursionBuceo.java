package principal;

public class ExcursionBuceo extends Excursion {
	private boolean certificado;
	private int profundidad;
	private boolean equipo;
	private final int PrecioEquipo = 100;
	
	public boolean isCertificado() {
		return certificado;
	}

	public void setCertificado(boolean certificado) {
		this.certificado = certificado;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

	public boolean isEquipo() {
		return equipo;
	}

	public void setEquipo(boolean equipo) {
		this.equipo = equipo;
	}

	public ExcursionBuceo(String codigo, Destino destino, int numeroParticipantes, double distanciaRecorrida,
			double duracion, boolean certificado, int profundidad, boolean equipo) {
		super(codigo, destino, numeroParticipantes, distanciaRecorrida, duracion);
		this.certificado = certificado;
		this.profundidad = profundidad;
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return super.toString() + "\nExcursionBuceo [certificado=" + certificado + ", profundidad " + profundidad
				+ ",equipos=" + equipo + "]";

	
	}
	
	@Override
	public double calcularPrecio() {
		if(isEquipo()) {
			return super.calcularPrecio()+getNumeroParticipantes()*PrecioEquipo;
			
		}else {
			return super.calcularPrecio();
		}
	}
}
