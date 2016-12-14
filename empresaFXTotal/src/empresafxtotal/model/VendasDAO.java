/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.model;

import empresafxtotal.controller.Cliente;
import empresafxtotal.controller.Funcionarios;
import empresafxtotal.controller.Venda;
import empresafxtotal.controller.VendaItem;
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
public class VendasDAO {
    
        public static int create (Venda v) throws SQLException{
        Statement stm =
                BancoDados.createConnection().createStatement();
        String sql = 
                "insert into vendas(fk_cliente , fk_vendedor, numero, datas) values('"+
                v.getCliente().getPk_cliente()+"','"
                + v.getVendedor().getPk_funcionario()+"','"
                +v.getNumero()+"','"
                +v.getData()+"')";            
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        System.out.println(sql);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        v.setPkVenda(key);          
       System.out.println(key);       
        for(VendaItem item: v.getItens()){  
            item.setFkVenda(key);
            System.out.println(item);                                   
            ItensVendaDAO.create(item);                    
        }
        return key;     
    }
        
       public static Venda retreave(int pk_Venda) throws SQLException{
           try{
               Statement stm=
                       BancoDados.createConnection()
                       .createStatement();
               String sql = "select * from vendas where pk_venda="+pk_Venda;
               
               ResultSet rs = stm.executeQuery(sql);
               rs.next();
               
               ArrayList<VendaItem> vi = ItensVendaDAO.retreaveByVenda(rs.getInt("pk_venda"));
               Cliente c = ClienteDAO.retreave(rs.getInt("fk_cliente"));
               Funcionarios f = FuncionarioDAO.retreave(rs.getInt("fk_funcionario"));
               return new Venda(pk_Venda,
                       rs.getInt("numero"),
                       rs.getDate("datas"),
                       c,
                       f,
                       vi);
           }catch (SQLException ex){
               Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
           return null;
           
       }
       
       public static Venda retreavebyVenda(int fk_venda) throws SQLException{
               Statement stm=
                       BancoDados.createConnection().
                       createStatement();
               String sql = "select * from vendas where pk_venda ="+fk_venda;
               ResultSet rs = stm.executeQuery(sql);
               rs.next();
                 ArrayList<VendaItem> vi = ItensVendaDAO.retreaveByVenda(rs.getInt("pk_venda"));
                 Funcionarios f = FuncionarioDAO.retreave(rs.getInt("fk_vendedor"));
                 Cliente c = ClienteDAO.retreave(rs.getInt("fk_cliente"));
                 return new  Venda(                 
                 rs.getInt("numero"),
                 rs.getDate("data"),
                 c,
                 f
                 );
               
           }
           
           public static ArrayList<Venda> retreaveAll() throws SQLException{
              Statement stm =
                      BancoDados.createConnection().createStatement();              
              String sql = "Select * from vendas";
              ResultSet rs = stm.executeQuery(sql);
              ArrayList<Venda> v = new ArrayList<>(); 
              
              while(rs.next()){ 
                 ArrayList<VendaItem> vi = ItensVendaDAO.retreaveByVenda(rs.getInt("pk_venda"));
                 Funcionarios f = FuncionarioDAO.retreave(rs.getInt("fk_vendedor"));
                 Cliente c = ClienteDAO.retreave(rs.getInt("fk_cliente"));
                 v.add(new Venda(
                 vi,
                 rs.getInt("numero"),
                 rs.getDate("data"),
                 c,
                 f
                 ));
                  
              }
               return v;
           }
           
           public static int retreabynumero() throws SQLException{
               Statement stm= 
                       BancoDados.createConnection().createStatement();
               String sql = "select max(numero) from vendas";
               ResultSet rs = stm.executeQuery(sql);
               rs.next();
               return rs.getInt(1);
           }        
           
//           public static ArrayList<Venda> retreabyVendaperNumero() throws SQLException{
//               Statement stm= 
//                       BancoDados.createConnection().createStatement();
//               String sql = "select * from vendas order By numero desc";
//               ResultSet rs = stm.executeQuery(sql);
//               ArrayList<Venda> av = new ArrayList<>();
//               while (rs.next()){
//               av.add(new Venda(
//               rs.getInt())
//               ))
//           }
//               return rs.getInt(1);
//           }
           
           
           public static void delete(Venda v) throws SQLException{
               
               Statement stm =
                       BancoDados.createConnection().createStatement();
               String sql = "delete from vendas where pk_venda="
                       + v.getPkVenda();
                       System.out.println(sql);                             
           }
           
           public static void update(Venda v) throws SQLException{
               
               Statement stm=
                       BancoDados.createConnection().createStatement();
               String sql = "update vendas set"+
                       "data="+v.getData()+
                       ",numero="+v.getNumero()
                       +" where pk_venda="+v.getPkVenda();
                System.out.println(sql);
                stm.executeQuery(sql);
               
           }
           
}
       

