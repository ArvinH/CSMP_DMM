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
@WebServlet("/Insert_API_users")
public class Backup_users extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String Replace_dbTableSechema = "replace into opportunities(id,deleted,SME_ID,date_entered,date_modified,modified_user_id,"+
						"created_by,description,user_name,user_password,first_name,last_name,is_admin,title,role_id,department,email,"+
						"secondaryemail,phone_home,phone_mobile,phone_work,phone_other,phone_fax,status,address_street,address_city,"+
						"address_state,address_country,address_postalcode,alt_address_pobox,messenger_id,messenger_type,reports_to_id,"+
						"date_format,time_zone,currency,language) ";
	private String Token = null;
	private String id=null ;
	private String deleted=null ;
	private String SME_ID=null ;
	private String date_entered=null ;
	private String date_modified=null ;
	private String modified_user_id=null ;
	private String created_by=null ;
	private String description=null ;
	
	private String user_name=null ;
	private String user_password=null ;
	private String first_name=null ;
	private String last_name=null ;
	private String is_admin=null ;
	private String title=null ;
	private String role_id=null ;
	private String department=null ;
	private String email=null ;
	private String secondaryemail=null ;
	private String phone_home=null ;
	private String phone_mobile=null ;
	private String phone_work=null ;
	private String phone_other=null ;
	private String phone_fax=null ;
	private String status=null ;
	private String address_street=null ;
	private String address_city=null ;
	private String address_state=null ;
	private String address_country=null ;
	private String address_postalcode=null ;
	private String alt_address_pobox=null ;
	private String messenger_id=null ;
	private String messenger_type=null ;
	private String reports_to_id=null ;
	private String date_format=null ;
	private String time_zone=null ;
	private String currency=null ;
	private String language=null ;

	
	// status for return (not for insert schema)
	private String Restatus = null;
	/**
	 * Default constructor.
	 */
	public Backup_users() {
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
		
		user_name = URLDecoder.decode(request.getParameter("user_name"),"UTF-8");
		user_password = URLDecoder.decode(request.getParameter("user_password"),"UTF-8");
		first_name = URLDecoder.decode(request.getParameter("first_name"),"UTF-8");
		last_name = URLDecoder.decode(request.getParameter("last_name"),"UTF-8");
		is_admin = URLDecoder.decode(request.getParameter("is_admin"),"UTF-8");
		title = URLDecoder.decode(request.getParameter("title"),"UTF-8");
		role_id = URLDecoder.decode(request.getParameter("role_id"),"UTF-8");
		department = URLDecoder.decode(request.getParameter("department"),"UTF-8");
		email = URLDecoder.decode(request.getParameter("email"),"UTF-8");
		secondaryemail = URLDecoder.decode(request.getParameter("secondaryemail"),"UTF-8");
		phone_home = URLDecoder.decode(request.getParameter("phone_home"),"UTF-8");
		phone_mobile = URLDecoder.decode(request.getParameter("phone_mobile"),"UTF-8");
		phone_work = URLDecoder.decode(request.getParameter("phone_work"),"UTF-8");
		phone_other = URLDecoder.decode(request.getParameter("phone_other"),"UTF-8");
		phone_fax = URLDecoder.decode(request.getParameter("phone_fax"),"UTF-8");
		status = URLDecoder.decode(request.getParameter("status"),"UTF-8");
		address_street = URLDecoder.decode(request.getParameter("address_street"),"UTF-8");
		address_city = URLDecoder.decode(request.getParameter("address_city"),"UTF-8");
		address_state = URLDecoder.decode(request.getParameter("address_state"),"UTF-8");
		address_country = URLDecoder.decode(request.getParameter("address_country"),"UTF-8");
		address_postalcode = URLDecoder.decode(request.getParameter("address_postalcode"),"UTF-8");
		alt_address_pobox = URLDecoder.decode(request.getParameter("alt_address_pobox"),"UTF-8");
		messenger_id = URLDecoder.decode(request.getParameter("messenger_id"),"UTF-8");
		messenger_type = URLDecoder.decode(request.getParameter("messenger_type"),"UTF-8");
		reports_to_id = URLDecoder.decode(request.getParameter("reports_to_id"),"UTF-8");
		date_format = URLDecoder.decode(request.getParameter("date_format"),"UTF-8");
		time_zone = URLDecoder.decode(request.getParameter("time_zone"),"UTF-8");
		currency = URLDecoder.decode(request.getParameter("currency"),"UTF-8");
		language = URLDecoder.decode(request.getParameter("language"),"UTF-8");

		
		
//		token_verification tt = new token_verification();
	   // int varify = tt.send(SME_ID,Token);
	    
	   // if( varify == 1){
		DBCollection connection = null;
		APIManager services = APIManager.INSTANCE;
		try {
			connection = services.getInstance(CSMP_DMM_API.backup_users_v1,"users");
			if (connection != null) {

				 //original SQL syntax
				 BasicDBObject doc = new BasicDBObject("schema", Replace_dbTableSechema+"values("+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+user_name+","+user_password+","+first_name+","+last_name+","+is_admin+","+title+","+role_id+","+department+","+email+","+secondaryemail+","+phone_home+","+phone_mobile+","+phone_work+","+phone_other+","+phone_fax+","+status+","+address_street+","+address_city+","+address_state+","+address_country+","+address_postalcode+","+alt_address_pobox+","+messenger_id+","+messenger_type+","+reports_to_id+","+date_format+","+time_zone+","+currency+","+language+");");
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
