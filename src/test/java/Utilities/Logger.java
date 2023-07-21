package Utilities;


import java.sql.Timestamp;

import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.base.TestBase; 

public class Logger extends TestBase {
	
	public  void info(String msg) {
 
		System.out.println(msg);	
		test.log(Status.INFO, msg);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [INFO] : " + msg;
		
		// TestNG Logs
		if(!msg.isEmpty()) { Reporter.log(logs); }
	}
	
	public  void info(Double msg) {
 
		System.out.println(msg);	
		test.log(Status.INFO,String.valueOf(msg));
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [INFO] : " + msg;
		
		// TestNG Logs
		if(msg != null) { Reporter.log(logs); }
	}
       
	public  void error(String msg) {
		
		System.err.println(msg);
		test.log(Status.ERROR, msg);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [ERROR] : " + msg;
				
		// TestNG Logs
		if(!msg.isEmpty()) { Reporter.log(logs); }
	}

	public  void info(int msg)  {
 
		System.out.println(msg);	
		test.log(Status.INFO,String.valueOf(msg));
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [INFO] : " + msg;
	 
	}
	
	
	public  void warn(String msg) throws Exception {
		
		System.out.println(msg);
		test.log(Status.WARNING, msg);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [WARN] : " + msg;
		
		// TestNG Logs
		if(!msg.isEmpty()) { Reporter.log(logs); }
	}
	
	public  void pass(String msg) throws Exception {
		
		System.out.println(msg);
		test.log(Status.PASS, msg);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [PASS] : " + msg;
		
		// TestNG Logs
		if(!msg.isEmpty()) { Reporter.log(logs); }
	}
	
	public  void fail(String msg) throws Exception {
		
		System.err.println(msg);
		test.log(Status.FAIL, msg);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [FAIL] : " + msg;
		
		// TestNG Logs
		if(!msg.isEmpty()) { Reporter.log(logs); }
	} 
}
