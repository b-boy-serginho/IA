/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemalaberinto.Laberinto;

// alt + shif + f = ordena el codigo
public class Laberinto {
    
    public static int soluciones = 0;
    public static int totalCasillas; // Para contar las casillas totales que deben ser visitadas
     
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
    
    public static void laberinto(int m[][], int i, int j, 
                                int iFin, int jFin, int paso){
        if(!posValida(m,i,j)) return;
        m[i][j] = paso;
        if(i == iFin && j == jFin){ 
            mostrar(m);
            soluciones++;
        }
        laberinto(m, i, j-1, iFin, jFin, paso+1);
        laberinto(m, i-1, j, iFin, jFin, paso+1);        
        laberinto(m, i, j+1, iFin, jFin, paso+1);
        laberinto(m, i+1, j, iFin, jFin, paso+1);
        m[i][j] = 0;
    }
    
    
    
    public static void laberintoA(int m[][], int i, int j, 
                                int iFin, int jFin, int paso){
        if(!posValida(m,i,j)) return;
        m[i][j] = paso;
        if(i == iFin && j == jFin) {
            mostrar(m);
            soluciones++;  // Incrementar el contador de soluciones
        } 
            // Intentar ir en las cuatro direcciones posibles
            laberinto(m, i, j-1, iFin, jFin, paso+1); // Izquierda
            laberinto(m, i-1, j, iFin, jFin, paso+1); // Arriba
            laberinto(m, i, j+1, iFin, jFin, paso+1); // Derecha
            laberinto(m, i+1, j, iFin, jFin, paso+1); // Abajo
        
        m[i][j] = 0;
    }
    
     public static void laberintoB(int m[][], int i, int j, 
                                int iFin, int jFin, int paso){
        if(!posValida(m,i,j)) return;
        m[i][j] = paso;
        if(i == iFin && j == jFin && paso == totalCasillas) {
            mostrar(m);
            soluciones++;  // Incrementar el contador de soluciones
        }
        laberinto(m, i, j-1, iFin, jFin, paso+1);
        laberinto(m, i-1, j, iFin, jFin, paso+1);        
        laberinto(m, i, j+1, iFin, jFin, paso+1);
        laberinto(m, i+1, j, iFin, jFin, paso+1);
        m[i][j] = 0;
    }
    
     public static void laberintoD(int m[][], int i, int j, 
                                int iFin, int jFin, int paso){
        if(!posValida(m, i, j)) return; // Si la posición no es válida, salimos
        
        m[i][j] = paso; // Marcar la casilla con el número del paso actual
        
        // Si llegamos a la posición final, contamos como una solución
        if(i == iFin && j == jFin) {
            mostrar(m);
            soluciones++;  // Incrementar el contador de soluciones
        } else {
            // Intentar ir en las cuatro direcciones posibles
            laberinto(m, i, j-1, iFin, jFin, paso+1); // Izquierda
            laberinto(m, i-1, j, iFin, jFin, paso+1); // Arriba
            laberinto(m, i, j+1, iFin, jFin, paso+1); // Derecha
            laberinto(m, i+1, j, iFin, jFin, paso+1); // Abajo
        }
        
        // Desmarcar la casilla para el backtracking (retroceder)
        m[i][j] = 0;
    }
    
    
    
    public static void main(String[] args) {
        int a = 3; 
        int b = 3;        
        totalCasillas = a * b; // Total de casillas que deben ser visitadas
        int [][] m = new int[a][b]; 
//        laberinto(m, 0, 0, a-1, b-1, 1); // Corrección en los índices
//        laberintoA(m, 0, 0, a-1, b-1, 1);
//        laberintoB(m, 0, 0, a-1, b-1, 1);
        laberinto(m, 0, 0, a-1, b-1, 1);
        System.out.println("Cantidad de soluciones posibles: " + soluciones);
        System.out.println("total: "+ totalCasillas);
    }
}

