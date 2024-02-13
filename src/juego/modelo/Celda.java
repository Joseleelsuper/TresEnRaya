package juego.modelo;

import juego.util.Coordenada;

/**
 * Clase celda, utilizada para crear el tablero
 * 
 * @author <a href="mailto:jtroyt00@estudiantes.unileon.es">Javier Troyano Torrado</a>
 * @version 1.0
 * @serial 2024/02/12
 */
public class Celda {
    /**
     * Coordenada.
     */
    private Coordenada coordenadas;
    /**
     * Para comprobar si la celda está vacía.
     */
    private boolean vacia;
    /**
     * Variable pieza.
     */
    private Pieza pieza;
    
    /**
     * Constructor.
     * 
     * @param coordenada Coordenada de la celda.
     */
    public Celda(Coordenada coordenada){
        this.coordenadas = coordenada;
        this.pieza = null;
        this.vacia = true;
    }

    /**
     * Comprueba si la celda está vacía.
     * 
     * @param vacia True si está vacía, false si no.
     */
    public void setVacia(boolean vacia){
        this.vacia = vacia;
    }

    /**
     * Establece las coordenadas.
     * 
     * @param coordenada Coordenada de la celda.
     */
    public void setCoordenadas(Coordenada coordenada){
        this.coordenadas = coordenada;
    }

    /**
     * Establece la pieza.
     * 
     * @param pieza Pieza a establecer.
     */
    public void establecerPieza(Pieza pieza){
        this.pieza = pieza;
        this.vacia = pieza == null ? true : false;
    }

    /**
     * Obtiene la pieza.
     * 
     * @return Pieza.
     */
    public Pieza obtenerPieza(){
        return this.pieza;
    }

    /**
     * Obtiene el color de la pieza.
     * 
     * @return Color de la pieza.
     */
    public Color obtenerColor(){
        return this.pieza.obtenerColor();
    }

    /**
     * Comprueba si la celda está vacía.
     * 
     * @return True si está vacía, false si no.
     */
    public boolean estaVacia(){
        return this.vacia;
    }

    /**
     * Consulta las coordenadas.
     * 
     * @return Coordenada.
     */
    public Coordenada consultarCoordenada(){
        return this.coordenadas;
    }

    @Override
    public String toString(){
        return ("Celda [pieza="+this.pieza+", coordenada=Coordenada[fila="+this.coordenadas.fila()+", columna="+this.coordenadas.columna()+"]]");
    }
}
