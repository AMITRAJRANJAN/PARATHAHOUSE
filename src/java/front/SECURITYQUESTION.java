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


public class SECURITYQUESTION extends HttpServlet
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
        String securityquestion=request.getParameter("SECURITYQUESTION");
        String securityanswer=request.getParameter("SECURITYANSWER");
     
        if(securityquestion=="Select"||securityanswer=="")
        {
            PW.println("<p id='MESSAGE'>Fields marked with * are mandatory.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("SECURITYQUESTION.jsp");
            RD.include(request, response);
        }
        else
        {
            String resetmethod=RU.resetmethod;
            if(resetmethod.equals("FORGOT USERNAME"))
            {
                try
                {
                    Statement st=DB.databaseconnection();
                    ResultSet rs=st.executeQuery("Select * from Users where Mobile='"+RU.mobile+"' AND Email='"+RU.email+"'");
                    
                    if(securityquestion.equals(rs.getString("Securityquestion")) && securityanswer.equals(rs.getString("Securityanswer")))
                    {
                        RU.username=rs.getString("Username");
                        RequestDispatcher RD=request.getRequestDispatcher("FORGOTPASSWORD.jsp");
                        RD.forward(request, response);
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Exception :"+e);
                }
                
            }
            else if(resetmethod.equals("FORGOT PASSWORD"))
            {
                try
                {
                        Statement st=DB.databaseconnection();
                        ResultSet rs=st.executeQuery("Select * from Users where Username='"+RU.username+"'");
                    
                        if(securityquestion.equals(rs.getString("Securityquestion")) && securityanswer.equals(rs.getString("Securityanswer")))
                        {
                            RequestDispatcher RD=request.getRequestDispatcher("FORGOTPASSWORD.jsp");
                            RD.forward(request, response);
                        }
                }
                catch(Exception e)
                {
                    System.out.println("Exception :"+e);
                }
                
            }
            
            RequestDispatcher RD=request.getRequestDispatcher("FORGOTUSERNAME.jsp");
            RD.include(request, response);
        }
               
    }

    public String getServletInfo()
    {
        return "Short description";
    }
}

