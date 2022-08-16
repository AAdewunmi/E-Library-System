/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.LibrarianBean;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author adrianadewunmi
 */
public class LibrarianDao {
    
    public static int save(LibrarianBean bean){
		int status=0;
                
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into e_librarian(id,name,email,password,mobile) values(?,?,?,?,?)");
			ps.setString(1,"1");
                        ps.setString(2,bean.getLibrarianName());
			ps.setString(3,bean.getLibrarianEmail());
			ps.setString(4,bean.getLibrarianPassword());
			ps.setLong(5,bean.getLibrarianMobileNumber());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
    
}
