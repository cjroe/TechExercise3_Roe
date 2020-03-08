

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import util.*;
import java.util.List;

/**
 * Servlet implementation class insertCard
 */
@WebServlet("/insertCard")
public class insertCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name").trim();
		String type = request.getParameter("type").trim();
		String cardColor = request.getParameter("color").trim();
		String mana = request.getParameter("mana").trim();
		String rule = request.getParameter("rule");
		UtilDB.createCard(name, type, mana, cardColor,rule);
		
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();

		output.append("ADDED CARD : " + name);
		
		response.sendRedirect(request.getContextPath() + "/home.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
