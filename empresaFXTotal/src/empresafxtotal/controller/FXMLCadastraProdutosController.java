/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import empresafxtotal.controller.Produtos;
import empresafxtotal.model.ProdutoDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mateus
 */
public class FXMLCadastraProdutosController implements Initializable {

    private Produtos p;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField textFieldProdutos;

    @FXML
    private TextField textFieldEstoqueMinimo;

    @FXML
    private TextField textFieldQtdEstoque;

    @FXML
    private ComboBox<Produtos> comboBoxProdutos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Produtos> lp = ProdutoDAO.retreaveAll();
        comboBoxProdutos.getItems().addAll(lp);
    }

    public void load() {
        p = comboBoxProdutos.getValue();
        textFieldProdutos.setText(p.getNome());
        textFieldEstoqueMinimo.setText(String.valueOf(p.getEstoque_minimo()));
        textFieldQtdEstoque.setText(String.valueOf(p.getQtd_estoque()));
    }

    public void limpaTela() {
        textFieldProdutos.clear();
        textFieldEstoqueMinimo.clear();
        textFieldQtdEstoque.clear();
        comboBoxProdutos.getSelectionModel().clearSelection();
    }

    public void salvar() throws SQLException {
        boolean insert = false;
        if (p == null) {
            p = new Produtos();
            insert = true;
        }else{
            ProdutoDAO.update(p);
        }
        p.setNome(textFieldProdutos.getText());
        p.setQtd_estoque(Integer.parseInt(textFieldQtdEstoque.getText()));
        p.setEstoque_minimo(Integer.parseInt(textFieldEstoqueMinimo.getText()));
        ProdutoDAO.create(p);
        limpaTela();
    }

  
}
