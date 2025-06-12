package com.mycompany.urubudopix;

import javax.swing.JOptionPane;

public class LogarPanel extends Logar {
    private final UrubudopixGUI frame;

    public LogarPanel(UrubudopixGUI frame) {
        super();
        this.frame = frame;

        // Botão "Clique Aqui!" para ir para cadastro
        jButton2.addActionListener(e -> frame.trocarPainel(new CadastrarPanel(frame)));

        // Botão "Entrar" para login
        jButton1.addActionListener(e -> {
            String nome = jTextField1.getText();
            String cpf = jTextField2.getText();

            ContaBancaria contaEncontrada = null;
            for (ContaBancaria c : BancoMemoria.contas) {
                if (c.getDono().getNome().equals(nome) && 
                    c.getDono().getCpf().equals(cpf)) {
                    contaEncontrada = c;
                    break;
                }
            }

            if (contaEncontrada != null) {
                frame.trocarPainel(new MenuPanel(frame, contaEncontrada));
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Usuário não encontrado!", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}