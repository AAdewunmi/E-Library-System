/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author adrianadewunmi
 */
public class DB {
    public static Connection getCon() throws ClassNotFoundException, SQLException{
        
        
        Connection connection;
        
        String userName = "root";
        String userPassword = "abc";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ELibraryDB", userName, userPassword);
        
        return connection;
    
    }
}
