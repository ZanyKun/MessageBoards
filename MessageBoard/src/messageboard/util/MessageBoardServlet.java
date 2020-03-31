package messageboard.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageBoard")
public class MessageBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static List<Pair> messageHistory = new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.print("<body style='text-align:center;'><form action'./MessageBoard' method='post' style=\"border: solid 1px grey; border-spacing: 5px; width: 300px; height: 250px; margin:auto; width: 50%;\">\r\n" + 
				"	  <div style=\"padding:20px;\">\r\n" + 
				"	    <label style=\"float:left;\" for=\"Name\">Name</label><br/>\r\n" + 
				"	    <input style=\"float:left;\" type=\"text\" name=\"name\" placeholder=\"Name\">\r\n" + 
				"	  </div>\r\n" + 
				"	  <div style=\"padding:20px;\">\r\n" + 
				"	    <label style=\"float:left;\" for=\"Message\">Message</label><br/>\r\n" + 
				"	    <input style=\"float:left; width:85%; height: 30%;\" type='text' name=\"text\" placeholder=\"Enter Message Here\"></input>\r\n" + 
				"	  </div>\r\n" + 
				"	  <div style=\"padding-top:90px;\">\r\n" + 
				"	  	<input style=\"width:300px; align-content=center;\" type=\"submit\" value=\"Submit Your Message\"/>\r\n" + 
				"	  </div>\r\n" + 
				"	</form>" + "<br><h2>Previous Messages</h2></body></br>");
		if(messageHistory.size() == 0){
			writer.print("<h3>There are no previous messages.</h3>");
		}
		else {
			ListIterator<Pair> ite = messageHistory.listIterator();
			while(ite.hasNext()) {
				Pair obj = (Pair) ite.next();
				writer.print("<div style='width:50%; height: 20%; border: solid 1px grey; border-spacing: 5px; margin:auto; padding-left:10px;'>"
						+ "<p style='float:left;'> Name: " + obj.getName() + " posted on " + LocalDateTime.now() + "</p><br/><br/><br/><p style='float:left;'>Message: " + obj.getMessage() + "</p>"
						+ "</div>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("name");
		String text = request.getParameter("text");
		if(name.trim().length() == 0 || text.trim().length() == 0) {
			writer.print("<body style='text-align:center;'><h3>Enter both a name and a message to submit a message</h3></body>");
		}else {
			Pair input = new Pair(name, text);
			messageHistory.add(input);
		}
		
		doGet(request, response);
	}
}

class Pair{
	String name;
	String message;
	
	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public Pair(String name, String message) {
		this.name = name;
		this.message = message;
	}
}
