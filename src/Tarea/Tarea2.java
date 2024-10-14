/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea;

import static Tarea.Tarea1_2.contarCasillas;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author megus
 */

//EL PROBLEMA DEL LABERINTO CON SALTO DE CABALLO.

//1. Dado una matriz de n x m, inicialmente todas las posiciones
//con valores de cero, avanzar las casillas en sentido HORARIO,
//con movimientos de izquierda, arriba, derecha y abajo. Avanzar 
//desde una posición inicial a una posición final con el movimiento del caballo.
//Existen 8 posibilidades de movimiento en forma de L. Implementar los siguientes:

public class Tarea2 {
    
//    a)     Algoritmo para mostrar todos los caminos posibles desde
//            una posición inicial a una posición final. 
//            Además, mostrar la cantidad de soluciones posibles
//         (Cantidad de caminos posibles de la posición inicial a la posición final).    
    
    // Movimientos posibles del caballo en forma de L
    private static final int[] MOV_X = {-2, -1, 1, 2,  2,  1, -1, -2};
    private static final int[] MOV_Y = { 1,  2, 2, 1, -1, -2, -2, -1};
    
        // Variable para almacenar la máxima longitud de un camino
    public static int maxLongitud = 0;
    
    // Método para verificar si una posición es válida
    public static boolean posValida(int m[][], int i, int j) {
        return i >= 0 && i < m.length && j >= 0 && j < m[i].length && m[i][j] == 0;
    }

