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
        for (int i = 0; i < 3; i++) {
            if (checkLine(tableroGlobal.obtenerTableroLocal(i,0).getGanador(), 
                          tableroGlobal.obtenerTableroLocal(i,1).getGanador(), 
                          tableroGlobal.obtenerTableroLocal(i,2).getGanador())) return true;
            if (checkLine(tableroGlobal.obtenerTableroLocal(0,i).getGanador(), 
                          tableroGlobal.obtenerTableroLocal(1,i).getGanador(), 
                          tableroGlobal.obtenerTableroLocal(2,i).getGanador())) return true;
        }
        if (checkLine(tableroGlobal.obtenerTableroLocal(0,0).getGanador(), 
                      tableroGlobal.obtenerTableroLocal(1,1).getGanador(), 
                      tableroGlobal.obtenerTableroLocal(2,2).getGanador())) return true;
        if (checkLine(tableroGlobal.obtenerTableroLocal(0,2).getGanador(), 
                      tableroGlobal.obtenerTableroLocal(1,1).getGanador(), 
                      tableroGlobal.obtenerTableroLocal(2,0).getGanador())) return true;
        return false;
    }

    private boolean checkLine(Jugador a, Jugador b, Jugador c) {
        return a != Jugador.VACIO && a == b && b == c;
    }

    private boolean verificarEmpateGlobal() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableroGlobal.obtenerTableroLocal(i, j).estaJugable()) return false;
            }
        }
        return true;
    }
}
