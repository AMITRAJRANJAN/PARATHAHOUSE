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

public class ORDER3 extends HttpServlet
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
        String TA=request.getParameter("AMOUNT");
        System.out.println("TOTAL AMOUNT "+TA);
        String deliveryaddress=request.getParameter("DELIVERYADDRESS");
        String contact=request.getParameter("CONTACT").toString();
        String pincode=request.getParameter("PINCODE").toString();
        
        if(deliveryaddress==""||contact==""||pincode=="")
        {
            PW.println("<p id='MESSAGE'>Delivery details are mandatory.</p>");
            RequestDispatcher RD=request.getRequestDispatcher("ORDER2.jsp");
            RD.include(request, response);  
        }
        else
        {
            int pin=Integer.parseInt(pincode);
            try
            {
                Statement st=DB.databaseconnection();
                ResultSet rs=st.executeQuery("Select * from Servingarea where Pincode='"+pin+"'");
                Boolean record=rs.next();
                if(record==true)
                {
                    session.setAttribute("DELIVERYADDRESS",deliveryaddress);
                    session.setAttribute("PINCODE",pincode);
                    session.setAttribute("CONTACT",contact);
                    response.sendRedirect("ORDER3.jsp");
                }
                else
                {
                    PW.println("<p id='MESSAGE'>Unreachable PINCODE.</p>");
                    RequestDispatcher RD=request.getRequestDispatcher("ORDER2.jsp");
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
