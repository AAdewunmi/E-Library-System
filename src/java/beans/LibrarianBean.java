/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package beans;

/**
 *
 * @author adrianadewunmi
 */
public class LibrarianBean {
    
    private int librarianID;
    private String librarianName, librarianEmail, librarianPassword;
    private long librarianMobileNumber;

    public LibrarianBean() {
    }

    public LibrarianBean(int librarianID, String librarianName, String librarianEmail, String librarianPassword, long librarianMobileNumber) {
        this.librarianID = librarianID;
        this.librarianName = librarianName;
        this.librarianEmail = librarianEmail;
        this.librarianPassword = librarianPassword;
        this.librarianMobileNumber = librarianMobileNumber;
    }

    public LibrarianBean(String librarianName, String librarianEmail, String librarianPassword, long librarianMobileNumber) {
        this.librarianName = librarianName;
        this.librarianEmail = librarianEmail;
        this.librarianPassword = librarianPassword;
        this.librarianMobileNumber = librarianMobileNumber;
    }

    public int getLibrarianID() {
        return librarianID;
    }

    public void setLibrarianID(int librarianID) {
        this.librarianID = librarianID;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getLibrarianEmail() {
        return librarianEmail;
    }

    public void setLibrarianEmail(String librarianEmail) {
        this.librarianEmail = librarianEmail;
    }

    public String getLibrarianPassword() {
        return librarianPassword;
    }

    public void setLibrarianPassword(String librarianPassword) {
        this.librarianPassword = librarianPassword;
    }

    public long getLibrarianMobileNumber() {
        return librarianMobileNumber;
    }

    public void setLibrarianMobileNumber(long librarianMobileNumber) {
        this.librarianMobileNumber = librarianMobileNumber;
    }
    
}
