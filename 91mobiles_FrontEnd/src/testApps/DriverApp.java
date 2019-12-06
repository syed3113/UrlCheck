package testApps;

import datatable.Xlfile_Reader;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.SeleniumServer;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testReports.TestReports;
import util.TestConfig;
import util.TestUtil;
import util.monitoringMail;
public class DriverApp{
	
	public static Properties CONFIG;
	public static Properties Objects;
	public static Properties APPTEXT;
	public static Xlfile_Reader Core;
	public static Xlfile_Reader testData=null;
	public static Xlfile_Reader DBresults=null;
	public static Random randomGenerator = new Random(); // Random Port Number generation 
	public static String currentTest;
	public static String keyword;
	//public static SeleniumServer server;
	//public static DefaultSelenium selenium=null;
	public static WebDriver driver=null;
	//public static EventFiringWebDriver driver=null;
	public static String object;
	public static String currentTSID;
	public static String stepDescription;
	public static String proceedOnFail;
	public static String testStatus;
	public static String data_column_name;
	public static int  testRepeat;
	public static int nSelPort;
	public static String sSelPort;
	public static Calendar cal = new GregorianCalendar();
	public static  int month = cal.get(Calendar.MONTH);
	public static int year = cal.get(Calendar.YEAR);
	public static  int sec =cal.get(Calendar.SECOND);
	public static  int min =cal.get(Calendar.MINUTE);
	public static  int date = cal.get(Calendar.DATE);
	public static  int day =cal.get(Calendar.HOUR_OF_DAY);
	public static String strDate;
	public static String result;
	public static String mailresult=" - Script successfully executed - no errors found";
	public static String mailscreenshotpath;
	public static final Logger SELENIUM_LOGS = Logger.getRootLogger();
	public static final Logger APPLICATION_LOGS = Logger.getLogger("QALogger");
	
	public static int totalTestCase=0;
	public static int passedTestCases=0;
	public static int failedTestCases=0;
	public static String startTime;
	public static String endTime;
	
	public static long startexecutionTime=0;

	//Get the current system time - used for generated unique file ids (ex: Screenshots, Reports etc on every test run)
	public static String getCurrentTimeStamp()
    { 
          SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy"+"_"+"HH-mm-ss");
          Date now = new Date(); 
         String CDate = CurrentDate.format(now); 
          return CDate; 
    }

	
	
	//Loaded the Selenium and Application log files
	
	
		

	
	
