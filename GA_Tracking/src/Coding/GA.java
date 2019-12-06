package Coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GA {

	public static void main(String[] args) {
		
		WebDriver driver ;
		

		
		  DesiredCapabilities capabilities = new DesiredCapabilities(); capabilities =
		  DesiredCapabilities.firefox(); capabilities.setBrowserName("firefox");
		  capabilities.setVersion("45.0.2"); capabilities.setPlatform(Platform.LINUX);
		 capabilities.setCapability("marionette", false); driver = new
		  FirefoxDriver(capabilities);
		 
		
		
		
		
		
		driver.get("https://www.91mobiles.com/top-10-mobiles-in-india");
		JavascriptExecutor js = (JavascriptExecutor)driver;

        ArrayList<Map<String, List<String> >> myList = new ArrayList<>();

        //Execute GTM script to fetch values       
        myList =  (ArrayList) js.executeScript("return window.dataLayer");

        // Parse through GTM arrayList  
        for(int a=0; a < myList.size(); a++) {
            for (String key : myList.get(a).keySet()) {
                System.out.println(key + "      " + myList.get(a).get(key));

            }
        }

		
		
	}
	
	
}
