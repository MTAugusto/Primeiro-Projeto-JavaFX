/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.model;

import empresafxtotal.controller.Cargos;
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
public class CargosDao {

    private CargosDao(){
}
    public static int create(Cargos c) throws SQLException{
        
        Statement stm = 
                BancoDados.createConnection().createStatement();
        
        String sql =
                "insert into cargos(nome,descricao) values('"+
                        c.getNome()+"','"+
                        c.getDescricao()+"')";
        
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        c.setPk_cargo(key);
        
        return key;
        
    }
    public static Cargos retreave(int pk_cargo){
        try{
            Statement stm =
                    BancoDados.createConnection()
                    .createStatement();
            String sql = "select * from cargos where pk_cargo ="+ pk_cargo;
            
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return new Cargos(pk_cargo,rs.getString("nome"),rs.getString("descricao"));
        }catch (SQLException ex){
            Logger.getLogger(CargosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static ArrayList<Cargos> retreaveAll(){
        try{
            Statement stm =
                    BancoDados.createConnection().createStatement();
            
            String sql = "select * from cargos";
            
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Cargos> cs = new ArrayList<>();
            while (rs.next()){                
                cs.add(new Cargos(
                        rs.getInt("pk_cargo"),
                        rs.getString("nome"),
                        rs.getString("descricao")));
            }
            return cs;
        }catch (SQLException ex){
            Logger.getLogger(CargosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}