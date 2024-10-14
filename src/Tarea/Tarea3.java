package Tarea;

//RECORRIDOS SOBRE EL LABERINTO Y CABALLO.

import static Tarea.Tarea2.contarCasillas;
import static Tarea.Tarea2.mostrar;
import java.util.LinkedList;


public class Tarea3 {
//    A. EL PROBLEMA DEL LABERINTO.

//Implementar los siguientes Algoritmos, utilizando
//        la Estructura de Código de "LLamada Recursiva dentro de un Ciclo".
//        Las posiciones a dónde se pueden mover de una posición, traslatar a una Lista de Reglas.
    
//1. Dado una matriz de n x m, inicialmente todas
//        las posiciones con valores de cero, avanzar 
//                las casillas en sentido horario con movimientos de izquierda, arriba, 
//    derecha y abajo. Hacer Algoritmos para los siguientes:
    public static boolean posValida(int m[][], int i, int j){ 
        return i >=0 && i < m.length && j >= 0 &&  
                j < m[i].length && m[i][j] == 0;    
    } 
     
    public static void mostrar(int m[][]){ 
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
 
        public Regla(int fil,int col){ 
            this.fil = fil; 
            this.col = col; 
        } 
    } 
 
    

    public static LinkedList<Regla> reglasAplicables(int m[][], int i, int j){ 
        LinkedList<Regla> L1 = new LinkedList<>(); 
 
        if (posValida(m, i, j - 1)) L1.add(new Regla(i, j - 1)); // izquierda 
        if (posValida(m, i - 1, j)) L1.add(new Regla(i - 1, j)); // arriba 
        if (posValida(m, i, j + 1)) L1.add(new Regla(i, j + 1)); // derecha 
        if (posValida(m, i + 1, j)) L1.add(new Regla(i + 1, j)); // abajo 
     
        return L1; 
    } 
 
    public static Regla elegirRegla(LinkedList<Regla> L1){ 
        return L1.removeFirst(); 
    } 
    
//a)     Algoritmo para mostrar todos los caminos posibles desde
//        una posición inicial a una posición final. 
//        Además, mostrar la cantidad de soluciones 
//                posibles (Cantidad de caminos posibles de la posición inicial a la posición final).
    static int solucionesA = 0; 
    public static void laberintoA( int m[][], int i, int j, 
        int ifin, int jfin, int paso){ 
        if(!posValida(m, i, j)) return; 
        m[i][j] = paso; 
        if(i == ifin && j == jfin){  
            mostrar(m); 
            solucionesA++; 
        } 
        LinkedList<Regla> L1 = reglasAplicables(m, i, j); 
        while(!L1.isEmpty()){ 
            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            laberintoA(m, R.fil, R.col, ifin, jfin, paso + 1); 
            m[R.fil][R.col] = 0; 
        } 
    }   
//b)     Algoritmo para mostrar todos los caminos posibles desde una posición
//        inicial a una posición final tal que se visiten todas las 
//                casillas de la matriz. Además, mostrar la cantidad de soluciones posibles.
    static int solucionesB = 0; 
    public static void laberintoB(int m[][], int i, int j, 
            int ifin, int jfin, int paso, int totalvisitadas, int totalcasillas) { 
        if (!posValida(m, i, j)) { 
            return; 
        } 
        m[i][j] = paso; 
        totalvisitadas++; 
        if (i == ifin && j == jfin) { 
            if (totalvisitadas == totalcasillas) { 
 
                mostrar(m); 
                solucionesB++; 
            } 
        } 
        LinkedList<Regla> L1 = reglasAplicables(m, i, j); 
        while (!L1.isEmpty()) { 
            Regla R = L1.removeFirst(); 
//            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            laberintoB(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, totalcasillas); 
            m[R.fil][R.col] = 0; 
        } 
 
        totalvisitadas--; 
    }
    
//c)      Algoritmo para mostrar todos los caminos posibles desde
//        una posición inicial a una posición final tal que NO se visiten 
//                todas las casillas de la matriz. Además, mostrar la cantidad de soluciones posibles.
    public static LinkedList<Regla> reglasAplicables2(int m[][], int i, int j){ 
        LinkedList<Regla> L1 = new LinkedList<>(); 
 
        if (posValida(m, i, j - 1)) L1.add(new Regla(i, j - 1)); // izquierda 
        if (posValida(m, i - 1, j)) L1.add(new Regla(i - 1, j)); // arriba 
        if (posValida(m, i, j + 1)) L1.add(new Regla(i, j + 1)); // derecha 
        if (posValida(m, i + 1, j)) L1.add(new Regla(i + 1, j)); // abajo 
     
        return L1; 
    } 
     static int solucionesC = 0; 
    public static void laberintoC(int m[][], int i, int j, 
            int ifin, int jfin, int paso, int totalvisitadas, int totalcasillas) { 
        if (!posValida(m, i, j)) { 
            return; 
        } 
        m[i][j] = paso; 
        totalvisitadas++; 
        if (i == ifin && j == jfin) { 
            if (totalvisitadas < totalcasillas) { 
 
                mostrar(m); 
                solucionesC++; 
            } 
        } 
        LinkedList<Regla> L1 = reglasAplicables2(m, i, j); 
        while (!L1.isEmpty()) { 
            Regla R = L1.removeFirst(); 
//            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            laberintoC(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, totalcasillas); 
            m[R.fil][R.col] = 0; 
        } 
 
        totalvisitadas--; 
    } 
    
//d)     Algoritmo para mostrar todos los caminos posibles de 
//        máxima longitud desde una posición inicial a una posición final.
//        Además, mostrar la cantidad de soluciones posibles.
    static int solucionesD = 0;   
    public static void laberintoD(int m[][], int i, int j, 
            int ifin, int jfin, int paso, int totalvisitadas, int maxLongitud) { 
        if (!posValida(m, i, j)) { 
            return; 
        } 
        m[i][j] = paso; 
        totalvisitadas++; 
        if (i == ifin && j == jfin) { 
            if (totalvisitadas <= maxLongitud) {  
                mostrar(m); 
                solucionesD++; 
            } 
        } 
        LinkedList<Regla> L1 = reglasAplicables2(m, i, j); 
        while (!L1.isEmpty()) { 
            Regla R = L1.removeFirst(); 
//            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            laberintoD(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, maxLongitud); 
            m[R.fil][R.col] = 0; 
        }  
        totalvisitadas--; 
    } 
    
