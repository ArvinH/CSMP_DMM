package CSMP.DMM.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import CSMP.DMM.service.model.CloudFoundryServices;
import CSMP.DMM.service.model.ServiceManager;

/**
 * Servlet implementation class HelloCloudfoundry
 */
@SuppressWarnings("restriction")
@WebServlet("/HelloCloudfoundry")
public class Insert_opportunities extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Insert_opportunities() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		response.setStatus(200);
		DBCollection connection = null;

		// establish connection to Mongodb Service
		ServiceManager services = ServiceManager.INSTANCE;
		try {
			connection = services.getInstance(CloudFoundryServices.Mongodb);

			if (connection != null) {

				for (int i = 0; i < 100; i++) {
					BasicDBObject doc = new BasicDBObject("name", "MongoDB")
							.append("type", "database")
							.append("count", i)
							.append("info",
									new BasicDBObject("x", i + 203).append("y",
											i + 102));
					connection.insert(doc);
				}
				
				DBObject myDoc = connection.findOne();
				System.out.println(myDoc);
			} else {
				System.out.println("connection error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter writer = response.getWriter();
		String Result = new String("Insert succeed!");
		writer.println(Result);
		writer.close();
	}

}
