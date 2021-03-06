/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import empresafxtotal.model.VendasDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public class Venda {

    private int numero;
    private Date data;
    private Cliente cliente;
    private Funcionarios vendedor;
    private ArrayList<VendaItem> itens;
    private int numeromax;

    private int pkVenda;

    public Venda() {
    }

    public Venda(int numeromax) {
        this.numeromax = numeromax;

    }

    public int getNumeromax() throws SQLException {
        return numeromax + 1;
    }

    public void setNumeromax(int numeromax) {
        this.numeromax = numeromax;
    }

    public Venda(int pkVenda, int numero, Date data, Cliente cliente, Funcionarios vendedor) {
        this.pkVenda = pkVenda;
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;

    }

    public Venda(int numero, Date data, Cliente cliente, Funcionarios vendedor) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public Venda(int pkVenda, int numero, Date data, Cliente cliente, Funcionarios vendedor, ArrayList<VendaItem> itens) {
        this.pkVenda = pkVenda;
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = new ArrayList<>(itens);

    }

    public Venda(ArrayList<VendaItem> itens, int numero, Date data, Cliente cliente, Funcionarios vendedor) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
    }

    public Venda(int numero, Date data, Funcionarios vendedor, ArrayList<VendaItem> itens, int pkVenda) {
        this.numero = numero;
        this.data = data;
        this.vendedor = vendedor;
        this.itens = itens;
        this.pkVenda = pkVenda;
    }

    public void addItem(VendaItem vi) {
        if (itens == null) {
            itens = new ArrayList<>();
        }
        itens.add(vi);
    }

    public int getNumero() {
        return numero;
    }

    public int getNumerodao() throws SQLException {
        return VendasDAO.retreabynumero() + 1;
    }

    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionarios getVendedor() {
        return vendedor;
    }

    public ArrayList<VendaItem> getItens() {
        return itens;
    }

    public int getPkVenda() {
        return pkVenda;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(Funcionarios vendedor) {
        this.vendedor = vendedor;
    }

    public void setItens(ArrayList<VendaItem> itens) {
        this.itens = itens;
    }

    public void setPkVenda(int pkVenda) {
        this.pkVenda = pkVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "numero=" + numero + ", data=" + data + ", cliente=" + cliente + ", vendedor=" + vendedor + ", itens=" + itens + ", pkVenda=" + pkVenda + '}';
    }

}
