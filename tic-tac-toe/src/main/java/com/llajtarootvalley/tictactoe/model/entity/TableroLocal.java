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

}
