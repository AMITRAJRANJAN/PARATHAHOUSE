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


public class FORGOT extends HttpServlet
{
    
    Resettinguser RU=new Resettinguser();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        processRequest(request, response);
        PrintWriter PW=response.getWriter();
        String forgot=request.getParameter("FORGOT");
        System.out.println(forgot);
        if(forgot==null)
        {
            PW.println("<p id='MESSAGE'>Please select an option.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("FORGOT.jsp");
            RD.include(request, response);
        }
        else if(forgot.equals("FORGOT USERNAME"))
        {
            RU.resetmethod=forgot;
            RequestDispatcher RD=request.getRequestDispatcher("FORGOTUSERNAME.jsp");
            RD.forward(request, response);
        }
        else if(forgot.equals("FORGOT PASSWORD"))
        {
            RU.resetmethod=forgot;
            RequestDispatcher RD=request.getRequestDispatcher("FORGOTPASSWORD.jsp");
            RD.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {       
        
       
    }

    public String getServletInfo()
    {
        return "Short description";
    }
}

