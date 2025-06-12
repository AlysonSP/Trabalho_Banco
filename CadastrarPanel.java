package com.mycompany.urubudopix;

import javax.swing.JOptionPane;

public class CadastrarPanel extends Cadastrar {
    private final UrubudopixGUI frame;

    public CadastrarPanel(UrubudopixGUI frame) {
        super(); // Chama o construtor da classe pai primeiro
        this.frame = frame;

        // Configurar botão Criar Conta
        jButton1.addActionListener(e -> {
            try {
                String nome = jTextField1.getText();
                String email = jTextField2.getText();
                String telefone = jTextField3.getText();
                String senha = jTextField4.getText();
                String confirmaSenha = jTextField5.getText();

                // Validações
                if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                        "Preencha todos os campos obrigatórios!", 
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!senha.equals(confirmaSenha)) {
                    JOptionPane.showMessageDialog(this,
                        "As senhas não conferem!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Criar cliente e conta
                Cliente novoCliente = new Cliente(nome, email, telefone, senha);
                ContaBancaria novaConta = new ContaBancaria(
                    (int)(Math.random() * 10000),
                    "CC",
                    novoCliente
                );
                novaConta.abrirConta();

                // Salvar em memória
                BancoMemoria.clientes.add(novoCliente);
                BancoMemoria.contas.add(novaConta);

                JOptionPane.showMessageDialog(this,
                    "Conta criada com sucesso!\nNúmero: " + novaConta.getNumConta());
                
                // Ir para o menu passando a conta criadaa
                frame.trocarPainel(new MenuPanel(frame, novaConta));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        // Configurar botão Voltar
        jButton2.addActionListener(e -> frame.trocarPainel(new LogarPanel(frame)));
    }
}