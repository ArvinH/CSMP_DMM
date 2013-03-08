package CSMP.DMM.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import CSMP.DMM.service.model.CSMP_DMM_API;
import CSMP.DMM.service.model.APIManager;

/**
 * Servlet implementation class HelloCloudfoundry
 */
@SuppressWarnings("restriction")
@WebServlet("/Insert_API_opportunities")
public class Insert_opportunities extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String insertdbTableSechema = "insert into opportunities(id,name,date_entered,date_modified," +
			"modified_user_id,created_by,description,deleted,assigned_user_id,opportunity_type, " + 
			"campaign_id, lead_source,amount, amount_usdollar, date_closed, next_step, sales_stage, probability) ";
	private String id = null;
	private String SME_ID = null;
	private String name = null;
	private String date_entered = null;
	private String date_modified = null;
	private String modified_user_id = null;
	private String created_by = null;
	private String description = null;
	private String deleted = null;
	private String assigned_user_id = null;
	private String opportunity_type = null;
	private String campaign_id = null;
	private String lead_source = null;
	private String amount = null;
	private String amount_usdollar = null;
	private String date_closed = null;
	private String next_step = null;
	private String sales_stage = null;
	private String probability = null;
	private String status = null;
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
		response.setCharacterEncoding("UTF-8");
		
		id = URLDecoder.decode(request.getParameter("id"),"UTF-8");
		SME_ID = URLDecoder.decode(request.getParameter("SME_ID"),"UTF-8");
		name = URLDecoder.decode(request.getParameter("name"),"UTF-8");
		date_entered = URLDecoder.decode(request.getParameter("date_entered"),"UTF-8");
		date_modified = URLDecoder.decode(request.getParameter("date_modified"),"UTF-8");
		modified_user_id = URLDecoder.decode(request.getParameter("modified_user_id"),"UTF-8");
		created_by = URLDecoder.decode(request.getParameter("created_by"),"UTF-8");
		description = URLDecoder.decode(request.getParameter("description"),"UTF-8");
		deleted = URLDecoder.decode(request.getParameter("deleted"),"UTF-8");
		assigned_user_id = URLDecoder.decode(request.getParameter("assigned_user_id"),"UTF-8");
		opportunity_type = URLDecoder.decode(request.getParameter("opportunity_type"),"UTF-8");
		campaign_id = URLDecoder.decode(request.getParameter("campaign_id"),"UTF-8");
		lead_source = URLDecoder.decode(request.getParameter("lead_source"),"UTF-8");
		amount = URLDecoder.decode(request.getParameter("amount"),"UTF-8");
		amount_usdollar = URLDecoder.decode(request.getParameter("amount_usdollar"),"UTF-8");
		date_closed = URLDecoder.decode(request.getParameter("date_closed"),"UTF-8");
		next_step = URLDecoder.decode(request.getParameter("next_step"),"UTF-8");
		sales_stage = URLDecoder.decode(request.getParameter("sales_stage"),"UTF-8");
		probability = URLDecoder.decode(request.getParameter("probability"),"UTF-8");
		

		DBCollection connection = null;

		APIManager services = APIManager.INSTANCE;
		try {
			connection = services.getInstance(CSMP_DMM_API.insert_opportunities,"opportunities");

			if (connection != null) {

					BasicDBObject doc = new BasicDBObject("schema", insertdbTableSechema+"values("+id+","+SME_ID+","+name+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+
							deleted+","+assigned_user_id+","+opportunity_type+","+campaign_id+","+lead_source+","+amount+","+amount_usdollar+","+date_closed+","+
							next_step+","+sales_stage+","+probability+");");
					connection.insert(doc);
				
				DBObject myDoc = connection.findOne();
				System.out.println(myDoc);
			} else {
				System.out.println("connection error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = new String("0");
		}

		PrintWriter writer = response.getWriter();
		status = new String("1");
		writer.println(status);
		writer.close();
	}

}
