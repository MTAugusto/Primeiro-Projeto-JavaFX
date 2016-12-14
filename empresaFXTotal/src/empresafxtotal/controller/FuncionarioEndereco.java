/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

/**
 *
 * @author mateus
 */
public class FuncionarioEndereco {
    
    private int pk_endereco;
    private int fk_Funcionario;
    
    private String logradouro;    
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    
    

    public FuncionarioEndereco() {
    }

    public FuncionarioEndereco(int pk_endereco, int fk_Funcionario, String logradouro, String bairro, String cidade, String estado, String pais, String cep) {
        this.pk_endereco = pk_endereco;
        this.fk_Funcionario = fk_Funcionario;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }

    public FuncionarioEndereco(int fk_Funcionario, String logradouro, String bairro, String cidade, String estado, String pais, String cep) {
        this.fk_Funcionario = fk_Funcionario;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }

    public int getPk_endereco() {
        return pk_endereco;
    }

    public int getFk_Funcionario() {
        return fk_Funcionario;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    public String getCep() {
        return cep;
    }

    public void setPk_endereco(int pk_endereco) {
        this.pk_endereco = pk_endereco;
    }

    public void setFk_Funcionario(int fk_Funcionario) {
        this.fk_Funcionario = fk_Funcionario;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "FuncionarioEndereco{" + "pk_endereco=" + pk_endereco + ", fk_Funcionario=" + fk_Funcionario + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + ", cep=" + cep + '}';
    }
    
    
    
}
