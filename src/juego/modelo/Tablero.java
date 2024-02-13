package juego.modelo;

import java.util.Arrays;
import juego.util.Coordenada;
import juego.util.Direccion;

/**
 * Componente Pieza, que representa las fichas del juego.
 * 
 * @author <a href="mailto:jgc1031@alu.ubu.es">José Gallardo Caballero</a>
 * @version 1.0
 * @serial 2024/02/12
 */
public class Tablero {
    /**
     * Variable tablero.
     */
    private Celda[][] tablero;

    /**
     * Constructor.
     * 
     * @param filas filas del tablero.
     * @param columnas columnas del tablero.
     */
    public Tablero(int filas, int columnas) {
        tablero = new Celda[filas][columnas];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				Coordenada coordenada = new Coordenada(i, j);
				Celda celda = new Celda(coordenada);
				tablero[i][j] = celda;
			}
		}
    }

    /**
     * Consultamos número de filas.
     * 
     * @return número de filas.
     */
    public int consultarNumeroFilas() {
        return tablero.length;
    }

    /**
     * Consultamos número de columnas.
     * 
     * @return número de columnas.
     */
    public int consultarNumeroColumnas() {
        return tablero[0].length;
    }

    /**
     * Consultamos si el tablero está completo.
     * 
     * @return true si el tablero está completo.
     */
    public boolean estaCompleto() {
		for (int i = 0; i < tablero.length; i++)
		{
			for (int j = 0; j < tablero[i].length; j++)
			{
				if (tablero[i][j] == null)
				{
					return false;
				}
			}
		}
		return true;
	}

    /**
     * Consultamos número de piezas en el tablero.
     * 
     * @param color color de las piezas.
     * @return número de piezas.
     */
    public int consultarNumeroPiezas(Color color) {
		int cont = 0;
		for (int i = 0; i < tablero.length; i++)
		{
			for (int j = 0; j < tablero[i].length; j++)
			{
				if (!tablero[i][j].estaVacia() && tablero[i][j].obtenerPieza().obtenerColor() == color) 
				{
					cont++;
				}
			}
		}
		return cont;
	}

    /**
     * Consultamos las piezas seguidas. Si hay 3 piezas seguidas del mismo color, el
     * jugador gana.
     * 
     * @param coordenada coordenada.
     * @param direccion dirección.
     * @return número de piezas seguidas.
     */
    public int contarPiezasConsecutivas(Coordenada coordenada, Direccion direccion) 
	{
		int contador = 0;
		Color color = null;
		Celda celda = this.obtenerCelda(coordenada);
		if(celda.estaVacia())
		{
			return contador;
		}else {
			color = celda.obtenerPieza().obtenerColor();
			contador++;
		}
		switch(direccion)
		{
			case HORIZONTAL:
				contador += contarPiezas(coordenada, 0, +1, color);
				contador += contarPiezas(coordenada, 0, -1, color);
				break;
			
			case VERTICAL:
				contador += contarPiezas(coordenada, +1, 0, color);
				contador += contarPiezas(coordenada, -1, 0, color);
				break;
				
			case DIAGONAL_NO_SE:
				contador += contarPiezas(coordenada, -1, -1, color);
				contador += contarPiezas(coordenada, +1, +1, color);
				break;
				
			case DIAGONAL_SO_NE:
				contador += contarPiezas(coordenada, +1, -1, color);
				contador += contarPiezas(coordenada, -1, +1, color);
				break;
		}
		return contador;
	}

    /**
     * Contamos las piezas.
     * 
     * @param coordenada coordenada.
     * @param i variable dependiente de la dirección.
     * @param j variable dependiente de la dirección.
     * @param color color de las piezas.
     * @return número de piezas.
     */
    private int contarPiezas(Coordenada coordenada, int i, int j, Color color)
	{
		int contador = 0;
		Coordenada coordenadaAux = new Coordenada(coordenada.fila() + i, coordenada.columna() + j);
		Celda celda = this.obtenerCelda(coordenadaAux);
		if(celda != null && !celda.estaVacia() && celda.obtenerPieza().obtenerColor() == color)
		{
			contador++;
			contador += contarPiezas(coordenadaAux, i, j, color);
		}
		return contador;
	}

    /**
     * Obtenemos celda específica, con su pieza si es que tiene.
     * 
     * @param coordenada coordenada de la celda a retornar.
     * @return celda.
     */
    public Celda obtenerCelda(Coordenada coordenada) {
		int fila = coordenada.fila();
		int columna = coordenada.columna();
		if (fila < 0 
				|| fila >= this.consultarNumeroFilas() 
				|| columna < 0 
				|| columna >= tablero[0].length) 
		{
			return null;
		}
		return tablero[fila][columna];
	}

    /**
     * Consultamos si la coordenada está en el tablero.
     * 
     * @param coordenada coordenada.
     * @return true si la coordenada está en el tablero.
     */
    public boolean estaEnTablero(Coordenada coordenada) {
		int fila = coordenada.fila();
		int columna = coordenada.columna();
		if (fila < 0 
				|| fila >= this.consultarNumeroFilas() 
				|| columna < 0 
				|| columna >= tablero[0].length) 
		{
			return false;
		}
		return true;
	}

    /**
     * Colocamos pieza en el tablero.
     * 
     * @param pieza pieza.
     * @param coordenada coordenada.
     */
    public void colocar(Pieza pieza, Coordenada coordenada) {
		int fila = coordenada.fila();
		int columna = coordenada.columna();
		if(pieza != null && this.estaEnTablero(coordenada))
		{
			tablero[fila][columna].establecerPieza(pieza);
		}
	}

    /**
     * Pasamos el tablero a texto.
     * 
     * @return tablero en texto.
     */
    public String aTexto() {
		String texto = "";
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j].estaVacia()) {
					texto += "-";
				} else {
					texto += tablero[i][j].obtenerPieza().obtenerColor().toChar();
				}
			}
			texto += "\n";
		}
		return texto;
	}

    @Override
	public String toString() {
		return "Tablero [tablero=" + Arrays.toString(tablero) + "]";
	}
}