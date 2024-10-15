package Tarea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import Tarea.Regla;
import static Tarea.Regla.reglasAplicablesAlfil;

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
    
    public static int c = 0;
    public static void LaberintoAlfilC(int m[][], int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            mostrar(m);
            c++;
        }
        LinkedList<Regla> L1 = reglasAplicablesAlfil(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = L1.removeFirst();   // Elige la 1ra Regla y elimina
            LaberintoAlfilC(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }
    
    

//    d)      Algoritmo para mostrar todos los caminos posibles de máxima 
//            longitud desde una posición inicial a una posición final. 
//            Además, mostrar la cantidad de soluciones posibles.
    
    static int maxLongitud = 0;

//    public static void alfilD(int[][] m, int i, int j, int iFin, int jFin, int paso) {
//        // Si la posición no es válida, regresamos
//        if (!posValida(m, i, j)) {
//            return;
//        }
//
//        // Marcamos la casilla con el paso actual
//        m[i][j] = paso;
//
//        // Si llegamos a la posición final
//        if (i == iFin && j == jFin) {
//            if (paso > maxLongitud) {
//                // Encontramos un camino más largo, actualizamos la máxima longitud
//                maxLongitud = paso;
//                solucionD = 1; // Reiniciamos el contador de soluciones
//                mostrar(m); // Mostramos el camino de máxima longitud
//            } else if (paso == maxLongitud) {
//                // Si el camino tiene la máxima longitud conocida, contamos una solución más
//                solucionD++;
//                mostrar(m);
//            }
//        } else {
//            // Exploramos las cuatro diagonales en todas sus posibilidades
//            for (int k = 1; k < m.length; k++) {
//                alfilD(m, i - k, j - k, iFin, jFin, paso + 1); // Arriba-Izquierda
//                alfilD(m, i - k, j + k, iFin, jFin, paso + 1); // Arriba-Derecha
//                alfilD(m, i + k, j - k, iFin, jFin, paso + 1); // Abajo-Izquierda
//                alfilD(m, i + k, j + k, iFin, jFin, paso + 1); // Abajo-Derecha
//            }
//        }
//
//        // Backtracking: Desmarcamos la casilla para futuras exploraciones
//        m[i][j] = 0;
//    }
    
    public static int d = 0;
    public static void LaberintoAlfilD(int[][] m, int i, int j, int ifin, int jfin, int paso, 
                                   int totalVisitadas, int max) {
        if (!posValida(m, i, j)) {
            return;  // Si la posición no es válida, terminamos esta rama de recursión.
        }

        // Marcamos la celda con el paso actual
        m[i][j] = paso;
        totalVisitadas++;  // Incrementamos el contador de celdas visitadas

        // Si llegamos a la posición final
        if (i == ifin && j == jfin) {
            if (totalVisitadas > max) {                            
                mostrar(m);  // Mostramos el camino de máxima longitud            
                d++;                
            }
        } else {
            // Generamos los movimientos válidos del alfil desde la posición actual
            LinkedList<Regla> L1 = reglasAplicablesAlfil(m, i, j);
            while (!L1.isEmpty()) {
                Regla R = L1.removeFirst();  // Tomamos la primera regla disponible
                // Llamada recursiva con el siguiente paso
                LaberintoAlfilD(m, R.fil, R.col, ifin, jfin, paso + 1, totalVisitadas, max);
            }
        }

        // Backtracking: Restablecemos la celda actual para futuras exploraciones
        m[i][j] = 0;
        totalVisitadas--;
    }

//    e)      Algoritmo para mostrar todos los caminos posibles 
//            de mínima longitud desde una posición inicial a una posición final. 
//            Además, mostrar la cantidad de soluciones posibles.
    public static int e = 0;

    public static void LaberintoAlfilE(int[][] m, int i, int j, int ifin, int jfin, int paso,
                                       int totalVisitadas, int minLongitud) {
        if (!posValida(m, i, j)) {
            return;  // Si la posición no es válida, terminamos esta rama de recursión.
        }

        m[i][j] = paso;  // Marcamos la celda con el paso actual.
        totalVisitadas++;  // Incrementamos el contador de celdas visitadas.

        if (i == ifin && j == jfin) {
            // Si alcanzamos la posición final y el camino es de la mínima longitud, mostramos el tablero.
            if (totalVisitadas == minLongitud) {
                mostrar(m);  
                e++;  // Incrementamos el contador de soluciones.
            }
        } else {
            // Generamos los movimientos válidos del alfil desde la posición actual.
            LinkedList<Regla> L1 = reglasAplicablesAlfil(m, i, j);

            while (!L1.isEmpty()) {
                Regla R = L1.removeFirst();  // Tomamos la primera regla disponible.
                // Llamada recursiva con el siguiente paso.
                LaberintoAlfilE(m, R.fil, R.col, ifin, jfin, paso + 1, totalVisitadas, minLongitud);
            }
        }

        m[i][j] = 0;  // Restablecemos la celda actual para permitir exploraciones alternativas.
        totalVisitadas--;
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
        
//        int a[][] = new int[5][5]; 
//        alfilB(a, 0, 0, 4, 4, 1);
//        System.out.println("Cantidad de soluciones: " + solucionB);
        
//        alfilC(alfil, iniI, iniJ, iFin, jFin, 1);
//        System.out.println("Cantidad de soluciones: " + solucionC);
        
//        LaberintoAlfilC(alfil, iniI, iniJ, iFin, jFin, 1);
//        System.out.println("Cantidad de soluciones: " + c);

        
        int a[][] = new int[4][4]; 
//        alfilD(a, iniI, iniJ, 3, 3, 1);
//        System.out.println("Cantidad de soluciones: " + solucionD);

        LaberintoAlfilD(a, iniI, iniJ, 3, 3, 1, 0, 5);
        System.out.println("Cantidad de soluciones: " + d);
        
//         LaberintoAlfilE(alfil, iniI, iniJ, iFin, jFin, 1, 0, 1);
//         System.out.println("Cantidad de soluciones: " + d);
              
    }

}
