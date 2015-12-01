package br.edu.kelly.modelo;

import br.edu.kelly.controle.Fila;
import br.edu.kelly.controle.Senha;
import br.edu.kelly.controle.Status;
import br.edu.kelly.controle.TempoAtendimento;
import br.edu.kelly.controle.Tipo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



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
            this.stm.executeUpdate("DROP TABLE IF EXISTS fila_normal");
            this.stm.executeUpdate("DROP TABLE IF EXISTS fila_prioritaria");
            this.stm.executeUpdate("DROP TABLE IF EXISTS fila_fies");
            
            this.stm.executeUpdate("DROP TABLE IF EXISTS tempo_atendimento");
            
            this.stm.executeUpdate("CREATE TABLE fila_normal(codigo VARCHAR(15) primary key, chegada VARCHAR(15), atendimento VARCHAR(15), status_atendimento VARCHAR(20), tipo_senha VARCHAR(20));");
            this.stm.executeUpdate("CREATE TABLE fila_prioritaria(codigo VARCHAR(15) primary key, chegada VARCHAR(15), atendimento VARCHAR(15), status_atendimento VARCHAR(20), tipo_senha VARCHAR(20));");
            this.stm.executeUpdate("CREATE TABLE fila_fies(codigo VARCHAR(15) primary key, chegada VARCHAR(15), atendimento VARCHAR(15), status_atendimento VARCHAR(20), tipo_senha VARCHAR(20));");
            
            this.stm.executeUpdate("CREATE TABLE tempo_atendimento(tipo_atendimento VARCHAR(2) primary key, tempo VARCHAR(5));");

        } catch (SQLException e) {
        }
    }
    
    public String tempoAtendimento(String tipoFila){
        ResultSet rs = null;
        
        try {
            rs = this.stm.executeQuery("SELECT * FROM tempo_atendimento where tipo_atendimento = '"+tipoFila+"';");
            return rs.getString("tempo");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insertTempoAtendimento(TempoAtendimento tempoAtendimento){
        String sql = "INSERT INTO tempo_atendimento(tipo_atendimento, tempo) VALUES(?,?)";
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, ""+tempoAtendimento.getTipo().subSequence(0, 1));
            stm.setString(2, ""+tempoAtendimento.getTempo());
            
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertSenha(Senha senha) {
        String sql;

        try {
            if(senha.getTipo().equals("Fies")){
                sql = "INSERT INTO fila_fies(codigo, chegada, status_atendimento, tipo_senha) VALUES(?,?,?,?)";
            }
            
            else if(senha.getTipo().equals("Normal")){
                sql = "INSERT INTO fila_normal(codigo, chegada, status_atendimento, tipo_senha) VALUES(?,?,?,?)";
            }
            else{
                sql = "INSERT INTO fila_prioritaria(codigo, chegada, status_atendimento, tipo_senha) VALUES(?,?,?,?)";
            }
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

    public Fila getFila(String tipoFila) {
        Fila f = new Fila();
        String select;
        ResultSet rs;
        if(tipoFila.equals("Normal")){
            select = "SELECT * FROM fila_normal";
        }
        else if(tipoFila.equals("Prioritaria")){
            select = "SELECT * FROM fila_prioritaria";
        }
        else{
            select = "SELECT * FROM fila_fies";
        }
        try {
            rs = this.stm.executeQuery(select);

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
