package Tarea;

import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author megus
 */
public class Tarea1_2 {
    
    static int cantidadSoluciones = 0; 
    static LinkedList<int[][]> listaSoluciones = new LinkedList<>(); //Para almacenar Soluciones 
 
       // Problema A 
    public static void laberinto(int m[][], int i, int j, int iFin, int jFin, int paso) { 
        if (!posValida(m, i, j)) return; 
 
        m[i][j] = paso; // Marcar la posición con el paso actual 
 
        // Si llegamos a la posición final 
        if (i == iFin && j == jFin) { 
            mostrar(m); // Mostrar el camino encontrado 
            cantidadSoluciones++; // Incrementar el contador de soluciones 
        } else { 
            // Probar todas las direcciones posibles 
            laberinto(m, i, j-1, iFin, jFin, paso+1); // Izquierda 
            laberinto(m, i-1, j, iFin, jFin, paso+1); // Arriba 
            laberinto(m, i, j+1, iFin, jFin, paso+1); // Derecha 
            laberinto(m, i+1, j, iFin, jFin, paso+1); // Abajo 
        } 
 
        m[i][j] = 0; // Desmarcar la posición para probar otros caminos 
    } 
     
     // Problema B 
    public static void laberinto2(int m[][], int i, int j, int iFin, int jFin,
                                  int paso, int totalVisitadas, int totalCasillas) { 
        if (!posValida(m, i, j)) return; // Verifica si la posición es válida 
         
        m[i][j] = paso; // Marca la posición actual con el número del paso 
        totalVisitadas++; // Aumenta el conteo de casillas visitadas 
 
        // Si llegamos a la posición final 
        if (i == iFin && j == jFin) { 
            // Verificamos si hemos visitado todas las casillas (sin obstáculos) 
            if (totalVisitadas == totalCasillas) { 
                mostrar(m); // Mostramos el camino 
                cantidadSoluciones++; // Incrementamos el contador de soluciones 
            } 
        } else { 
            // Probar todas las direcciones posibles 
            laberinto2(m, i, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Izquierda 
            laberinto2(m, i-1, j, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Arriba 
            laberinto2(m, i, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Derecha 
            laberinto2(m, i+1, j, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Abajo 
        } 
 
        m[i][j] = 0; // Desmarcar la posición para probar otros caminos 
        totalVisitadas--; // Retrocedemos en el conteo de casillas visitadas 
    } 
     
     // Problema C 
    public static void laberinto3(int m[][], int i, int j, int iFin, int jFin,
                                  int paso, int totalVisitadas, int totalCasillas) { 
        if (!posValida(m, i, j)) return; // Verificar si la posición es válida 
 
        m[i][j] = paso; // Marcar la posición actual con el número del paso 
        totalVisitadas++; // Aumenta el conteo de casillas visitadas 
 
        // Si llegamos a la posición final 
        if (i == iFin && j == jFin) { 
            // Verificamos si NO se han visitado todas las casillas (sin obstáculos) 
            if (totalVisitadas < totalCasillas) { 
                mostrar(m); // Mostrar el camino si es válido (no todas las casillas visitadas) 
                cantidadSoluciones++; // Incrementar el contador de soluciones 
            } 
        } else { 
            // Probar todas las direcciones posibles 
            laberinto3(m, i, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Izquierda 
            laberinto3(m, i-1, j, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Arriba 
            laberinto3(m, i, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Derecha 
            laberinto3(m, i+1, j, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Abajo 
        }  
        m[i][j] = 0; // Desmarcar la posición para explorar otros caminos 
    } 
     
     // Problema D      
    public static void laberinto4(int m[][], int i, int j, int iFin, int jFin, 
                                  int paso, int totalVisitadas, int maxLongitud) { 
        if (!posValida(m, i, j)) return; // Verificar si la posición es válida 
 
        m[i][j] = paso; // Marcar la posición actual con el número del paso 
        totalVisitadas++; // Aumenta el conteo de casillas visitadas 
 
        // Si llegamos a la posición final 
        if (i == iFin && j == jFin) { 
            // Verificamos si el camino tiene la longitud máxima posible 
            if (totalVisitadas == maxLongitud) { 
                mostrar(m); // Mostrar el camino si es válido (longitud máxima) 
                cantidadSoluciones++; // Incrementar el contador de soluciones 
            } 
        } else { 
            // Probar todas las direcciones posibles 
            laberinto4(m, i, j-1, iFin, jFin, paso+1, totalVisitadas, maxLongitud); // Izquierda 
            laberinto4(m, i-1, j, iFin, jFin, paso+1, totalVisitadas, maxLongitud); // Arriba 
            laberinto4(m, i, j+1, iFin, jFin, paso+1, totalVisitadas, maxLongitud); // Derecha 
            laberinto4(m, i+1, j, iFin, jFin, paso+1, totalVisitadas, maxLongitud); // Abajo 
        } 
 
        m[i][j] = 0; // Desmarcar la posición para explorar otros caminos 
    } 
     
     // Problema E 
     
    public static void laberinto5(int m[][], int i, int j, int iFin, int jFin,
                                  int paso, int totalVisitadas, int minLongitod) { 
        if (!posValida(m, i, j)) return; // Verificar si la posición es válida 
 
        m[i][j] = paso; // Marcar la posición actual con el número del paso 
        totalVisitadas++; // Aumenta el conteo de casillas visitadas 
 
        // Si llegamos a la posición final 
        if (i == iFin && j == jFin) { 
            // Verificamos si el camino tiene la longitud máxima posible 
            if (totalVisitadas > minLongitod) { 
                mostrar(m); // Mostrar el camino si es válido (longitud máxima) 
                cantidadSoluciones++; // Incrementar el contador de soluciones 
            } 
        } else { 
            // Probar todas las direcciones posibles 
            laberinto5(m, i, j-1, iFin, jFin, paso+1, totalVisitadas, minLongitod); // Izquierda 
            laberinto5(m, i-1, j, iFin, jFin, paso+1, totalVisitadas, minLongitod); // Arriba 
            laberinto5(m, i, j+1, iFin, jFin, paso+1, totalVisitadas, minLongitod); // Derecha 
            laberinto5(m, i+1, j, iFin, jFin, paso+1, totalVisitadas, minLongitod); // Abajo 
        } 
 
        m[i][j] = 0; // Desmarcar la posición para explorar otros caminos 
    } 
     
    //Problema 2 = Ya esta implementado el problema en cada inciso, es decir que  
    // reconoce que -1 es (Pared) y 0 es camino libre. 
     
    // Problema 3.1 
     
    public static void laberinto6(int m[][], int i, int j, int iFin, int jFin, int paso,
                                  int totalVisitadas, int totalCasillas) { 
        if (!posValida(m, i, j)) return; // Verificar si la posición es válida 
 
        m[i][j] = paso; // Marcar la posición actual con el número del paso 
        totalVisitadas++; // Aumenta el conteo de casillas visitadas 
 
        // Si llegamos a la posición final 
        if (i == iFin && j == jFin) { 
            // Verificamos si se han visitado todas las casillas sin obstáculos 
            if (totalVisitadas == totalCasillas) { 
                mostrar(m); // Mostrar el camino si es válido (visitó todas las casillas) 
                cantidadSoluciones++; // Incrementar el contador de soluciones 
            } 
        } else { 
            // Probar todas las 8 direcciones posibles 
            laberinto6(m, i, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Izquierda 
            laberinto6(m, i-1, j, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Arriba 
            laberinto6(m, i, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Derecha 
            laberinto6(m, i+1, j, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Abajo 
 
            // Movimientos en diagonal 
            laberinto6(m, i-1, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal arriba
            //izquierda 
            laberinto6(m, i-1, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal 
            //arriba-derecha 
            laberinto6(m, i+1, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal abajo
            //izquierda 
            laberinto6(m, i+1, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal 
            //abajo-derecha 
        } 
 
        m[i][j] = 0; // Desmarcar la posición para explorar otros caminos 
    } 
     
    // Problema 3.2      
    public static void laberinto7(int m[][], int i, int j, int iFin, int jFin,
                                  int paso, int totalVisitadas, int totalCasillas) { 
        if (!posValida(m, i, j)) return; // Verificar si la posición es válida 
 
        m[i][j] = paso; // Marcar la posición actual con el número del paso 
        totalVisitadas++; // Aumenta el conteo de casillas visitadas 
 
        // Si llegamos a la posición final 
        if (i == iFin && j == jFin) { 
            // Verificamos si NO se han visitado todas las casillas 
            if (totalVisitadas < totalCasillas) { 
                mostrar(m); // Mostrar el camino si es válido (no visitó todas las casillas) 
                cantidadSoluciones++; // Incrementar el contador de soluciones 
            } 
        } else { 
            // Probar todas las 8 direcciones posibles 
            laberinto7(m, i, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Izquierda 
            laberinto7(m, i-1, j, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Arriba 
            laberinto7(m, i, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Derecha 
            laberinto7(m, i+1, j, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Abajo 
 
            // Movimientos en diagonal 
            laberinto7(m, i-1, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal arriba
            //izquierda 
            laberinto7(m, i-1, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal 
            // arriba-derecha 
            laberinto7(m, i+1, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal abajo
            //izquierda 
            laberinto7(m, i+1, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal 
            //abajo-derecha 
        } 
 
        m[i][j] = 0; // Desmarcar la posición para explorar otros caminos 
    } 
     
    // Problema 4.1 
     
    public static void laberinto8(int m[][], int i, int j, int iFin, int jFin, int paso, int totalVisitadas, 
int totalCasillas) { 
        if (!posValida(m, i, j)) return; // Verificar si la posición es válida 
 
        m[i][j] = paso; // Marcar la posición actual con el número del paso 
        totalVisitadas++; // Aumenta el conteo de casillas visitadas 
 
        // Si llegamos a la posición final 
        if (i == iFin && j == jFin) { 
            // Verificamos si se han visitado todas las casillas sin obstáculos 
            if (totalVisitadas == totalCasillas) { 
                mostrar(m); // Mostrar el camino si es válido (visitó todas las casillas) 
                cantidadSoluciones++; // Incrementar el contador de soluciones 
            } 
        } else { 
          
            // Movimientos en diagonal 
            laberinto8(m, i-1, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal arriba
            //izquierda 
            laberinto8(m, i-1, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal 
            //arriba-derecha 
            laberinto8(m, i+1, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal abajo
            //izquierda 
            laberinto8(m, i+1, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal 
            //abajo-derecha 
        } 
 
        m[i][j] = 0; // Desmarcar la posición para explorar otros caminos 
    } 
     
    // Problema 4.2 
     
    public static void laberinto9(int m[][], int i, int j, int iFin, int jFin, int paso, int totalVisitadas, 
int totalCasillas) { 
        if (!posValida(m, i, j)) return; // Verificar si la posición es válida 
 
        m[i][j] = paso; // Marcar la posición actual con el número del paso 
        totalVisitadas++; // Aumenta el conteo de casillas visitadas 
 
        // Si llegamos a la posición final 
        if (i == iFin && j == jFin) { 
            // Verificamos si NO se han visitado todas las casillas 
            if (totalVisitadas < totalCasillas) { 
                mostrar(m); // Mostrar el camino si es válido (no visitó todas las casillas) 
                cantidadSoluciones++; // Incrementar el contador de soluciones 
            } 
        } else { 
         
           
            // Movimientos en diagonal 
            laberinto9(m, i-1, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal arriba
            //izquierda 
            laberinto9(m, i-1, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal 
            //arriba-derecha 
            laberinto9(m, i+1, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal abajo
            //izquierda 
            laberinto9(m, i+1, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Diagonal 
            //abajo-derecha 
        } 
        m[i][j] = 0; // Desmarcar la posición para explorar otros caminos 
    } 
     
     // Guardar una copia de la solución en la LinkedList 
    public static void guardarSolucion(int m[][]) { 
        int[][] solucion = new int[m.length][m[0].length]; 
        for (int i = 0; i < m.length; i++) { 
            for (int j = 0; j < m[i].length; j++) { 
                solucion[i][j] = m[i][j]; // Copiar cada valor de la matriz 
            } 
        } 
        listaSoluciones.add(solucion); // Agregar la copia a la lista de soluciones 
    } 
     
    // Problema 5 
     
    public static void laberinto10(int m[][], int i, int j, int iFin, int jFin, 
                                   int paso, int totalVisitadas, int totalCasillas) { 
        if (!posValida(m, i, j)) return; // Verificar si la posición es válida 
 
        m[i][j] = paso; // Marcar la posición actual con el número del paso 
        totalVisitadas++; // Aumenta el conteo de casillas visitadas 
 
        // Si llegamos a la posición final 
        if (i == iFin && j == jFin) { 
            // Verificamos si NO se han visitado todas las casillas 
            if (totalVisitadas < totalCasillas) { 
                guardarSolucion(m); // Guardar la solución en la lista 
                cantidadSoluciones++; // Incrementar el contador de soluciones 
            } 
        } else { 
            // Probar todas las 8 direcciones posibles 
            laberinto10(m, i, j-1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Izquierda 
            laberinto10(m, i-1, j, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Arriba 
            laberinto10(m, i, j+1, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Derecha 
            laberinto10(m, i+1, j, iFin, jFin, paso+1, totalVisitadas, totalCasillas); // Abajo 
 
           
        } 
 
        m[i][j] = 0; // Desmarcar la posición para explorar otros caminos 
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
 
 
    // Verificar si la posición es válida 
    public static boolean posValida(int m[][], int i, int j) { 
        return i >= 0 && i < m.length && j >= 0 && j < m[i].length && m[i][j] == 0; 
    } 
 
    // Mostrar el camino encontrado 
    public static void mostrar(int m[][]) { 
        for (int i = 0; i < m.length; i++) { 
            for (int j = 0; j < m[i].length; j++) { 
                System.out.print(m[i][j] + "\t"); 
            } 
            System.out.println(); 
        } 
        System.out.println(); 
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
 
    // Función principal para ejecutar el programa 
  // Función principal para ejecutar el programa 
    public static void main(String[] args) { 
        // Matriz del laberinto (0 es camino libre, -1 es obstáculo) 
        int laberinto[][] = { 
            {0, 0, 0, 0}, 
            {0, -1, 0, 0}, 
            {0, 0, 0, 0}, 
            {0, 0, 0, 0} 
        }; 
 
        int inicioI = 0, inicioJ = 0; // Posición inicial 
        int finI = 3, finJ = 3; // Posición final 
 
        // Contamos el número total de casillas válidas para determinar si el camino es válido 
        int totalCasillas = contarCasillas(laberinto); 
 
        // Iniciar el laberinto desde la posición inicial 
        laberinto10(laberinto, inicioI, inicioJ, finI, finJ, 1, 0, totalCasillas); 
        // Mostrar la cantidad de soluciones válidas encontradas 
        System.out.println("Cantidad de soluciones donde NO se visitan todas las casillas: " + 
        cantidadSoluciones); 
        // Mostrar todas las soluciones almacenadas en la LinkedList 
        mostrarSoluciones(); 
    }
}
