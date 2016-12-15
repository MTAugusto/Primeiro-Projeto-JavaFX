/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.model;


import empresafxtotal.controller.Produtos;
import empresafxtotal.model.BancoDados;
import empresafxtotal.model.ClienteDAO;
import empresafxtotal.model.EnderecoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    
    private ProdutoDAO() {
        
    }
    
    public static int create(Produtos produto) {
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            //
            String sql = "insert into produtos (nome,estoque_minimo, qtd_estoque) values('" + produto.getNome() + "','" 
                    + produto.getEstoque_minimo() + "','"
                    + produto.getQtd_estoque() + "')";
            
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();//
            int key = rs.getInt(1); //retorna o id gravado no banco
            produto.setPk_produto(key);//guardamos o id salvo no banco na variavel setPk_cliente.
            
            return key;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static Produtos retreave(int pk_produto) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                    createStatement();
            
            String sql = "Select * from produtos where pk_produto=" + pk_produto;
            
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            
            return new Produtos(rs.getInt("pk_produto"), rs.getString("nome"), rs.getInt("estoque_minimo"), rs.getInt("qtd_estoque"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void delete(Produtos p) {
        
        try {
            Statement stm
                    = BancoDados.createConnection().
                    createStatement();
            String sql = "delete from produtos where pk_enderenco=" + p.getPk_produto();
            
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ArrayList<Produtos> retreaveAll() {
        try {
            Statement stm
                    = BancoDados.createConnection().
                    createStatement();
            String sql = "Select * from produtos";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Produtos> p = new ArrayList<>();
        while (rs.next())//vamos fazer uma condição para que o next vai andando na tabela ate o final
        {
                
                p.add(new Produtos(
                        rs.getInt("pk_produto"),
                        rs.getString("nome"),
                        rs.getInt("estoque_minimo"),
                        rs.getInt("qtd_estoque")));
            }
            
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static Produtos retreavebyProduto(int fk_produto){
        
        try{
            Statement stm =
                    BancoDados.createConnection().
                    createStatement();
            String sql = "select * from produtos where pk_produto="+fk_produto;
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                return new Produtos(
                rs.getInt("pk_produto"),
                        rs.getString("nome"),
                        rs.getInt("estoque_minimo"),
                        rs.getInt("qtd_estoque"));                               
                                                
            }
        }catch (SQLException ex){
                        Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
        return null;
           
        }
            
    
    public static void update(Produtos p) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                    createStatement();
            String sql = "update  produtos set " + "nome=" + p.getNome() + ",estoque_minimo=" + p.getEstoque_minimo()
                    + ",qtd_estoque" + p.getQtd_estoque() + "where=" + p.getPk_produto();
            
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
