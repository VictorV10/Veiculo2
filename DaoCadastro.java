
package Dao;

import Banco.DAOBase;
import Bean.Cadastro;
import Bean.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCadastro extends DAOBase {
     public void incluir(Cadastro cadastro) {
        Connection con = getConection();

        PreparedStatement ps = null;
        //PreparedStatement ps2 = null;
        ResultSet rs = null;

        try {

            //con.setAutoCommit(false);
            String sql = "insert into cadastro (Placa,Renavan,CodC) values (?,?,?)";
            ps = con.prepareStatement(sql);

          
            ps.setString(1, cadastro.getPlaca());
            ps.setLong(2, (long) cadastro.getRenavan());
            ps.setInt(3, cadastro.getModelo().getCodigo());

            ps.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } 
     }
     public void alterar(Cadastro cadastro) {
        Connection con = getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String sql = "update cadastro set placa = ?, renavan=? where CodCadastro = ?";

            ps = con.prepareStatement(sql);

             ps.setString(1, cadastro.getPlaca());
            ps.setLong(2, (long) cadastro.getRenavan());
            ps.setInt(3, cadastro.getCodCadastro());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }
  public void excluir(int CodCadastro) {
        Connection con = getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String sql = "delete from cadastro where CodCadastro = ?";
            ps = con.prepareStatement(sql);
            ps.setLong(1, CodCadastro);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
   }
  public List<Cadastro> consultar() {
        Connection con = getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cadastro> listaCadastro = new ArrayList<Cadastro>();
        try {
            String sqlSelect = " Select c.codCadastro, "
        +" c.Placa,c.Renavan,m.Descricao "
	+" from Modelo as m"	
	+" inner join Cadastro as c "	
        +" on (c.codCadastro = c.codCadastro)";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                int CodCadastro = rs.getInt("CodCadastro");
                String Placa = rs.getString("placa");
                int Renavan = rs.getInt("Renavan");
                String descricao = rs.getString("descricao");
                
                Marca modelo = new Marca(descricao);
                Cadastro cadastro = new Cadastro(CodCadastro,Placa,Renavan,modelo);
                listaCadastro.add(cadastro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return listaCadastro;
    }
  
}
