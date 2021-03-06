package CSMP.DMM.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import token_test.token_verification;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import CSMP.DMM.service.model.CSMP_DMM_API;
import CSMP.DMM.service.model.APIManager;

/**
 * Servlet implementation class HelloCloudfoundry
 */
@SuppressWarnings("restriction")
@WebServlet("/Insert_API_campaigns")
public class Backup_campaigns extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String Replace_dbTableSechema = "replace into campaigns(id,deleted,SME_ID,date_entered,date_modified,modified_user_id,created_by"+
	",description,assigned_user_id,name,type,status,date_closed,expectedrevenue,budgetcost,actualcost,expectedresponse,numsent,"+
			"product_id,sponsor,targetaudience,targetsize,expectedresponsecount,expectedsalescount,expectedroi,actualresponsecount,actualsalescount,actualroi) ";
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
	
	
	
	// status for return (not for insert schema)
	private String ReStatus = null;
	/**
	 * Default constructor.
	 */
	public Backup_campaigns() {
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
		
		
//		token_verification tt = new token_verification();
	   // int varify = tt.send(SME_ID,Token);
	    
	   // if( varify == 1){
		DBCollection connection = null;
		APIManager services = APIManager.INSTANCE;
		try {
			connection = services.getInstance(CSMP_DMM_API.backup_campaigns_v1,"campaigns");
			if (connection != null) {

				 //original SQL syntax
				 BasicDBObject doc = new BasicDBObject("schema", Replace_dbTableSechema+"values("+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+assigned_user_id+","+name+","+type+","+status+","+date_closed+","+expectedrevenue+","+budgetcost+","+actualcost+","+expectedresponse+","+numsent+","+product_id+","+sponsor+","+targetaudience+","+targetsize+","+expectedresponsecount+","+expectedsalescount+","+expectedroi+","+actualresponsecount+","+actualsalescount+","+actualroi+");");
				 connection.insert(doc);
				// according to python-mysql-connector
				/*BasicDBObject doc = new BasicDBObject("schema", insertdbTableSechema+"values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)*^*["+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+
						assigned_user_id+","+name+","+related_to+","+opportunity_type+","+campaign_source+","+lead_source+","+amount+","+date_closed+","+
						next_step+","+sales_stage+","+probability+"]");
					
				*/	
				
			} else {
				ReStatus = new String("0, ERROR");
				System.out.println("connection error");
			}
			ReStatus = new String("1, OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReStatus = new String("0, ERROR");
		}
		finally{
			
		}

		PrintWriter writer = response.getWriter();
		
		writer.println(ReStatus);
		writer.close();
		/*    }
	    else if( varify == -301 ){

			PrintWriter writer = response.getWriter();
			status = new String("301, parameter error"); 
			writer.println(status);
			writer.close();
			
	    }
	    else if( varify == -302 ){

			PrintWriter writer = response.getWriter();
			status = new String("302, request executed failed"); 
			writer.println(status);
			writer.close();
			
	    }
	    else{
	    	PrintWriter writer = response.getWriter();
	    	status = new String("something wrong with token varify"); 
			writer.println(status);
			writer.close();
	    }
	    */
	}

}
