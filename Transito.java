/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw1p2clases;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Aguirre
 */
public class Transito extends JFrame {
private Multa[] multas;
    private int contadorMultas;

    // Constructor
    public Transito() {
        multas = new Multa[100];
        contadorMultas = 0;
    }

    // Método para buscar una multa por su código
    public Multa buscarMulta(int codigo) {
        for (int i = 0; i < contadorMultas; i++) {
            if (multas[i].getCodigo() == codigo) {
                return multas[i];
            }
        }
        return null;
    }

    // Método para agregar una nueva multa
    public void agregarMulta(int codigo, String nombre, String tipo) {
        if (contadorMultas >= multas.length) {
            JOptionPane.showMessageDialog(this, "No hay espacio para agregar mas multas");
            return;
        }

        if (buscarMulta(codigo) != null) {
            JOptionPane.showMessageDialog(this, "EL CODIGO DE MULTA YA EXISTE");
            return;
        }

        multas[contadorMultas] = new Multa(codigo, nombre, tipo);
        contadorMultas++;
    }

    // Método para pagar una multa
    public void pagarMulta(int codigo) {
        Multa multa = buscarMulta(codigo);
        if (multa != null) {
            multa.pay();
        } else {
            JOptionPane.showMessageDialog(this, "NO SE ENCONTRO EL CODIGO");
        }
    }

    // Método para imprimir todas las multas
    public void imprimirMultas() {
        for (int i = 0; i < contadorMultas; i++) {
            ////
        }
    }

    // Método para imprimir estadísticas del sistema de multas
    public void imprimirEstadisticas() {
        int multasPagadas = 0;
        int multasPendientes = 0;
        double montoPagado = 0.0;
        double montoPendiente = 0.0;

        for (int i = 0; i < contadorMultas; i++) {
            if (multas[i].isPagada()) {
                multasPagadas++;
                montoPagado += multas[i].getMontoAPagar();
            } else {
                multasPendientes++;
                montoPendiente += multas[i].getMontoAPagar();
            }
        }
        JOptionPane.showMessageDialog(this, "Cantidad de Multas generadas: " + contadorMultas + "\n Cantidad de Multas Pagadas: " + multasPagadas + " -- con un monto en Lps " + montoPagado + "\n Cantidad de Multas pendientes por pagar: " + multasPendientes + " -- con un monto en Lps " + montoPendiente);
    }

    // Método main para probar la clase Transito
    
    
}