package juego.modelo;

/**
 * Componente Pieza, que representa las fichas del juego.
 * 
 * @author <a href="mailto:jgc1031@alu.ubu.es">José Gallardo Caballero</a>
 * @version 1.0
 * @serial 2024/02/12
 */
public class Pieza
{
    /**
    * Variable Color.
    * Las piezas pueden ser BLANCAS ó NEGRAS.
    */
    private Color color;
     
    /**
    * Constructor
    * 
    * @param color color Color de la pieza.
    */
    public Pieza(Color color)
    {
        this.color = color;
    }
     
    /**
    * Convertimos a texto
    * 
    * @return color Color de la pieza.
    */
    public String aTexto()
    {
        return color.toChar() + "";
    }
     
    /**
    * Obtenemos color de la pieza.
    * 
    * @return color Color de la pieza.
    */
    public Color obtenerColor()
    {
        return color;
    }
 
    @Override
    public String toString()
    {
        return "Pieza [color= " + color + "]";
    }
 }
