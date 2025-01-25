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

public class ORDER1 extends HttpServlet
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
        String paratha=request.getParameter("PARATHASELECTOR");
        if(paratha.equals("Select"))
        {
            RequestDispatcher RD=request.getRequestDispatcher("HOME.jsp");
            RD.forward(request, response);    
        }
        else
        {
            try
            {
                Statement st=DB.databaseconnection();
                ResultSet rs=st.executeQuery("Select * from Paratha where Name='"+paratha+"'");
                Boolean record=rs.next();
                session.setAttribute("SELECTEDPARATHA", rs.getString("Name"));
                session.setAttribute("SELECTEDPARATHARATE", rs.getString("Rate"));
                PW.print("<form action='ORDER2'>"+
                                   "<div id='PARATHASECTION'>" +
                                   "<h2 class='INNERHEADINGS'>Paratha</h2>" +
                                   "<input value='"+rs.getString("Name")+" Paratha'"+" disabled='' id='PARATHA' type='text' name='PARATHA'>" +
                                   "</div>" +
                                   "<div id='RATESECTION'>" +
                                   "<h2 class='INNERHEADINGS'>Rate</h2>" +
                                   "<input value="+rs.getInt("Rate")+" disabled='' id='RATE' type='text' name='RATE'>" +
                                   "</div>" +
                                   "<div id='QUANTITYSECTION'>" +
                                   "<h2 class='INNERHEADINGS'>Quantity</h2>" +
                                   "<input id='QUANTITY' type='text' name='QUANTITY'>" +
                                   "</div>" +
                                   "<button id='PROCEEDTOORDER'>Proceed to Order</button>" +
                                   "");
                RequestDispatcher RD=request.getRequestDispatcher("HOME.jsp");
                RD.include(request, response);
                
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
