package juego.modelo;

/**
 * Enum que marca el color de ambos jugaodres.
 * 
 * @author <a href="mailto:jtroyt00@estudiantes.unileon.es">Javier Troyano Torrado</a>
 * @version 1.0
 * @serial 2024/02/12
 */
public enum Color {
    /**
     * Color blanco.
     */    
    BLANCO('O'),
    /**
     * Color negro.
     */
    NEGRO('X');

    /**
     * Variable color.
     */
    private char color;

    /**
     * Constructor.
     * 
     * @param color Color.
     */
    Color(char color){
        this.color = color;
    }

    /**
     * Pasamos el color a modo texto
     * 
     * @return carácter
     */ 
    public char toChar(){
        return this.color;
    }
}
