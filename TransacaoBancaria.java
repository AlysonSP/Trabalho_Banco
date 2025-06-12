package com.mycompany.urubudopix;

/**
 * Classe utilitária para realizar transações bancárias básicas como saque e depósito.
 * Todos os métodos são estáticos. Esta classe não deve ser instanciada.
 */
public final class TransacaoBancaria {

    private TransacaoBancaria() {
        // Previne a instanciação
    }

    /**
     * Realiza um saque na conta bancária, delegando para o método da própria conta.
     *
     * @param conta Conta bancária de origem.
     * @param valor Valor a ser sacado.
     */
    public static void sacar(ContaBancaria conta, double valor) {
        if (conta == null) {
            System.out.println("ERRO (TransacaoBancaria): Conta não pode ser nula.");
            return;
        }
        conta.sacar(valor);
    }

    /**
     * Realiza um depósito na conta bancária, delegando para o método da própria conta.
     *
     * @param conta Conta bancária de destino.
     * @param valor Valor a ser depositado.
     */
    public static void depositar(ContaBancaria conta, double valor) {
        if (conta == null) {
            System.out.println("ERRO (TransacaoBancaria): Conta não pode ser nula.");
            return;
        }
        conta.depositar(valor);
    }
}