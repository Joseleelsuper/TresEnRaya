package juego.control;
import juego.modelo.*;
import juego.util.Coordenada;
import juego.util.Direccion;

/**
 * Clase Arbitro, donde ocure el control del juego.
 * 
 * @author <a href="mailto:jtroyt00@estudiantes.unileon.es">Javier Troyano Torrado</a>
 * @version 1.0
 * @serial 2024/02/12
 */
public class ArbitroTresEnRaya {
    /**
     * Jugador ganador.
     */
    public Jugador ganador;
    /**
     * Tablero.
     */
    public Tablero tablero;
    /**
     * Jugadores totales.
     */
    public Jugador[] jugadores = new Jugador[2];
    /**
     * Turno del jugador.
     */
    public Jugador turno;
    /**
     * Si la partida ha acabado.
     */
    public boolean acabada;
    /**
     * Número de filas.
     */
    private static final int NUMERO_FILAS = 3;
    /**
     * Número de columnas.
     */
    private static final int NUMERO_COLUMNAS = 3;

    /**
     * Constructor.
     */
    public ArbitroTresEnRaya(){
        this.ganador = null;
        this.tablero = new Tablero(NUMERO_FILAS, NUMERO_COLUMNAS);
        this.turno = null;
        this.acabada = false;
    }

    /**
     * Obtiene el ganador.
     * 
     * @return Jugador ganador.
     */
    public Jugador obtenerGanador(){
        return this.ganador;
    }

    /**
     * Obtiene el tablero.
     * 
     * @return Tablero.
     */
    public Tablero obtenerTablero(){
        return this.tablero;
    }

    /**
     * Obtiene el turno.
     * 
     * @return Jugador.
     */
    public Jugador obtenerTurno(){
        return this.turno;
    }
    
    /**
     * Consulta si la partida ha acabado.
     * 
     * @return Si la partida ha acabado.
     */
    public boolean estaAcabado(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j< 3; j++){
                Coordenada coordenada = new Coordenada(i, j);
                if((tablero.contarPiezasConsecutivas(coordenada, Direccion.VERTICAL) == NUMERO_FILAS)||
                (tablero.contarPiezasConsecutivas(coordenada, Direccion.HORIZONTAL) == NUMERO_COLUMNAS)||
                (tablero.contarPiezasConsecutivas(coordenada, Direccion.DIAGONAL_NO_SE) == NUMERO_FILAS)||
                (tablero.contarPiezasConsecutivas(coordenada, Direccion.DIAGONAL_SO_NE) == NUMERO_COLUMNAS)){
                    this.acabada = true;
                    this.ganador = turno;
                    return true;
                }
            }
        }   
        if(tablero.consultarNumeroPiezas(Color.BLANCO) + tablero.consultarNumeroPiezas(Color.NEGRO) == NUMERO_FILAS*NUMERO_COLUMNAS){
            this.acabada = true;
            this.ganador = null;
            return true;
        }
        this.acabada = false;
        return false;
    }

    /**
     * Cambia el turno de partida.
     */
    public void fijarTurno(){
        if(turno == jugadores[1]){
            turno = jugadores[0];
        }else{
            turno = jugadores[1];
        }
    }

    /**
     * Registra a los jugadores antes de empezar la partida.
     * 
     * @param jugador Jugadores a registrar
     */
    public void registrarJugador(String jugador){
        if(jugadores[0] == null){
            jugadores[0] = new Jugador(jugador, Color.BLANCO);
        }else if(jugadores[1] == null){
            jugadores[1] = new Jugador(jugador, Color.NEGRO);
            this.turno = jugadores[0];
        }else{
            System.err.println("No puede haber mas de dos jugadores");
        }
    }

    /**
     * Comprueba si los movimientos son legales.
     * 
     * @param coordenada Coordenada.
     * @return true si es legal.
     */
    public boolean esMovimientoLegal(Coordenada coordenada){
        if(coordenada.fila() > NUMERO_FILAS-1 || coordenada.fila() < 0 || coordenada.columna() > NUMERO_COLUMNAS-1 || coordenada.columna() < 0){
            return false;
        }
        if(tablero.obtenerCelda(coordenada).estaVacia() && !estaAcabado()){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Comenzamos a jugar colocando las piezas en el tablero.
     * 
     * @param coordenada Coordenada en donde se colocan.
     */
    public void jugar(Coordenada coordenada){
        if(esMovimientoLegal(coordenada)){
            tablero.colocar(new Pieza(turno.consultarColor()), coordenada);
            if(!estaAcabado())
            {
                fijarTurno();
            }
        }
    }
}
