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

public class ORDER4 extends HttpServlet
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
        String selectedparatha=session.getAttribute("SELECTEDPARATHA").toString();
        String selectedparatharate=session.getAttribute("SELECTEDPARATHARATE").toString();
        String parathaquantity=session.getAttribute("QUANTITY").toString();
        String totalamount=session.getAttribute("TOTALAMOUNT").toString();
        String deliveryaddress=session.getAttribute("DELIVERYADDRESS").toString();
        String pincode=session.getAttribute("PINCODE").toString();
        String contact=session.getAttribute("CONTACT").toString();
        String paymentmode=request.getParameter("PAYMENTMODESELECTOR");
        System.out.println("Orderid : "+paymentmode);
        session.setAttribute("PAYMENTMODE",paymentmode);
        if(paymentmode.equals("SELECT"))
        {
            RequestDispatcher RD=request.getRequestDispatcher("ORDER3.jsp");
            RD.include(request, response);  
        }
        else
        {
            try
            {
                Statement st=DB.databaseconnection();
                ResultSet rs=st.executeQuery("Select * from Paymentmode where Name='"+paymentmode+"'");
                Boolean record=rs.next();
                if(record==true)
                {
                    PW.print("<form action=ORDERDATA>"+
                                       "<div id='PAYMENTBLOCK'>"+
                                        "<div class='PAYMENTBLOCK' id='AMOUNTSECTION'>" +
                                        "<h2 class='INNERHEADINGS'>Amount to be Paid</h2>" +
                                        "<input value='Rs "+totalamount+"' disabled='' id='AMOUNT' type='text' name='AMOUNT'>" +
                                        "</div>" +
                                        "<div class='PAYMENTBLOCK' id='PAYMENTADDRESSSECTION'>" +
                                        "<h2 class='INNERHEADINGS'>"+rs.getString("Name")+"</h2>" +
                                        "<input value='"+rs.getString("Address")+"' disabled='' id='PAYMENTADDRESS' type='text' name='PAYMENTADDRESS'>"+
                                        "</div>"+
                                        "<div class='PAYMENTBLOCK' class='TRANSACTIONBLOCK' id='TRANSACTIONSECTION'>"+
                                        "<h2 class='INNERHEADINGS'>Transaction Id/Transaction Detail</h2>" +
                                        "<input id='TRANSACTIONDETAIL' type='text' name='TRANSACTIONDETAIL'><button id='PAYMENTSUBMISSION'>Submit</button>"+
                                        "</div>"+
                                        "<p>Please submit the transaction id/ transaction detail after making payment.</p>"+
                                        "</div>"+
                                        "</form>"); 
                        RequestDispatcher RD=request.getRequestDispatcher("ORDER3.jsp");
                        RD.include(request, response);
                    
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception :"+e);
            }
              
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
