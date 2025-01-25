package front;

import back.Database;
import back.Newuser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SIGNUP extends HttpServlet
{
    Database DB=new Database();   
    Newuser NU=new Newuser();
    
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
        String name=request.getParameter("NAME");
        String mobile=request.getParameter("MOBILE");
        String email=request.getParameter("EMAIL");
                
        if(name=="" || mobile=="" || email=="")
        {
            PW.println("<p id='MESSAGE'>Fields marked with * are mandatory.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("SIGNUP.jsp");
            RD.include(request, response);
        }
        else
        {
            int nameL=name.length();
            int emailL=email.length();
            int n=name.indexOf(" ");
            int e=email.indexOf("@");
            NU.name=name;
            NU.mobile=mobile;
            NU.email=email;
            NU.username=(name.toLowerCase()).substring(0,n)+email.substring(0,e)+(nameL+emailL);
            RequestDispatcher RD=request.getRequestDispatcher("SIGNUP2.jsp");
            RD.forward(request, response);
            System.out.println("***********   SIGNUP1  ***************");
            System.out.println("NAME:"+NU.name);
            System.out.println("MOBILE"+NU.mobile);
            System.out.println("EMAIL"+NU.email);
        }
    }

    public String getServletInfo()
    {
        return "Short description";
    }
}

