package matricescine;

import javax.swing.JOptionPane;

public class MatricesCine {

    /**
     * Ejercicio cine
     */
    public static void main(String[] args) {
        String cine[][];
        int filas, columnas, fila, columna;
        boolean salir = false; 
        
        do{
            filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas (4 y 9)"));
            columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas (4 y 9)"));
        }while((filas<4 || filas>9)|| (columnas<4 || columnas>9));
        
        cine = new String [filas][columnas];
        
        for(fila=0; fila<filas; fila++){
            for(columna=0; columna<columnas; columna++){
                cine[fila][columna]= String.valueOf(columna);
            }
        }
        
        while(salir == false){ //MENU
            
        }
        
        
    }
    
}
