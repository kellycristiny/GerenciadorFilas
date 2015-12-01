/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.kelly.controle;

/**
 *
 * @author Luiz
 */
public class TempoAtendimento {
    private String tipo;
    private double tempo;
    
    public TempoAtendimento(String tipo, double tempo){
        this.tipo = tipo;
        this.tempo = tempo;        
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTempo(double tempo){
        this.tempo = tempo;
    } 
    
    public double getTempo(){
        return tempo;
    }
}
