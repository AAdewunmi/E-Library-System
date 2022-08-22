/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author adrianadewunmi
 */

import beans.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {
    
    public static int save(BookBean bean){
        int status = 0;
        
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("insert into e_book values(?,?,?,?,?,?)");
            ps.setString(1, bean.getCallno());
            ps.setString(2, bean.getName());
            ps.setString(3, bean.getAuthor());
            ps.setString(4, bean.getPublisher());
            ps.setInt(5, bean.getQuantity());
            ps.setInt(6, 0);
            status = ps.executeUpdate();
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("SAVE ERROR! " + e);
        }
        
        return status;
    }
    
}
