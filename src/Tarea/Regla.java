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
public class Regla {

    public int fil;
    public int col;

    public Regla(int fil, int col) {
        this.fil = fil;
        this.col = col;
    }
    
    private static boolean posValida(int[][] m, int i, int j) {
        return (i >= 0 && i < m.length) && (j >= 0 && j < m[i].length) && (m[i][j] == 0);
    }

    public static LinkedList<Regla> reglasAplicablesRey(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList();
        if (posValida(m, i, j - 1)) {
            L1.add(new Regla(i, j - 1));
        }
        if (posValida(m, i - 1, j)) {
            L1.add(new Regla(i - 1, j));
        }
        if (posValida(m, i, j + 1)) {
            L1.add(new Regla(i, j + 1));
        }
        if (posValida(m, i + 1, j)) {
            L1.add(new Regla(i + 1, j));
        }
        if (posValida(m, i - 1, j - 1)) {
            L1.add(new Regla(i - 1, j - 1));
        }
        if (posValida(m, i - 1, j + 1)) {
            L1.add(new Regla(i - 1, j + 1));
        }    
        if (posValida(m, i + 1, j + 1)) {
            L1.add(new Regla(i + 1, j + 1));
        } 
        if (posValida(m, i + 1, j - 1)) {
            L1.add(new Regla(i + 1, j - 1));
        }  
        return L1;
    }
    
    public static LinkedList<Regla> reglasAplicablesCaballo(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList();
        if (posValida(m, i - 1, j - 2)) {
            L1.add(new Regla(i - 1, j - 2));
        }
        if (posValida(m, i - 2, j - 1)) {
            L1.add(new Regla(i - 2, j - 1));
        }
        if (posValida(m, i - 2, j + 1)) {
            L1.add(new Regla(i - 2, j + 1));
        }
        if (posValida(m, i - 1, j + 2)) {
            L1.add(new Regla(i - 1, j + 2));
        }
        if (posValida(m, i + 1, j + 2)) {
            L1.add(new Regla(i + 1, j + 2));
        }
        if (posValida(m, i + 2, j + 1)) {
            L1.add(new Regla(i + 2, j + 1));
        }    
        if (posValida(m, i + 2, j - 1)) {
            L1.add(new Regla(i + 2, j - 1));
        } 
        if (posValida(m, i + 1, j - 2)) {
            L1.add(new Regla(i + 1, j - 2));
        }  
        return L1;
    }
    
    public static LinkedList<Regla> reglasAplicablesTorre(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList();
        int x = j - 1;
        while (posValida(m, i, x)) {
            L1.add(new Regla(i, x));
            x--;
        }
        x = i - 1;
        while (posValida(m, x, j)) {
            L1.add(new Regla(x, j));
            x--;
        }
        x = j + 1;
        while (posValida(m, i, x)) {
            L1.add(new Regla(i, x));
            x++;
        }
        x = i + 1;
        while (posValida(m, x, j)) {
            L1.add(new Regla(x, j));
            x++;
        }     
        return L1;
    }

    
    public static LinkedList<Regla> reglasAplicablesAlfil(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList();
        int x = i - 1;
        int y = j - 1;
        while (posValida(m, x, y)) {
            L1.add(new Regla(x, y));
            x--;
            y--;
        }
        x = i - 1;
        y = j + 1;
        while (posValida(m, x, y)) {
            L1.add(new Regla(x, y));
            x--;
            y++;
        }
        x = i + 1;
        y = j + 1;
        while (posValida(m, x, y)) {
            L1.add(new Regla(x, y));
            x++;
            y++;
        }
        
        x = i + 1;
        y = j - 1;
        while (posValida(m, x, y)) {
            L1.add(new Regla(x, y));
            x++;
            y--;
        }     
        return L1;
    }
    
     public static LinkedList<Regla> reglasAplicablesReina(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList();
        L1.addAll(reglasAplicablesTorre(m, i, j));
        L1.addAll(reglasAplicablesAlfil(m, i, j));       
        return L1;
    }
}

