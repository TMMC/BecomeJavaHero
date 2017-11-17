package pl.bogdan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormReceiver extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("text");
		parameter = parameter.toUpperCase();
		request.setAttribute("upper_text", parameter);
		request.getRequestDispatcher("web2.jsp")
		.forward(request, response);
	}
}
