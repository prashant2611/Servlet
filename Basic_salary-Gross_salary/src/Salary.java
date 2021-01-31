import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class Salary extends HttpServlet	
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,HTTPException
  {
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  
	  double hra,sal,da,bonus,total,tax,gross;
	  
	  sal=Double.parseDouble(request.getParameter("s1"));
	  hra=0.4*sal;
	  da=0.2*sal;
	  bonus=0.3*sal;
	  total=sal+hra+da+bonus;
	  tax=0.1*total;
	  gross=total-tax;
	  
	  out.println("<html>");
	  out.println("<body>");
	  out.println("<h1>");
	  out.println("Gross salary of "+sal+" is "+gross);
	  out.println("</h1>");
	  out.println("</body>");
	  out.println("</html>");
	  
	  out.close();
  }
}
