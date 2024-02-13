package juego.util;

/**
 * Representa las direcciones posibles en las que se puede colocar una palabra en el tablero.
 * 
 * @author <a href="mailto:jgc1031@alu.ubu.es">José Gallardo Caballero</a>
 * @version 1.0
 * @serial 2024/02/12
 */
public enum Direccion
{
    /**
     * Dirección Horizontal
     */
	HORIZONTAL,
    /**
     * Dirección Vertical
     */
	VERTICAL,
    /**
     * Diagonal Suroeste-Norste
     */
	DIAGONAL_SO_NE,
    /**
     * Diagonal Noroeste-Sureste
     */
	DIAGONAL_NO_SE;
}