   	@BeforeSuite
	public void startTesting() throws Exception{
   		
   		// Code to Generate random numbers
   		
		 nSelPort = randomGenerator.nextInt(40000);
		 startexecutionTime=System.currentTimeMillis();
		// strDate=getCurrentTimeStamp();
		 strDate = TestUtil.now("dd.MMMMM.yyyy").toString();
		 startTime=TestUtil.now("hh.mm.ss aaa");
     	System.out.println("date time stamp :"+strDate);
		 
		 // Start testing method will start generating the Test Reports from the beginning       
		//TestReports.startTesting("//opt//tomcat//webapps//ROOT//htmlpages//index"+strDate+".html",
     TestReports.startTesting("//var//www//html//htmlpages//index"+strDate+".html",
		TestUtil.now("hh.mm.ss aaa"), 
        "91mobiles Live",
        "-");
		
				
			 
				
				
				
       //Loading Config File
		CONFIG = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//config//config.properties");
		//FileInputStream fs = new FileInputStream("\\home\\ahtisham\\Desktop\\91mobiles\\src\\config\\config.properties");
		CONFIG.load(fs);
		
		
		// LOAD Objects properties File
		Objects = new Properties();
		fs = new FileInputStream(System.getProperty("user.dir")+"//src//config//Objects.properties");
		Objects.load(fs);
		
	
		//Load datatable
		Core= new Xlfile_Reader(System.getProperty("user.dir")+"//src//config//Core.xlsx");
		testData  =  new Xlfile_Reader(System.getProperty("user.dir")+"//src//config//TestData.xlsx");
		
		
		
		//System.setProperty("webdriver.gecko.driver", CONFIG.getProperty("driverPath"));
		
		// System.setProperty("webdriver.gecko.driver",  "//usr//local//bin//geckodriver");
		
			
		
		
		
		//Phantom Driver
		
		/*
		 * DesiredCapabilities capabilities = new DesiredCapabilities();
		 * 
		 * capabilities.setJavascriptEnabled(true);
		 * capabilities.setCapability(PhantomJSDriverService.
		 * PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"/home/ahtisham/Desktop/Phantom/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
		 * capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		 * capabilities.setPlatform(Platform.ANY); 
		 * driver = new PhantomJSDriver(capabilities);
		 */
		 
		 
		 
		// DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities = DesiredCapabilities.firefox();
		 // capabilities.setBrowserName("firefox"); capabilities.setVersion("45.0.2");
		// capabilities.setPlatform(Platform.LINUX);
		 // capabilities.setCapability("marionette", false); 
		 // driver = newFirefoxDriver(capabilities);
		/*FirefoxBinary firefoxBinary = new FirefoxBinary();
		 * 
	    firefoxBinary.addCommandLineOptions("--headless");
	    System.setProperty("webdriver.gecko.driver", "/home/ahtisham/Desktop/driver/geckodriver");
	    
	    FirefoxOptions firefoxOptions = new FirefoxOptions();
	    firefoxOptions.setCapability("marionette", false);
	    firefoxOptions.setBinary(firefoxBinary);
	     driver = new FirefoxDriver(firefoxOptions);*/
		
		// Html Unit Driver
		 // driver = new HtmlUnitDriver();
		 
		 
		
		//Chrome Driver Headless
		
		
		  
		  System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
		  //System.setProperty("webdriver.chrome.driver", "/usr/lib64/chromium-browser/chromedriver"); //Server location ChromeOptions
		  ChromeOptions chromeOptions =new ChromeOptions(); 
		  chromeOptions.addArguments("--headless");
		  //chromeOptions.addArguments("window-size=1920, 1080"); 
		  driver = new ChromeDriver(chromeOptions);
		 
		 
		 
		 
		 
		  
		 
		 
		 
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "/home/ahtisham/Desktop/driver/geckodriver"); FirefoxOptions options = new
		 * FirefoxOptions(); options.setHeadless(true); WebDriver driver = new
		 * FirefoxDriver(options);
		 */
			
		 
		  
		   // Firefox with head
		  
		
		
		
		
		
		/*
		 * DesiredCapabilities capabilities = new DesiredCapabilities(); capabilities =
		 * DesiredCapabilities.firefox(); capabilities.setBrowserName("firefox");
		 * capabilities.setVersion("45.0.2"); capabilities.setPlatform(Platform.LINUX);
		 * capabilities.setCapability("marionette", false); driver = new
		 * FirefoxDriver(capabilities);
		 */
		 
		 
		  
		 
		 
		 
		 
				//System.setProperty("webdriver.gecko.driver", CONFIG.getProperty("driverPath"));
				////usr//local/bin//geckodriver.exe
				//maximize window
				driver.manage().window().maximize();
				
				
				
