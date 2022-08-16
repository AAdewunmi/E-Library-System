/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.LibrarianBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    public static int update(LibrarianBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update e_librarian set name=?,email=?,password=?,mobile=? where id=?");
			ps.setString(1,bean.getLibrarianName());
			ps.setString(2,bean.getLibrarianEmail());
			ps.setString(3,bean.getLibrarianPassword());
			ps.setLong(4,bean.getLibrarianMobileNumber());
			ps.setInt(5,bean.getLibrarianID());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
    }
    
    public static List<LibrarianBean> view(){
		List<LibrarianBean> list=new ArrayList<LibrarianBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_librarian");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				LibrarianBean bean=new LibrarianBean();
				bean.setLibrarianID(rs.getInt("id"));
				bean.setLibrarianName(rs.getString("name"));
				bean.setLibrarianEmail(rs.getString("email"));
				bean.setLibrarianPassword(rs.getString("password"));
				bean.setLibrarianMobileNumber(rs.getLong("mobile"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
    
}
