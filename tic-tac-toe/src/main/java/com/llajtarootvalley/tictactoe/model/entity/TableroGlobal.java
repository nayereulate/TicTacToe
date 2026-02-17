package com.llajtarootvalley.tictactoe.model.entity;

public class TableroGlobal {
	private TableroLocal[][] tablerosLocales;

    private int siguienteFilaTablero = -1;
    private int siguienteColTablero = -1;

    public TableroGlobal() {
        tablerosLocales = new TableroLocal[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablerosLocales[i][j] = new TableroLocal();
            }
        }
    }

    public TableroLocal obtenerTableroLocal(int fila, int col) {
        return tablerosLocales[fila][col];
    }
    
    public void actualizarProximoTableroObligatorio(int filaJugadaEnLocal, int colJugadaEnLocal) {
        TableroLocal proximoTablero = tablerosLocales[filaJugadaEnLocal][colJugadaEnLocal];
        
        if (!proximoTablero.estaJugable()) {
            this.siguienteFilaTablero = -1;
            this.siguienteColTablero = -1;
        } else {
            this.siguienteFilaTablero = filaJugadaEnLocal;
            this.siguienteColTablero = colJugadaEnLocal;
        }
    }
    
}
