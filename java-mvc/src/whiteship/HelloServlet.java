package whiteship;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = req.getParameter("name");
		if(name == null){
			
			name = "JSP";
		}
		
		String hello = "Hello" + name;
		req.setAttribute("hello", hello);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hello.jsp");
		dispatcher.forward(req, resp);
	}

}
