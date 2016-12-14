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
public class VendaItem {
    private int fkVenda;
    private int pkVendaItem;
    private int qtd;
    private float valorUnitario;
    private Produtos produto;    
    private float valortotal;
    public VendaItem() {
    }

    public VendaItem(int fkVenda, float valortotal) {
        this.fkVenda = fkVenda;
        this.valortotal = valortotal;
    }

    public float getValortotal() {
        return valortotal;
    }

    public void setValortotal(float valortotal) {
        this.valortotal = valortotal;
    }   
    
    public VendaItem(Produtos name, int qtd){
        this.produto = name;
        this.qtd = qtd;
    }
    
    public VendaItem(int qtd, float valorUnitario, Produtos produto) {
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.produto = produto;
    }

     public VendaItem(int pkVendaItem,int fkVenda, Produtos produto,  int qtd, float valorUnitario) {
         this.pkVendaItem = pkVendaItem;
         this.fkVenda = fkVenda; 
         this.produto = produto;
         this.qtd = qtd;
         this.valorUnitario = valorUnitario;
        
        
               
    }
    
    
    public VendaItem(int pkVendaItem , Produtos produto, int fkVenda, int qtd, float valorUnitario) {
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.produto = produto;
        this.fkVenda = fkVenda;
        this.pkVendaItem = pkVendaItem;
    }

    public int getQtd() {
        return qtd;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public Produtos getProduto() {
        return produto;
    }

    public int getFkVenda() {
        return fkVenda;
    }

    public int getPkVendaItem() {
        return pkVendaItem;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public void setFkVenda(int fkVenda) {
        this.fkVenda = fkVenda;
    }

    public void setPkVendaItem(int pkVendaItem) {
        this.pkVendaItem = pkVendaItem;
    }

    @Override
    public String toString() {
        return "VendaItem{" + "qtd=" + qtd + ", valorUnitario=" + valorUnitario + ", produto=" + produto + ", fkVenda=" + fkVenda + ", pkVendaItem=" + pkVendaItem + '}';
    }
    
    
    
}