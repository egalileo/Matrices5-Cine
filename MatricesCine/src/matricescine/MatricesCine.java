package matricescine;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MatricesCine {

    /**
     * Ejercicio cine
     */
    public static void main(String[] args) {
        String cine[][], salida = "", cualAsiento, cualLetra, cualNumero;
        String butacas[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "K"};
        JTextArea hoja = new JTextArea();
        int filas, columnas, fila, columna, opcion, cualFila = -1, cualColumna = -1;
        boolean salir = false, encontrado = false;

        do {
            filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas (4 y 9)"));
            columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas (4 y 9)"));
        } while ((filas < 4 || filas > 9) || (columnas < 4 || columnas > 9));

        cine = new String[filas][columnas];

        for (fila = 0; fila < filas; fila++) {
            for (columna = 0; columna < columnas; columna++) {
                cine[fila][columna] = butacas[fila] + String.valueOf(columna + 1);
            }
        }

        while (salir == false) { //MENU
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea\n1. Ver sala\n2. Comprar boleto\n3. Devolver boleto\n4. Cambiar asiento\nCualquier otro para salir"));

            if (opcion == 1) { // VER MATRIZ\
                salida = "";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida += cine[fila][columna] + "\t";
                    }
                    salida += "\n";
                }
                hoja.setText(salida);
                JOptionPane.showMessageDialog(null, hoja);
            } else if (opcion == 2) { // COMPRAR BOLETO
                salida = "";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida += cine[fila][columna] + "\t";
                    }
                    salida += "\n";
                }
                salida += "Cual asiento desea comprar?";
                hoja.setText(salida);
                cualAsiento = JOptionPane.showInputDialog(hoja);
                cualAsiento = cualAsiento.toUpperCase();

                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        if (cualAsiento.equals(cine[fila][columna])) { //SOLO SI LO ENCUENTRO
                            encontrado = true;
                            cualFila = fila;
                            cualColumna = columna;
                        }
                    }
                }

                if (encontrado = true) {
                    if (cine[cualFila][cualColumna].equals("X")) { //asiento ocupado, no se puede vender
                        JOptionPane.showMessageDialog(null, "Error. El asiento " + cualAsiento + " se encuentra ocupado");
                    } else { // si puedo vender
                        cine[cualFila][cualColumna] = "X";
                        JOptionPane.showMessageDialog(null, "Asiento " + cualAsiento + " vendido");
                    }
                } else if (encontrado = false) {
                    JOptionPane.showMessageDialog(null, "Error. El asiento " + cualAsiento + " No se encuentra en la sala");
                }

            } else if (opcion == 3) { // DEVOLVER BOLETO
                encontrado = false;
                salida = "";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida += cine[fila][columna] + "\t";
                    }
                    salida += "\n";
                }
                salida += "Cual asiento desea devolver?";
                hoja.setText(salida);
                cualAsiento = JOptionPane.showInputDialog(hoja);
                cualAsiento = cualAsiento.toUpperCase();
                cualLetra = String.valueOf(cualAsiento.charAt(0));
                cualColumna = Integer.parseInt(String.valueOf(cualAsiento.charAt(1)));

                for (fila = 0; fila < filas; fila++) {
                    if(cualLetra.equals(butacas[fila])){ //encontro
                        encontrado = true;
                        cualFila = fila;
                    }
                }
                
                if (encontrado = true) {
                    if (cine[cualFila][cualColumna-1].equals("X")) { //asiento ocupado, si se puede devolver
                        cine[cualFila][cualColumna-1] = cualAsiento;
                        JOptionPane.showMessageDialog(null, "Asiento " + cualAsiento + " devuelto");
                        
                    } else { // el asiento no ha sido comprado aun
                        JOptionPane.showMessageDialog(null, "Error. El asiento " + cualAsiento + " no ha sido comprado, se encuentra vacio");
                    }
                } else if (encontrado = false) {
                    JOptionPane.showMessageDialog(null, "Error. El asiento " + cualAsiento + " No se encuentra en la sala");
                }

                
                System.out.println(cualAsiento);
                System.out.println(cualFila);
                System.out.println(cualColumna-1);

//                for (fila = 0; fila < filas; fila++) {
//                    for (columna = 0; columna < columnas; columna++) {
//                        if (cualAsiento.equals(cine[fila][columna])) { //SOLO SI LO ENCUENTRO
//                            encontrado = true;
//                            cualFila = fila;
//                            cualColumna = columna;
//                        }
//                    }
//                }
            } else if (opcion == 4) { // CAMBIAR ASIENTO

            } else { // SALIR
                salir = true;
            }
        }

    }

}
