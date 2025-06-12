package com.mycompany.urubudopix;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoContaPanel extends JPanel {
    private final UrubudopixGUI frame;
    private final ContaBancaria conta;

    public InfoContaPanel(UrubudopixGUI frame, ContaBancaria conta) {
        this.frame = frame;
        this.conta = conta;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Painel com as informações
        JPanel infoPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        
        // Adiciona as informações da conta
        adicionarCampo(infoPanel, "Número da Conta:", String.valueOf(conta.getNumConta()));
        adicionarCampo(infoPanel, "Nome do Titular:", conta.getDono().getNome());
        adicionarCampo(infoPanel, "CPF:", conta.getDono().getCpf());
        adicionarCampo(infoPanel, "Tipo da Conta:", conta.getTipo());
        adicionarCampo(infoPanel, "Status:", conta.getStatus() ? "Ativa" : "Inativa");
        adicionarCampo(infoPanel, "Saldo:", String.format("R$ %.2f", conta.getSaldo()));

        // Adiciona o painel de informações
        add(infoPanel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton voltarBtn = new JButton("Voltar ao Menu");
        voltarBtn.addActionListener(e -> frame.trocarPainel(new MenuPanel(frame, conta)));
        
        buttonPanel.add(voltarBtn);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void adicionarCampo(JPanel panel, String label, String valor) {
        JLabel lblCampo = new JLabel(label);
        lblCampo.setFont(new Font("Arial", Font.BOLD, 12));
        
        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Arial", Font.PLAIN, 12));
        
        panel.add(lblCampo);
        panel.add(lblValor);
    }
}