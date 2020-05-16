
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class DbConnection {

    private Connection connection;

    public Connection connect() throws SQLException {

        if (this.connection == null || this.connection.isClosed()) {     
            
            try {           
                Class.forName("com.mysql.jdbc.Driver");
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eczanesistemi?user=root&password=123");
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return this.connection;
    }
}
