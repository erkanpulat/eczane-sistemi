/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

/**
 *
 * @author user
 */
public abstract class DbConnection {
    private Connection connection;
    
    public Connection connect(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/eczanesistemi?user=root&password=123");                      
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return this.connection;
    }
}
