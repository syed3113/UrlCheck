package API.AMP;

import static com.jayway.restassured.RestAssured.*;



import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class AMP_Validation {
	public static Xlfile_Reader xl;
	public static int totalTestCase=0;
	public static int passedTestCases=0;
	public static int failedTestCases=0;
	@BeforeSuite
	
	public static void startTesting() throws Exception
	{
		//Xlfile_Reader xl= new Xlfile_Reader();
	   Xlfile_Reader.setExcelFile("/home/ahtisham/Automation/AMP/src/test/java/API/AMP/AMP.xls", "Sheet1");
	   
	}

	
	/*
	 * @Test public static void Verify3() throws Exception { Boolean validate =
	 * null; String s1= null; String s2 = "true"; RestAssured.baseURI
	 * ="https://amp.cloudflare.com/q"; Response res= given()
	 * .contentType(ContentType.JSON) .when() .get(xl.getCellData(8,0));
	 * System.out.println("Excel Data:-" +xl.getCellData(8, 0));
	 * 
	 * String text = res.asString(); System.out.println("Data:-" +text); try {
	 * validate = res.jsonPath().get("valid"); System.out.println(validate); s1 =
	 * Boolean.toString(validate); } catch (Exception e) {
	 * System.out.println("Catch Block"); //xl.setCellData(text,i,1); }
	 * Assert.assertEquals(s1, s2);; System.out.println("False");
	 * 
	 * 
	 * }
	 * 
	 */

	  @Test
	  
	  public static void Verify() throws Exception { Boolean validate = null;
	  
	  int f2 = failedTestCases;
		 String fail1 = Integer.toString(f2);
		  System.out.println("Failed Test Cases:-"+fail1);
		 xl.setCellData(fail1,3,1);
		 
		 int p2 = passedTestCases;
			 String pass1 = Integer.toString(p2);
			  System.out.println("Passed Test Cases:-"+pass1);
			 xl.setCellData(pass1,2,1);
	  
	  for(int i=6;i<=Xlfile_Reader.getRowCount("Sheet1");i++) {
		  System.out.println(Xlfile_Reader.getRowCount("Sheet1"));
	 /* 
	  Xlfile_Reader xl= new Xlfile_Reader(); Xlfile_Reader.setExcelFile(
	  "/home/ahtisham/Automation/AMP/src/test/java/API/AMP/AMP.xls", "Sheet1");*/
	  RestAssured.baseURI ="https://amp.cloudflare.com/q";
	  Response res=
		 given()
	  .contentType(ContentType.JSON) 
	  .when() 
	  //.get("/www.91mobiles.com/best-mobiles-in-india-amp");
	  //.get(xl.getCellData(i,0)+"-amp"); 
	  .get(xl.getCellData(i,0));
	  
	  System.out.println("Excel Data:-" +xl.getCellData(i, 0));
			
			  int t = totalTestCase++;
			 // int t1 = t+1;
			  String all = Integer.toString(t);
			  System.out.println("Total Test Cases:-"+all);
			  xl.setCellData(all,1,1);
			 
	  String text = res.asString(); System.out.println("Data:-" +text); 
	  try {
	  validate = res.jsonPath().get("valid");
	  System.out.println(validate); } 
	  catch (Exception e) { System.out.println("Catch Block");}
	  //xl.setCellData(text,i,1); } 
	  if(validate.equals(false)) {
	  System.out.println("Result Fail"); 
	  xl.setCellData("Fail",i,1);
	 int f = failedTestCases++;
	 int f1 = f+1;
	 String fail = Integer.toString(f1);
	  System.out.println("Failed Test Cases:-"+fail);
	 xl.setCellData(fail,3,1);
	  
	  
	  }
	  
	  else if(validate.equals(true)) {
		  System.out.println("Result Pass");
		  xl.setCellData("Pass",i,1);
		  int p = passedTestCases++;
		  int p1 = p+1;
			 String pass = Integer.toString(p1);
			  System.out.println("Passed Test Cases:-"+pass);
			 xl.setCellData(pass,2,1);
	  }
	  
	  
	  }
	  
	   }
	 
	
	
	@AfterSuite
	
	public static void endScript() throws Exception
	{
	
		//Xl.generateReport("excel-report.xlsx");
		//SendMail.send("syed.gaadi@gmail.com", InvokeMail.to, "JUnit Report", "Check the PDF attachment.");
		SendMail.send(InvokeMail.server, InvokeMail.from, InvokeMail.to, InvokeMail.subject, InvokeMail.messageBody, InvokeMail.attachmentPath, InvokeMail.attachmentName);
	}
	
}
