/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea;





import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class Rey {

    public static int soluciones;
    public static LinkedList<int[][]> listaSoluciones = new LinkedList<>(); //Para almacenar Soluciones 

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

    public static class Regla {

        public int fil;
        public int col;

        public Regla(int fil, int col) {
            this.fil = fil;
            this.col = col;
        }
    }

    //a) Algoritmo para mostrar todos los caminos posibles desde una posición inicial a una posición final. 
    //Además, mostrar la cantidad de soluciones posibles.
    public static void ReyA(int m[][], int i, int j,
            int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            mostrar(m);
            soluciones++;
        }
        LinkedList<Regla> L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            ReyA(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    //b)   Algoritmo para mostrar todos los caminos posibles desde una posición inicial a una posición final tal 
    //       que se visiten todas las casillas de la matriz. Además, mostrar la cantidad de soluciones posibles.
    public static void ReyB(int m[][], int i, int j,
            int ifin, int jfin, int paso, int totalvisitadas, int totalcasillas) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        totalvisitadas++;
        if (i == ifin && j == jfin) {
            if (totalvisitadas == totalcasillas) {
                mostrar(m);
                soluciones++;
            }

        }
        LinkedList<Regla> L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            ReyB(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, totalcasillas);
            m[R.fil][R.col] = 0;
        }
        totalvisitadas--;
    }
    
    // C) Algoritmo para mostrar todos los caminos posibles desde una posición inicial a una posición final tal que NO
       //     se visiten todas las casillas de la matriz. Además, mostrar la cantidad de soluciones posibles.
    
     public static void ReyC(int m[][], int i, int j,
            int ifin, int jfin, int paso, int totalvisitadas, int totalcasillas) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        totalvisitadas++;
        if (i == ifin && j == jfin) {
            if (totalvisitadas < totalcasillas) {
                mostrar(m);
                soluciones++;
            }

        }
        LinkedList<Regla> L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            ReyC(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, totalcasillas);
            m[R.fil][R.col] = 0;
        }
        totalvisitadas--;
    }
     
     //d)     Algoritmo para mostrar todos los caminos posibles de máxima longitud desde una posición inicial a una posición final. 
     //Además, mostrar la cantidad de soluciones posibles.

     public static void ReyD(int m[][], int i, int j,
            int ifin, int jfin, int paso, int totalvisitadas, int maxLongitud) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        totalvisitadas++;
        if (i == ifin && j == jfin) {
            if (totalvisitadas >= maxLongitud) {
                mostrar(m);
                soluciones++;
            }

        }
        LinkedList<Regla> L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            ReyD(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, maxLongitud);
            m[R.fil][R.col] = 0;
        }
        
    }
     
     
     
    //e)     Algoritmo para mostrar todos los caminos posibles de mínima longitud desde una posición inicial a una posición final.
     //Además, mostrar la cantidad de soluciones posibles.
     
     public static void ReyE(int m[][], int i, int j,
            int ifin, int jfin, int paso, int totalvisitadas, int minLongitud) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        totalvisitadas++;
        if (i == ifin && j == jfin) {
            if (totalvisitadas <= minLongitud) {
                mostrar(m);
                soluciones++;
            }

        }
        LinkedList<Regla> L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            ReyE(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, minLongitud);
            m[R.fil][R.col] = 0;
        }
       
    }
     
     //f)     Algoritmo para resolver cualquiera de los incisos anteriores utilizando una Lista de Matrices.
     
     public static void guardarSolucion(int m[][]) { 
        int[][] solucion = new int[m.length][m[0].length]; 
        for (int i = 0; i < m.length; i++) { 
            for (int j = 0; j < m[i].length; j++) { 
                solucion[i][j] = m[i][j]; // Copiar cada valor de la matriz 
            } 
        } 
        listaSoluciones.add(solucion); // Agregar la copia a la lista de soluciones 
    } 
     
      public static void mostrarSoluciones() { 
        for (int k = 0; k < listaSoluciones.size(); k++) { 
            System.out.println("Solución " + (k + 1) + ":"); 
            int[][] solucion = listaSoluciones.get(k); 
            for (int i = 0; i < solucion.length; i++) { 
                for (int j = 0; j < solucion[i].length; j++) { 
                    System.out.print(solucion[i][j] + "\t"); 
                } 
                System.out.println(); 
            } 
            System.out.println(); 
        } 
    } 
      
      public static void ReyF(int m[][], int i, int j,
            int ifin, int jfin, int paso, int totalvisitadas, int totalcasillas) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        totalvisitadas++;
        if (i == ifin && j == jfin) {
            if (totalvisitadas == totalcasillas) {
                guardarSolucion(m);
                soluciones++;
            }

        }
        LinkedList<Regla> L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            ReyF(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, totalcasillas);
            m[R.fil][R.col] = 0;
        }
        totalvisitadas--;
    }
             

    public static LinkedList<Regla> reglasAplicables(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList<>();

        if (posValida(m, i - 1, j)) {
            L1.add(new Regla(i - 1, j)); // izquierda 
        }
        if (posValida(m, i - 1, j - 1)) {
            L1.add(new Regla(i - 1, j - 1)); // arriba 
        }
        if (posValida(m, i, j - 1)) {
            L1.add(new Regla(i, j - 1)); // derecha 
        }
        if (posValida(m, i + 1, j - 1)) {
            L1.add(new Regla(i + 1, j - 1)); // abajo 
        }
        if (posValida(m, i + 1, j)) {
            L1.add(new Regla(i + 1, j)); // abajo 
        }
        if (posValida(m, i + 1, j + 1)) {
            L1.add(new Regla(i + 1, j + 1)); // abajo 
        }
        if (posValida(m, i, j + 1)) {
            L1.add(new Regla(i, j + 1)); // abajo 
        }
        if (posValida(m, i - 1, j + 1)) {
            L1.add(new Regla(i - 1, j + 1)); // abajo 
        }
        return L1;
    }

    public static Regla elegirRegla(LinkedList<Regla> L1) {
        return L1.removeFirst();
    }

    public static int Contarcasillas(int m[][]) {
        int c = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    c++;
                }
            }
        }
        return c;
    }

    
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int iniI = 0;
        int iniJ = 0;
        int iFin = 3;
        int jFin = 3;
        int laberinto[][] = new int[n][m];

        int laberinto2[][] = {
            {0, 0, 0},
            {0, 0, 0},
            {-1, 0, 0},};

        int totalcasillas = Contarcasillas(laberinto2);

         ReyF(laberinto2, 0, 0, 2, 2, 1, 0, totalcasillas); 
        // Mostrar la cantidad de soluciones válidas encontradas 
        System.out.println("Cantidad de soluciones donde NO se visitan todas las casillas: " + 
        soluciones); 
        // Mostrar todas las soluciones almacenadas en la LinkedList 
        mostrarSoluciones(); 

    }

}
