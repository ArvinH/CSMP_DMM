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
@WebServlet("/Insert_API_basesalesorders")
public class Backup_salesorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String Replace_dbTableSechema = "replace into opportunities(id,deleted,SME_ID,date_entered,date_modified,"+
				"modified_user_id,created_by,description,assigned_user_id,subject,opportunityid,accountid,quoteid,invoiceid,"+
				"purchaseorder,contactid,vendorid,duedate,carrier,sostatus,pending,salescommission,exciseduty,subtotal,adjustment,"+
				"total,taxtype,discount_percent,discount_amount,s_h_amount,terms_conditions,currency_id,conversion_rate,billing_address_street,"+
				"billing_address_city,billing_address_state,billing_address_postalcode,billing_address_country,billing_address_pobox,shipping_address_street,"+
				"shipping_address_city,shipping_address_state,shipping_address_postalcode,shipping_address_country,shipping_address_pobox) ";
	private String Token = null;
	private String id=null ;
	private String deleted=null ;
	private String SME_ID=null ;
	private String date_entered=null ;
	private String date_modified=null ;
	private String modified_user_id=null ;
	private String created_by=null ;
	private String description=null ;
	
	private String assigned_user_id=null ;
	private String subject=null ;
	private String opportunityid=null ;
	private String accountid=null ;
	private String quoteid=null ;
	private String invoiceid=null ;
	private String purchaseorder=null ;
	private String contactid=null ;
	private String vendorid=null ;
	private String duedate=null ;
	private String carrier=null ;
	private String sostatus=null ;
	private String pending=null ;
	private String salescommission=null ;
	private String exciseduty=null ;
	private String subtotal=null ;
	private String adjustment=null ;
	private String total=null ;
	private String taxtype=null ;
	private String discount_percent=null ;
	private String discount_amount=null ;
	private String s_h_amount=null ;
	private String terms_conditions=null ;
	private String currency_id=null ;
	private String conversion_rate=null ;
	private String billing_address_street=null ;
	private String billing_address_city=null ;
	private String billing_address_state=null ;
	private String billing_address_postalcode=null ;
	private String billing_address_country=null ;
	private String billing_address_pobox=null ;
	private String shipping_address_street=null ;
	private String shipping_address_city=null ;
	private String shipping_address_state=null ;
	private String shipping_address_postalcode=null ;
	private String shipping_address_country=null ;
	private String shipping_address_pobox=null ;

	
	// status for return (not for insert schema)
	private String status = null;
	/**
	 * Default constructor.
	 */
	public Backup_salesorders() {
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
		subject = URLDecoder.decode(request.getParameter("subject"),"UTF-8");
		opportunityid = URLDecoder.decode(request.getParameter("opportunityid"),"UTF-8");
		accountid = URLDecoder.decode(request.getParameter("accountid"),"UTF-8");
		quoteid = URLDecoder.decode(request.getParameter("quoteid"),"UTF-8");
		invoiceid = URLDecoder.decode(request.getParameter("invoiceid"),"UTF-8");
		purchaseorder = URLDecoder.decode(request.getParameter("purchaseorder"),"UTF-8");
		contactid = URLDecoder.decode(request.getParameter("contactid"),"UTF-8");
		vendorid = URLDecoder.decode(request.getParameter("vendorid"),"UTF-8");
		duedate = URLDecoder.decode(request.getParameter("duedate"),"UTF-8");
		carrier = URLDecoder.decode(request.getParameter("carrier"),"UTF-8");
		sostatus = URLDecoder.decode(request.getParameter("sostatus"),"UTF-8");
		pending = URLDecoder.decode(request.getParameter("pending"),"UTF-8");
		salescommission = URLDecoder.decode(request.getParameter("salescommission"),"UTF-8");
		exciseduty = URLDecoder.decode(request.getParameter("exciseduty"),"UTF-8");
		subtotal = URLDecoder.decode(request.getParameter("subtotal"),"UTF-8");
		adjustment = URLDecoder.decode(request.getParameter("adjustment"),"UTF-8");
		total = URLDecoder.decode(request.getParameter("total"),"UTF-8");
		taxtype = URLDecoder.decode(request.getParameter("taxtype"),"UTF-8");
		discount_percent = URLDecoder.decode(request.getParameter("discount_percent"),"UTF-8");
		discount_amount = URLDecoder.decode(request.getParameter("discount_amount"),"UTF-8");
		s_h_amount = URLDecoder.decode(request.getParameter("s_h_amount"),"UTF-8");
		terms_conditions = URLDecoder.decode(request.getParameter("terms_conditions"),"UTF-8");
		currency_id = URLDecoder.decode(request.getParameter("currency_id"),"UTF-8");
		conversion_rate = URLDecoder.decode(request.getParameter("conversion_rate"),"UTF-8");
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

		
		
//		token_verification tt = new token_verification();
	   // int varify = tt.send(SME_ID,Token);
	    
	   // if( varify == 1){
		DBCollection connection = null;
		APIManager services = APIManager.INSTANCE;
		try {
			connection = services.getInstance(CSMP_DMM_API.backup_salesorders_v1,"salesorders");
			if (connection != null) {

				 //original SQL syntax
				 BasicDBObject doc = new BasicDBObject("schema", Replace_dbTableSechema+"values("+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+assigned_user_id+","+subject+","+opportunityid+","+accountid+","+quoteid+","+invoiceid+","+purchaseorder+","+contactid+","+vendorid+","+duedate+","+carrier+","+sostatus+","+pending+","+salescommission+","+exciseduty+","+subtotal+","+adjustment+","+total+","+taxtype+","+discount_percent+","+discount_amount+","+s_h_amount+","+terms_conditions+","+currency_id+","+conversion_rate+","+billing_address_street+","+billing_address_city+","+billing_address_state+","+billing_address_postalcode+","+billing_address_country+","+billing_address_pobox+","+shipping_address_street+","+shipping_address_city+","+shipping_address_state+","+shipping_address_postalcode+","+shipping_address_country+","+shipping_address_pobox+");");
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
