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
@WebServlet("/Insert_API_base")
public class Backup_calls extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String Replace_dbTableSechema = "replace into opportunities(id,deleted,SME_ID,date_entered,date_modified,modified_user_id,"+
				"created_by,description,assigned_user_id,name,account,account_type,duration_hours,duration_minutes,date_start,date_end,"+
				"status,direction,reminder_time,email_reminder_time,email_reminder_sent,contact_name,contact_account,contact_email,contact_workphone) ";
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
	private String account = null;
	private String account_type = null;
	private String duration_hours = null;
	private String duration_minutes = null;
	private String date_start = null;
	private String date_end = null;
	private String status = null;
	private String direction = null;
	private String reminder_time = null;
	private String email_reminder_time = null;
	private String email_reminder_sent = null;
	private String contact_name = null;
	private String contact_account = null;
	private String contact_email = null;
	private String contact_workphone = null;
	
	
	
	
	// status for return (not for insert schema)
	private String Restatus = null;
	/**
	 * Default constructor.
	 */
	public Backup_calls() {
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
		account = URLDecoder.decode(request.getParameter("account"),"UTF-8");
		account_type = URLDecoder.decode(request.getParameter("account_type"),"UTF-8");
		duration_hours = URLDecoder.decode(request.getParameter("duration_hours"),"UTF-8");
		duration_minutes = URLDecoder.decode(request.getParameter("duration_minutes"),"UTF-8");
		date_start = URLDecoder.decode(request.getParameter("date_start"),"UTF-8");
		date_end = URLDecoder.decode(request.getParameter("date_end"),"UTF-8");
		status = URLDecoder.decode(request.getParameter("status"),"UTF-8");
		direction = URLDecoder.decode(request.getParameter("direction"),"UTF-8");
		reminder_time = URLDecoder.decode(request.getParameter("reminder_time"),"UTF-8");
		email_reminder_time = URLDecoder.decode(request.getParameter("email_reminder_time"),"UTF-8");
		email_reminder_sent = URLDecoder.decode(request.getParameter("email_reminder_sent"),"UTF-8");
		contact_name = URLDecoder.decode(request.getParameter("contact_name"),"UTF-8");
		contact_account = URLDecoder.decode(request.getParameter("contact_account"),"UTF-8");
		contact_email = URLDecoder.decode(request.getParameter("contact_email"),"UTF-8");
		contact_workphone = URLDecoder.decode(request.getParameter("contact_workphone"),"UTF-8");
		
		
		
//		token_verification tt = new token_verification();
	   // int varify = tt.send(SME_ID,Token);
	    
	   // if( varify == 1){
		DBCollection connection = null;
		APIManager services = APIManager.INSTANCE;
		try {
			connection = services.getInstance(CSMP_DMM_API.backup_calls_v1,"calls");
			if (connection != null) {

				 //original SQL syntax
				 BasicDBObject doc = new BasicDBObject("schema", Replace_dbTableSechema+"values("+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+assigned_user_id+","+name+","+account+","+account_type+","+duration_hours+","+duration_minutes+","+date_start+","+date_end+","+status+","+direction+","+reminder_time+","+email_reminder_time+","+email_reminder_sent+","+contact_name+","+contact_account+","+contact_email+","+contact_workphone+");");
				 connection.insert(doc);
				// according to python-mysql-connector
				/*BasicDBObject doc = new BasicDBObject("schema", insertdbTableSechema+"values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)*^*["+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+
						assigned_user_id+","+name+","+related_to+","+opportunity_type+","+campaign_source+","+lead_source+","+amount+","+date_closed+","+
						next_step+","+sales_stage+","+probability+"]");
					
				*/	
				
			} else {
				Restatus = new String("0, ERROR");
				System.out.println("connection error");
			}
			Restatus = new String("1, OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Restatus = new String("0, ERROR");
		}
		finally{
			
		}

		PrintWriter writer = response.getWriter();
		
		writer.println(Restatus);
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