    // Método para mostrar el laberinto
    public static void mostrar(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Algoritmo para encontrar todos los caminos posibles usando movimientos de caballo
    public static int laberintoA(int m[][], int i, int j, int iFin, int jFin, int paso) {
        if (!posValida(m, i, j)) return 0; // Si la posición no es válida, se retorna 0
        if (i == iFin && j == jFin) { // Si alcanzamos la meta
            m[i][j] = paso; // Marcamos el último paso
            mostrar(m); // Mostramos el camino
            m[i][j] = 0; // Desmarcamos para buscar otros caminos
            return 1; // Retornamos que encontramos una solución
        }

        m[i][j] = paso; // Marcamos el paso actual
        int soluciones = 0;

        // Probar los 8 posibles movimientos del caballo
        for (int k = 0; k < 8; k++) {
            soluciones += laberintoA(m, i + MOV_X[k], j + MOV_Y[k], iFin, jFin, paso + 1);
        }

        m[i][j] = 0; // Desmarcamos el paso actual para otros caminos
        return soluciones; // Retornamos la cantidad de soluciones encontradas
    }
    
    // Algoritmo para encontrar todos los caminos posibles recorriendo todas las casillas    
    public static int laberintoB(int m[][], int i, int j, int iFin, int jFin, int paso, int totalPasos) {
        if (!posValida(m, i, j)) return 0; // Si la posición no es válida, se retorna 0
        if (paso == totalPasos && i == iFin && j == jFin) { // Si alcanzamos el último paso en la posición final
            m[i][j] = paso; // Marcamos el último paso
            mostrar(m); // Mostramos el camino
            m[i][j] = 0; // Desmarcamos para buscar otros caminos
            return 1; // Retornamos que encontramos una solución
        }

        m[i][j] = paso; // Marcamos el paso actual
        int soluciones = 0;

        // Probar los 8 posibles movimientos del caballo
        for (int k = 0; k < 8; k++) {
            soluciones += laberintoB(m, i + MOV_X[k], j + MOV_Y[k], iFin, jFin, paso + 1, totalPasos);
        }

        m[i][j] = 0; // Desmarcamos el paso actual para otros caminos
        return soluciones; // Retornamos la cantidad de soluciones encontradas
    }

     // Algoritmo para encontrar todos los caminos posibles usando movimientos de caballo
    public static int laberintoC(int m[][], int i, int j, int iFin, int jFin, int paso) {
        if (!posValida(m, i, j)) return 0; // Si la posición no es válida, se retorna 0
        if (i == iFin && j == jFin) { // Si alcanzamos la meta
            m[i][j] = paso; // Marcamos el último paso
            mostrar(m); // Mostramos el camino
            m[i][j] = 0; // Desmarcamos para buscar otros caminos
            return 1; // Retornamos que encontramos una solución
        }

        m[i][j] = paso; // Marcamos el paso actual
        int soluciones = 0;

        // Probar los 8 posibles movimientos del caballo
        for (int k = 0; k < 8; k++) {
            soluciones += laberintoC(m, i + MOV_X[k], j + MOV_Y[k], iFin, jFin, paso + 1);
        }

        m[i][j] = 0; // Desmarcamos el paso actual para otros caminos
        return soluciones; // Retornamos la cantidad de soluciones encontradas
    }
    
    // Algoritmo para encontrar caminos de máxima longitud
    public static int laberintoD(int m[][], int i, int j, int iFin, int jFin, int paso) {
        if (!posValida(m, i, j)) return 0; // Si la posición no es válida, se retorna 0
        if (i == iFin && j == jFin) { // Si alcanzamos la meta
            if (paso > maxLongitud) { // Si el camino actual es más largo que el máximo conocido
                maxLongitud = paso; // Actualizamos la máxima longitud
            }
            m[i][j] = paso; // Marcamos el último paso
            mostrar(m); // Mostramos el camino
            m[i][j] = 0; // Desmarcamos para buscar otros caminos
            return 1; // Retornamos que encontramos una solución
        }

        m[i][j] = paso; // Marcamos el paso actual
        int soluciones = 0;

        // Probar los 8 posibles movimientos del caballo
        for (int k = 0; k < 8; k++) {
            soluciones += laberintoD(m, i + MOV_X[k], j + MOV_Y[k], iFin, jFin, paso + 1);
        }

        m[i][j] = 0; // Desmarcamos el paso actual para otros caminos
        return soluciones; // Retornamos la cantidad de soluciones encontradas
    }
    
     public static int contarCaminosDeMaximaLongitud(int m[][], int i, int j, int iFin, int jFin, int paso) {
        if (!posValida(m, i, j)) return 0; // Si la posición no es válida, se retorna 0
        if (i == iFin && j == jFin && paso == maxLongitud) { // Si alcanzamos la meta y el camino es de máxima longitud
            return 1; // Contamos este camino como una solución
        }

        m[i][j] = paso; // Marcamos el paso actual
        int soluciones = 0;

        // Probar los 8 posibles movimientos del caballo
        for (int k = 0; k < 8; k++) {
            soluciones += contarCaminosDeMaximaLongitud(m, i + MOV_X[k], j + MOV_Y[k], iFin, jFin, paso + 1);
        }

        m[i][j] = 0; // Desmarcamos el paso actual para otros caminos
        return soluciones; // Retornamos la cantidad de soluciones encontradas
    }

    // Clase interna para representar un movimiento con su número de pasos
    static class Movimiento {
        int x, y, pasos;

        Movimiento(int x, int y, int pasos) {
            this.x = x;
            this.y = y;
            this.pasos = pasos;
        }
    }

    // Método BFS para encontrar la longitud mínima de un camino
    public static int laberintoE(int[][] m, int iInicial, int jInicial, int iFinal, int jFinal) {
        Queue<Movimiento> queue = new LinkedList<>();
        queue.add(new Movimiento(iInicial, jInicial, 0));
        
        boolean[][] visitado = new boolean[m.length][m[0].length];
        visitado[iInicial][jInicial] = true;

        int minLongitud = Integer.MAX_VALUE;

        // Búsqueda en anchura
        while (!queue.isEmpty()) {
            Movimiento actual = queue.poll();

            // Si llegamos a la posición final
            if (actual.x == iFinal && actual.y == jFinal) {
                minLongitud = Math.min(minLongitud, actual.pasos);
            }

            // Probar los 8 posibles movimientos del caballo
            for (int k = 0; k < 8; k++) {
                int nuevoX = actual.x + MOV_X[k];
                int nuevoY = actual.y + MOV_Y[k];

                if (posValida(m, nuevoX, nuevoY) && !visitado[nuevoX][nuevoY]) {
                    visitado[nuevoX][nuevoY] = true;
                    queue.add(new Movimiento(nuevoX, nuevoY, actual.pasos + 1));
                }
            }
        }
        return minLongitud;
    }

    // Método BFS para contar todas las soluciones posibles de mínima longitud
    public static int contarCaminosMinimos(int[][] m, int iInicial, int jInicial, int iFinal, int jFinal, int minLongitud) {
        Queue<Movimiento> queue = new LinkedList<>();
        queue.add(new Movimiento(iInicial, jInicial, 0));

        int soluciones = 0;

        // Búsqueda en anchura para contar todas las soluciones de mínima longitud
        while (!queue.isEmpty()) {
            Movimiento actual = queue.poll();

            // Si llegamos a la posición final y hemos recorrido exactamente la mínima longitud
            if (actual.x == iFinal && actual.y == jFinal && actual.pasos == minLongitud) {
                soluciones++;
            }

            // Probar los 8 posibles movimientos del caballo
            for (int k = 0; k < 8; k++) {
                int nuevoX = actual.x + MOV_X[k];
                int nuevoY = actual.y + MOV_Y[k];

                if (posValida(m, nuevoX, nuevoY)) {
                    queue.add(new Movimiento(nuevoX, nuevoY, actual.pasos + 1));
                }
            }
        }

        return soluciones;
    }

    
    // Método para copiar una matriz
    public static int[][] copiarMatriz(int[][] m) {
        int[][] copia = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            System.arraycopy(m[i], 0, copia[i], 0, m[i].length);
        }
        return copia;
    }

