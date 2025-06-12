package com.mycompany.urubudopix;

/**
 * Classe principal da aplicação Urubu do Pix.
 * Simula operações bancárias para demonstrar as funcionalidades das classes Cliente e ContaBancaria.
 * Toda a saída é exibida no console.
 */
public final class Urubudopix {

    // Construtor privado para prevenir instanciação
    private Urubudopix() {}

    /**
     * Ponto de entrada principal da aplicação.
     */
    public static void main(String[] args) {
        UrubudopixGUI.iniciar();
    }
}