    static int solucionesD2 = 0;
       public static void laberintoDTodasLasCasillas(int m[][], int i, int j, 
            int ifin, int jfin, int paso, int totalvisitadas, int totalcasillas) { 
        if (!posValida(m, i, j)) { 
            return; 
        } 
        m[i][j] = paso; 
        totalvisitadas++; 
        if (i == ifin && j == jfin) { 
            if (totalvisitadas == totalcasillas) { 
 
                mostrar(m); 
                solucionesD2++; 
            } 
        } 
        LinkedList<Regla> L1 = reglasAplicables2(m, i, j); 
        while (!L1.isEmpty()) { 
            Regla R = L1.removeFirst(); 
//            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            laberintoDTodasLasCasillas(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, totalcasillas); 
            m[R.fil][R.col] = 0; 
        } 
 
        totalvisitadas--; 
    }
        
    static int soluciones1 = 0;   
     public static void laberintoD1(int m[][], int i, int j, 
            int ifin, int jfin, int paso) { 
        if (!posValida(m, i, j)) { 
            return; 
        } 
        m[i][j] = paso; 
        if (i == ifin && j == jfin) { 
                mostrar(m); 
                soluciones1++; 
        } 
        LinkedList<Regla> L1 = reglasAplicables2(m, i, j); 
        while (!L1.isEmpty()) { 
            Regla R = L1.removeFirst(); 
//            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            laberintoD1(m, R.fil, R.col, ifin, jfin, paso + 1); 
            m[R.fil][R.col] = 0; 
        }
    }
        
//e)     Algoritmo para mostrar todos los caminos posibles de mínima 
//        longitud desde una posición inicial a una posición final. Además, 
//                mostrar la cantidad de soluciones posibles.
    static int solucionesE = 0;   
    public static void laberintoE(int m[][], int i, int j, 
            int ifin, int jfin, int paso, int totalvisitadas, int minLongitud) { 
        if (!posValida(m, i, j)) { 
            return; 
        } 
        m[i][j] = paso; 
        totalvisitadas++; 
        if (i == ifin && j == jfin) { 
            if (totalvisitadas > minLongitud) {  
                mostrar(m); 
                solucionesE++; 
            } 
        } 
        LinkedList<Regla> L1 = reglasAplicables2(m, i, j); 
        while (!L1.isEmpty()) { 
            Regla R = L1.removeFirst(); 
//            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina 
            laberintoE(m, R.fil, R.col, ifin, jfin, paso + 1, totalvisitadas, minLongitud); 
            m[R.fil][R.col] = 0; 
        }  
        totalvisitadas--; 
    } 
    
//2. Ejecutar para todos los incisos del Ejercicio 1, inicialmente con 
//        posiciones con valor de cero (paso libre), valor de -1 (atajo o pared).
//                Analizar las salidas y escribir conclusiones.

//3. Implementar los ejercicios 2 y 3. Redefiniendo el movimiento en el Laberinto,
//                también se puede mover una casilla por las diagonales.
//     (8 posibilidades de movimientos)

//4. Implementar los ejercicios 2 y 3. Redefiniendo el movimiento
//                en el Laberinto, solo por la diagonales, no horizontal ni vertical. 
//                (4 posibilidades de movimientos)

//5. Utilizar una Lista de Matrices para adaptar la resolución 
//                del Problema del Laberinto y mostrar la resolución
//                de cualquiera de los problemas de arriba, utilizando esta estructura de datos.
    
