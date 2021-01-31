
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;


public class DemoClass extends HttpServlet
{
 public void init() throws ServletException
 {
	 System.out.println("Init method.");
 }
 
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,HTTPException
 {
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  
	  
	  
	  out.println("<html>");
	  out.println("<body>");
	  out.println("<h1>Prashant Patil");
	  out.println("</h1>");
	  out.println("</body>");
	  out.println("</html>");
	  
	  out.close();
	  
 }
 
 public void destroy()
 {
	 System.out.println("Destroy method.");
 }
 
}
