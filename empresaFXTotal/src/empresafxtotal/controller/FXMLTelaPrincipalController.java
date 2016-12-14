/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author L
 */
public class FXMLTelaPrincipalController implements Initializable {

    @FXML
    private AnchorPane anchorPaneTelas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void abraTelaMantemCliente() throws IOException{
        
        AnchorPane a = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLMantemCliente.fxml"));
        anchorPaneTelas.getChildren().setAll(a);
              
    }
    public void abraTelaCadastraCargo() throws IOException{
        
         AnchorPane b = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLCadastraCargo.fxml"));
         anchorPaneTelas.getChildren().setAll(b);
    }
    
     public void abraTelaCadastraFuncionario() throws IOException{
        
         AnchorPane c = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLCadastraFuncionario.fxml"));
         anchorPaneTelas.getChildren().setAll(c);
    }
     
     public void abraTelaCadastraProdutos() throws IOException{
        
         AnchorPane p = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLCadastraProdutos.fxml"));
         anchorPaneTelas.getChildren().setAll(p);
    }
     
     
      public void abraTelaRealizaVenda() throws IOException{
        
         AnchorPane v = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLRealizaVenda.fxml"));
         anchorPaneTelas.getChildren().setAll(v);
    }
    
}
