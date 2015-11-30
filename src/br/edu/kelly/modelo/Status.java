
package br.edu.kelly.modelo;


public class Status {
  String descricao;
  
  public Status(String s){
      this.descricao = s;
  }
  
  public void setDescricao(String descricao){
      this.descricao = descricao;
  }

  public String getDescricao() {
      return descricao;
  }
}
