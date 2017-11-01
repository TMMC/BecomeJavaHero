package pl.edu.bogdan.training.mvc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormAnalyzer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		String text = request.getParameter("text");
		text = text.toUpperCase();
		request.setAttribute("text", text);
        request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
