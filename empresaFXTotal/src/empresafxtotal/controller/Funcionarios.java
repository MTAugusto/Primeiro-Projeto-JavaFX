/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import empresafxtotal.model.FuncionarioDAO;
import java.sql.SQLException;

/**
 *
 * @author mateus
 */
public class Funcionarios {
    private int pk_funcionario;
    private String nome;
    private String CPF;
    
    private Cargos Pk_cargo;
    private FuncionarioEndereco funcEndereco;
    
    public Funcionarios(){
        
    }

    
    
    public FuncionarioEndereco getFuncEndereco() {
        return funcEndereco;
    }

    public void setFuncEndereco(FuncionarioEndereco funcEndereco) {
        this.funcEndereco = funcEndereco;
    }

    public Funcionarios(int pk_funcionario, String nome, String CPF) {
        this.pk_funcionario = pk_funcionario;
        this.nome = nome;
        this.CPF = CPF;
    }   
    
    public Funcionarios(String nome, String cpf){
        this.nome = nome;
        this.CPF = cpf;
    }
    
    public Funcionarios(int pk_funcionario, String nome, String cpf, Cargos cargo , FuncionarioEndereco funcEndereco){
        this.pk_funcionario = pk_funcionario;
        this.nome = nome;
        this.CPF = cpf;
        this.Pk_cargo = cargo;
        this.funcEndereco = funcEndereco;
        
    }
    
    public int getPk_funcionario(){
        return pk_funcionario;
    }
    
    public void setPk_funcionario(int pk_funcionario){
        this.pk_funcionario = pk_funcionario;
        this.funcEndereco.setFk_Funcionario(pk_funcionario);
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        if(nome.length()<=80){
            this.nome = nome;
        }else {
            throw new RuntimeException("Tamanho maximo 80 caracteres");
            
        }
    }
    
    public String getCPF(){
        return CPF;
    }
    
    public void setCPF(String cpf){
        this.CPF = cpf;
    }
    
    public Cargos getCargo(){
        return Pk_cargo;
    }
    public void setCargo(Cargos cargo){
        this.Pk_cargo = cargo;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    public void save() throws SQLException{
        FuncionarioDAO.create(this);
    }
    public void update() throws SQLException{
        //
    }
}
