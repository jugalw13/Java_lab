import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Initials")
public class Initials extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public Initials() { 
		super(); 
	}
	
	public String initials(String name) {
		String in = Character.toString(name.charAt(0));
		for (int i = 1; i < name.length(); i++) 
			if (name.charAt(i) == ' ')
				in+=name.charAt(i + 1); 
		return in.toUpperCase();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("name");
		String in=initials(n);
		out.println(in);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}