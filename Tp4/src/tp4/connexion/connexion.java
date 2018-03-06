package tp4.connexion;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class connexion {
	
	static Connection con;
	
	public static Connection connection() {
		if (con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setURL("jdbc:mysql://86.70.218.40:1997/Magasin");
            
            // URL reseau local   data.setURL("jdbc:mysql://192.168.1.66:3306/Magasin");
            
            data.setUser("tibobo");
            data.setPassword("19970805tr");
            
            /*  URL local
            MysqlDataSource data = new MysqlDataSource();
            data.setURL("jdbc:mysql://localhost:3306/test");
            data.setPort(3306);
            data.setDatabaseName("Magasin");  //jdbc:mysql://localhost:3306/test");
            data.setUser("ROOT");
            data.setPassword("");
            */
            
            try {
                con = data.getConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return con;
	}
}
