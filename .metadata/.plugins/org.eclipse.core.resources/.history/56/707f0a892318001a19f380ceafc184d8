package lotame.laptopurl;

import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HitUrlTest {
	WebDriver driver;
	Instant start;

	@Test
	public void hitUrlTest() throws Exception {
		Xlfile_Reader.setExcelFile("../Lotame-Url/src/test/java/lotame/laptopurl/Lotame_laptop_pages.xls", "Sheet1");
		for (int i = 1; i < Xlfile_Reader.getRowCount("Sheet1"); i++) {
			System.out.println(Xlfile_Reader.getRowCount("Sheet1"));
			String url = Xlfile_Reader.getCellData(i, 0);
			System.out.println("Url:-" + url);

			
			
			  System.setProperty("webdriver.chrome.driver",
			  "/usr/lib64/chromium-browser/chromedriver"); // Server location //
			  
			  ChromeOptions chromeOptions = new ChromeOptions();
			  chromeOptions.addArguments("--headless"); //
			  chromeOptions.addArguments("window-size=1920, 1080");
			  chromeOptions.addArguments(
			  " Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36"
			  ); driver = new ChromeDriver(chromeOptions);
			 
			 

			// For local mobile view testing

			
			/*
			 * ChromeOptions chromeOptions = new ChromeOptions(); //
			 * chromeOptions.addArguments("--headless"); //
			 * chromeOptions.addArguments("window-size=1920, 1080");
			 * chromeOptions.addArguments(
			 * " Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36"
			 * ); driver = new ChromeDriver(chromeOptions);
			 */
			int j;
			start = Instant.now();
			for (j = 1; j <= 1000; j++)

			{
				driver.get(url);

				Date time = new java.util.Date(System.currentTimeMillis());
				System.out.println("Time:-" + time);
				System.out.println(new SimpleDateFormat("HH:mm:ss").format(time));

				System.out.println("Number of hits :-" + j);

			}
			Xlfile_Reader.setCellData(j, i, 1);
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: " + (timeElapsed.toMillis()) / 1000 + " seconds");
			Xlfile_Reader.setCellData1((timeElapsed.toMillis()) / 1000, i, 2);
			driver.close();
		}

	}
}
