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
@WebServlet("/Insert_API_accounts")
public class Backup_accounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String Replace_dbTableSechema = "replace into opportunities(id,deleted,SME_ID,date_entered,date_modified,modified_user_id,created_by,description,"+
			"assigned_user_id,name,account_type,industry,annual_revenue,email,secondaryemail,phone_fax,rating,phone_office,phone_alternate,website,ownership,"+
			"employees,ticker_symbol,billing_address_street,billing_address_city,billing_address_state,billing_address_postalcode,billing_address_country,"+
			"billing_address_pobox,shipping_address_street,shipping_address_city,shipping_address_state,shipping_address_postalcode,shipping_address_country,"+
			"shipping_address_pobox,parent_id,sic_code,campaign_id,emailoptout,notify_owner) ";
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
	private String account_type = null;
	private String industry = null;
	private String annual_revenue = null;
	private String email = null;
	private String secondaryemail = null;
	private String phone_fax = null;
	private String rating = null;
	private String phone_office = null;
	private String phone_alternate = null;
	private String website = null;
	private String ownership = null;
	private String employees = null;
	private String ticker_symbol = null;
	private String billing_address_street = null;
	private String billing_address_city = null;
	private String billing_address_state = null;
	private String billing_address_postalcode = null;
	private String billing_address_country = null;
	private String billing_address_pobox = null;
	private String shipping_address_street = null;
	private String shipping_address_city = null;
	private String shipping_address_state = null;
	private String shipping_address_postalcode = null;
	private String shipping_address_country = null;
	private String shipping_address_pobox = null;
	private String parent_id = null;
	private String sic_code = null;
	private String campaign_id = null;
	private String emailoptout = null;
	private String notify_owner = null;
	
	
	// status for return (not for insert schema)
	private String status = null;
	/**
	 * Default constructor.
	 */
	public Backup_accounts() {
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
		account_type = URLDecoder.decode(request.getParameter("account_type"),"UTF-8");
		industry = URLDecoder.decode(request.getParameter("industry"),"UTF-8");
		annual_revenue = URLDecoder.decode(request.getParameter("annual_revenue"),"UTF-8");
		email = URLDecoder.decode(request.getParameter("email"),"UTF-8");
		secondaryemail = URLDecoder.decode(request.getParameter("secondaryemail"),"UTF-8");
		phone_fax = URLDecoder.decode(request.getParameter("phone_fax"),"UTF-8");
		rating = URLDecoder.decode(request.getParameter("rating"),"UTF-8");
		phone_office = URLDecoder.decode(request.getParameter("phone_office"),"UTF-8");
		phone_alternate = URLDecoder.decode(request.getParameter("phone_alternate"),"UTF-8");
		website = URLDecoder.decode(request.getParameter("website"),"UTF-8");
		ownership = URLDecoder.decode(request.getParameter("ownership"),"UTF-8");
		employees = URLDecoder.decode(request.getParameter("employees"),"UTF-8");
		ticker_symbol = URLDecoder.decode(request.getParameter("ticker_symbol"),"UTF-8");
		billing_address_street = URLDecoder.decode(request.getParameter("billing_address_street"),"UTF-8");
		billing_address_city = URLDecoder.decode(request.getParameter("billing_address_city"),"UTF-8");
		billing_address_state = URLDecoder.decode(request.getParameter("billing_address_state"),"UTF-8");
		billing_address_postalcode = URLDecoder.decode(request.getParameter("billing_address_postalcode"),"UTF-8");
		billing_address_country = URLDecoder.decode(request.getParameter("billing_address_country"),"UTF-8");
		billing_address_pobox = URLDecoder.decode(request.getParameter("billing_address_pobox"),"UTF-8");
		shipping_address_street = URLDecoder.decode(request.getParameter("shipping_address_street"),"UTF-8");
		shipping_address_city = URLDecoder.decode(request.getParameter("shipping_address_city"),"UTF-8");
		shipping_address_state = URLDecoder.decode(request.getParameter("shipping_address_state"),"UTF-8");
		shipping_address_postalcode = URLDecoder.decode(request.getParameter("shipping_address_postalcode"),"UTF-8");
		shipping_address_country = URLDecoder.decode(request.getParameter("shipping_address_country"),"UTF-8");
		shipping_address_pobox = URLDecoder.decode(request.getParameter("shipping_address_pobox"),"UTF-8");
		parent_id = URLDecoder.decode(request.getParameter("parent_id"),"UTF-8");
		sic_code = URLDecoder.decode(request.getParameter("sic_code"),"UTF-8");
		campaign_id = URLDecoder.decode(request.getParameter("campaign_id"),"UTF-8");
		emailoptout = URLDecoder.decode(request.getParameter("emailoptout"),"UTF-8");
		notify_owner = URLDecoder.decode(request.getParameter("notify_owner"),"UTF-8");
		
		
		
		
//		token_verification tt = new token_verification();
	   // int varify = tt.send(SME_ID,Token);
	    
	   // if( varify == 1){
		DBCollection connection = null;
		APIManager services = APIManager.INSTANCE;
		try {
			connection = services.getInstance(CSMP_DMM_API.backup_accounts_v1,"accounts");
			if (connection != null) {

				 //original SQL syntax
				 BasicDBObject doc = new BasicDBObject("schema", Replace_dbTableSechema+"values("+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+assigned_user_id+","+name+","+account_type+","+industry+","+annual_revenue+","+email+","+secondaryemail+","+phone_fax+","+rating+","+phone_office+","+phone_alternate+","+website+","+ownership+","+employees+","+ticker_symbol+","+billing_address_street+","+billing_address_city+","+billing_address_state+","+billing_address_postalcode+","+billing_address_country+","+billing_address_pobox+","+shipping_address_street+","+shipping_address_city+","+shipping_address_state+","+shipping_address_postalcode+","+shipping_address_country+","+shipping_address_pobox+","+parent_id+","+sic_code+","+campaign_id+","+emailoptout+","+notify_owner+");");
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
