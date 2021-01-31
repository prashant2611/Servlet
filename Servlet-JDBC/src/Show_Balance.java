import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Show_Balance extends HttpServlet
{
	Connection con;
    Statement st;
  public void init() throws ServletException
  {
	  
	  try
	  {
	  Class.forName("com.mysql.jdbc.Driver");
	  con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
	  st=(Statement) con.createStatement();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws HTTPException,IOException
  {
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  
	  int acno=Integer.parseInt(request.getParameter("ac"));
	  ResultSet rs;
	  try
	  {
		 rs=st.executeQuery("select * from account where acno="+acno);
		 if(rs.next())
		 {
			 out.println("<html>");
			 out.println("<body>");
			 out.println("<h1>");
			 out.println("Hello "+rs.getString(2)+" your balance is: "+rs.getDouble(3));
			 out.println("</h1>");
			 out.println("</body>");
			 out.println("</html>");
		 }
		 out.close();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  
  public void destroy()
  {
	  try
	  {
	   con.close();
	   st.close();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  
}
