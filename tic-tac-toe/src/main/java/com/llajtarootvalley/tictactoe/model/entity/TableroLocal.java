package com.llajtarootvalley.tictactoe.model.entity;

import com.llajtarootvalley.tictactoe.model.*;

public class TableroLocal {
	private Jugador[][] casillas;
    private EstadoJuego estadoActual;
    private int fichasColocadas;

    public TableroLocal() {
        this.casillas = new Jugador[3][3];
        this.estadoActual = EstadoJuego.EN_PROGRESO;
        this.fichasColocadas = 0;
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casillas[i][j] = Jugador.VACIO;
            }
        }
    }
    
    public boolean marcarCasilla(int fila, int col, Jugador jugador) {
        if (this.estadoActual == EstadoJuego.EN_PROGRESO && casillas[fila][col] == Jugador.VACIO) {
            casillas[fila][col] = jugador;
            fichasColocadas++;
            actualizarEstado(fila, col, jugador);
            return true;
        }
        return false;
    }
    
    private void actualizarEstado(int r, int c, Jugador player) {
        if (verificarVictoria(r, c, player)) {
            this.estadoActual = (player == Jugador.X) ? EstadoJuego.X_GANA : EstadoJuego.O_GANA;
        } else if (fichasColocadas == 9) {
            this.estadoActual = EstadoJuego.EMPATE;
        }
    }

    private boolean verificarVictoria(int r, int c, Jugador player) {
        if (casillas[r][0] == player && casillas[r][1] == player && casillas[r][2] == player) return true;
        if (casillas[0][c] == player && casillas[1][c] == player && casillas[2][c] == player) return true;
        
        if (r == c && casillas[0][0] == player && casillas[1][1] == player && casillas[2][2] == player) return true;
        if (r + c == 2 && casillas[0][2] == player && casillas[1][1] == player && casillas[2][0] == player) return true;
        return false;
    }

}
