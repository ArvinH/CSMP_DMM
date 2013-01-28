package CSMP.DMM.service.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataModel {
	private Connection conn = null; 
	private Statement stmt = null; 
	private ResultSet rs = null; 
	private PreparedStatement pst = null; 

	public InsertDataModel(){
	
	}
	
	public void InsertTable(String insertdbSQL, String[] list){
	 	try 
	    { 
	      pst = conn.prepareStatement(insertdbSQL); 
	      
	      int index = 1;
	      while(index <= list.length)
	      {
	    	  pst.setString(index, list[index - 1]);
	    	  index = index + 1;
	      }
	      pst.executeUpdate(); 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("InsertDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	    
	    } 
	}
	
	
}
