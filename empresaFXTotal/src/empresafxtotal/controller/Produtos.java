/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import empresafxtotal.model.ProdutoDAO;
import java.sql.SQLException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mateus
 */
public class Produtos {
    
    private int pk_produto;
    private String nome;
    private int estoque_minimo;
    private int qtd_estoque;       

    public Produtos() {
    }
    
    public Produtos(String nome, int qtd_estoque) {
        this.nome = nome;
        this.qtd_estoque = qtd_estoque;
    }
    
        public Produtos(int pk_produto, String nome, int estoque_minimo, int qtd_estoque) {
        this.pk_produto = pk_produto;
        this.nome = nome;
        this.estoque_minimo = estoque_minimo;
        this.qtd_estoque = qtd_estoque;
    }

    public Produtos(String nome, int estoque_minimo, int qtd_estoque) {
        this.nome = nome;
        this.estoque_minimo = estoque_minimo;
        this.qtd_estoque = qtd_estoque;
    }
       

    /**
     * @return the pk_produto
     */
    public int getPk_produto() {
        return pk_produto;
    }

    /**
     * @param pk_produto the pk_produto to set
     */
    public void setPk_produto(int pk_produto) {
        this.pk_produto = pk_produto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the estoque_minimo
     */
    public int getEstoque_minimo() {
        return estoque_minimo;
    }

    /**
     * @param estoque_minimo the estoque_minimo to set
     */
    public void setEstoque_minimo(int estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    /**
     * @return the qtd_estoque
     */
    public int getQtd_estoque() {
        return qtd_estoque;
    }

    /**
     * @param qtd_estoque the qtd_estoque to set
     */
    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    @Override
    public String toString() {
        return nome;
    }
    
        public void save() throws SQLException{
        ProdutoDAO.create(this);
    }
    
    public void update() throws SQLException{
       //
        
    }
    
}
