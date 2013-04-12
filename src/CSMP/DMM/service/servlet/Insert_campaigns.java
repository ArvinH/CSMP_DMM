package CSMP.DMM.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CSMP.DMM.service.model.APIManager;
import CSMP.DMM.service.model.CSMP_DMM_API;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

/**
 * Servlet implementation class Insert_campaigns
 */
@SuppressWarnings("restriction")
@WebServlet("/Insert_API_campaigns")
public class Insert_campaigns extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String insertdbTableSechema = "insert into campaigns(id,deleted,SME_ID,date_entered,date_modified," +
			"modified_user_id,created_by,description,assigned_user_id,name,type,status,date_closed,expectedrevenue" + 
			"budgetcost, actualcost,expectedresponse, numsent, product_id, sponsor, targetaudience, targetsize, expectedresponsecount"+
			"expectedsalescount,expectedroi,actualresponsecount,actualsalescount,actualroi) ";
	private String Token = null;
	private String id = null;
	private String deleted = null;
	private String SME_ID = null;
	private String date_entered = null;
	private String date_modified = null;
	private String modified_user_id = null;
	private String created_by = null;
	private String description = null;
	private String assigned_user_id = null;
	private String name = null;
	private String type = null;
	private String status = null;
	private String date_closed = null;
	private String expectedrevenue = null;
	private String budgetcost = null;
	private String actualcost = null;
	private String expectedresponse = null;
	private String numsent = null;
	private String product_id = null;
	private String sponsor = null;
	private String targetaudience = null;
	private String targetsize = null;
	private String expectedresponsecount = null;
	private String expectedsalescount = null;
	private String expectedroi = null;
	private String actualresponsecount = null;
	private String actualsalescount = null;
	private String actualroi = null;
	// status for return
	private String ReStatus = null;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Insert_campaigns() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		response.setStatus(200);
		response.setCharacterEncoding("UTF-8");
		Token = URLDecoder.decode(request.getParameter("Token"),"UTF-8"); 
		id = URLDecoder.decode(request.getParameter("id"),"UTF-8");
		deleted = URLDecoder.decode(request.getParameter("deleted"),"UTF-8");
		SME_ID = URLDecoder.decode(request.getParameter("SME_ID"),"UTF-8");
		date_entered = URLDecoder.decode(request.getParameter("date_entered"),"UTF-8");
		date_modified = URLDecoder.decode(request.getParameter("date_modified"),"UTF-8");
		modified_user_id = URLDecoder.decode(request.getParameter("modified_user_id"),"UTF-8");
		created_by = URLDecoder.decode(request.getParameter("created_by"),"UTF-8");
		description = URLDecoder.decode(request.getParameter("description"),"UTF-8");
		assigned_user_id = URLDecoder.decode(request.getParameter("assigned_user_id"),"UTF-8");
		name = URLDecoder.decode(request.getParameter("name"),"UTF-8");
		type = URLDecoder.decode(request.getParameter("type"),"UTF-8");
		status = URLDecoder.decode(request.getParameter("status"),"UTF-8");
		date_closed = URLDecoder.decode(request.getParameter("date_closed"),"UTF-8");
		expectedrevenue = URLDecoder.decode(request.getParameter("expectedrevenue"),"UTF-8");
		budgetcost = URLDecoder.decode(request.getParameter("budgetcost"),"UTF-8");
		actualcost = URLDecoder.decode(request.getParameter("actualcost"),"UTF-8");
		expectedresponse = URLDecoder.decode(request.getParameter("expectedresponse"),"UTF-8");
		numsent = URLDecoder.decode(request.getParameter("numsent"),"UTF-8");
		product_id = URLDecoder.decode(request.getParameter("product_id"),"UTF-8");
		sponsor = URLDecoder.decode(request.getParameter("sponsor"),"UTF-8");
		targetaudience = URLDecoder.decode(request.getParameter("targetaudience"),"UTF-8");
		targetsize = URLDecoder.decode(request.getParameter("targetsize"),"UTF-8");
		expectedresponsecount = URLDecoder.decode(request.getParameter("expectedresponsecount"),"UTF-8");
		expectedsalescount = URLDecoder.decode(request.getParameter("expectedsalescount"),"UTF-8");
		expectedroi = URLDecoder.decode(request.getParameter("expectedroi"),"UTF-8");
		actualresponsecount = URLDecoder.decode(request.getParameter("actualresponsecount"),"UTF-8");
		actualsalescount = URLDecoder.decode(request.getParameter("actualsalescount"),"UTF-8");
		actualroi = URLDecoder.decode(request.getParameter("actualroi"),"UTF-8");
			
		DBCollection connection = null;
		APIManager services = APIManager.INSTANCE;
		try {
			connection = services.getInstance(CSMP_DMM_API.insert_campaigns_v1,"campaigns");
			ReStatus = new String("1");
			if (connection != null) {
				
					BasicDBObject doc = new BasicDBObject("schema", insertdbTableSechema+"values("+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+assigned_user_id+","+
							name+","+type+","+status+","+date_closed+","+expectedrevenue+","+budgetcost+","+actualcost+","+expectedresponse+","+
							numsent+","+product_id+","+sponsor+","+targetaudience+","+targetsize+","+expectedresponsecount+","+expectedsalescount+","+expectedroi+","+actualresponsecount+","+actualsalescount+","+actualroi+");");
				
					connection.insert(doc);
					
				
			} else {
				System.out.println("connection error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReStatus = new String("0");
		}
		finally{
			
		}

		PrintWriter writer = response.getWriter();
		
		writer.println(ReStatus);
		writer.close();
	}

}
