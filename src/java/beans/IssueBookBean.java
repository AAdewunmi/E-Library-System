/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package beans;

import java.sql.Date;

/**
 *
 * @author adrianadewunmi
 */
public class IssueBookBean {

    private String callno, studentid, studentname;
    private long studentmobile;
    private Date issuedate;
    private String returnstatus;

    public IssueBookBean() {
    }

    public IssueBookBean(String callno, String studentid, String studentname, long studentmobile) {
        this.callno = callno;
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentmobile = studentmobile;
    }

    public String getCallno() {
        return callno;
    }

    public void setCallno(String callno) {
        this.callno = callno;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public long getStudentmobile() {
        return studentmobile;
    }

    public void setStudentmobile(long studentmobile) {
        this.studentmobile = studentmobile;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public String getReturnstatus() {
        return returnstatus;
    }

    public void setReturnstatus(String returnstatus) {
        this.returnstatus = returnstatus;
    }
    
    
    
}
