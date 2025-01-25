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


public class RESETPASSWORD extends HttpServlet
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
       String password=request.getParameter("PASSWORD");
       String confirmpassword=request.getParameter("CONFIRMPASSWORD");
       if(password.equals(null)||confirmpassword.equals(null))
       {
           PW.println("<p id='MESSAGE'>Fields marked with * are mandatory</p>");
           RequestDispatcher RD=request.getRequestDispatcher("RESETPASSWORD.jsp");
           RD.include(request, response);
       }
       else if(password.equals(confirmpassword))
       {
           String sql="Update Users set Password='"+password+"' where Username='"+RU.username+"'";
           try
            {
                Statement st=DB.databaseconnection();
                st.executeUpdate(sql);
                RequestDispatcher RD=request.getRequestDispatcher("RESETPASSWORDGREETING.html");
                RD.forward(request, response);
            }
            catch(Exception e)
            {
                System.out.println("Exception :"+e);
            }
       }
       else
       {
           PW.println("<p id='MESSAGE'>Password field and Confirm password field should not differ.</p>");
           RequestDispatcher RD=request.getRequestDispatcher("RESETPASSWORD.jsp");
           RD.include(request, response);
       }
    }

    public String getServletInfo()
    {
        return "Short description";
    }
}

