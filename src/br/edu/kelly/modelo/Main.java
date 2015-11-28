package br.edu.kelly.modelo;

import br.edu.kelly.telas.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tipo n = new Tipo("Normal");
        Tipo p = new Tipo("Preferencial");
        Tipo f = new Tipo("Fies");
        
        Fila filaNormal = new Fila(n);
        Fila filaPreferencial = new Fila(p);
        Fila filaFies = new Fila(f);
        
        Senha s1 = new Senha(new java.util.Date(System.currentTimeMillis()),n,filaNormal.tamanhoDaFila());
        filaNormal.adicionarNaFila(s1);
        
        Senha s2 = new Senha(new java.util.Date(System.currentTimeMillis()),p,filaPreferencial.tamanhoDaFila());
        filaPreferencial.adicionarNaFila(s2);
        
        Senha s3 = new Senha(new java.util.Date(System.currentTimeMillis()),f, filaFies.tamanhoDaFila());
        filaFies.adicionarNaFila(s3);
        
        Senha s4 = new Senha(new java.util.Date(System.currentTimeMillis()),f, filaFies.tamanhoDaFila());
        filaFies.adicionarNaFila(s4);
        
        /*
        System.out.println(s1.getCodigo());
        System.out.println(s2.getCodigo());
        System.out.println(s3.getCodigo());
        System.out.println(s4.getCodigo());
         */      

        new Tela01GUI(filaNormal,filaPreferencial,filaFies).setVisible(true);
    }
    
}
