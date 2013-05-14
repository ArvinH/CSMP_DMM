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
@WebServlet("/Insert_API_contacts")
public class Backup_contacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String Replace_dbTableSechema = "replace into opportunities(id,deleted,SME_ID,date_entered,date_modified,"+
					"modified_user_id,created_by,description,assigned_user_id,salutation,first_name,last_name,title,"+
					"department,do_not_call,phone_home,phone_mobile,phone_work,phone_other,phone_fax,primary_address_street,"+
					"primary_address_city,primary_address_state,primary_address_postalcode,primary_address_country,primary_address_pobox,"+
					"alt_address_street,alt_address_city,alt_address_state,alt_address_postalcode,alt_address_country,alt_address_pobox,"+
					"assistant,assistant_phone,lead_source,reports_to_id,campaign_id,account_id,birthdate,email,secondaryemail,emailoptout,"+
					"reference,notify_owner) ";
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
	private String salutation = null;
	private String first_name = null;
	private String last_name = null;
	private String title = null;
	private String department = null;
	private String do_not_call = null;
	private String phone_home = null;
	private String phone_mobile = null;
	private String phone_work = null;
	private String phone_other = null;
	private String phone_fax = null;
	private String primary_address_street = null;
	private String primary_address_city = null;
	private String primary_address_state = null;
	private String primary_address_postalcode = null;
	private String primary_address_country = null;
	private String primary_address_pobox = null;
	private String alt_address_street = null;
	private String alt_address_city = null;
	private String alt_address_state = null;
	private String alt_address_postalcode = null;
	private String alt_address_country = null;
	private String alt_address_pobox = null;
	private String assistant = null;
	private String assistant_phone = null;
	private String lead_source = null;
	private String reports_to_id = null;
	private String campaign_id = null;
	private String account_id = null;
	private String birthdate = null;
	private String email = null;
	private String secondaryemail = null;
	private String emailoptout = null;
	private String reference = null;
	private String notify_owner = null;
	
	// status for return (not for insert schema)
	private String status = null;
	/**
	 * Default constructor.
	 */
	public Backup_contacts() {
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
		salutation = URLDecoder.decode(request.getParameter("salutation"),"UTF-8");
		first_name = URLDecoder.decode(request.getParameter("first_name"),"UTF-8");
		last_name = URLDecoder.decode(request.getParameter("last_name"),"UTF-8");
		title = URLDecoder.decode(request.getParameter("title"),"UTF-8");
		department = URLDecoder.decode(request.getParameter("department"),"UTF-8");
		do_not_call = URLDecoder.decode(request.getParameter("do_not_call"),"UTF-8");
		phone_home = URLDecoder.decode(request.getParameter("phone_home"),"UTF-8");
		phone_mobile = URLDecoder.decode(request.getParameter("phone_mobile"),"UTF-8");
		phone_work = URLDecoder.decode(request.getParameter("phone_work"),"UTF-8");
		phone_other = URLDecoder.decode(request.getParameter("phone_other"),"UTF-8");
		phone_fax = URLDecoder.decode(request.getParameter("phone_fax"),"UTF-8");
		primary_address_street = URLDecoder.decode(request.getParameter("primary_address_street"),"UTF-8");
		primary_address_city = URLDecoder.decode(request.getParameter("primary_address_city"),"UTF-8");
		primary_address_state = URLDecoder.decode(request.getParameter("primary_address_state"),"UTF-8");
		primary_address_postalcode = URLDecoder.decode(request.getParameter("primary_address_postalcode"),"UTF-8");
		primary_address_country = URLDecoder.decode(request.getParameter("primary_address_country"),"UTF-8");
		primary_address_pobox = URLDecoder.decode(request.getParameter("primary_address_pobox"),"UTF-8");
		alt_address_street = URLDecoder.decode(request.getParameter("alt_address_street"),"UTF-8");
		alt_address_city = URLDecoder.decode(request.getParameter("alt_address_city"),"UTF-8");
		alt_address_state = URLDecoder.decode(request.getParameter("alt_address_state"),"UTF-8");
		alt_address_postalcode = URLDecoder.decode(request.getParameter("alt_address_postalcode"),"UTF-8");
		alt_address_country = URLDecoder.decode(request.getParameter("alt_address_country"),"UTF-8");
		alt_address_pobox = URLDecoder.decode(request.getParameter("alt_address_pobox"),"UTF-8");
		assistant = URLDecoder.decode(request.getParameter("assistant"),"UTF-8");
		assistant_phone = URLDecoder.decode(request.getParameter("assistant_phone"),"UTF-8");
		lead_source = URLDecoder.decode(request.getParameter("lead_source"),"UTF-8");
		reports_to_id = URLDecoder.decode(request.getParameter("reports_to_id"),"UTF-8");
		campaign_id = URLDecoder.decode(request.getParameter("campaign_id"),"UTF-8");
		account_id = URLDecoder.decode(request.getParameter("account_id"),"UTF-8");
		birthdate = URLDecoder.decode(request.getParameter("birthdate"),"UTF-8");
		email = URLDecoder.decode(request.getParameter("email"),"UTF-8");
		secondaryemail = URLDecoder.decode(request.getParameter("secondaryemail"),"UTF-8");
		emailoptout = URLDecoder.decode(request.getParameter("emailoptout"),"UTF-8");
		reference = URLDecoder.decode(request.getParameter("reference"),"UTF-8");
		notify_owner = URLDecoder.decode(request.getParameter("notify_owner"),"UTF-8");
		
		
//		token_verification tt = new token_verification();
	   // int varify = tt.send(SME_ID,Token);
	    
	   // if( varify == 1){
		DBCollection connection = null;
		APIManager services = APIManager.INSTANCE;
		try {
			connection = services.getInstance(CSMP_DMM_API.backup_contacts_v1,"contacts");
			if (connection != null) {

				 //original SQL syntax
				 BasicDBObject doc = new BasicDBObject("schema", Replace_dbTableSechema+"values("+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+assigned_user_id+","+salutation+","+first_name+","+last_name+","+title+","+department+","+do_not_call+","+phone_home+","+phone_mobile+","+phone_work+","+phone_other+","+phone_fax+","+primary_address_street+","+primary_address_city+","+primary_address_state+","+primary_address_postalcode+","+primary_address_country+","+primary_address_pobox+","+alt_address_street+","+alt_address_city+","+alt_address_state+","+alt_address_postalcode+","+alt_address_country+","+alt_address_pobox+","+assistant+","+assistant_phone+","+lead_source+","+reports_to_id+","+campaign_id+","+account_id+","+birthdate+","+email+","+secondaryemail+","+emailoptout+","+reference+","+notify_owner+");");
				 connection.insert(doc);
				// according to python-mysql-connector
				/*BasicDBObject doc = new BasicDBObject("schema", insertdbTableSechema+"values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)*^*["+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+
						assigned_user_id+","+name+","+related_to+","+opportunity_type+","+campaign_source+","+lead_source+","+amount+","+date_closed+","+
						next_step+","+sales_stage+","+probability+"]");
					
				*/	
				
			} else {
				status = new String("0, ERROR");
				System.out.println("connection error");
			}
			status = new String("1, OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = new String("0, ERROR");
		}
		finally{
			
		}

		PrintWriter writer = response.getWriter();
		
		writer.println(status);
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
