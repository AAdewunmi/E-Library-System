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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public static List<BookBean> view(){
        List<BookBean> list = new ArrayList<BookBean>();
        
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("select * from e_book");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BookBean bean = new BookBean();
                bean.setCallno(rs.getString("callno"));
                bean.setName(rs.getString("name"));
                bean.setAuthor(rs.getString("author"));
                bean.setPublisher(rs.getString("publisher"));
                bean.setQuantity(rs.getInt("quantity"));
                bean.setIssued(rs.getInt("issued"));
                list.add(bean);
            }
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("VIEW ERROR! " +  e);
        }
        return list;
    }
    
    public static int delete(String callno){
        int status = 0;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("delete from e_book where callno=?");
            ps.setString(1, callno);
            status = ps.executeUpdate();
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("DELETE ERROR! " + e);
        }
        return status;
    }
    
    public static int getIssued(String callno){
        int issued = 0;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("select * from e_book where callno=?");
            ps.setString(1, callno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                issued = rs.getInt("issued");
            }
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("GET ISSUED ERROR! " + e);
        }
        return issued;
    }
    
    public static boolean checkIssue(String callno){
        boolean status = false;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("select * from e_book where callno=? and quantity>issued");
            ps.setString(1, callno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                status = true;
            }
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("CHECK ISSUE ERROR! " + e);
        }
        return status;
    }
    
    public static int issueBook(IssueBookBean bean){
        String callno = bean.getCallno();
        boolean checkstatus = checkIssue(callno);
        System.out.println("Check Status: " + checkstatus);
        if(checkstatus){
            int status = 0;
            try{
                Connection con = DB.getCon();
                PreparedStatement ps = con.prepareStatement("insert into e_issuebook values(?,?,?,?,?,?)");
                ps.setString(1, bean.getCallno());
                ps.setString(2, bean.getStudentid());
                ps.setString(3, bean.getStudentname());
                ps.setLong(4, bean.getStudentmobile());
                java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                ps.setDate(5, currentDate);
                ps.setString(6, "no");
                status = ps.executeUpdate();
                if(status > 0){
                    PreparedStatement ps2 = con.prepareStatement("update e_book set issued=? where callno=?");
                    ps2.setInt(1, getIssued(callno) + 1);
                    ps2.setString(2, callno);
                    status = ps2.executeUpdate();
                }
                con.close();
            }catch(ClassNotFoundException | SQLException e){
                System.out.println("ISSUE BOOK ERROR! " + e);
            }
            return status;
        }else{
            return 0;
        }
    }
    
}
