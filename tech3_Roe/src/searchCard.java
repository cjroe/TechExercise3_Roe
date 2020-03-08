

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import util.*;
import java.util.List;
import datamodel.Card;
/**
 * Servlet implementation class searchCard
 */
@WebServlet("/searchCard")
public class searchCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        String title = "Search Results";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
        String keyword = request.getParameter("keyword");
		System.out.println("I AM BEING CALLED HERE");
		List<Card> cards = UtilDB.listCards();	
			
		if(keyword != null && !keyword.isEmpty()) {
			cards = UtilDB.listCards(keyword);
		}
		
		PrintWriter output = response.getWriter();
        output.println(docType + //
                "<html>\n" + //
                "<head><title>" + title + "</title></head>\n" + //
                "<body bgcolor=\"#f0f0f0\">\n" + //
                "<h1 align=\"center\">" + title + "</h1>\n");
        
		if(cards.isEmpty()) {
			output.println(String.format("<h1> Sorry cards with name like %s could not be found!", keyword));
		} else {
			for(Card card: cards) {
				System.out.println("Found a card:" + card.getName());
				showCardDetails(output, card);	
			}	
		}

		output.println("<p><a href=\"./home.html \"> Back to home </a></p>");
		output.println("<p><a href=\"./searchCard.html \"> Back to search </a></p>" );
		output.println("</body></html>");
	}

	void showCardDetails(PrintWriter output, Card card) {
		System.out.println("I AM HERE WITH : "+ card.getName());
		output.println("<h2>" + card.getName() + "</h2>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