    //-----------------------------------------------------------------------------
//    B. EL PROBLEMA DEL MOVIMIENTO DEL CABALLO.

//1. Dado una matriz de n x m, inicialmente todas las posiciones con valores de cero,
//        avanzar las casillas en sentido HORARIO, con movimientos de izquierda,
//                arriba, derecha y abajo. Avanzar desde una posición inicial a 
//                        una posición final con el movimiento del caballo. 
//                                Existen 8 posibilidades de movimiento en forma de L.
//                                        Implementar los siguientes:

    
//a)     Algoritmo para mostrar todos los caminos posibles desde una posición inicial
//        a una posición final. Además, mostrar la cantidad de soluciones posibles 
//       (Cantidad de caminos posibles de la posición inicial a la posición final).
     public static LinkedList<Regla> reglasAplicablesA(int m[][], int i, int j) { 
        LinkedList<Regla> L1 = new LinkedList<>(); 
        
        // Movimientos del caballo en "L"
        if (posValida(m, i - 2, j + 1)) L1.add(new Regla(i - 2, j + 1)); // 2 arriba, 1 derecha
        if (posValida(m, i - 2, j - 1)) L1.add(new Regla(i - 2, j - 1)); // 2 arriba, 1 izquierda
        if (posValida(m, i - 1, j + 2)) L1.add(new Regla(i - 1, j + 2)); // 1 arriba, 2 derecha
        if (posValida(m, i + 1, j + 2)) L1.add(new Regla(i + 1, j + 2)); // 1 abajo, 2 derecha
        if (posValida(m, i + 2, j + 1)) L1.add(new Regla(i + 2, j + 1)); // 2 abajo, 1 derecha
        if (posValida(m, i + 2, j - 1)) L1.add(new Regla(i + 2, j - 1)); // 2 abajo, 1 izquierda
        if (posValida(m, i + 1, j - 2)) L1.add(new Regla(i + 1, j - 2)); // 1 abajo, 2 izquierda
        if (posValida(m, i - 1, j - 2)) L1.add(new Regla(i - 1, j - 2)); // 1 arriba, 2 izquierda
        
        return L1; 
    }
    
     static int solucionesCA = 0;
      public static void saltoCaballoA(int m[][], int i, int j, int iFin, int jFin, int paso) {
        // Verificar si la posición actual es válida
        if (!posValida(m, i, j)) {
            return;
        }

        // Marcar el paso actual en la matriz
        m[i][j] = paso;

        // Verificar si se llegó a la posición final
        if (i == iFin && j == jFin) {
            mostrar(m);  // Mostrar la solución
            solucionesCA++;
            return;
        }

        // Obtener las reglas aplicables (movimientos posibles del caballo)
        LinkedList<Regla> L1 = reglasAplicablesA(m, i, j);
        
        // Mientras haya movimientos posibles
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige una regla y la elimina de la lista
            saltoCaballoA(m, R.fil, R.col, iFin, jFin, paso + 1); // Llamada recursiva
            m[R.fil][R.col] = 0; // Desmarcar la casilla para backtracking
        }
    }
     
