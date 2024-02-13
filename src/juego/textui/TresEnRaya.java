package juego.textui;

import java.util.Scanner;

import juego.control.ArbitroTresEnRaya;
import juego.modelo.Jugador;
import juego.modelo.Tablero;
import juego.util.Coordenada;

/**
 * Jugar al tres en raya en modo texto.
 * 
 * @author <a mailto="jose:jgc1031@alu.ubu.es">José Gallardo Caballero</a>
 * @version 1.0
 * @serial 2024/02/12
 */
public class TresEnRaya {

	/** Número de argumentos máximo. */
	private static final int NUM_ARGUMENTOS = 2;

	/** Arbitro. */
	private static ArbitroTresEnRaya arbitro;

	/**
	 * Constructor. Lo creé para eliminar el warning en la documentación.
	 */
	public TresEnRaya() {
	}

	/**
	 * Flujo de ejecución principal del juego.
	 * 
	 * @param args nombres de los jugadores.
	 */
	public static void main(String[] args) {
		if (args.length != NUM_ARGUMENTOS) {
			mostrarAyuda();
		} else {
			// Inicialización del juego según los argumentos validados
			arbitro = new ArbitroTresEnRaya();
			arbitro.registrarJugador(args[0]); // asumiendo que los argumentos son los nombres de los jugadores
			arbitro.registrarJugador(args[1]);

			// Fase de juego, iteramos sobre las distintas jugadas.
			Scanner teclado = new Scanner(System.in); // teclado permite leer enteros con el método nextInt

			// mientras la partida no esté acabada leer de teclado fila, columna, y si la
			// jugada es válida, completarla
			mostrarTablero(arbitro.obtenerTablero());
			while (!arbitro.estaAcabado()) {
				System.out.printf("Introduce la fila y la columna separadas por un espacio (Ej. 2 1): ");
				String entrada = teclado.nextLine();
				String[] partes = entrada.split(" ");

				if (partes.length != 2) {
					System.out.println("Entrada inválida. Intenta de nuevo siguiendo el ejemplo dado.");
				} else {
					int fila = Integer.parseInt(partes[0]);
					int columna = Integer.parseInt(partes[1]);
					Coordenada coordenada = new Coordenada(fila, columna);

					if (arbitro.esMovimientoLegal(coordenada)) {
						arbitro.jugar(coordenada);
						System.out.println("Jugada realizada en fila " + fila + ", columna " + columna);
						mostrarTablero(arbitro.obtenerTablero());
					} else {
						System.out.println("Jugada inválida. Está seguro de que la celda (" + fila + ", " + columna + ") está vacía o dentro del tablero?\n");
					}
				}
			}

			// Informar del resultado final de la partida (ganador o tablas)
			Jugador ganador = arbitro.obtenerGanador();
			if (ganador != null) {
				mostrarTablero(arbitro.obtenerTablero());
				System.out.println("El ganador es " + ganador.consultarNombre());
			} else {
				System.out.println("La partida ha terminado en tablas");
			}

			teclado.close();
		}
	}

	/**
	 * Muestra la ayuda en línea para la inicialización correcta del juego.
	 */
	private static void mostrarAyuda() {
		System.out.println("Se deben de pasar 2 parámetros después a la hora de ejecutar el programa.");
		System.out.println("Recomiendo ejecutar directamente el fichero 'ejecutar_texui'.");
	}

	/**
	 * Muestra el estado actual del tablero.
	 * 
	 * @param tablero tablero a pintar en pantalla.
	 */
	private static void mostrarTablero(Tablero tablero) {
		System.out.println(tablero.aTexto());
	}
}