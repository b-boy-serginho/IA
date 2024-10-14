package Tarea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//MOVIMIENTO DE REY, CABALLO, TORRE, ALFIL, DAMA.
public class Tarea4 {

    public static int solucionA = 0;
    public static int solucionB = 0;
    public static int solucionC = 0;
    public static int solucionD = 0;
    public static int solucionE = 0;
    public static int solucionF = 0;
//   Caminos de Rey, Caballo, Torre, Alfil y la Dama. 
//    Dado una matriz de n x m, inicialmente con valores de ceros (Sin Atajos).
//    Implementar Algoritmos con llamadas recursivas desde un ciclo,
//    para cada uno de los problemas de los movimientos de: Rey, Caballo,Torre, Alfil y Dama.    
    
//Implementar y ejecutar para diferentes valores de n y m. (No necesariamente matriz cuadrada)
    
    
    
    
//a)     Algoritmo para mostrar todos los caminos posibles desde una
//       posición inicial a una posición final. Además,
//       mostrar la cantidad de soluciones posibles.
    public static boolean posValida(int m[][], int i, int j) {
        return i >= 0 && i < m.length && j >= 0
                && j < m[i].length && m[i][j] == 0;
    }

    public static void mostrar(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void alfilA(int m[][], int i, int j,
            int iFin, int jFin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }

        m[i][j] = paso;
        if (i == iFin && j == jFin) {
            mostrar(m);
            solucionA++;
        }

        // Movimiento en las cuatro diagonales
        for (int k = 1; k < m.length; k++) {  // Se mueve hasta el borde del tablero en cada dirección
            alfilA(m, i - k, j - k, iFin, jFin, paso + 1); // Arriba-Izquierda
            alfilA(m, i - k, j + k, iFin, jFin, paso + 1); // Arriba-Derecha
            alfilA(m, i + k, j - k, iFin, jFin, paso + 1); // Abajo-Izquierda
            alfilA(m, i + k, j + k, iFin, jFin, paso + 1); // Abajo-Derecha
        }
        m[i][j] = 0; // Backtracking
    }

//    b)      Algoritmo para mostrar todos los caminos posibles desde
//            una posición inicial a una posición final tal que se
//            visiten todas las casillas de la matriz. 
//            Además, mostrar la cantidad de soluciones posibles.
    // Verifica si todas las casillas han sido visitadas (sin ceros)
    public static boolean todasVisitadas(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    return false; // Hay casillas sin visitar
                }
            }
        }
        return true; // Todas las casillas han sido visitadas
    }

    // Algoritmo principal con backtracking para encontrar todos los caminos
    public static void alfilB(int m[][], int i, int j, int iFin, int jFin, int paso) {
        // Si la posición no es válida, regresamos
        if (!posValida(m, i, j)) {
            return;
        }

        // Marcamos la casilla con el paso actual
        m[i][j] = paso;

        // Si llegamos a la posición final y todas las casillas fueron visitadas
        if (i == iFin && j == jFin && todasVisitadas(m)) {
            mostrar(m); // Mostramos la solución encontrada
            solucionB++; // Contamos la solución
        } else {
            // Exploramos las cuatro diagonales en todas las posibilidades
            for (int k = 1; k < m.length; k++) {
                alfilB(m, i - k, j - k, iFin, jFin, paso + 1); // Arriba-Izquierda
                alfilB(m, i - k, j + k, iFin, jFin, paso + 1); // Arriba-Derecha
                alfilB(m, i + k, j - k, iFin, jFin, paso + 1); // Abajo-Izquierda
                alfilB(m, i + k, j + k, iFin, jFin, paso + 1); // Abajo-Derecha
            }
        }

        // Backtracking: desmarcamos la posición actual para futuras búsquedas
        m[i][j] = 0;
    }

//    c)      Algoritmo para mostrar todos los caminos posibles desde
//            una posición inicial a una posición final tal que NO se
//            visiten todas las casillas de la matriz. Además,
//            mostrar la cantidad de soluciones posibles.
    // Algoritmo con backtracking para encontrar todos los caminos posibles
    public static void alfilC(int[][] m, int i, int j, int iFin, int jFin, int paso) {
        // Si la posición no es válida, regresamos
        if (!posValida(m, i, j)) {
            return;
        }

        // Marcamos la casilla con el paso actual
        m[i][j] = paso;

        // Si llegamos a la posición final, mostramos el camino y contamos la solución
        if (i == iFin && j == jFin) {
            mostrar(m); // Mostrar el camino encontrado
            solucionC++; // Contar la solución
        } else {
            // Explorar las cuatro diagonales en todas sus posibilidades
            for (int k = 1; k < m.length; k++) {
                alfilC(m, i - k, j - k, iFin, jFin, paso + 1); // Arriba-Izquierda
                alfilC(m, i - k, j + k, iFin, jFin, paso + 1); // Arriba-Derecha
                alfilC(m, i + k, j - k, iFin, jFin, paso + 1); // Abajo-Izquierda
                alfilC(m, i + k, j + k, iFin, jFin, paso + 1); // Abajo-Derecha
            }
        }

        // Backtracking: desmarcar la casilla actual para futuras exploraciones
        m[i][j] = 0;
    }

