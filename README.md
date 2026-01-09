<p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/566/566312.png" width="100" alt="Super TicTacToe Logo">
</p>

<h1 align="center">Super Tic-Tac-Toe: Ultimate Strategy</h1>

<p align="center">
  <img src="https://img.shields.io/github/stars/tu-usuario/super-tictactoe?style=for-the-badge&color=ffd700" alt="Stars">
  <img src="https://img.shields.io/github/forks/tu-usuario/super-tictactoe?style=for-the-badge&color=blue" alt="Forks">
  <img src="https://img.shields.io/github/issues/tu-usuario/super-tictactoe?style=for-the-badge&color=red" alt="Issues">
  <img src="https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/JavaFX-21-blue?style=for-the-badge&logo=java&logoColor=white" alt="JavaFX">
</p>

<p align="center">
  <strong>Una reimaginación estratégica del clásico "Gato" con una profundidad táctica sin precedentes.</strong>
  <br />
  <a href="#-demo">Ver Demo</a> 
  · 
  <a href="#-instalación">Instalación</a> 
  · 
  <a href="https://github.com/tu-usuario/super-tictactoe/issues">Reportar Error</a>
</p>

---

## 📖 Tabla de Contenidos
- [Sobre el Proyecto](#-sobre-el-proyecto)
- [Reglas del Juego](#-reglas-del-juego)
- [Capturas de Pantalla](#-capturas-de-pantalla)
- [Arquitectura y Tecnologías](#-arquitectura-y-tecnologías)
- [Instalación](#-instalación)
- [Roadmap](#-roadmap)
- [Contribuciones](#-contribuciones)

---

## 🎮 Sobre el Proyecto

**Super Tic-Tac-Toe** no es el juego que conoces de la infancia. Es un juego de estrategia fractal. Cada celda de un tablero de 3x3 contiene otro tablero completo de 3x3. Tu objetivo es ganar los tableros pequeños para conquistar el tablero grande.

### ¿Por qué este proyecto?
* **Complejidad Algorítmica:** Gestión de 81 celdas interconectadas.
* **UI Dinámica:** Uso de CSS avanzado en JavaFX para retroalimentación en tiempo real.
* **Patrón MVC:** Separación estricta entre la lógica de juego y la vista.

---

## 📜 Reglas del Juego

El juego sigue la mecánica **"Ultimate"**:
1.  **Destino Forzado:** Si el Jugador 1 mueve en la esquina superior derecha de un cuadro pequeño, el Jugador 2 *debe* realizar su siguiente movimiento en el cuadro grande de la esquina superior derecha.
2.  **Victoria Macro:** Ganas el juego cuando logras alinear 3 cuadros pequeños ganados.
3.  **Movimiento Libre:** Si te envían a un cuadro que ya está lleno o ganado, puedes elegir cualquier celda vacía en **cualquier** tablero del mapa.

---

## 🖼️ Capturas de Pantalla

| Menú Principal | Gameplay Activo | Pantalla de Victoria |
| :---: | :---: | :---: |
| <img src="https://via.placeholder.com/300x200?text=Menu+Preview" width="250"> | <img src="https://via.placeholder.com/300x200?text=Board+Preview" width="250"> | <img src="https://via.placeholder.com/300x200?text=Victory+Preview" width="250"> |

---

## 🛠️ Arquitectura y Tecnologías

El proyecto está construido bajo los más altos estándares de desarrollo en Java:

* **[Java 17+](https://www.oracle.com/java/):** Core del lenguaje y programación orientada a objetos.
* **[JavaFX 21](https://openjfx.io/):** Motor de renderizado gráfico y manejo de eventos.
* **[Scene Builder](https://www.oracle.com/java/technologies/javafxscenebuilder-info.html):** Diseño de layouts FXML.
* **[Maven](https://maven.apache.org/):** Gestión de dependencias y ciclo de vida del proyecto.

### Estructura de Clases Principal
```mermaid
graph TD
    A[Main App] --> B[GameController]
    B --> C[MacroBoard Model]
    C --> D[MicroBoard Model]
    D --> E[Cell Status]
    B --> F[View Layout FXML]
