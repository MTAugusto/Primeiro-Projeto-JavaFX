/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import empresafxtotal.model.CargosDao;
import java.sql.SQLException;

/**
 *
 * @author mateus
 */
public class Cargos {
    private int pk_cargo;
    private String nome;
    private String descricao;
    
    //private Funcionario funcionario;// associação
    public Cargos(){
    
}


    public Cargos(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;                
    }
    
    public Cargos(int pk_cargo, String nome, String descricao){
        this.pk_cargo = pk_cargo;
        this.nome = nome;
        this.descricao = descricao;        
    }

    
    public int getPk_cargo(){
        return pk_cargo;
    }
    
    public void setPk_cargo(int pk_cargo){
        this.pk_cargo = pk_cargo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        if(nome.length()<=80){
        this.nome = nome;
       } else{
            throw new RuntimeException("Tamanho maximo é de 80 caracteres");
        }
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    
    public void save() throws SQLException{
        CargosDao.create(this);
    }
    
    public void update() throws SQLException{
        //
    }
}
