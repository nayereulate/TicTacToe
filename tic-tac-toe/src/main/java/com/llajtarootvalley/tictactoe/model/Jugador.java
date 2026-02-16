package com.llajtarootvalley.tictactoe.model;

public enum Jugador {
	X("X"),
    O("O"),
    VACIO("-");

    private final String simbolo;

    private Jugador(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
    
    @Override
    public String toString() {
        return simbolo;
    }
}
