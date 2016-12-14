/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import empresafxtotal.model.CargosDao;
import empresafxtotal.model.FuncionarioDAO;
import java.net.URL;
import java.sql.SQLException;
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
public class FXMLCadastraFuncionarioController implements Initializable {
            
    private Funcionarios f;
    private Cargos c;
    private FuncionarioEndereco fe;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private ComboBox<Funcionarios> comboBoxFuncionarios;
    
    @FXML
    private TextField textFieldNome;
    
    @FXML
    private TextField textFieldCPF;
    
    @FXML
    private TextField textFieldEndereco;

    @FXML
    private TextField textFieldBairro;

    @FXML
    private ComboBox<String> comboBoxEstado;

    @FXML
    private TextField textFieldCidade;

    @FXML
    private ComboBox<String> comboPais;

    @FXML
    private TextField textFieldCEP;
    
    @FXML
    private ComboBox<Cargos> comboBoxInvocaCargos;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxEstado.
                getItems().
                addAll("AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO"
                );
        
        comboPais.getItems().add("Japão");
        comboPais.getItems().add("Coreia");
        comboPais.getItems().add("Alemanha");
        
        List<Cargos> l = CargosDao.retreaveAll();
        comboBoxInvocaCargos.getItems().addAll(l);
        
        List<Funcionarios> lf= FuncionarioDAO.retreaveAll();
        comboBoxFuncionarios.getItems().addAll(lf);
    }  
    
    public void load(){
                
        
        comboBoxInvocaCargos.setValue(f.getCargo());
        textFieldEndereco.setText(f.getFuncEndereco().getLogradouro());
        textFieldBairro.setText(f.getFuncEndereco().getBairro());
        textFieldCEP.setText(f.getFuncEndereco().getCep());
        textFieldCidade.setText(f.getFuncEndereco().getCidade());
        comboBoxEstado.setValue(f.getFuncEndereco().getEstado());
        comboPais.setValue(f.getFuncEndereco().getPais());
        textFieldNome.setText(f.getNome());
        textFieldCPF.setText(f.getCPF());
    }
    public void limpaTela(){
        textFieldBairro.clear();
        textFieldCEP.clear();
        textFieldCPF.clear();
        textFieldCidade.clear();
        textFieldEndereco.clear();
        textFieldNome.clear();    
    }
    public void salvar() throws SQLException{
        boolean insert = false;
        if(f == null){
            f= new Funcionarios();
            fe=new FuncionarioEndereco();
            insert = true;
        }
        c = comboBoxInvocaCargos.getValue();
        f.setCargo(comboBoxInvocaCargos.getValue());
        
        fe.setBairro(textFieldBairro.getText());
        fe.setCep(textFieldCEP.getText());
        fe.setCidade(textFieldCidade.getText());
        fe.setLogradouro(textFieldEndereco.getText());
        fe.setEstado(comboBoxEstado.getValue());
        fe.setPais(comboPais.getValue());
        f.setNome(textFieldNome.getText());
        f.setCPF(textFieldCPF.getText());
        f.setFuncEndereco(fe);
        
        if(insert){
            f.save();
            } else f.update();
        limpaTela();
    }
    
    
    public void cancelar(){
         limpaTela();
    }
    
    
}