				//wait for 30 seconds and then fail
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
				
	
		
	}
	
	@Test
	
	public void testApp() {
		
		String startTime=null;
		
		
		
		TestReports.startSuite("Suite 1");
		totalTestCase=Core.getRowCount("Suite1");
		
		for(int tcid=2 ; tcid<=Core.getRowCount("Suite1");tcid++){
			currentTest = Core.getCellData("Suite1", "TCID", tcid);
			
			// initilize start time of test
			if(Core.getCellData("Suite1", "Runmode", tcid).equals("Y")){
				
				// executed the keywords
				
				// loop again - rows in test data
				int totalSets=testData.getRowCount(currentTest+"1");; // holds total rows in test data sheet. IF sheet does not exist then 2 by default
				if(totalSets<=1){
					totalSets=2; // run atleast once
				}
					
				for( testRepeat=2; testRepeat<=totalSets;testRepeat++){	
					startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");

				APPLICATION_LOGS.debug("Executing the test "+ currentTest);
				
				// implemented keywords file
				try{
				for(int tsid=2;tsid<=Core.getRowCount(currentTest);tsid++){
					
					
					// Get values from xls file
					
					keyword=Core.getCellData(currentTest, "Keyword", tsid);
					object=Core.getCellData(currentTest, "Object", tsid);
					currentTSID=Core.getCellData(currentTest, "TSID", tsid);
					stepDescription=Core.getCellData(currentTest, "Description", tsid);
					proceedOnFail=Core.getCellData(currentTest, "ProceedOnFail", tsid);
					data_column_name=Core.getCellData(currentTest, "Data_Column_Name", tsid);
				    //System.out.println(keyword);
					Method method= KeywordsApp.class.getMethod(keyword);
					result = (String)method.invoke(method);
					APPLICATION_LOGS.debug("***Result of execution -- "+result);
					
					// take screenshot - every keyword
					String fileName="Suite1_TC"+(tcid-1)+"_TS"+tsid+"_"+keyword+testRepeat+".jpg";
				
					
					if(result.startsWith("Pass")){
						//passedTestCases++;
						//System.out.println("Passed Test Cases:-"+passedTestCases);
						testStatus=result;
						//passedTestCases++;
						//Uncomment this one to capture screenshots in case of Pass
					//	TestUtil.captureScreenshot(CONFIG.getProperty("screenshotPath")+TestUtil.imageName+".jpeg");
						
				TestReports.addKeyword(stepDescription, keyword, result, "http://"+TestUtil.Handeler()+":8282//screenshots//"+TestUtil.imageNameIP);//+".jpeg"
					
					}
					
					else if(result.startsWith("Fail")){
							testStatus=result;
							failedTestCases++;
							System.out.println("Fail Block");
							
							
							String link="<a href=http://"+TestUtil.Handeler()+"//htmlpages"+"//Suite_1_TC"+tcid+"_"+currentTest.replaceAll(" ", "_")+DriverApp.year+"_"+DriverApp.date+"_"+(DriverApp.month+1)+"_"+DriverApp.day+"_"+DriverApp.min+"_" +DriverApp.sec+".html>"+currentTest+"</a>";
							TestUtil.captureScreenshot(CONFIG.getProperty("screenshotPath")+TestUtil.imageName+".jpeg");
							TestReports.addKeyword(stepDescription, keyword, result, "http://"+TestUtil.Handeler()+"//screenshots//"+TestUtil.imageNameIP+".jpeg");
							
							TestConfig.addLinkDetail(tcid, link, startTime, TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),testStatus);
							TestUtil.captureScreenshot(CONFIG.getProperty("screenshotPath")+TestUtil.imageName+".jpeg"); //+".jpeg"
							//System.out.println("SS");
							
							//failedTestCases++;
							// take screenshot - only on error
						
						
							//changed to make the screenshot path generic
						//TestReports.addKeyword(stepDescription, keyword, result, "http://"+TestUtil.Handeler()+":8282//screenshots//"+TestUtil.imageNameIP);//+".jpeg"
					//	TestReports.addKeyword(stepDescription, keyword, result, "http://"+TestUtil.Handeler()+"//screenshots//"+TestUtil.imageNameIP+".jpeg");
						//TestReports.addKeyword(stepDescription, keyword, result, mailscreenshotpath);
					
					
						//	mailscreenshotpath = "C:/CMAutomation/tomcat-6.0/webapps/ROOT/screenshots/"+currentTest+currentTSID+TestUtil.year+"_"+TestUtil.date+"_"+(TestUtil.month+1)+"_"+TestUtil.day+"_"+TestUtil.min+"_" +TestUtil.sec+".jpeg";
						mailscreenshotpath = TestUtil.imageName+".jpeg";  //+".jpeg"
						System.out.println("Screenshot path :: "+ mailscreenshotpath);
						
						//System.out.println("Your attachment path"+ TestConfig.attachmentPath);
							mailresult=" - Script failed ";
							
								
								  if(proceedOnFail.equalsIgnoreCase("N")) {
								  
								  break;
								  
								  
								  }
								 
					//	break;
						
						}
					
					}
					
				}
				
				catch(Throwable t){
					APPLICATION_LOGS.debug("Error came");
					
					
					
				}
				
				// report pass or fail in HTML Report
				
				if(testStatus == null){
					testStatus="Pass"; 
					
				}
				APPLICATION_LOGS.debug("######################"+currentTest+" --- " +testStatus);
				
				
				TestReports.addTestCase(currentTest, 
										startTime, 
										TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),
										testStatus,tcid );
				
					/*
					 * if(result.startsWith("Fail")){
					 * 
					 * break; }
					 */
			
			
				
				}// test data 

				
			}else{
				APPLICATION_LOGS.debug("Skipping the test "+ currentTest);
				testStatus="Skip";
				
				// report skipped
				APPLICATION_LOGS.debug("#######################"+currentTest+" --- " +testStatus);
				/*
				 * TestReports.addTestCase(currentTest,
				 * TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),
				 * TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), testStatus );
				 */
				
			}
			
			
			 if(testStatus.startsWith("Pass")){
			  passedTestCases++;System.out.println("Pass Uncomment"); }
			 /* 
			 * else if(testStatus.startsWith("Fail")) { failedTestCases++;
			 * System.out.println("Fail Uncomment");String
			 * link="<a href=http://"+TestUtil.Handeler()+"//htmlpages"+"//Suite_1_TC"+tcid+
			 * "_"+currentTest.replaceAll(" ",
			 * "_")+DriverApp.year+"_"+DriverApp.date+"_"+(DriverApp.month+1)+"_"+DriverApp.
			 * day+"_"+DriverApp.min+"_" +DriverApp.sec+".html>"+currentTest+"</a>";
			 * TestReports.addKeyword(stepDescription, keyword, result,
			 * "http://"+TestUtil.Handeler()+":8282//screenshots//"+TestUtil.imageNameIP);
			 * TestConfig.addLinkDetail(tcid, link, startTime,
			 * TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),testStatus);
			 * 
			 * }
			 */
			 
			 
			 
			testStatus=null;
			/*
			if(result.startsWith("Fail")){
                break; 
                }*/

		}
		TestReports.endSuite();
	}
	
	
	

	
	@AfterSuite
	public static void endScript() throws Exception{
		
		// Once the test is completed update the end time in HTML report
		TestReports.updateEndTime(TestUtil.now("hh.mm.ss aaa"));
		
	    endTime=TestUtil.now("hh.mm.ss aaa");
		//long totaltimeTaken=(System.currentTimeMillis()-startexecutionTime)/(1000*60) ;
		// Sending Mail when script fails
		//if(result.startsWith("Fail")){
			
			
		//driver.quit();
		
			//monitoringMail.sendMail(TestConfig.server, TestConfig.from,TestConfig.username, TestConfig.password,TestConfig.port, TestConfig.to, TestConfig.subject+mailresult+" "+"on step "+stepDescription+'-'+" "+result+" "+" "+"Timed out after "+Keywords.globalwait+" seconds", TestConfig.messageBody, mailscreenshotpath, TestConfig.attachmentName);
		//monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,TestConfig.subject+mailresult+" "+"on step "+stepDescription+'-'+" "+result+" "+" "+"Timed out after "+KeywordsApp.globalwait+" seconds", TestConfig.messageBody, mailscreenshotpath, TestConfig.attachmentName);
		//monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject,TestConfig.getMessageBody(totalTestCase, passedTestCases, failedTestCases, strDate, startTime,endTime));//,totaltimeTaken
		//driver.quit();
			
		//}
		
		// Sending Mail After Execution of All TestCases 
		
	//	monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject+mailresult, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		
		//or
		
		//monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
	    monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.getMessageBody(totalTestCase, passedTestCases, failedTestCases, strDate, startTime,endTime));//,totaltimeTaken
	   driver.quit();
		

	}
	

}