//b)     Algoritmo para mostrar todos los caminos posibles desde una posición inicial 
//        a una posición final tal que se visiten todas las casillas de la matriz.
//        Además, mostrar la cantidad de soluciones posibles.
      // Función recursiva para encontrar todas las soluciones del salto del caballo
      public static LinkedList<Regla> reglasAplicablesB(int m[][], int i, int j) { 
        LinkedList<Regla> L1 = new LinkedList<>(); 
        
        // Movimientos del caballo en "L"
        if (posValida(m, i - 2, j + 1)) L1.add(new Regla(i - 2, j + 1)); // 2 arriba, 1 derecha
        if (posValida(m, i - 2, j - 1)) L1.add(new Regla(i - 2, j - 1)); // 2 arriba, 1 izquierda
        if (posValida(m, i - 1, j + 2)) L1.add(new Regla(i - 1, j + 2)); // 1 arriba, 2 derecha
        if (posValida(m, i + 1, j + 2)) L1.add(new Regla(i + 1, j + 2)); // 1 abajo, 2 derecha
        if (posValida(m, i + 2, j + 1)) L1.add(new Regla(i + 2, j + 1)); // 2 abajo, 1 derecha
        if (posValida(m, i + 2, j - 1)) L1.add(new Regla(i + 2, j - 1)); // 2 abajo, 1 izquierda
        if (posValida(m, i + 1, j - 2)) L1.add(new Regla(i + 1, j - 2)); // 1 abajo, 2 izquierda
        if (posValida(m, i - 1, j - 2)) L1.add(new Regla(i - 1, j - 2)); // 1 arriba, 2 izquierda
        
        return L1; 
    }

     static int solucionesCB = 0; 
    public static void caminoCaballoB(int m[][], int i, int j, int iFin, int jFin, int paso) {
        // Verificar si la posición actual es válida
        if (!posValida(m, i, j)) {
            return;
        }

        // Marcar el paso actual en la matriz
        m[i][j] = paso;
        
        // Verificar si se llegó a la posición final y todas las casillas han sido visitadas
        if (paso == m.length * m[0].length && i == iFin && j == jFin) {
            mostrar(m);  // Mostrar la solución
            solucionesCB++;  // Incrementar el contador de soluciones
            return;
        }

        // Obtener las reglas aplicables (movimientos posibles del caballo)
        LinkedList<Regla> L1 = reglasAplicablesB(m, i, j);

        // Mientras haya movimientos posibles
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige una regla y la elimina de la lista
            caminoCaballoB(m, R.fil, R.col, iFin, jFin, paso + 1); // Llamada recursiva
            m[R.fil][R.col] = 0; // Desmarcar la casilla para backtracking
        }
    }

//c)      Algoritmo para mostrar todos los caminos posibles desde una posición
//        inicial a una posición final tal que NO se visiten todas las casillas 
//                de la matriz. Además, mostrar la cantidad de soluciones posibles.
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
    
    static int solucionesCC = 0; 
    public static void caminoCaballoC(int m[][], int i, int j, int iFin, int jFin, int paso,
                                    int totalVisitadas, int totalCasillas) {
        // Verificar si la posición actual es válida
        if (!posValida(m, i, j)) {
            return;
        }

        // Marcar el paso actual en la matriz
        m[i][j] = paso;
        totalVisitadas++;
        // Verificar si se llegó a la posición final y todas las casillas han sido visitadas
        if (i == iFin && j == jFin) {
            if (totalVisitadas < totalCasillas) { 
                mostrar(m);
                solucionesCC++;
            }
        }

        // Obtener las reglas aplicables (movimientos posibles del caballo)
        LinkedList<Regla> L1 = reglasAplicablesB(m, i, j);

        // Mientras haya movimientos posibles
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige una regla y la elimina de la lista
            caminoCaballoC(m, R.fil, R.col, iFin, jFin,  paso + 1, totalVisitadas, totalCasillas); // Llamada recursiva
            m[R.fil][R.col] = 0; // Desmarcar la casilla para backtracking
        }
        totalVisitadas--;
    }
    
//d)     Algoritmo para mostrar todos los caminos posibles de máxima longitud
//        desde una posición inicial a una posición final. Además, mostrar la 
//                cantidad de soluciones posibles.
    static int solucionesCD = 0; 
    public static void caminoCaballoCD(int m[][], int i, int j, int iFin, int jFin, int paso,
                                    int totalVisitadas, int maxLongitud) {
        // Verificar si la posición actual es válida
        if (!posValida(m, i, j)) {
            return;
        }
        // Marcar el paso actual en la matriz
        m[i][j] = paso;
        totalVisitadas++;
        // Verificar si se llegó a la posición final y todas las casillas han sido visitadas
        if (i == iFin && j == jFin) {
            if (totalVisitadas <= maxLongitud) { 
                mostrar(m);
                solucionesCD++;
            }
        }
        // Obtener las reglas aplicables (movimientos posibles del caballo)
        LinkedList<Regla> L1 = reglasAplicablesB(m, i, j);

        // Mientras haya movimientos posibles
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige una regla y la elimina de la lista
            caminoCaballoCD(m, R.fil, R.col, iFin, jFin,  paso + 1, totalVisitadas, maxLongitud); // Llamada recursiva
            m[R.fil][R.col] = 0; // Desmarcar la casilla para backtracking
        }
        totalVisitadas--;
    }
