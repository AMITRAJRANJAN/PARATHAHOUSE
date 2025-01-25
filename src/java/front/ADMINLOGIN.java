package front;

import back.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import back.Database;

public class ADMINLOGIN extends HttpServlet
{
    Database DB=new Database();
    Admin A=new Admin();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {  
        HttpSession session=request.getSession();
        PrintWriter PW=response.getWriter();
        response.setContentType("text/html");
        String username=request.getParameter("USERNAME");
        String password=request.getParameter("PASSWORD");
        
        if(username=="" || password=="")
        {
            PW.println("<p id='MESSAGE'>Fields marked with * is mandatory.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("ADMINLOGIN.jsp");
            RD.include(request, response);
        }
        else
        {
            try
            {
                Statement st=DB.databaseconnection();
                ResultSet rs=st.executeQuery("Select * from Admin where Username='"+username+"' AND Password='"+password+"'");
                Boolean userrecord=rs.next();
                if(userrecord==true)
                {
                    session.setAttribute("ADMINNAME", rs.getString("Name"));
                    session.setAttribute("ADMINUSERNAME",rs.getString("Username"));
                    response.sendRedirect("ADMINPANEL.jsp");
                }
                else if(userrecord==false)
                {
                    PW.println("<p id='MESSAGE'>Unauthorised user.</p>");
                    RequestDispatcher RD=request.getRequestDispatcher("ADMINLOGIN.jsp");
                    RD.include(request, response);
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception "+e);
            }
        }
    }

    public String getServletInfo()
    {
        return "Short description";
    }

}
