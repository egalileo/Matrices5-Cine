package matricescine;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MatricesCine {

    /**
     * Ejercicio cine
     */
    public static void main(String[] args) {
        String cine[][], salida = "";
        String butacas[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "K"};
        JTextArea hoja = new JTextArea();
        int filas, columnas, fila, columna, opcion;
        boolean salir = false;

        do {
            filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas (4 y 9)"));
            columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas (4 y 9)"));
        } while ((filas < 4 || filas > 9) || (columnas < 4 || columnas > 9));

        cine = new String[filas][columnas];

        for (fila = 0; fila < filas; fila++) {
            for (columna = 0; columna < columnas; columna++) {
                cine[fila][columna] = butacas[fila]+String.valueOf(columna+1);
            }
        }

        while (salir == false) { //MENU
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea\n1. Ver sala\n2. Comprar boleto\n3. Devolver boleto\n4. Cambiar asiento\nCualquier otro para salir"));

            if (opcion == 1) { // VER MATRIZ\
                salida="";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida+=cine[fila][columna]+"\t";
                    }
                    salida+="\n";
                }
                hoja.setText(salida);
                JOptionPane.showMessageDialog(null, hoja);
            } else if (opcion == 2) { // COMPRAR BOLETO

            } else if (opcion == 3) { // DEVOLVER BOLETO

            } else if (opcion == 4) { // CAMBIAR ASIENTO

            } else { // SALIR
                salir = true;
            }
        }

    }

}
