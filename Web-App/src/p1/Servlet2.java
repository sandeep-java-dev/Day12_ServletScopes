package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// We need email to validate user
		System.out.println(" inside servelt 2 ");
		String email = req.getParameter("email");
		
		String username = (String)req.getAttribute("user-name");
		String domain = (String)req.getAttribute("domain-name");
		
		// -- added 1000 for database code 
		if(username.equals("abc")) // boolean value from DAO
		{
			PrintWriter out = resp.getWriter();
			if(domain.equals("gmail.com")) // ---1000 code 
				out.print("Gmail account of "+username);
			
			if(domain.equals("outlook.com"))
				out.print("Microsoft account of "+username);
			
			
		}
		
		
		// else 
	}
	
}
