//teste01
package br.edu.kelly.modelo;

import java.util.ArrayList;

public class Fila { 
    private final ArrayList<Senha> fila = new <Senha>ArrayList();
    private Tipo tipo;
   
    public Fila(){}
    
    public Fila(Tipo tipo){
        this.tipo=tipo;
    } 
    
    public void setTipo(Tipo t){
        this.tipo = t;
    }
    
    public Tipo getTipo(){
        return tipo;
    }
    
    public boolean adicionarNaFila(Senha s){
        //if(s.getTipo().equals(tipo.getDescricao())){
           fila.add(s);
           return true;
        //}
        //return false;
    }
    
    public void removerDaFila(Senha s){
        fila.remove(s);
    }
    public int tamanhoDaFila(){
        return fila.size();
    }
    
    public boolean isVazia(){
       return fila.isEmpty();
    }
    
    public void esvaziarFila(){
        fila.removeAll(fila);
    }
    
    public Senha senhaPesquisada(String s){
        for(Senha senha: fila){
            if(senha.getCodigo().equals(s)){
                return senha;
            }
        }
        return null;
    }
    
    public int qtdSenhasAnteriores(Senha s){
        int qtd=0;
        for(Senha senha: fila){
            if(!senha.getCodigo().equals(s.getCodigo())){
                qtd++;
            }
        }
        return qtd;
    }
}