//e)     Algoritmo para mostrar todos los caminos posibles de mínima longitud
//        desde una posición inicial a una posición final. Además, mostrar la
//                cantidad de soluciones posibles.
     static int solucionesCE = 0; 
    public static void caminoCaballoCE(int m[][], int i, int j, int iFin, int jFin, int paso,
                                    int totalVisitadas, int minLongitod) {
        // Verificar si la posición actual es válida
        if (!posValida(m, i, j)) {
            return;
        }

        // Marcar el paso actual en la matriz
        m[i][j] = paso;
        totalVisitadas++;
        // Verificar si se llegó a la posición final y todas las casillas han sido visitadas
        if (i == iFin && j == jFin) {
            if (totalVisitadas > minLongitod) { 
                mostrar(m);
                solucionesCE++;
            }
        }

        // Obtener las reglas aplicables (movimientos posibles del caballo)
        LinkedList<Regla> L1 = reglasAplicablesB(m, i, j);

        // Mientras haya movimientos posibles
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1); // Elige una regla y la elimina de la lista
            caminoCaballoCD(m, R.fil, R.col, iFin, jFin,  paso + 1, totalVisitadas, minLongitod); // Llamada recursiva
            m[R.fil][R.col] = 0; // Desmarcar la casilla para backtracking
        }
        totalVisitadas--;
    }
    
    
//2. Ejecutar para todos los incisos del Ejercicio 1, inicialmente con 
//        posiciones con valor de cero (paso libre), valor de -1 (atajo o pared).
//                Analizar las salidas y escribir conclusiones.
    
//3. Utilizar una Lista de Matrices para adaptar la resolución del 
//                Problema del Movimiento del Caballo y mostrar la resolución de cualquiera 
//                de los problemas de arriba, utilizando esta estructura de datos.

      public static void main(String[] args) { 
        int a = 3;  
        int b = 3;       
        int iFin = 4; 
        int jFin = 4; 
        int ini = 2;
        int fin = 2;
        int [][] m = new int[a][b]; 
        int laberinto[][] = {  
            {0, 0, 0, 0, 0},  
            {0, 0, 0, 0, 0},  
            {0, 0, 0, 0, 0},  
            {0, 0, 0, 0, 0},  
            {0, 0, 0, 0, 0}, 
        };  
//        laberintoA(m, 0, 0, iFin, jFin, 1);  
//            System.out.println("Soluciones: "+solucionesA); 
//        
//        int totalCasillas = contarCasillas(m); 
//          laberintoB(m, 0, 0, iFin, jFin, 1, 0, totalCasillas);
//        System.out.println("Soluciones: "+solucionesB);
        
//          laberintoC(m, 0, 0, iFin, jFin, 1, 0, totalCasillas);
//        System.out.println("Soluciones: "+solucionesC);
        
//          laberintoD(laberinto, 0, 0, iFin, jFin, 1, 0, 8);
//          System.out.println("Sol "+solucionesD);
          
//          laberintoE(m, 0, 0, 2, 2, 1, 0, 3);
//          System.out.println("Sol "+solucionesE);
          
//          saltoCaballoA(m, 0, 0, iFin, jFin, 1);
//          System.out.println("Solcuciones: "+ solucionesCA);

//          caminoCaballoB(laberinto, 0, 0, iFin, jFin, 1);
//          System.out.println("Solcuciones: "+ solucionesCB);
          
//          int totalCasillas = contarCasillas(m); 
//        caminoCaballoC(m, 0, 0, iFin, jFin, 1, 0, totalCasillas);
//          System.out.println("Soluciones: "+ solucionesCC); 

//        int maxLong = 5;
//        caminoCaballoCD(m, 0, 0, iFin, jFin, 1, 0, maxLong);
//          System.out.println("Soluciones: "+ solucionesCD); 

//          int minLong = 9;
//        caminoCaballoCE(laberinto, 0, 0, iFin, jFin, 1, 0, minLong);
//          System.out.println("Soluciones: "+ solucionesCE);           
    }
      
      
      
}