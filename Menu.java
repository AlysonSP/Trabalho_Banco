/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package com.mycompany.urubudopix;

public class Menu extends javax.swing.JPanel {
    
    public Menu() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Inicialização dos componentes
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton(); 
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(4, 1, 10, 10));

        jButton1.setText("Ver Informações da Conta");
        jButton2.setText("Realizar Transações");
        jButton3.setText("Verificar Extrato");
        jButton4.setText("Sair");

        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
    }

    // Variables declaration - do not modify
    protected javax.swing.JButton jButton1;
    protected javax.swing.JButton jButton2;
    protected javax.swing.JButton jButton3;
    protected javax.swing.JButton jButton4;
    // End of variables declaration
}
