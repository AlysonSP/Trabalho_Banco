package com.mycompany.urubudopix;

/**
 * Classe que representa uma conta bancária com operações básicas.
 */
public class ContaBancaria {
    // Atributos
    private int numConta;         // Número da conta
    private String tipo;          // Tipo da conta (CC ou CP)
    private Cliente dono;          // Nome do proprietário
    private double saldo;         // Saldo atual
    private boolean status;       // Status da conta (aberta ou fechada)

    // Construtor
    public ContaBancaria(int numConta, String tipo, Cliente dono) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.dono = dono;
        this.saldo = 0.0;
        this.status = false; // Conta começa fechada
    }

    // Métodos de acesso (getters)
    public int getNumConta() {
        return numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean getStatus() {
        return status;
    }

    // Métodos de operação

    // Abrir conta
    public void abrirConta() {
        if (!status) {
            status = true;
            if (tipo.equalsIgnoreCase("CC")) {
                saldo = 50.0; // Conta Corrente começa com R$50
            } else if (tipo.equalsIgnoreCase("CP")) {
                saldo = 150.0; // Conta Poupança começa com R$150
            }
            System.out.println("Conta aberta com sucesso!");
        } else {
            System.out.println("A conta já está aberta.");
        }
    }

    // Fechar conta
    public void fecharConta() {
        if (status) {
            if (saldo == 0) {
                status = false;
                System.out.println("Conta fechada com sucesso!");
            } else {
                System.out.println("Não é possível fechar a conta. Saldo diferente de zero.");
            }
        } else {
            System.out.println("A conta já está fechada.");
        }
    }

    // Depositar
    public void depositar(double valor) {
        if (status && valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Depósito não realizado. Verifique o status da conta e o valor.");
        }
    }

    // Sacar
    public void sacar(double valor) {
        if (status && valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Saque não realizado. Verifique o status da conta, o valor e o saldo.");
        }
    }

    // Pagar mensalidade
    public void pagarMensal() {
        double valorMensal = 0;
        if (tipo.equalsIgnoreCase("CC")) {
            valorMensal = 12.0;
        } else if (tipo.equalsIgnoreCase("CP")) {
            valorMensal = 20.0;
        }
        if (status && saldo >= valorMensal) {
            saldo -= valorMensal;
            System.out.println("Mensalidade paga. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Não foi possível pagar a mensalidade.");
        }
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    protected javax.swing.JTextField jTextField1;
    protected javax.swing.JTextField jTextField2;

    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "123.456.789-00", "Rua A, 123");
        ContaBancaria conta = new ContaBancaria(
            (int)(Math.random() * 10000),
            "CC",
            cliente // agora é o objeto Cliente, não apenas o nome
        );

        conta.abrirConta();
        conta.depositar(100);
        conta.sacar(50);
        conta.pagarMensal();
        conta.fecharConta();
    }
}