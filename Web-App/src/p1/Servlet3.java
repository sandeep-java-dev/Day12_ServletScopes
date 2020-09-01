package p1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet3
 */
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Servlet 3 :- Served at: ").append(request.getContextPath());
		
		
		ServletContext context = getServletContext();
		String serverAddress = context.getInitParameter("Server-address");
		
		ServletConfig config = getServletConfig();
		String role = config.getInitParameter("role");
		
		String hrNumber = config.getInitParameter("web-address");
		
		response.getWriter().append("server address "+serverAddress+" role "+role+" HR Number "+hrNumber);
	}

}
