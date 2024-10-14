/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea;

import java.util.LinkedList;

/**
 *
 * @author megus
 */
public class Caballo {
    
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
    static int soluciones = 0;
    public static void laberintoA( int m[][], int i, int j,
        int ifin, int jfin, int paso){
        if(!posValida(m, i, j)) return;
        m[i][j] = paso;
        if(i == ifin && j == jfin){ 
            mostrar(m);
            soluciones++;
        }
        LinkedList<Regla> L1 = reglasAplicables(m, i, j);
        while(!L1.isEmpty()){
            Regla R = elegirRegla(L1); // Elige la 1ra Regla y elimina
            laberintoA(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
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
    
    public static void main(String[] args) {
        int a = 3; 
        int b = 3;      
        int iFin = 2;
        int jFin = 2;
        int [][] m = new int[a][b];
        int laberinto[][] = { 
            {0, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 0}, 
            {0, 0, -1, 0, 0}, 
            {0, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 0},
        }; 
        laberintoA(m, 0, 0, iFin, jFin, 1); 
        System.out.println("Soluciones: "+soluciones);
    }
}
