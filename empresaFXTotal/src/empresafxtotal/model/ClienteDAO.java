/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.model;

import empresafxtotal.controller.Cliente;
import empresafxtotal.controller.Endereco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author L
 */
public class ClienteDAO {

    private ClienteDAO() {
    }
    
    public static int create(Cliente c) throws SQLException{

            Statement stm =
                    BancoDados.createConnection().
                            createStatement();            
            String sql = 
              "insert into clientes (nome, cpf) values ('" +
                    c.getNome() + "','" +
                    c.getCpf() +"')";
                                
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            c.setPk_cliente(key);
            
            EnderecoDAO.create(c.getEndereco());
            
            return key;
    }
    
    public static Cliente retreave(int pk_cliente){
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();
            
            String sql = "select * from clientes where pk_cliente =" + pk_cliente;
            
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            
            Endereco e = EnderecoDAO.retreaveByCliente(pk_cliente);
            return new Cliente(pk_cliente,
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    e);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
    public static ArrayList<Cliente> retreaveAll(){
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();
            
            String sql = "select * from clientes";
            
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Cliente> cs = new ArrayList<>();
            while (rs.next()){
                Endereco e = EnderecoDAO.retreaveByCliente(rs.getInt("pk_cliente"));
                cs.add(new Cliente(
                        rs.getInt("pk_cliente"), 
                        rs.getString("nome"), 
                        rs.getString("cpf"), 
                        e));
            }
            
            return cs;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
    
    
}
