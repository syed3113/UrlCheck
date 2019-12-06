package AMP;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;







public class AMP_Validation {
	
	public static Xlfile_Reader xl;
	public static int totalTestCase=1;
	public static int passedTestCases=0;
	public static int failedTestCases=0;
	public static WebDriver driver;
	@BeforeSuite
	public  static void startTesting() throws Exception
	{
		//Xlfile_Reader xl= new Xlfile_Reader();
	   Xlfile_Reader.setExcelFile("/home/ahtisham/Automation/AMP_Beta/src/AMP/AMP.xls", "Sheet1");
	   	   
	}
	@Test
	 public  static void Verify() throws Exception {
		 
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "/usr/lib/chromium-browser/chromedriver");
		 * //System.setProperty("webdriver.chrome.driver",
		 * "/usr/lib64/chromium-browser/chromedriver"); //Server location ChromeOptions
		 * chromeOptions =new ChromeOptions(); chromeOptions.addArguments("--headless");
		 * //chromeOptions.addArguments("window-size=1920, 1080"); WebDriver driver =
		 * new ChromeDriver(chromeOptions);
		 */
          
       System.setProperty("webdriver.chrome.driver","/home/ahtisham/Downloads/chromedriver (11)");
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		/*
		 * DesiredCapabilities capabilities = new DesiredCapabilities(); capabilities =
		 * DesiredCapabilities.firefox(); capabilities.setBrowserName("firefox");
		 * capabilities.setVersion("45.0.2"); capabilities.setPlatform(Platform.LINUX);
		 * capabilities.setCapability("marionette", false); driver = new
		 * FirefoxDriver(capabilities);
		 */
		 
		 
		 
		
	  
	  int f2 = failedTestCases;
		     String fail1 = Integer.toString(f2);
		     System.out.println("Failed Test Cases:-"+fail1);
		     xl.setCellData(fail1,3,1);
		 
		 int p2 = passedTestCases;
			 String pass1 = Integer.toString(p2);
			 System.out.println("Passed Test Cases:-"+pass1);
			 xl.setCellData(pass1,2,1);
	  driver.get("https://validator.ampproject.org/");
		/*
		 * totalTestCase=Xlfile_Reader.getRowCount("Sheet1"); int t = totalTestCase; //
		 * int t1 = t+1; String all = Integer.toString(t);
		 * System.out.println("Total Test Cases:-"+all); xl.setCellData(all,1,1);
		 */
	
	  System.out.println("Total Test Cases:-"+totalTestCase);
	 // xl.setCellData(totalTestCase,1,1);
	  for(int i=6;i<=Xlfile_Reader.getRowCount("Sheet1");i++) {
		  
		    System.out.println(Xlfile_Reader.getRowCount("Sheet1"));
	        WebElement val =   driver.findElement(By.xpath("(//*[@id=\"input\"])[2]"));
	        System.out.println("Excel Check:-"+xl.getCellData(i,0));
	        val.sendKeys(xl.getCellData(i,0));
	        Thread.sleep(3000);
	        driver.findElement(By.id("validateButton")).click();
	        Thread.sleep(7000);
	        System.out.println("Excel Data:-" +xl.getCellData(i, 0));
			//driver.navigate().refresh();
			
			int t = totalTestCase++; 
			int t1 = t+1; 
			String all = Integer.toString(t);
			System.out.println("Total Test Cases:-"+all); 
			xl.setCellData(all,1,1);
			 
	 
	 
	  String text =driver.findElement(By.xpath("//*[@id=\"statusBar\"]/paper-material/div/span")).getText();
	  System.out.println(text);
	  //xl.setCellData(text,i,1); } 
	  if(text.equals("FAIL")) {
				/*
				 * try { String s =
				 * driver.findElement(By.xpath("(//*[contains(text(),'Page not found')])")).
				 * getText(); System.out.println(s); }catch(Exception e) {}
				 */
	  System.out.println("Result Fail"); 
	  xl.setCellData("Fail",i,1);
	  int f = failedTestCases++;
	  int f1 = f+1;
	  String fail = Integer.toString(f1);
	  System.out.println("Failed Test Cases:-"+fail);
	  xl.setCellData(fail,3,1);
		  
	  
	  }
	  
	  else if(text.equals("PASS")) {
		  System.out.println("Result Pass");
		  xl.setCellData("Pass",i,1);
		  int p = passedTestCases++;
		  int p1 = p+1;
		  String pass = Integer.toString(p1);
		  System.out.println("Passed Test Cases:-"+pass);
		  xl.setCellData(pass,2,1);
	  }
	  val.clear();
	  
	  }
	  
	   }
	 
	
	 
	@AfterSuite
	
	public static void endScript() throws Exception
	{
	
		//Xl.generateReport("excel-report.xlsx");
		//SendMail.send("syed.gaadi@gmail.com", InvokeMail.to, "JUnit Report", "Check the PDF attachment.");
		SendMail.send(InvokeMail.server, InvokeMail.from, InvokeMail.to, InvokeMail.subject, InvokeMail.messageBody, InvokeMail.attachmentPath, InvokeMail.attachmentName);
		driver.quit();
	}
	
	

}
