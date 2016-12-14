/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import empresafxtotal.model.CargosDao;
import empresafxtotal.model.FuncionarioDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mateus
 */
public class FXMLCadastraCargoController implements Initializable {
    
    private Cargos c;

    
    @FXML
    private AnchorPane anchorPaneTelas;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private TextField textFieldCargo;
    
    @FXML
    private TextField textFieldFuncao;
    
    @FXML
    private ComboBox<Cargos> comboBoxCargos;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<Cargos> l = CargosDao.retreaveAll();
        comboBoxCargos.getItems().addAll(l);
                
    }    
    
    
    public void load(){
        c = comboBoxCargos.getValue();
        
        textFieldCargo.setText(c.getNome());
        textFieldFuncao.setText(c.getDescricao());
        
    }
    
    public void limpaTela(){
        textFieldCargo.clear();
        textFieldFuncao.clear();
    }
    
    public void salvar() throws SQLException{
        boolean insert = false;
        if(c == null){
           c= new Cargos();
            insert = true;
        }
        c.setNome(textFieldCargo.getText());
        c.setDescricao(textFieldFuncao.getText());
        
        if(insert){
            c.save();
        }else {
            c.update();
        }
        limpaTela();
    }
    public void cancelar(){
        limpaTela();
    }
}
