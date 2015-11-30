package br.edu.kelly.conexao;

import br.edu.kelly.modelo.Fila;
import br.edu.kelly.modelo.Senha;
import br.edu.kelly.modelo.Status;
import br.edu.kelly.modelo.Tipo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConexaoSqlite {

    private final Connection conn;
    private final Statement stm;

    public ConexaoSqlite(String arquivo) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:" + arquivo);
        this.stm = this.conn.createStatement();
    }

    public void initDB() {
        try {
            //Remove e cria a tabela a cada execução
            this.stm.executeUpdate("DROP TABLE IF EXISTS senhas");
            this.stm.executeUpdate("CREATE TABLE senhas(id INTEGER primary key AUTOINCREMENT , codigo VARCHAR(15), chegada VARCHAR(15), atendimento VARCHAR(15), status_atendimento VARCHAR(20), tipo_senha VARCHAR(20));");
        } catch (SQLException e) {
        }
    }

    public void insert(Senha senha) {
        String sql = "INSERT INTO senhas(codigo, chegada, status_atendimento, tipo_senha) VALUES(?,?,?,?)";

        try {
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, senha.getCodigo());
            stm.setString(2, senha.getChegada());
            stm.setString(3, senha.getStatus());
            stm.setString(4, senha.getTipo());

            stm.execute();
            stm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Fila getFila() {
        Fila f = new Fila();
        ResultSet rs;
        try {
            rs = this.stm.executeQuery("SELECT * FROM senhas ORDER BY id");

            while (rs.next()) {
                Senha s = new Senha(rs.getString("codigo"), rs.getString("chegada"), new Tipo(rs.getString("tipo_senha")), new Status(rs.getString("status_atendimento")));
                f.adicionarNaFila(s);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }
}
