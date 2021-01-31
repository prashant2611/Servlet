import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InsertClass extends HttpServlet
{
	Connection con;
	PreparedStatement pst;
  public void init() throws ServletException
  {
	  try
	  {
		  Class.forName("com.mysql.jdbc.Driver");
		  con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
	      pst=(PreparedStatement) con.prepareStatement("insert into account values(?,?,?)");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, HTTPException
  {
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  
	  int flag=0;
	  int acno=Integer.parseInt(request.getParameter("acno"));
	  String acnm= request.getParameter("acnm");
	  int acbal=Integer.parseInt(request.getParameter("acbl"));
	  
	  try 
	  {
		pst.setInt(1,acno);
	    pst.setString(2,acnm);
	    pst.setInt(3,acbal);
	    
	    int check= pst.executeUpdate();
	    if(check>0)
	    {
	    	flag=1;
	    }
	  } 
	  catch (Exception e) 
	  {
		e.printStackTrace();
	   }
	  
	  out.println("<html>");
	  out.println("<body>");
	  out.println("<h1>");
	  if(flag==1)
	  {
		  out.println("Data Inserted sucessfully.<br>");
		  out.println("<h3><a href=index.html>Back</a><h3>");
	  }
	  else
	  {
		  
		  out.println("Invalid Data<br>");
		  out.println("<a href=index.html>Back</a>");
	  }
	  out.println("</h1>"); 
	  out.println("</body>");
	  out.println("</html>");
	  
	  out.close();
  }
  
  public void destroy()
  {
	  try
	  {
	  con.close();
	  pst.close();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  
}
