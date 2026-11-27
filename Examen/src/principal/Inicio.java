package principal;

import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		Scanner cs = new Scanner(System.in);
		Excursion[] excursiones = new Excursion[30];
		int numExcursiones = 0;
		int opcion;
		do {
			System.out.println("1- Introducir Excursiones");
			System.out.println("2- Mostrar Excursiones que superen una velocidad media dada");
			System.out.println("3- Inscribir participantes en una excursion");
			System.out.println("4- Eliminar una excursion");
			System.out.println("5- Mostrar todas las excursiones");
			System.out.println("6- Salir");
			System.out.println("Elije una opcion:");
			opcion = cs.nextInt();

			while (opcion < 1 || opcion > 6) {
				System.out.println("Elije una opcion valida");
				opcion = cs.nextInt();
			}

			switch (opcion) {
			case 1:
				numExcursiones = introducirExcursiones(cs, excursiones, numExcursiones);
				break;
			case 2:
				mostrarPorVelocidad(cs, excursiones, numExcursiones);
				break;
			case 3:
				inscribirParticipantes(cs, excursiones, numExcursiones);
				break;
			case 4:
				numExcursiones = eliminarExcursion(cs, excursiones, numExcursiones);
				break;	
			case 5:
				mostrarTodas(excursiones, numExcursiones);
				break;
			case 6:
				System.out.println("¡Gracias por usar el programa! Hasta pronto.");
				break;
			}
		} while (opcion != 6);

		cs.close();
	}

	public static int introducirExcursiones(Scanner cs, Excursion[] excursiones, int numExcursiones) {
		if (numExcursiones >= excursiones.length) {
			System.out.println("Ya has puesto el maximo de Excursiones");
			return numExcursiones;
		}

		cs.nextLine();

		System.out.print("Introduce el código de la excursión: ");
		String codigo = cs.nextLine();
		while (codigo.isEmpty() || existeCodigo(excursiones, numExcursiones, codigo)) {
			System.out.print("No existe ningun codigo, Introduce un código único: ");
			codigo = cs.nextLine();
		}

		Destino destino = pedirDestino(cs);

		System.out.print("Introduce el número de participantes (0 - 25): ");
		int participantes = cs.nextInt();
		while (participantes < 0 || participantes > Excursion.maxParticipantes) {
			System.out.print("Introduce un número entre 0 y 25: ");
			participantes = cs.nextInt();
		}

		System.out.print("Introduce la distancia recorrida: ");
		int distancia = cs.nextInt();
		while (distancia <= 0) {
			System.out.print("La distancia debe ser mayor que 0: ");
			distancia = cs.nextInt();
		}

		System.out.print("Introduce la duración de la excursión: ");
		int duracion = cs.nextInt();
		while (duracion <= 0) {
			System.out.print("La duración debe ser mayor que 0: ");
			duracion = cs.nextInt();
		}

		excursiones[numExcursiones] = new Excursion(codigo, destino, participantes, distancia, duracion);
		numExcursiones++;
		System.out.println("Excursión registrada correctamente.");

		return numExcursiones;
	}

	public static boolean existeCodigo(Excursion[] excursiones, int numExcursiones, String codigo) {
		for (int i = 0; i < numExcursiones; i++) {
			if (excursiones[i].getCodigo().equalsIgnoreCase(codigo)) {
				return true;
			}
		}
		return false;
	}

	public static Destino pedirDestino(Scanner cs) {
		System.out.println("Selecciona el destino:");
		System.out.println("1- MONTAÑA");
		System.out.println("2- PLAYA");
		System.out.println("3- CIUDAD");
		System.out.print("Opción: ");
		int op = cs.nextInt();

		while (op < 1 || op > 4) {
			System.out.print("Opción no válida. Elige entre 1 y 3: ");
			op = cs.nextInt();
		}

		switch (op) {
		case 1:
			return Destino.MONTAÑA;
		case 2:
			return Destino.PLAYA;
		case 3:
			return Destino.CIUDAD;
		default:
			return Destino.INDEFINIDO;
		}
	}

	public static void mostrarPorVelocidad(Scanner cs, Excursion[] excursiones, int numExcursiones) {
		if (numExcursiones == 0) {
			System.out.println("No hay excursiones registradas.");
			return;
		}

		System.out.print("Introduce la velocidad media mínima: ");
		double velocidadMinima = cs.nextDouble();
		while (velocidadMinima < 0) {
			System.out.print("La velocidad no puede ser negativa: ");
			velocidadMinima = cs.nextDouble();
		}

		boolean encontrada = false;
		for (int i = 0; i < numExcursiones; i++) {
			double vel = excursiones[i].obtenerVelocidadMedia();
			if (vel > velocidadMinima) {
				System.out.println("Código: " + excursiones[i].getCodigo() + " - Velocidad media: " + vel + " km/h");
				encontrada = true;
			}
		}

		if (!encontrada) {
			System.out.println("No existe ninguna excursión que supere esa velocidad media.");
		}
	}

	public static void inscribirParticipantes(Scanner cs, Excursion[] excursiones, int numExcursiones) {
		if (numExcursiones == 0) {
			System.out.println("No hay excursiones registradas.");
			return;
		}

		cs.nextLine();
		System.out.print("Introduce el código de la excursión: ");
		String codigo = cs.nextLine();

		int pos = -1;
		for (int contador = 0; contador < numExcursiones; contador++) {
			if (excursiones[contador].getCodigo().equalsIgnoreCase(codigo)) {
				pos = contador;
				break;
			}
		}

		if (pos == -1) {
			System.out.println(" No existe ninguna excursión con ese código.");
		} else if (excursiones[pos].grupoCompleto()) {
			System.out.println(" La excursión ya está completa.");
		} else {
			System.out.print("Introduce el número de participantes a inscribir: ");
			int nuevos = cs.nextInt();
			while (nuevos <= 0) {
				System.out.print(" Debe inscribir al menos 1 participante: ");
				nuevos = cs.nextInt();
			}

			int total = excursiones[pos].getNumParticipantes() + nuevos;
			if (total <= Excursion.maxParticipantes) {
				excursiones[pos].setNumParticipantes(total);
				System.out.println("Participantes inscritos correctamente. Total actual: " + total);
			} else {
				int plazasLibres = Excursion.maxParticipantes - excursiones[pos].getNumParticipantes();
				System.out.println(" No hay plazas suficientes. Solo quedan " + plazasLibres + " plazas libres.");
			}
		}
	}

	public static int eliminarExcursion(Scanner cs, Excursion[] excursiones, int numExcursiones) {
		if (numExcursiones == 0) {
			System.out.println("No hay excursiones registradas.");
			return numExcursiones;
		}

		Destino destinoEliminar = pedirDestino(cs);
		int eliminadas = 0;

		for (int contador = 0; contador < numExcursiones; contador++) {
			if (excursiones[contador].getDestino() == destinoEliminar) {
				for (int i = contador; i < numExcursiones - 1; i++) {
					excursiones[i] = excursiones[i + 1];
				}
				excursiones[numExcursiones - 1] = null;
				numExcursiones--;
				eliminadas++;
				contador--;
			}
		}

		if (eliminadas > 0) {
			System.out
					.println("Se han eliminado " + eliminadas + " excursión(es) con destino " + destinoEliminar + ".");
		} else {
			System.out.println("No existe ninguna excursión con el destino indicado.");
		}

		return numExcursiones;
	}
	
	public static void mostrarTodas(Excursion[] excursiones, int numExcursiones) {
		if (numExcursiones == 0) {
			System.out.println("No hay excursiones almacenadas.");
			return;
		}

		for (int contador = 0; contador < numExcursiones; contador++) {
			System.out.println(excursiones[contador].toString());
		}
	}

}
