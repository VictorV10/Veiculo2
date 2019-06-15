
package Dao;
import Banco.DAOBase;
import Bean.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DaoMarca extends DAOBase {
   
   public List<String> consultar() {
        Connection con = getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> listaMarca = new ArrayList<String>();
        try {
            String sqlSelect = "select * from modelo";
           ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                String descricao = rs.getString("Descricao");
                //int CodModelo = rs.getInt("CodModelo");
                Marca m = new Marca( descricao);
                listaMarca.add(descricao);
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
      return listaMarca;
  } 
   
}
