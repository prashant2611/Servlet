import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Welcome extends GenericServlet
{
     public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException
     {
    	 response.setContentType("text/html");
    	 PrintWriter out=response.getWriter();
    	 
    	 out.println("<html>");
    	 out.println("<body");
    	 out.println("<h1>Welcome!</h1>");
    	 out.println("</html>");
    	 out.println("</body");
    	 
     }
}
