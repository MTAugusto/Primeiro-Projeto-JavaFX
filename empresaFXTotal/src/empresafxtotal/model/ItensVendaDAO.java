/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.model;

import empresafxtotal.controller.Produtos;
import empresafxtotal.controller.Venda;
import empresafxtotal.controller.VendaItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public class ItensVendaDAO {

    public static int create(VendaItem iv) throws SQLException {

        Statement stm
                = BancoDados.createConnection().createStatement();
        String sql
                = "insert into vendas_itens(fk_venda, fk_produto, qtd , valor_unitario) values("
                + iv.getFkVenda() + ","
                + iv.getProduto().getPk_produto() + ","
                + iv.getQtd() + ","
                + iv.getValorUnitario() + ")";

        System.out.println(sql);
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        iv.setPkVendaItem(key);

        return key;

    }

    public static VendaItem retreave(int pkVenda) throws SQLException {
        Statement stm
                = BancoDados.createConnection().createStatement();
        String sql = "select * from vendas_itens where pk_venda=" + pkVenda;
        System.out.println(pkVenda);
        ResultSet rs = stm.executeQuery(sql);
        rs.next();

        Produtos p = ProdutoDAO.retreave(rs.getInt("fk_produto"));

        return new VendaItem(
                rs.getInt("pk_item"),
                rs.getInt("fk_venda"),
                p,
                rs.getInt("qtd"),
                rs.getFloat("valor_unitario"));

    }

    public static ArrayList<VendaItem> retreaveByVenda(int fk_venda) throws SQLException {

        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        System.out.println(fk_venda);
        String sql = "select * from vendas_itens where fk_venda=" + fk_venda;
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<VendaItem> v = new ArrayList<>();
        while (rs.next()) {

            Produtos p = ProdutoDAO.retreave(rs.getInt("fk_produto"));
            v.add(new VendaItem(
                    rs.getInt("pk_item"),
                    rs.getInt("fk_venda"),
                    p,
                    rs.getInt("qtd"),
                    rs.getFloat("valor_unitario")));
        }

        return v;

    }

    public static ArrayList<VendaItem> retreaveAll() throws SQLException {

        Statement stm
                = BancoDados.createConnection().createStatement();
        String sql = "select * from vendas_itens";
        ResultSet rs = stm.executeQuery(sql);

        ArrayList<VendaItem> v = new ArrayList<>();

        while (rs.next()) {
            Produtos p = ProdutoDAO.retreave(rs.getInt("fk_produto"));
            v.add(new VendaItem(
                    rs.getInt("pk_item"),
                    rs.getInt("fk_venda"),
                    p,
                    rs.getInt("qtd"),
                    rs.getFloat("valor_unitario")));
        }
        return v;

    }

    public static ArrayList<VendaItem> retreavebyValorTotal() throws SQLException {

        Statement stm = BancoDados.createConnection().createStatement();
        String sql = "select fk_venda, sum(valor_unitario) valortotal from vendas_itens"
                + "Group by fk_venda";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<VendaItem> aiv = new ArrayList<>();
        while (rs.next()) {
            aiv.add(new VendaItem(
                    rs.getInt("fk_venda"),
                    rs.getFloat("valortotal")));
        }
        return aiv;
    }

    public static void delete(VendaItem vi) throws Exception {

        Statement stm
                = BancoDados.createConnection().createStatement();
        String sql = "delete from vendas_itens where pk_funcionario="
                + vi.getPkVendaItem();
        System.out.println(sql);

    }

    public static void update(VendaItem vi) throws SQLException {

        Statement stm
                = BancoDados.createConnection().createStatement();
        String sql = "update vendas_itens set"
                + "qtd='" + vi.getQtd()
                + "',valor_unitario" + vi.getValorUnitario();
        System.out.println(sql);
        stm.execute(sql);
    }

}
