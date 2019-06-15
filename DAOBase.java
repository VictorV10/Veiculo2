
package Banco;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOBase {
       public Connection getConection(){
        String url = "jdbc:postgresql://localhost:5432/Veiculos";
        String user = "postgres", pass = "root";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
           ex.printStackTrace();
            System.out.println("Problemas com a conexão de banco");
        }
        return con;
        
    } 
}   