    // Método para mostrar una lista de matrices (cada una representa un paso del camino)
    public static void mostrarListaDeMatrices(List<int[][]> listaMatrices) {
        for (int paso = 0; paso < listaMatrices.size(); paso++) {
            System.out.println("Paso " + (paso + 1) + ":");
            int[][] matriz = listaMatrices.get(paso);
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Algoritmo para encontrar todos los caminos posibles usando movimientos de caballo, almacenando las matrices en una lista
    public static int laberintoConListaMatrices(int m[][], int i, int j, int iFin, int jFin, int paso, List<int[][]> listaMatrices) {
        if (!posValida(m, i, j)) return 0; // Si la posición no es válida, se retorna 0
        if (i == iFin && j == jFin) { // Si alcanzamos la meta
            m[i][j] = paso; // Marcamos el último paso
            listaMatrices.add(copiarMatriz(m)); // Guardamos la matriz actual en la lista
            mostrarListaDeMatrices(listaMatrices); // Mostramos el camino
            m[i][j] = 0; // Desmarcamos para buscar otros caminos
            listaMatrices.remove(listaMatrices.size() - 1); // Removemos la última matriz al regresar
            return 1; // Retornamos que encontramos una solución
        }

        m[i][j] = paso; // Marcamos el paso actual
        listaMatrices.add(copiarMatriz(m)); // Guardamos la matriz actual en la lista

        int soluciones = 0;
        // Probar los 8 posibles movimientos del caballo
        for (int k = 0; k < 8; k++) {
            soluciones += laberintoConListaMatrices(m, i + MOV_X[k], j + MOV_Y[k], iFin, jFin, paso + 1, listaMatrices);
        }

        m[i][j] = 0; // Desmarcamos el paso actual para otros caminos
        listaMatrices.remove(listaMatrices.size() - 1); // Removemos la última matriz al regresar
        return soluciones; // Retornamos la cantidad de soluciones encontradas
    }
    
    public static void caballo(int m[][], int i, int j,
            int iFin, int jFin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == iFin && j == jFin) {
            mostrar(m);
        }
        caballo(m, i-2, j + 1, iFin, jFin, paso + 1);  
        caballo(m, i-2, j - 1, iFin, jFin, paso + 1);
        
        caballo(m, i-1, j + 2, iFin, jFin, paso + 1);
        caballo(m, i + 1, j+2, iFin, jFin, paso + 1);
        
        caballo(m, i+2, j + 1, iFin, jFin, paso + 1);
        caballo(m, i + 2, j-1, iFin, jFin, paso + 1);
        
        caballo(m, i + 1, j - 2, iFin, jFin, paso + 1);
        caballo(m, i - 1, j - 2, iFin, jFin, paso + 1);  
        
        m[i][j] = 0;
    }
    
    public static boolean todasVisitadas(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    return false; // Si queda alguna casilla sin visitar, no hemos terminado.
                }
            }
        }
        return true;
    }

    public static int contarCasillas(int m[][]) { 
        int totalCasillas = 0; 
        for (int i = 0; i < m.length; i++) { 
            for (int j = 0; j < m[i].length; j++) { 
                if (m[i][j] == 0) { // Solo contamos las casillas que se pueden visitar (sin obstáculos) 
                    totalCasillas++; 
                } 
            } 
        } 
        return totalCasillas; 
    } 
    
    private static int solucionB = 0;
    
    public static void caballoB(int m[][], int i, int j,
            int iFin, int jFin, int paso, int totalVisitadas, int totalCasillas) {
        if (!posValida(m, i, j)) {
            return;
        }        
        m[i][j] = paso;
        totalVisitadas++;
        if (i == iFin && j == jFin) {
            if (totalVisitadas == totalCasillas) { 
                mostrar(m);
                solucionB++;
            }
        }
        caballoB(m, i-2, j + 1, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);  
        caballoB(m, i-2, j - 1, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        
        caballoB(m, i-1, j + 2, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        caballoB(m, i + 1, j+2, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        
        caballoB(m, i+2, j + 1, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        caballoB(m, i + 2, j-1, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        
        caballoB(m, i + 1, j - 2, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        caballoB(m, i - 1, j - 2, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);  
        
        m[i][j] = 0;
        totalVisitadas--;
    }
    
    private static int solucionC = 0;
    
    public static void caballoC(int m[][], int i, int j,
            int iFin, int jFin, int paso, int totalVisitadas, int totalCasillas) {
        if (!posValida(m, i, j)) {
            return;
        }        
        m[i][j] = paso;
        totalVisitadas++;
        if (i == iFin && j == jFin) {
            if (totalVisitadas < totalCasillas) { 
                mostrar(m);
                solucionC++;
            }
        }
        caballoC(m, i-2, j + 1, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);  
        caballoC(m, i-2, j - 1, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        
        caballoC(m, i-1, j + 2, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        caballoC(m, i + 1, j+2, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        
        caballoC(m, i+2, j + 1, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        caballoC(m, i + 2, j-1, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        
        caballoC(m, i + 1, j - 2, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);
        caballoC(m, i - 1, j - 2, iFin, jFin, paso + 1, totalVisitadas, totalCasillas);  
        
        m[i][j] = 0;        
    }
    
    public static void main(String[] args) {
        int n =5, m = 5; // Tamaño del laberinto (5x5)
        int[][] laberinto = new int[n][m];
        int a[][] = {  
            {0, 0, 0, 0, 0},  
            {0, 0, 0, 0, 0},  
            {0, 0, -1, 0, 0},  
            {0, 0, 0, 0, 0},  
            {0, 0, 0, 0, 0}, 
        }; 
        int iInicial = 0, jInicial = 0; // Posición inicial
        int iFinal = 4, jFinal = 4; // Posición final
        int totalCasillas = contarCasillas(a); 
//-------------------------------------------------------------------------------------
//        caballo(laberinto, iInicial, jInicial, iFinal, jFinal, 1);
//-------------------------------------------------------------------------------------
//        caballoB(a, iInicial, jInicial, iFinal, jFinal, 1, 0, totalCasillas);
//        System.out.println("Cantidad: "+solucionB);
//-------------------------------------------------------------------------------------
//        caballoC(a, iInicial, jInicial, iFinal, jFinal, 1, 0, totalCasillas);
//        System.out.println("Cantidad: "+solucionC);
//-------------------------------------------------------------------------------------
//        System.out.println("Todos los caminos posibles:");
//        int soluciones = laberintoA(laberinto, iInicial, jInicial, iFinal, jFinal, 1);
//        System.out.println("Cantidad de soluciones posibles: " + soluciones);
        //-------------------------------------------------------------------------------------
//        Para un tablero de tamaño 5x5, el código muestra todos los caminos
//        posibles desde la posición inicial (0, 0) hasta la posición
//        final (4, 4), asegurando que todas las casillas sean visitadas
//        exactamente una vez. También cuenta cuántas soluciones de este tipo existen.
//        System.out.println("Todos los caminos posibles que visitan todas las casillas:");
//        int totalPasos = n * m; // El número total de pasos necesarios para visitar todas las casillas
//        int solucionesB = laberintoB(laberinto, iInicial, jInicial, iFinal, jFinal, 1, totalPasos);
//        System.out.println("Cantidad de soluciones posibles: " + solucionesB);
        //-------------------------------------------------------------------------------------
//        System.out.println("Todos los caminos posibles sin necesidad de visitar todas las casillas:");
//        int solucionesC = laberintoC(laberinto, iInicial, jInicial, iFinal, jFinal, 1);
//        System.out.println("Cantidad de soluciones posibles: " + solucionesC);
        //-------------------------------------------------------------------------------------
//        System.out.println("Buscando caminos de máxima longitud...");
//        // Paso 1: Encontramos la máxima longitud posible
//        laberintoD(laberinto, iInicial, jInicial, iFinal, jFinal, 1);
//        System.out.println("Máxima longitud encontrada: " + maxLongitud);
//        // Paso 2: Contamos cuántos caminos de máxima longitud existen
//        int solucionesD = contarCaminosDeMaximaLongitud(laberinto, iInicial, jInicial, iFinal, jFinal, 1);
//        System.out.println("Cantidad de soluciones de máxima longitud: " + solucionesD);
        //-------------------------------------------------------------------------------------
        // Paso 1: Encontramos la mínima longitud posible con BFS
//        System.out.println("Buscando la longitud mínima...");
//        int minLongitud = laberintoE(laberinto, iInicial, jInicial, iFinal, jFinal);
//        System.out.println("Longitud mínima encontrada: " + minLongitud);
//
//        // Paso 2: Contamos cuántos caminos de mínima longitud existen
//        System.out.println("Contando los caminos de mínima longitud...");
//        int solucionesE = contarCaminosMinimos(laberinto, iInicial, jInicial, iFinal, jFinal, minLongitud);
//
//        System.out.println("Cantidad de soluciones de mínima longitud: " + solucionesE);
        //-------------------------------------------------------------------------------------
//        int[][] laberinto2 = {
//            { 0,  0,  0, -1,  0},
//            { 0, -1,  0,  0,  0},
//            { 0,  0, -1,  0,  0},
//            { 0,  0,  0, -1,  0},
//            { 0,  0,  0,  0,  0}
//        };
//        
//        System.out.println("Todos los caminos posibles:");
//        int solucionesA = laberintoA(laberinto2, iInicial, jInicial, iFinal, jFinal, 1);
//        System.out.println("Cantidad de soluciones posibles: " + solucionesA);
        //-------------------------------------------------------------------------------------
//         List<int[][]> listaMatrices = new ArrayList<>(); // Lista para almacenar las matrices
//
//        System.out.println("Todos los caminos posibles utilizando lista de matrices:");
//        int soluciones3 = laberintoConListaMatrices(laberinto, iInicial, jInicial, iFinal, jFinal, 1, listaMatrices);
//        System.out.println("Cantidad de soluciones posibles: " + soluciones3);
        //-------------------------------------------------------------------------------------
        
    }
    

    
}
