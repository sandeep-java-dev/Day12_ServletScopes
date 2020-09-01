package p1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String serverAddress = context.getInitParameter("Server-address");
		
		ServletConfig config = getServletConfig();
		String role = config.getInitParameter("role");
		
		String hrNumber = config.getInitParameter("HR-Number");
		
		resp.getWriter().append("server address "+serverAddress+" role "+role+" HR Number "+hrNumber);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		// abc@gmail.com
		
		if(email.endsWith(".com"))
		{
			System.out.println("--Servlet 1 "+email);
			String arr[] = email.split("@");
			
			// --- 1000 lines ----
			if(arr.length == 2)
			{
				String username = arr[0];
				String domain = arr[1];
				
				req.setAttribute("user-name",username);
				req.setAttribute("domain-name", domain);
				
				
				System.out.println(username+" and "+domain);
				
				RequestDispatcher rd = req.getRequestDispatcher("Servlet2");
				rd.forward(req, resp);
				/// it has 3 values 
				// 1. email from login page
				// 2. user-name & domain-name

			}
			
		}
		else
		{
			//send error msg
			// resp.sendError(sc); skiping
			resp.sendRedirect("login.html");
		}
		
	}
	
	
	
}
