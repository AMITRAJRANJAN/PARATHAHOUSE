package front;

import back.Newuser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SIGNUP2 extends HttpServlet
{
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
        processRequest(request, response);
        PrintWriter PW=response.getWriter();
        String password=request.getParameter("PASSWORD");
        String confirmpassword=request.getParameter("CONFIRMPASSWORD");
        
        if(password=="" || confirmpassword=="")
        {
            PW.println("<p id='MESSAGE'>Fields marked with * are mandatory.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("SIGNUP2.jsp");
            RD.include(request, response);
        }
        else if(password.equals(confirmpassword))
        {
            NU.password=password;
            RequestDispatcher RD=request.getRequestDispatcher("SIGNUP3.jsp");
            RD.forward(request, response);
            System.out.println("***********   SIGNUP2  ***************");
            System.out.println("NAME:"+NU.name);
            System.out.println("MOBILE"+NU.mobile);
            System.out.println("EMAIL"+NU.email);
            System.out.println("USERNAME"+NU.username);
            System.out.println("PASSWORD"+NU.password);
        }
        else
        {
            PW.println("<p id='MESSAGE'>Fields marked with * are mandatory.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("SIGNUP2.jsp");
            RD.include(request, response);
        }
    }

    public String getServletInfo()
    {
        return "Short description";
    }

}
