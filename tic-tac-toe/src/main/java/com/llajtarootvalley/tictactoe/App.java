package com.llajtarootvalley.tictactoe;

import com.llajtarootvalley.tictactoe.model.*;
import com.llajtarootvalley.tictactoe.model.entity.*;
import com.llajtarootvalley.tictactoe.model.service.*;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
    	GameController juego = new GameController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("GAME TIC-TAC-TOE");
        System.out.println("Instrucciones: Ingresa coordenadas del 0 al 2.");

        while (juego.getEstadoJuego() == EstadoJuego.EN_PROGRESO) {
            imprimirTableroCompleto(juego);
            
            System.out.println("\nTurno de: " + juego.getJugadorActual());            
            TableroGlobal tg = juego.getTableroGlobal();
            if (tg.esMovimientoLibre()) {
                System.out.println("Modo: ¡MOVIMIENTO LIBRE! Elige cualquier tablero disponible.");
            } else {
                System.out.println("Restricción: Debes jugar en el tablero (" + 
                        tg.getSiguienteFilaTablero() + ", " + tg.getSiguienteColTablero() + ")");
            }

            int fT, cT, fC, cC;
            try {
                if (tg.esMovimientoLibre()) {
                    System.out.print("Tablero Fila (0-2): "); fT = scanner.nextInt();
                    System.out.print("Tablero Col  (0-2): "); cT = scanner.nextInt();
                } else {
                    fT = tg.getSiguienteFilaTablero();
                    cT = tg.getSiguienteColTablero();
                }
                
                System.out.print("Casilla Fila (0-2): "); fC = scanner.nextInt();
                System.out.print("Casilla Col  (0-2): "); cC = scanner.nextInt();

                boolean valido = juego.realizarMovimiento(fT, cT, fC, cC);
                if (!valido) {
                    System.out.println("Movimiento INVÁLIDO, intenta de nuevo.");
                }

            } catch (Exception e) {
                System.out.println("Error: Ingresa solo números enteros.");
                scanner.nextLine();
            }
        }

        imprimirTableroCompleto(juego);
        System.out.println("FIN DEL JUEGO. Resultado: " + juego.getEstadoJuego());
        scanner.close();
    }

    private static void imprimirTableroCompleto(GameController  juego) {
        TableroGlobal global = juego.getTableroGlobal();
        
        System.out.println("\n-------------------------");
        for (int filaGlobal = 0; filaGlobal < 3; filaGlobal++) {
            for (int filaLocal = 0; filaLocal < 3; filaLocal++) {
                System.out.print("| ");
                for (int colGlobal = 0; colGlobal < 3; colGlobal++) {
                    Jugador ganadorLocal = global.obtenerTableroLocal(filaGlobal, colGlobal).getGanador();
                    
                    for (int colLocal = 0; colLocal < 3; colLocal++) {
                        if (ganadorLocal != Jugador.VACIO) {
                            if (filaLocal == 1 && colLocal == 1) System.out.print(ganadorLocal + " ");
                            else System.out.print(". ");
                        } else {
                            System.out.print(global.obtenerTableroLocal(filaGlobal, colGlobal)
                                    .obtenerCasilla(filaLocal, colLocal) + " ");
                        }
                    }
                    System.out.print("| ");
                }
                System.out.println();
            }
            System.out.println("------------------------");
        }
    }
}
