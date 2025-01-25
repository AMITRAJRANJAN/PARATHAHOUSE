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

public class ORDERCANCELLATION extends HttpServlet
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
        String ordercancellation=request.getParameter("ORDERCANCELLATION");
        System.out.println("1 "+ordercancellation);
       
        if(ordercancellation==null||ordercancellation=="")
        {
            System.out.println("2 "+ordercancellation);
            PW.println("<p id='MESSAGE'>Please select an order.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("ACTIVEORDERS.jsp");
            RD.include(request, response);    
        }
        else
        {
            int i=ordercancellation.indexOf("&");
            int orderid=Integer.parseInt(ordercancellation.substring(0, i));
            String transactiondetail=ordercancellation.substring(i+1);
            System.out.println(orderid);
            System.out.println(transactiondetail);
                try
                {
                    Statement st=DB.databaseconnection();
                    st.executeUpdate("Update Orderdetail set Orderstatus='Canceled' where Id="+orderid+" AND Transactiondetail='"+transactiondetail+"'");
                    PW.println("<p id='MESSAGE'>Orderstatus Updated</p>");
                    RequestDispatcher RD=request.getRequestDispatcher("ACTIVEORDERS.jsp");
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
