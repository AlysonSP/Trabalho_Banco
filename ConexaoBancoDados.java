package com.mycompany.urubudopix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gerencia a conexão com o banco de dados MySQL para a aplicação Urubu do Pix.
 * Implementa o padrão Singleton para garantir uma única instância de conexão.
 * Classe utilitária, não deve ser instanciada.
 */
public final class ConexaoBancoDados {
    private static final String URL = "jdbc:mysql://localhost:3306/urubudopix?sslMode=REQUIRED&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Estudante@1";

    private static Connection connection;

    // Construtor privado para evitar instância
    private ConexaoBancoDados() {}

    /**
     * Obtém uma conexão com o banco de dados MySQL.
     * Se já existir e estiver aberta, retorna a mesma.
     * Caso contrário, cria uma nova conexão.
     *
     * @return Uma instância de {@link Connection} com o banco de dados.
     * @throws RuntimeException se ocorrer erro ao carregar o driver JDBC ou conectar.
     */
    public static Connection getConnection() {
        if (connection == null || isConnectionClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Tentando conectar a: " + URL);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Conexão com o banco de dados obtida com sucesso!");
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC do MySQL não encontrado!");
                throw new RuntimeException("Driver JDBC do MySQL não encontrado", e);
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados:");
                System.err.println("SQLState: " + e.getSQLState());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("Message: " + e.getMessage());
                throw new RuntimeException("Erro ao conectar ao banco de dados", e);
            }
        }
        return connection;
    }

    /**
     * Verifica se a conexão atual está fechada ou nula.
     */
    private static boolean isConnectionClosed() {
        if (connection == null) {
            return true;
        }
        try {
            return connection.isClosed();
        } catch (SQLException e) {
            System.err.println("Erro ao verificar o estado da conexão: " + e.getMessage());
            return true;
        }
    }

    /**
     * Fecha a conexão ativa com o banco de dados, se existir e estiver aberta.
     * Após o fechamento, a variável de conexão é definida como null.
     */
    public static void closeConnection() {
        if (connection != null && !isConnectionClosed()) {
            try {
                connection.close();
                System.out.println("Conexão com o banco de dados fechada.");
                connection = null;
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados.");
            }
        }
    }
}