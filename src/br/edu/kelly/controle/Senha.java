package br.edu.kelly.controle;

import java.sql.Date;

public class Senha {
    private String codigo;
    private String chegada ;
    private String atendimento;
    private Tipo tipo;
    private Status status;
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public String getChegada(){
        return chegada;
    }
    
    public void setChegada(String chegada){
        this.chegada = chegada;
    }
    
    public String getAtendimento(){
        return atendimento;
    }

    public void setAtendimento(String atendimento){
        this.atendimento = atendimento; 
    }

    public void setStatus(Status status){
        this.status=status;
    }
    
    public String getStatus(){
        return status.getDescricao();
    }
    
    public Senha(Date chegada, Tipo tipo, int tamanhoDaFila, Status status){
        int numero;
        this.chegada=chegada.toString();
        
        this.tipo = tipo;
        this.atendimento = null;
        this.status =  status;
        numero = ++tamanhoDaFila;
        if(numero <10){ 
            String zeros = "00";
            this.codigo = tipo.descricao.subSequence(0, 1)+zeros+numero;
        }
        else if(numero > 10 && numero < 100){
            String zeros = "0";
            this.codigo = tipo.descricao.subSequence(0, 1)+zeros+numero;
        }
        else{
            String zeros = "";
            this.codigo = tipo.descricao.subSequence(0, 1)+""+numero;
        }
    }
    
    public Senha(String codigo, String chegada, Tipo tipo, Status status){
        this.codigo = codigo;
        this.chegada= chegada;
        this.tipo = tipo;
       // this.atendimento = atendimento;
        this.status =  status;
    }
    
    public void resetSenhas(){
       // numero = 1;
    }

    public String getTipo() {
        return tipo.getDescricao();
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
 }