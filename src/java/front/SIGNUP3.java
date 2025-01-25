package front;

import back.Database;
import back.Newuser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SIGNUP3 extends HttpServlet
{
    Newuser NU=new Newuser();
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
        PrintWriter PW=response.getWriter();
        processRequest(request, response);
        String securityquestion=request.getParameter("SECURITYQUESTION");
        String securityanswer=request.getParameter("SECURITYANSWER");
        
        if(securityquestion=="Select"||securityanswer=="")
        {
            PW.println("<p id='MESSAGE'>Fields marked with * are mandatory.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("SIGNUP3.jsp");
            RD.include(request, response);
        }
        else
        {
  
            NU.securityquestion=securityquestion;
            NU.securityanswer=securityanswer;
            
            String sql="Insert into Users (Name,Username,Password,Securityquestion,Securityanswer,Mobile,Email) values ('"+NU.name+"','"+NU.username+"','"+NU.password+"','"+NU.securityquestion+"','"+NU.securityanswer+"','"+NU.mobile+"','"+NU.email+"');";
            try
            {
                Statement st=DB.databaseconnection();
                st.executeUpdate(sql);
                NU.name="";
                NU.mobile="";
                NU.email="";
                NU.username="";
                NU.password="";
                NU.securityquestion="";
                NU.securityanswer="";
                RequestDispatcher RD=request.getRequestDispatcher("NEWUSERGREETING.html");
                RD.forward(request, response);
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
