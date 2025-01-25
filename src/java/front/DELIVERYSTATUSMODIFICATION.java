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

public class DELIVERYSTATUSMODIFICATION extends HttpServlet
{
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
        String orderid=request.getParameter("ORDERID");
        String contact=request.getParameter("CONTACT");
        String deliverystatus=request.getParameter("DELIVERYSTATUS");
       
        if(orderid==""||contact==""||deliverystatus=="")
        {
            PW.println("<p id='MESSAGE'>Fields marked with * are mandatory.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("PENDINGDELIVERIES.jsp");
            RD.include(request, response);    
        }
        else
        {
                int id=Integer.parseInt(orderid);
                try
                {
                    Statement st=DB.databaseconnection();
                    st.executeUpdate("Update Orderdetail set Deliverystatus='"+deliverystatus+"' where Id="+id+" AND Contact='"+contact+"'");
                    PW.println("<p id='MESSAGE'>Deliverystatus Updated</p>");
                    RequestDispatcher RD=request.getRequestDispatcher("PENDINGDELIVERIES.jsp");
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
