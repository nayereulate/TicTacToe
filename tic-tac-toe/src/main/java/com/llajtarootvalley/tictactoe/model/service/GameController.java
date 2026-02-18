package com.llajtarootvalley.tictactoe.model.service;

import com.llajtarootvalley.tictactoe.model.entity.*;
import com.llajtarootvalley.tictactoe.model.*;

public class GameController {
	private TableroGlobal tableroGlobal;
    private Jugador jugadorActual;
    private EstadoJuego estadoJuego;

    public GameController() {
        reiniciarJuego();
    }

    public void reiniciarJuego() {
        this.tableroGlobal = new TableroGlobal();
        this.jugadorActual = Jugador.X;
        this.estadoJuego = EstadoJuego.EN_PROGRESO;
    }

    public boolean realizarMovimiento(int filaT, int colT, int filaC, int colC) {
        if (estadoJuego != EstadoJuego.EN_PROGRESO) return false;

        if (!esMovimientoValidoEnGlobal(filaT, colT)) return false;

        TableroLocal subTablero = tableroGlobal.obtenerTableroLocal(filaT, colT);

        boolean exito = subTablero.marcarCasilla(filaC, colC, jugadorActual);
        
        if (exito) {
            actualizarEstadoJuego();
            
            tableroGlobal.actualizarProximoTableroObligatorio(filaC, colC);
            
            if (estadoJuego == EstadoJuego.EN_PROGRESO) {
                jugadorActual = (jugadorActual == Jugador.X) ? Jugador.O : Jugador.X;
            }
            return true;
        }
        return false;
    }

    private boolean esMovimientoValidoEnGlobal(int filaT, int colT) {
        if (tableroGlobal.esMovimientoLibre()) {
            return tableroGlobal.obtenerTableroLocal(filaT, colT).estaJugable();
        }
        return filaT == tableroGlobal.getSiguienteFilaTablero() && 
               colT == tableroGlobal.getSiguienteColTablero();
    }

    private void actualizarEstadoJuego() {
        if (verificarVictoriaGlobal()) {
            this.estadoJuego = (jugadorActual == Jugador.X) ? EstadoJuego.X_GANA : EstadoJuego.O_GANA;
        } else if (verificarEmpateGlobal()) {
            this.estadoJuego = EstadoJuego.EMPATE;
        }
    }
    
    private boolean verificarVictoriaGlobal() {
    	return false;
    }
    
    private boolean verificarEmpateGlobal() {
    	return false;
    }
}
