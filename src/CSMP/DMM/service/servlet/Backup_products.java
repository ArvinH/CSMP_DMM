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
@WebServlet("/Insert_API_products")
public class Backup_products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String Replace_dbTableSechema = "replace into opportunities(id,deleted,SME_ID,date_entered,date_modified,modified_user_id,"+
				"created_by,description,assigned_user_id,name,discontinued,code,category,manufacturer,usageunit,qtyinstock,qtyindemand,"+
				"qty_per_unit,unit_price,currency,commissionrate,taxclass,sales_start_date,sales_end_date,start_date,expiry_date,mfr_part_no,vendor_part_no,"+
				"vendor_id,website,glacct,serialno,productsheet) ";
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
	private String name=null ;
	private String discontinued=null ;
	private String code=null ;
	private String category=null ;
	private String manufacturer=null ;
	private String usageunit=null ;
	private String qtyinstock=null ;
	private String qtyindemand=null ;
	private String qty_per_unit=null ;
	private String unit_price=null ;
	private String currency=null ;
	private String commissionrate=null ;
	private String taxclass=null ;
	private String sales_start_date=null ;
	private String sales_end_date=null ;
	private String start_date=null ;
	private String expiry_date=null ;
	private String mfr_part_no=null ;
	private String vendor_part_no=null ;
	private String vendor_id=null ;
	private String website=null ;
	private String glacct=null ;
	private String serialno=null ;
	private String productsheet=null ;

	
	// status for return (not for insert schema)
	private String status = null;
	/**
	 * Default constructor.
	 */
	public Backup_products() {
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
		discontinued = URLDecoder.decode(request.getParameter("discontinued"),"UTF-8");
		code = URLDecoder.decode(request.getParameter("code"),"UTF-8");
		category = URLDecoder.decode(request.getParameter("category"),"UTF-8");
		manufacturer = URLDecoder.decode(request.getParameter("manufacturer"),"UTF-8");
		usageunit = URLDecoder.decode(request.getParameter("usageunit"),"UTF-8");
		qtyinstock = URLDecoder.decode(request.getParameter("qtyinstock"),"UTF-8");
		qtyindemand = URLDecoder.decode(request.getParameter("qtyindemand"),"UTF-8");
		qty_per_unit = URLDecoder.decode(request.getParameter("qty_per_unit"),"UTF-8");
		unit_price = URLDecoder.decode(request.getParameter("unit_price"),"UTF-8");
		currency = URLDecoder.decode(request.getParameter("currency"),"UTF-8");
		commissionrate = URLDecoder.decode(request.getParameter("commissionrate"),"UTF-8");
		taxclass = URLDecoder.decode(request.getParameter("taxclass"),"UTF-8");
		sales_start_date = URLDecoder.decode(request.getParameter("sales_start_date"),"UTF-8");
		sales_end_date = URLDecoder.decode(request.getParameter("sales_end_date"),"UTF-8");
		start_date = URLDecoder.decode(request.getParameter("start_date"),"UTF-8");
		expiry_date = URLDecoder.decode(request.getParameter("expiry_date"),"UTF-8");
		mfr_part_no = URLDecoder.decode(request.getParameter("mfr_part_no"),"UTF-8");
		vendor_part_no = URLDecoder.decode(request.getParameter("vendor_part_no"),"UTF-8");
		vendor_id = URLDecoder.decode(request.getParameter("vendor_id"),"UTF-8");
		website = URLDecoder.decode(request.getParameter("website"),"UTF-8");
		glacct = URLDecoder.decode(request.getParameter("glacct"),"UTF-8");
		serialno = URLDecoder.decode(request.getParameter("serialno"),"UTF-8");
		productsheet = URLDecoder.decode(request.getParameter("productsheet"),"UTF-8");

		
//		token_verification tt = new token_verification();
	   // int varify = tt.send(SME_ID,Token);
	    
	   // if( varify == 1){
		DBCollection connection = null;
		APIManager services = APIManager.INSTANCE;
		try {
			connection = services.getInstance(CSMP_DMM_API.backup_products_v1,"products");
			if (connection != null) {

				 //original SQL syntax
				 BasicDBObject doc = new BasicDBObject("schema", Replace_dbTableSechema+"values("+id+","+deleted+","+SME_ID+","+date_entered+","+date_modified+","+modified_user_id+","+created_by+","+description+","+assigned_user_id+","+name+","+discontinued+","+code+","+category+","+manufacturer+","+usageunit+","+qtyinstock+","+qtyindemand+","+qty_per_unit+","+unit_price+","+currency+","+commissionrate+","+taxclass+","+sales_start_date+","+sales_end_date+","+start_date+","+expiry_date+","+mfr_part_no+","+vendor_part_no+","+vendor_id+","+website+","+glacct+","+serialno+","+productsheet+");");
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
