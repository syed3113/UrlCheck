package AMP.mobiles;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class AMP_Validation {
	
	static ExtentReports report;
	 static ExtentTest logger;
	 
	 
	@Test
	
	public static void Verify() throws Exception {
		 report=new ExtentReports("./Reports/TestReport.html");
		logger=report.startTest("VerifySum");
		Boolean validate = null;
	    for(int i=5;i<=10;i++) {
	    	
		Xlfile_Reader xl= new Xlfile_Reader();
		Xlfile_Reader.setExcelFile("/home/ahtisham/Automation/91mobiles_AMP/src/test/java/AMP/mobiles/AMP.xls", "Sheet1");
		RestAssured.baseURI ="https://amp.cloudflare.com/q";
		Response res=
		 given()
		 .contentType(ContentType.JSON)
		 .when()
		// .get("/www.91mobiles.com/best-mobiles-in-india-amp");
		// .get(xl.getCellData(i,0)+"-amp");
		 .get(xl.getCellData(i,0));
		
		System.out.println("Excel Data:-" +xl.getCellData(i, 0));
		 
		String text = res.asString();
		 System.out.println("Data:-" +text);
		 logger.log(LogStatus.PASS, "Test Verified");
		try {
		 validate = res.jsonPath().get("valid");
		System.out.println(validate);
		} 
		catch (Exception e) {
			System.out.println("Catch Block");
			//xl.setCellData(text,i,1);
		}
		if(validate.equals(false))
		{
			System.out.println("Result Fail");
			xl.setCellData("Fail",i,1);
			
			
		}
		
		else if(validate.equals(true))
		{
			System.out.println("Result Pass");
			xl.setCellData("Pass",i,1);
		}
	    	
	}
	}
	
	
	@AfterSuite
	
	public static void endScript() throws Exception
	{
	      report.endTest(logger);
	      report.flush();
	
	}
	
}


