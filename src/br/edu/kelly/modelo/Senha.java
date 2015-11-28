
package br.edu.kelly.modelo;

import java.util.Date;

public class Senha {
    private final String codigo;
    private final Date horaChegada;
    private Date horaAtendimento;
    private Tipo tipo;
    private Status status;
    
    public String getCodigo(){
        return codigo;
    }
   

    public void setHoraAtendimento(Date horaAtendimento){
        this.horaAtendimento=horaAtendimento; 
    }

    public void setStatus(Status status){
        this.status=status;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public Senha(Date horaChegada, Tipo t, int tamanhoDaFila){
        int numero;
        this.horaChegada=horaChegada;
        this.tipo = t;
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
    
    public void resetSenhas(){
       // numero = 1;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
       
}