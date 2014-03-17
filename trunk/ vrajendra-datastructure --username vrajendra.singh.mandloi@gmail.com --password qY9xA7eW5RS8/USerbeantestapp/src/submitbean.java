

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanpkg.beanclass;

public class submitbean extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public submitbean() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		beanclass b1 = new beanclass();
		HttpSession session  = request.getSession(true);
		b1.setUsername(request.getParameter("username"));
		b1.setPassword(request.getParameter("password"));
		b1.setNumber(Integer.parseInt(request.getParameter("number")));
		
		request.setAttribute("beanclass", b1);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Displaybean.jsp");
        dispatcher.forward(request,response);
	}
}
