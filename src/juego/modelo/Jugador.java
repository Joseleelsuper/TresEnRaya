/**
 * Componente que representa a un jugador del juego.
 * 
 * @author <a href="mailto:jgc1031@alu.ubu.es">José Gallardo Caballero</a>
 * @version 1.0
 * @serial 2024/02/12
 */
package juego.modelo;

/**
 * Clase jugador.
 */
public class Jugador
{
	/**
	 * Cada jugador tiene un nombre.
	 */
	private String nombre;
	/**
	 * Cada jugador tiene un color.
	 */
	private Color color;
	
	/**
	 * Constructor.
	 * 
	 * @param nombre nombre
	 * @param color color
	 */
	public Jugador(String nombre, Color color)
	{
		this.nombre = nombre;
		this.color = color;
	}
	
	/**
	 * Consultamos color.
	 * 
	 * @return color color
	 */
	public Color consultarColor()
	{
		return color;
	}
	
	/**
	 * Consultamos nombre.
	 * 
	 * @return nombre nombre
	 */
	public String consultarNombre()
	{
		return nombre;
	}
	
	/**
	 * Generamos pieza.
	 * 
	 * @return Pieza Pieza
	 */
	public Pieza generarPieza()
	{
		return new Pieza(color);
	}
	
	@Override
	public String toString()
	{
		return "Jugador [nombre=" + nombre + ", color=" + color + "]";
	}
}