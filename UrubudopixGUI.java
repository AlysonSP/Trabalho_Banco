package com.mycompany.urubudopix;

import javax.swing.*;

public class UrubudopixGUI extends JFrame {

    public UrubudopixGUI() {
        setTitle("Urubu do Pix");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);

        // Começa com o painel de login
        setContentPane(new LogarPanel(this));
    }

    // Troca o painel exibido
    public void trocarPainel(JPanel novoPainel) {
        setContentPane(novoPainel);
        revalidate();
        repaint();
    }

    // Inicialização da interface gráfica
    public static void iniciar() {
        SwingUtilities.invokeLater(() -> {
            UrubudopixGUI gui = new UrubudopixGUI();
            gui.setVisible(true);
        });
    }
}