package com.mycompany.urubudopix;

import javax.swing.JOptionPane;

public class MenuPanel extends Menu {
    private final UrubudopixGUI frame;
    private final ContaBancaria conta;

    // Construtor que aceita frame e conta
    public MenuPanel(UrubudopixGUI frame, ContaBancaria conta) {
        super();
        this.frame = frame;
        this.conta = conta;
        initMenuComponents();
    }

    // Construtor que aceita apenas frame (para uso no login inicial)
    public MenuPanel(UrubudopixGUI frame) {
        super();
        this.frame = frame;
        this.conta = null;
        initMenuComponents();
    }

    private void initMenuComponents() {
        // Botão Ver Conta
        jButton1.addActionListener(e -> {
            if (conta != null) {
                frame.trocarPainel(new InfoContaPanel(frame, conta));
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Nenhuma conta selecionada!", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        // Configurar botão Transações
        jButton2.addActionListener(e -> {
            if (conta != null) {
                String[] opcoes = {"Depositar", "Sacar", "Cancelar"};
                int escolha = JOptionPane.showOptionDialog(this,
                    "Escolha a operação:",
                    "Transações",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

                switch (escolha) {
                    case 0: // Depositar
                        String valorDep = JOptionPane.showInputDialog("Valor para depósito:");
                        try {
                            double quantia = Double.parseDouble(valorDep);
                            conta.depositar(quantia);
                            JOptionPane.showMessageDialog(this, 
                                "Depósito realizado!\nNovo saldo: R$" + conta.getSaldo());
                            atualizarPainel();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Valor inválido!");
                        }
                        break;

                    case 1: // Sacar
                        String valorSaq = JOptionPane.showInputDialog("Valor para saque:");
                        try {
                            double quantia = Double.parseDouble(valorSaq);
                            conta.sacar(quantia);
                            JOptionPane.showMessageDialog(this, 
                                "Saque realizado!\nNovo saldo: R$" + conta.getSaldo());
                            atualizarPainel();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Valor inválido!");
                        }
                        break;
                }
            }
        });

        // Configurar botão Extrato
        jButton3.addActionListener(e -> {
            if (conta != null) {
                StringBuilder extrato = new StringBuilder();
                extrato.append("EXTRATO DA CONTA\n\n");
                extrato.append("Número da conta: ").append(conta.getNumConta()).append("\n");
                extrato.append("Titular: ").append(conta.getDono().getNome()).append("\n");
                extrato.append("Tipo: ").append(conta.getTipo()).append("\n");
                extrato.append("Saldo atual: R$").append(String.format("%.2f", conta.getSaldo()));

                JOptionPane.showMessageDialog(this, 
                    extrato.toString(), 
                    "Extrato", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Configurar botão Sair
        jButton4.addActionListener(e -> frame.trocarPainel(new LogarPanel(frame)));
    }

    private void atualizarPainel() {
        frame.trocarPainel(new MenuPanel(frame, conta));
    }
}