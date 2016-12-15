/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import empresafxtotal.model.ClienteDAO;
import empresafxtotal.model.FuncionarioDAO;
import empresafxtotal.model.ProdutoDAO;
import empresafxtotal.model.VendasDAO;
import java.beans.EventHandler;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author mateus
 */
public class FXMLRealizaVendaController implements Initializable {

    Venda v;
    VendaItem vi;

    @FXML
    private TextField TextFieldQuantidade;

    @FXML
    private TextField ValorProd;

    @FXML
    private TextField TextFieldNumero;

    @FXML
    private ComboBox<Cliente> comboBoxCliente;

    @FXML
    private ComboBox<Funcionarios> comboBoxVendedor;

    @FXML
    private ComboBox<Produtos> comboBoxProdutos;

    @FXML
    private TextField TextFieldValorTotal;

    @FXML
    private TableView TableViewProdutos;

    @FXML
    private TableColumn<VendaItem, Integer> TableQuantidade;

    @FXML
    private TableColumn<VendaItem, String> TableProdutos;

    @FXML
    private TableColumn<VendaItem, Float> TableValor;

    private ObservableList<VendaItem> obsprodutos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<Cliente> l = ClienteDAO.retreaveAll();
        comboBoxCliente.getItems().addAll(l);

        List<Funcionarios> lf = FuncionarioDAO.retreaveByVendedor();
        comboBoxVendedor.getItems().addAll(lf);

        List<Produtos> lp = ProdutoDAO.retreaveAll();
        comboBoxProdutos.getItems().addAll(lp);

        try {
            v = VendasDAO.retreabyVendaperNumero();
            TextFieldNumero.setText(String.valueOf(v.getNumeromax()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLRealizaVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        TableQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        TableValor.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        TableProdutos.setCellValueFactory(new PropertyValueFactory<>("produto"));

        TableViewProdutos.setItems(null);
        TableViewProdutos.setItems(obsprodutos);

        TextFieldNumero.setDisable(true);
        TextFieldValorTotal.setDisable(true);

    }

    public void lancar() {

        vi = new VendaItem(Integer.parseInt(TextFieldQuantidade.getText()), Float.parseFloat(ValorProd.getText()), comboBoxProdutos.getValue());
        obsprodutos.add(vi);
        TextFieldQuantidade.clear();
        ValorProd.clear();
        AtualizarValor();

    }

    public void AtualizarValor() {

        double soma = 0;
        for (VendaItem somavalores : obsprodutos) {
            soma += somavalores.getQtd() * somavalores.getValorUnitario();
        }
        TextFieldValorTotal.setText(String.valueOf(soma));
    }

    public void delete() {
        obsprodutos.remove(TableViewProdutos.getSelectionModel().getSelectedItem());
    }

    public void limpaTela() {

        TextFieldQuantidade.clear();
        ValorProd.clear();
        obsprodutos.clear();
        vi = null;
        TextFieldValorTotal.clear();

    }

    public void salvar() throws SQLException {
        boolean insert = false;
        if (v == null) {
            v = new Venda();
            insert = true;
        }

        ArrayList<VendaItem> avi = new ArrayList<>(obsprodutos);

        v.setCliente(comboBoxCliente.getValue());
        v.setData(new Date(System.currentTimeMillis()));
        v.setNumero(v.getNumerodao());
        v.setItens(avi);
        v.setVendedor(comboBoxVendedor.getValue());

        VendasDAO.create(v);
        limpaTela();
    }
}
