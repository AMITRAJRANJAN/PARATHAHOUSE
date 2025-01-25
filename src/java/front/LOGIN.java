package front;

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

public class LOGIN extends HttpServlet
{
    Database DB=new Database();
    
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
        processRequest(request, response);
        response.setContentType("text/html");

        HttpSession session=request.getSession();
        PrintWriter PW=response.getWriter();
        String username=request.getParameter("USERNAME");
        String password=request.getParameter("PASSWORD");
                
        
        if(username=="" || password=="")
        {
            PW.println("<p id='MESSAGE'>Fields marked with * is mandatory.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("MAIN.jsp");
            RD.include(request, response);
        }
        else
        {
            try
            {
                Statement st=DB.databaseconnection();
                ResultSet rs=st.executeQuery("Select * from users where Username='"+username+"' AND Password='"+password+"'");
                Boolean userrecord=rs.next();
                if(userrecord==true)
                {
                    session.setAttribute("CURRENTUSER", rs.getString("Name"));
                    session.setAttribute("CURRENTUSERNAME",rs.getString("Username"));
                    response.sendRedirect("HOME.jsp");
                }
                else if(userrecord==false)
                {
                    PW.println("<p id='MESSAGE'>Unauthorised user.</p>");
                    RequestDispatcher RD=request.getRequestDispatcher("MAIN.jsp");
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
