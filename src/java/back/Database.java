package back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database 
{
    public Statement databaseconnection() throws ClassNotFoundException, SQLException
    {
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/PARATHAHOUSE","root","mysql");
                  Statement st=con.createStatement();
                  return st;
      }
}
