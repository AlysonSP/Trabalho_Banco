package com.mycompany.urubudopix;

/**
 * Representa um cliente do banco, armazenando seus dados pessoais.
 * Os dados do cliente são definidos no momento da criação e não podem ser alterados posteriormente.
 */
public class Cliente {
    private final String nome;
    private final String cpf;
    private final String dataNascimento;
    private final String rg;

    /**
     * Constrói uma nova instância de Cliente.
     *
     * @param nome Nome completo do cliente.
     * @param cpf CPF do cliente.
     * @param dataNascimento Data de nascimento (formato: "dd/MM/yyyy").
     * @param rg RG ou outro documento de identificação.
     */
    public Cliente(String nome, String cpf, String dataNascimento, String rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    @Override
    public String toString() {
        return String.format("Cliente{nome='%s', cpf='%s'}", nome, cpf);
    }
}