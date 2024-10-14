/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea;


import static Tarea.Tarea3.solucionesA;
import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class Rey {
    
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
    
    public static void Rey( int m[][], int i, int j, 
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
            Rey(m, R.fil, R.col, ifin, jfin, paso + 1); 
            m[R.fil][R.col] = 0; 
        } 
    } 
 
    

    public static LinkedList<Regla> reglasAplicables(int m[][], int i, int j){ 
        LinkedList<Regla> L1 = new LinkedList<>(); 
 
        if (posValida(m, i-1, j )) L1.add(new Regla(i-1, j )); // izquierda 
        if (posValida(m, i - 1, j-1)) L1.add(new Regla(i - 1, j-1)); // arriba 
        if (posValida(m, i, j - 1)) L1.add(new Regla(i, j - 1)); // derecha 
        if (posValida(m, i + 1, j-1)) L1.add(new Regla(i + 1, j-1)); // abajo 
        if (posValida(m, i + 1, j)) L1.add(new Regla(i + 1, j)); // abajo 
        if (posValida(m, i + 1, j+1)) L1.add(new Regla(i + 1, j+1)); // abajo 
         if (posValida(m, i , j+1)) L1.add(new Regla(i , j+1)); // abajo 
          if (posValida(m, i-1 , j+1)) L1.add(new Regla(i-1 , j+1)); // abajo 
     
        return L1; 
    } 
 
    public static Regla elegirRegla(LinkedList<Regla> L1){ 
        return L1.removeFirst(); 
    } 
    
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int iniI = 0;
        int iniJ = 0;
        int iFin = 3;
        int jFin = 3;
        int laberinto[][] = new int[n][m];
        
        Rey(laberinto,0,0,2,2,1);



        
    }
    
}
