
package Tarea;

import java.util.LinkedList;

public class Torre {

    public static boolean posValida(int m[][], int i, int j) {
        return i >= 0 && i < m.length && j >= 0
                && j < m[i].length && m[i][j] == 0;
    }

    public static class Regla {

        public int fil;
        public int col;

        public Regla(int fil, int col) {
            this.fil = fil;
            this.col = col;
        }
    }

    public static Regla elegirRegla(LinkedList<Regla> L1) {
        return L1.removeFirst();
    }

    public static LinkedList reglasAplicables(int m[][], int i, int j) {
        LinkedList L1 = new LinkedList<>();
        int k = j - 1;
        while (posValida(m, i, k)) {
            L1.add(new Regla(i, k));
            k = k - 1;
        }
        k = i - 1;
        while (posValida(m, k, j)) {
            L1.add(new Regla(k, j));
            k = k - 1;
        }
        k = j + 1;
        while (posValida(m, i, k)) {
            L1.add(new Regla(i, k));
            k = k + 1;
        }

        k = i + 1;
        while (posValida(m, k, j)) {
            L1.add(new Regla(k, j));
            k = k + 1;
        }
        return L1;

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

    static int solucionesA = 0;

    public static void torre(int m[][], int i, int j,
            int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            mostrar(m);
            solucionesA++;
        }
        LinkedList<Regla> L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            torre(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }
    
    
//    public static void TorreNoTodasCasillas(int m[][], int i, int j,
//            int ifin, int jfin, int paso, int totalvisitadas, int totalcasillas) {
//        if (!posValida(m, i, j)) {
//            return;
//        }
//        m[i][j] = paso;
//        totalvisitadas++;
//
//        if (i == ifin && j == jfin) {
//            if (totalvisitadas < totalcasillas) {
//                mostrar(m);
//                soluciones++;
//            }
//        }
//        LinkedList L1 = reglasAplicables2(m, i, j);
//        while (!L1.isEmpty()) {
//            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina
//            TorreNoTodasCasillas(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, totalcasillas);
//            m[R.fil][R.col] = 0;
//        }
//        totalvisitadas--;
//    }


    
//    b)     Algoritmo para mostrar todos los caminos posibles desde una posición 
//            inicial a una posición final tal que se visiten todas las casillas de la matriz.
//            Además, mostrar la cantidad de soluciones posibles.
    
    
//c)      Algoritmo para mostrar todos los caminos posibles desde una posición 
//        inicial a una posición final tal que NO se visiten todas las casillas de la matriz. 
//                Además, mostrar la cantidad de soluciones posibles.
//
//d)      Algoritmo para mostrar todos los caminos posibles de longitud mínima
//         (camino óptimo) desde una posición inicial a una posición final.. 
//                 Además, mostrar la cantidad de soluciones posibles.
//
//
//2. Implementar el Ejercicio 1, todos los incisos, colocando
//        a la matriz Atajos (valor -1). Verificar las salidas,
//                tal que satisface  el enunciado.
//
//3. Utilizar una Lista de Matrices, para dar solución a cualquiera de los ejercicios anteriores.
    
    public static void main(String[] args) {
        int a = 3;
        int b = 3;
        int iFin = 2;
        int jFin = 2;
        int ini = 2;
        int fin = 2;
        int[][] m = new int[a][b];
        int laberinto[][] = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
        };
        
        torre(m, 0, 0, 2, 2, 1);
        System.out.println("Soluciones "+solucionesA);
        

    }

}
