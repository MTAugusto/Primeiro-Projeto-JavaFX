/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.model;

import empresafxtotal.controller.FuncionarioEndereco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class FuncionarioEnderecoDAO {
    
    public static int create(FuncionarioEndereco fe) throws SQLException{
        try {
            Statement stm =
                    BancoDados.createConnection().
                    createStatement();
            String sql =
                    "insert into funcionarios_enderecos (fk_funcionario, logadouro, bairro, cidade, estado, pais, cep) values (" +
                    fe.getFk_Funcionario() + ",'" +
                    fe.getLogradouro() +"','"+
                    fe.getBairro() +"','"+
                    fe.getCidade() +"','"+
                    fe.getEstado() +"','"+
                    fe.getPais() +"','"+
                    fe.getCep() +"')";
            System.out.println(sql);    
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            fe.setPk_endereco(key);
            return key;
        
        } catch (SQLException ex){
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null , ex);
        }
        return 0;
    }
    
    public static FuncionarioEndereco retreave(int pkEndereco){
        try {
            Statement stm = 
                    BancoDados.createConnection().
                    createStatement();
            String sql = "Select * from funcionarios_enderecos where pk_endereco="+ pkEndereco;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            
            return new FuncionarioEndereco( rs.getInt("pk_endereco"), 
                    rs.getInt("fk_funcionario"),
                    rs.getString("logadouro"), 
                    rs.getString("bairro"), 
                    rs.getString("cidade"), 
                    rs.getString("estado"), 
                    rs.getString("pais"), 
                    rs.getString("cep") 
                    );
        } catch(SQLException ex){
            Logger.getLogger(FuncionarioEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static FuncionarioEndereco retreavebyFuncionario(int fkFuncionario){
        try{
            Statement stm=
                    BancoDados.createConnection().
                    createStatement();
            
            String sql = "select * from funcionarios_enderecos where fk_funcionario="+ fkFuncionario;
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                return new FuncionarioEndereco(
                    rs.getInt("pk_endereco"), 
                    rs.getInt("fk_funcionario"),
                    rs.getString("logadouro"), 
                    rs.getString("bairro"), 
                    rs.getString("cidade"), 
                    rs.getString("estado"), 
                    rs.getString("pais"), 
                    rs.getString("cep"));
            }
        }   catch(SQLException ex){
            Logger.getLogger(FuncionarioEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return null;
    }
    
    
    public static ArrayList<FuncionarioEndereco> retreaveAll(){
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();
            String sql = "Select * from funcionarios_enderecos";
            ResultSet rs = stm.executeQuery(sql);
            
            ArrayList<FuncionarioEndereco> fe = new ArrayList<>();
            
            while (rs.next()){
                fe.add(new FuncionarioEndereco( rs.getInt("pk_endereco"), 
                    rs.getInt("fk_funcionario"),
                    rs.getString("logadouro"), 
                    rs.getString("bairro"), 
                    rs.getString("cidade"), 
                    rs.getString("estado"), 
                    rs.getString("pais"), 
                    rs.getString("cep")));
            }
            return fe;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;
    }
    
    public static void delete(FuncionarioEndereco fe){

        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();

            String sql = "delete from funcionarios_enderecos where pk_endereco="
                    + fe.getPk_endereco();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void update(FuncionarioEndereco fe){
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();
            //update ... set logradouro = 'Rua tal', bairo = 'kk'
            String sql = "update funcionarios_enderecos set " +
                    "logadouro = '" + fe.getLogradouro() +
                    "',bairro = '" + fe.getBairro() +
                    "',cidade = '" + fe.getCidade() +
                    "',estado = '" + fe.getEstado() +
                    "',pais = '" + fe.getPais() +
                    "',cep = '" + fe.getCep() +
                     "' where pk_endereco=" 
                    + fe.getPk_endereco();
            System.out.println(sql);
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
