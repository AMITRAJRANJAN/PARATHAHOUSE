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

public class ORDERDATA extends HttpServlet
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
        int orderid=Integer.parseInt(session.getAttribute("ORDERID").toString());
        String user=session.getAttribute("CURRENTUSER").toString();
        String username=session.getAttribute("CURRENTUSERNAME").toString();
        String selectedparatha=session.getAttribute("SELECTEDPARATHA").toString();
        int selectedparatharate=Integer.parseInt(session.getAttribute("SELECTEDPARATHARATE").toString());
        int parathaquantity=Integer.parseInt(session.getAttribute("QUANTITY").toString());
        int totalamount=Integer.parseInt(session.getAttribute("TOTALAMOUNT").toString());
        String deliveryaddress=session.getAttribute("DELIVERYADDRESS").toString();
        String pincode=session.getAttribute("PINCODE").toString();
        String contact=session.getAttribute("CONTACT").toString();
        String paymentmode=session.getAttribute("PAYMENTMODE").toString();
        String transactiondetail=request.getParameter("TRANSACTIONDETAIL");
        System.out.println("USERNAME; : "+paymentmode);
        String sql="Insert into Orderdetail values("+orderid+",'"+user+"','"+username+"','"+selectedparatha+"',"+parathaquantity+","+selectedparatharate+","+totalamount+",'"+paymentmode+"','"+transactiondetail+"','Pending','"+deliveryaddress+"',"+pincode+","+contact+",'Pending','Active')";
            try
            {
                Statement st=DB.databaseconnection();
                st.executeUpdate(sql);
                RequestDispatcher RD=request.getRequestDispatcher("ORDERGREETING.html");
                RD.forward(request, response);
                    
           }
            
            catch(Exception e)
            {
                System.out.println("Exception :"+e);
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
