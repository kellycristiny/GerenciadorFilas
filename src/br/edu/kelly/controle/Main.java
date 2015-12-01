package br.edu.kelly.controle;

import br.edu.kelly.visao.Tela01GUI;
import br.edu.kelly.modelo.ConexaoSqlite;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tipo n = new Tipo("Normal");
        Tipo p = new Tipo("Prioritaria");
        Tipo f = new Tipo("Fies");
        
        Fila filaNormal = new Fila(n);
        Fila filaPreferencial = new Fila(p);
        Fila filaFies = new Fila(f);
        java.util.Date dataUtil = new java.util.Date(System.currentTimeMillis());  
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());  
        
        
        Status status = new Status("Em espera");
        Senha s1 = new Senha( dataSql ,n ,filaNormal.tamanhoDaFila(), status);
        s1.setStatus(status);
        filaNormal.adicionarNaFila(s1);
        
        
        dataUtil = new java.util.Date(System.currentTimeMillis());  
        dataSql = new java.sql.Date(dataUtil.getTime());
        
        Senha s2 = new Senha( dataSql,p ,filaPreferencial.tamanhoDaFila(), status);
        s2.setStatus(status);
        filaPreferencial.adicionarNaFila(s2);
        
        
               
        dataUtil = new java.util.Date(System.currentTimeMillis());  
        dataSql = new java.sql.Date(dataUtil.getTime());
        
        Senha s3 = new Senha(dataSql,f ,filaFies.tamanhoDaFila(), status);
        s3.setStatus(status);
        filaFies.adicionarNaFila(s3);
        
        dataUtil = new java.util.Date(System.currentTimeMillis());  
        dataSql = new java.sql.Date(dataUtil.getTime());
        
        Senha s4 = new Senha(dataSql,f ,filaFies.tamanhoDaFila(), status);
        s4.setStatus(status);
        filaFies.adicionarNaFila(s4);
        
     
        
        /**  Teste
        System.out.println(s1.getCodigo());
        System.out.println(s2.getCodigo());
        System.out.println(s3.getCodigo());
        System.out.println(s4.getCodigo());
         */
        try {
            ConexaoSqlite con = new ConexaoSqlite("fila_db");
            con.initDB();
            Fila fila;
            con.insertSenha(s2);
            con.insertSenha(s3);
            con.insertSenha(s4);
            
            TempoAtendimento tempoNormal = new TempoAtendimento("N",2);
            TempoAtendimento tempoPrioritaria = new TempoAtendimento("P",1);
            TempoAtendimento tempoFies = new TempoAtendimento("F",8);
            
            con.insertTempoAtendimento(tempoFies);
            con.insertTempoAtendimento(tempoPrioritaria);
            con.insertTempoAtendimento(tempoNormal);
            
            new Tela01GUI().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
