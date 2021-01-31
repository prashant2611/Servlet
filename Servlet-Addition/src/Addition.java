import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class Addition extends HttpServlet 
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,HTTPException
  {
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  
	  int no1= Integer.parseInt(request.getParameter("n1"));
	  int no2= Integer.parseInt(request.getParameter("n2"));
	  int no3=no1+no2;
	  
	  out.println("<html>");
	  out.println("<body>");
	  out.println("<h1>Addition is: "+no3);
	  out.println("</h1>");
	  out.println("</body>");
	  out.println("</html>");
	  
	  out.close();
	  
  }
}
