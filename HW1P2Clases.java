/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hw1p2clases;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Jorge Aguirre
 */
public class HW1P2Clases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Transito transito = new Transito(); 
        JFrame frame = new JFrame("Sistema de Multas de Tránsito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JButton agregarMultaBtn = new JButton("Agregar Multa");
        JButton pagarMultaBtn = new JButton("Pagar Multa");
        JButton imprimirEstadisticasBtn = new JButton("Estadísticas");

        panel.add(agregarMultaBtn);
        panel.add(pagarMultaBtn);
        panel.add(imprimirEstadisticasBtn);

        agregarMultaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField codigoField = new JTextField(5);
                JTextField nombreField = new JTextField(10);
                JTextField tipoField = new JTextField(10);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Código:"));
                myPanel.add(codigoField);
                myPanel.add(Box.createHorizontalStrut(15)); 
                myPanel.add(new JLabel("Nombre:"));
                myPanel.add(nombreField);
                myPanel.add(Box.createHorizontalStrut(15)); 
                myPanel.add(new JLabel("Tipo:"));
                myPanel.add(tipoField);

                int result = JOptionPane.showConfirmDialog(null, myPanel, "Ingrese los detalles de la multa", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    int codigo = Integer.parseInt(codigoField.getText());
                    String nombre = nombreField.getText();
                    String tipo = tipoField.getText();
                    transito.agregarMulta(codigo, nombre, tipo);
                }
            }
        });

        pagarMultaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoStr = JOptionPane.showInputDialog("Ingrese el código de la multa a pagar:");
                int codigo = Integer.parseInt(codigoStr);
                transito.pagarMulta(codigo);
            }
        });

        imprimirEstadisticasBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transito.imprimirEstadisticas();
            }
        });

        frame.pack();  // Ajusta el tamaño del frame al contenido
        frame.setVisible(true);
    }
}