//    d)      Algoritmo para mostrar todos los caminos posibles de máxima 
//            longitud desde una posición inicial a una posición final. 
//            Además, mostrar la cantidad de soluciones posibles.
    static int maxLongitud = 0;

    public static void alfilD(int[][] m, int i, int j, int iFin, int jFin, int paso) {
        // Si la posición no es válida, regresamos
        if (!posValida(m, i, j)) {
            return;
        }

        // Marcamos la casilla con el paso actual
        m[i][j] = paso;

        // Si llegamos a la posición final
        if (i == iFin && j == jFin) {
            if (paso > maxLongitud) {
                // Encontramos un camino más largo, actualizamos la máxima longitud
                maxLongitud = paso;
                solucionD = 1; // Reiniciamos el contador de soluciones
                mostrar(m); // Mostramos el camino de máxima longitud
            } else if (paso == maxLongitud) {
                // Si el camino tiene la máxima longitud conocida, contamos una solución más
                solucionD++;
                mostrar(m);
            }
        } else {
            // Exploramos las cuatro diagonales en todas sus posibilidades
            for (int k = 1; k < m.length; k++) {
                alfilD(m, i - k, j - k, iFin, jFin, paso + 1); // Arriba-Izquierda
                alfilD(m, i - k, j + k, iFin, jFin, paso + 1); // Arriba-Derecha
                alfilD(m, i + k, j - k, iFin, jFin, paso + 1); // Abajo-Izquierda
                alfilD(m, i + k, j + k, iFin, jFin, paso + 1); // Abajo-Derecha
            }
        }

        // Backtracking: Desmarcamos la casilla para futuras exploraciones
        m[i][j] = 0;
    }

//    e)      Algoritmo para mostrar todos los caminos posibles 
//            de mínima longitud desde una posición inicial a una posición final. 
//            Además, mostrar la cantidad de soluciones posibles.
    // Clase auxiliar para representar un estado del tablero
    static class Estado {
        int i, j;  // Coordenadas en el tablero
        List<int[]> camino;  // Camino recorrido hasta el momento

        Estado(int i, int j, List<int[]> camino) {
            this.i = i;
            this.j = j;
            this.camino = new ArrayList<>(camino);
            this.camino.add(new int[]{i, j});
        }
    }

    // Muestra un camino
    public static void mostrarCamino(List<int[]> camino) {
        for (int[] paso : camino) {
            System.out.print("(" + paso[0] + ", " + paso[1] + ") -> ");
        }
        System.out.println("FIN");
    }

    // Algoritmo BFS para encontrar todos los caminos de mínima longitud
    public static void bfsMinimo(int[][] m, int iInicio, int jInicio, int iFin, int jFin) {
        Queue<Estado> cola = new LinkedList<>();
        cola.add(new Estado(iInicio, jInicio, new ArrayList<>()));

        int minLongitud = Integer.MAX_VALUE;
        int cantidadSoluciones = 0;

        while (!cola.isEmpty()) {
            Estado actual = cola.poll();
            int i = actual.i;
            int j = actual.j;
            List<int[]> camino = actual.camino;

            if (i == iFin && j == jFin) {
                if (camino.size() < minLongitud) {
                    minLongitud = camino.size();
                    cantidadSoluciones = 1;
                    mostrarCamino(camino);
                } else if (camino.size() == minLongitud) {
                    cantidadSoluciones++;
                    mostrarCamino(camino);
                }
            }

            for (int k = 1; k < m.length; k++) {
                if (posValida(m, i - k, j - k)) {
                    cola.add(new Estado(i - k, j - k, camino));
                }
                if (posValida(m, i - k, j + k)) {
                    cola.add(new Estado(i - k, j + k, camino));
                }
                if (posValida(m, i + k, j - k)) {
                    cola.add(new Estado(i + k, j - k, camino));
                }
                if (posValida(m, i + k, j + k)) {
                    cola.add(new Estado(i + k, j + k, camino));
                }
            }
        }

        System.out.println("Cantidad de soluciones de mínima longitud: " + cantidadSoluciones);
    }

//    2.      Ejecutar también los algoritmos para todos los incisos, 
//            incluyendo Atajos en la matriz (valor = -1).
//    todo lo anterior
    
//    3. Proponer un nuevo problema creativo e interesante, 
//       aplicando las ideas de los problemas anteriores. Citar fuente.
    
    
    
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int iniI = 0;
        int iniJ = 0;
        int iFin = 3;
        int jFin = 3;
        int alfil[][] = new int[n][m];

//        alfilA(alfil, 0, 0, iFin, jFin, 1);
//        System.out.println("Cantidad de soluciones: " + solucionA);
//        int a[][] = new int[3][3]; 
//        alfilB(a, 0, 0, 2, 2, 1);
//        System.out.println("Cantidad de soluciones: " + solucionB);
//        alfilC(alfil, iniI, iniJ, iFin, jFin, 1);
//        System.out.println("Cantidad de soluciones: " + solucionC);
//        int a[][] = new int[3][3]; 
//        alfilD(a, iniI, iniJ, 2, 2, 1);
//        System.out.println("Cantidad de soluciones: " + solucionD);
        // Iniciar la búsqueda desde (0, 0) hasta (3, 3)
//         int a[][] = new int[3][3]; 
//        bfsMinLongitud(a, 0, 0, 2, 2);        
    }

}
