/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.model;

import empresafxtotal.controller.Cargos;
import empresafxtotal.controller.FuncionarioEndereco;
import empresafxtotal.controller.Funcionarios;
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
public class FuncionarioDAO {
   
    
    public static int create(Funcionarios f) throws SQLException{
        Statement stm = 
                BancoDados.createConnection().createStatement();
        
        String sql = "insert into funcionarios(fk_cargo, nome, cpf) values("
                +f.getCargo().getPk_cargo() +",'" 
                +f.getNome() + "','"
                +f.getCPF()+"')";
        System.out.println(sql);
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        f.setPk_funcionario(key);
        FuncionarioEnderecoDAO.create(f.getFuncEndereco());
        
        return key;
}

public static Funcionarios retreave(int pk_funcionario){
    
    try{
        Statement stm =
            BancoDados.createConnection().createStatement();
            String sql = "select * from funcionarios where pk_cargo ="+pk_funcionario;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            Cargos c = CargosDao.retreave(rs.getInt("fk_cargo"));
            FuncionarioEndereco fe= FuncionarioEnderecoDAO.retreavebyFuncionario(pk_funcionario);
            
            return new Funcionarios(
                    rs.getInt("pk_funcionario"),
                    rs.getString("nome"),
                    rs.getString("CPF"),                    
                    c,fe);
        }catch(SQLException ex){
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
               return null;
    
}
   public static Funcionarios retreaveByFuncionario(int fk_funcionario){
            try{
                Statement stm=
                BancoDados.createConnection().
                           createStatement();
                
                String sql = "select * from funcionario where pk_funcionario = "+fk_funcionario;
                ResultSet rs = stm.executeQuery(sql);
                if(rs.next()){
                 
                Cargos c = CargosDao.retreave(rs.getInt("fk_cargo"));
                FuncionarioEndereco fe= FuncionarioEnderecoDAO.retreavebyFuncionario(rs.getInt("pk_funcionario"));
                return new Funcionarios(
                    rs.getInt("pk_funcionario"),
                    rs.getString("nome"),
                    rs.getString("CPF"),                    
                    c,fe);
                }
            }catch (SQLException ex){
                        Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null , ex);
                }
        return null;
}
   public static ArrayList<Funcionarios> retreaveByVendedor(){
       try{
       Statement stm=
               BancoDados.createConnection().createStatement();
       String sql = "select * from funcionarios where fk_cargo = 1";
       ResultSet rs = stm.executeQuery(sql);
       
       ArrayList<Funcionarios> f = new ArrayList<>();
       
       while (rs.next()){
           
       f.add(new Funcionarios(   
                    rs.getInt("pk_funcionario"),
                    rs.getString("nome"),
                    rs.getString("CPF")));
                }                     
           return f;
       }catch(SQLException ex){
           Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
       
   }  
   
   
   
    public static ArrayList<Funcionarios> retreaveAll(){
        try {
            Statement stm =
                    BancoDados.createConnection().
                                createStatement();
                    String sql = "Select * from Funcionarios";
                    ResultSet rs = stm.executeQuery(sql);
                    
                    ArrayList<Funcionarios> f = new ArrayList<>();
                    
                    while (rs.next()){
                    Cargos c = CargosDao.retreave(rs.getInt("fk_cargo"));
                    FuncionarioEndereco fe= FuncionarioEnderecoDAO.retreavebyFuncionario(rs.getInt("pk_funcionario"));
                        f.add(new Funcionarios(
                           rs.getInt("pk_funcionario"),
                    rs.getString("nome"),
                    rs.getString("CPF"),                    
                    c,fe));
           }
                return f;
        }catch (SQLException ex){
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return null;
}
     public static void delete(Funcionarios f){
            try {
                    Statement stm = 
                                    BancoDados.createConnection().
                                    createStatement();
                    String sql = "delete from funcionario where pk_funcionario="
                    + f.getPk_funcionario();
                    System.out.println(sql);
                }catch (SQLException ex){
                        Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE , null, ex);
                        
}   
}
    public static void update(Funcionarios f){
            try{
                Statement stm=
                    BancoDados.createConnection().
                    createStatement();
            String sql = "update funcionarios set"+
                          "nome='"+f.getNome()+
                          "',cpf='"+f.getCPF()
                          +"'where pk_funcionario ="+f.getPk_funcionario();
                          System.out.println(sql);
                          stm.execute(sql);
                }catch (SQLException ex){
                            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
}
}
}




