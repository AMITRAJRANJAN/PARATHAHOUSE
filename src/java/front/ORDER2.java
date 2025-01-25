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

public class ORDER2 extends HttpServlet
{
    Database DB=new Database();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        processRequest(request, response);
        HttpSession session=request.getSession();
        PrintWriter PW=response.getWriter();
        String quantity=request.getParameter("QUANTITY");
        if(quantity=="")
        {
            RequestDispatcher RD=request.getRequestDispatcher("HOME.jsp");
            RD.forward(request, response);    
        }
        else
        {
                session.setAttribute("QUANTITY",quantity);
                RequestDispatcher RD=request.getRequestDispatcher("ORDER2.jsp");
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
