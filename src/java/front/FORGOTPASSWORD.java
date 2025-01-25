package front;

import back.Database;
import back.Newuser;
import back.Resettinguser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FORGOTPASSWORD extends HttpServlet
{
    Resettinguser RU=new Resettinguser();
    Database DB=new Database();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {       
        processRequest(request, response);
        PrintWriter PW=response.getWriter();
        String username=request.getParameter("USERNAME");
        
        if(username==null)
        {
            PW.println("<p id='MESSAGE'>Fields marked with * are mandatory.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("FORGOTPASSWORD.jsp");
            RD.include(request, response);
        }
        else
        {
            try
            {
                Statement st=DB.databaseconnection();
                ResultSet rs=st.executeQuery("Select * from Users where Username='"+username+"'");
                Boolean userrecord=rs.next();
                if(userrecord==false)
                {
                    PW.println("<p id='MESSAGE'>No any existing user found.</p>");
                    RequestDispatcher RD=request.getRequestDispatcher("FORGOTPASSWORD.jsp");
                    RD.include(request, response);
                }
                else if(userrecord==true)
                {
                    RU.username=username;
                    RequestDispatcher RD=request.getRequestDispatcher("SECURITYQUESTION.jsp");
                    RD.include(request, response);
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception :"+e);
            }
        }
    }

    public String getServletInfo()
    {
        return "Short description";
    }
}

