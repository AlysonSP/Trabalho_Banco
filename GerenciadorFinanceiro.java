package com.mycompany.urubudopix;

/**
 * Classe utilitária para gerenciamento financeiro, como verificação de extratos.

 */
public final class GerenciadorFinanceiro {

    private GerenciadorFinanceiro() {
        // Previne a instanciação
    }

    /**
     * Exibe o extrato detalhado de uma conta bancária no console.
     *
     * @param conta Conta bancária da qual o extrato será exibido.
     */
    public static void verificarExtrato(ContaBancaria conta) {
        if (conta == null) {
            System.out.println("ERRO (GerenciadorFinanceiro): Conta bancária fornecida é nula.");
            return;
        }
        System.out.println("\n--- EXTRATO (via GerenciadorFinanceiro) ---");
        System.out.println("Número da Conta: " + conta.getNumConta());
        Cliente dono = conta.getDono();
        System.out.println("Titular: " + (dono != null ? dono.getNome() : "N/A"));
        System.out.println("Tipo: " + conta.getTipo());
        System.out.println("Status: " + (conta.getStatus() ? "Aberta" : "Fechada"));
        System.out.printf("Saldo Atual: R$ %.2f%n", conta.getSaldo());
        System.out.println("-------------------------------------------\n");
    }
}