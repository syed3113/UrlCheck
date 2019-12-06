package testApps;

import datatable.Xlfile_Reader;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class KeywordsApp extends DriverApp {

	private static final String objects = null;
	public static Random randomGenerator = new Random();
	public static Calendar cal = new GregorianCalendar(); // used for adding current date in variable and then used in
															// paths
	public static int date = cal.get(Calendar.DATE); // used for adding current date in variable and then used in paths
	public static int month = cal.get(Calendar.MONTH); // used for adding current date in variable and then used in
														// paths
	public static int year = cal.get(Calendar.YEAR); // used for adding current date in variable and then used in paths
	public static int sec = cal.get(Calendar.SECOND); // used for adding current date in variable and then used in paths
	public static int day = cal.get(Calendar.HOUR_OF_DAY); // used for adding current date in variable and then used in
															// paths
	public static int hour = cal.get(Calendar.HOUR); // used for adding current date in variable and then used in paths
	public static int min = cal.get(Calendar.MINUTE); // used for adding current date in variable and then used in paths
	public static String sMin = new Integer(randomGenerator.nextInt(60)).toString(); // Converted Integer value to
																						// String and then used in paths
	public static String sSec = new Integer(randomGenerator.nextInt(60)).toString(); // Converted Integer value to
																						// String and then used in paths
	public static String sHour = new Integer(randomGenerator.nextInt(24)).toString(); // Converted Integer value to
																						// String and then used in paths
	public static String sDate = new Integer(date).toString(); // Converted Integer value to String and then used in
																// paths
	/*
	 * public static String sMin = new Integer(min).toString(); //Converted Integer
	 * value to String and then used in paths public static String sSec=new
	 * Integer(sec).toString(); //Converted Integer value to String and then used in
	 * paths public static String sHour=new Integer(hour).toString(); //Converted
	 * Integer value to String and then used in paths
	 */

	public static String call_id; // Used in GetText() and DBQuerycheck() to store the call id to be used for Eval
									// UI
	public static String sUser = null;
	public static String sUser_Name;
	public static Xlfile_Reader datareader = null;
	public static Xlfile_Reader datawriter = null;
	public static float round;
	public static float round1;
	public static String expected;
	public static String[] expectedtext;
	public static String[] actualtext;
	public static String actual;
	public static String current_window;
	public static int Expectedprice;
	public static int Selectedprice;
	public static int TextBoxPrice;
	public static int SpilitedPrice;
	public static String script_error = null;
	public static int globalwait;
	public static float exptext;
	// Navigate to the current URL

	public static String navigate() throws Throwable {
		APPLICATION_LOGS.debug("Executing Navigate");
		try {

			driver.get(CONFIG.getProperty(object));
			APPLICATION_LOGS.debug("URL Open");

		} catch (Throwable t) {

			// Report error in Application logs
			APPLICATION_LOGS.debug("Error while navigating -" + object + t.getMessage());

		}
		return "Pass";

	}

	// Implement Wait

	public static String waitfor()
			throws NumberFormatException, InterruptedException, AddressException, MessagingException {
		APPLICATION_LOGS.debug("Executing wait Keyword");
		// extract the test data
		String data = testData.getCellData(currentTest, data_column_name, testRepeat);
		try {

			float test = (Float.parseFloat(data));
			int test1 = (int) test;
			Thread.sleep(test1);
			globalwait = test1 / 1000;
		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while waiting -" + object + t.getMessage());
			return "Fail";
		}
		return "Pass";
	}

	// Get URL from test data xlsx

	public static String getURL()
			throws NumberFormatException, InterruptedException, AddressException, MessagingException {
		APPLICATION_LOGS.debug("Getting URL from excel");
		// extract the test data
		String data = testData.getCellData(currentTest, data_column_name, testRepeat);
		APPLICATION_LOGS.debug("Data:-" + data);
		try {
			String URL = driver.getCurrentUrl();
			APPLICATION_LOGS.debug("Redirection URL:-" + URL);
			Assert.assertEquals(URL, data);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while waiting -" + object + t.getMessage());
			return "Fail ";
		}
		return "Pass";
	}

	// Get design data from phone finder xlsx

	// Get URL from test data xlsx

	public static String getDesign()
			throws NumberFormatException, InterruptedException, AddressException, MessagingException {
		APPLICATION_LOGS.debug("Getting Data from excel");
		// extract the test data
		String data = testData.getCellData(currentTest, data_column_name, testRepeat);
		APPLICATION_LOGS.debug("Data:-" + data);
		try {
			String design = driver.findElement(By.xpath(Objects.getProperty(object))).getText();
			APPLICATION_LOGS.debug("Design:-" + design);
			Assert.assertEquals(data, design);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while waiting -" + object + t.getMessage());
			return "Fail";
		}
		return "Pass";
	}

	// Displayed Method

	public static String Display() {
		APPLICATION_LOGS.debug("Verifying isDisplayed Method");

		try {

			driver.findElement(By.xpath(Objects.getProperty(object))).isDisplayed();
			APPLICATION_LOGS.debug("Is Displayed Method Pass");

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error in display method -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";
	}

//Collapsing Compare Section

	public static String Enable() {
		APPLICATION_LOGS.debug("Verifying Collapse Displayed Method");

		try {

			driver.findElement(By.xpath(Objects.getProperty(object))).isEnabled();
			APPLICATION_LOGS.debug("Is Displayed Method Pass");

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error in display method -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";
	}

	public static String listDisplay() {
		APPLICATION_LOGS.debug("Verifying isDisplayed Method");

		try {

			driver.findElement(By.xpath(Objects.getProperty(object))).isDisplayed();
			APPLICATION_LOGS.debug("Is Displayed Method Fail");

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error while list Display -" + object + t.getMessage());

			return "Pass";
		}

		return "Fail";
	}

	// Clicking on back button

	public static String Back() {
		APPLICATION_LOGS.debug("Clicking on back button");

		try {

			driver.navigate().back();

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error while clicking back button -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";
	}

	// Clicking on Refresh button

	public static String Refresh() {
		APPLICATION_LOGS.debug("Clicking on refresh button");

		try {

			driver.navigate().refresh();

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error while clicking refresh button -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";
	}

	// Move Slider

	public static String moveSlider() throws Throwable {
		APPLICATION_LOGS.debug("Moving the Slider");

		try {

			WebElement element = driver.findElement(By.xpath(Objects.getProperty(object)));
			Actions act = new Actions(driver);
			act.dragAndDropBy(element, 0, -30).build().perform();

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while moving the slider -" + object + t.getMessage());

			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";
	}

	// Clicking on a find mobile button

	public static String clickButton() {
		APPLICATION_LOGS.debug("Executing click button");
		try {
			System.out.println("Click On Button");
			WebElement element = (driver.findElement(By.xpath(Objects.getProperty(object))));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			System.out.println("After Radio button");
		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}
		return "Pass";

	}

	// iframe

	/*
	 * public static String frameHandle() { APPLICATION_LOGS.debug("iframe"); try {
	 * System.out.println("Enter in iframe"); driver.switchTo().frame(1);
	 * System.out.println("After iframe"); } catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail - Button Not Found"; } return "Pass";
	 * 
	 * }
	 */

	// Selecting Radio Button

	public static String radioButton() {
		APPLICATION_LOGS.debug("Executing Radio button");
		try {
			System.out.println("Enter in Radio button");
			WebElement element = (driver.findElement(By.xpath(Objects.getProperty(object))));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			System.out.println("After Radio button");
		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}
		return "Pass";

	}

	/*
	 * public static String inputValue() { APPLICATION_LOGS.debug("Sending Value");
	 * String data =testData.getCellData(currentTest, data_column_name ,
	 * testRepeat); try { System.out.println("Select Radio Button");
	 * driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(data);
	 * System.out.println("After selecting Radio button"); } catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail - Button Not Found"; } return "Pass";
	 * 
	 * }
	 */

	// Page Down

	public static String pageDown() {
		APPLICATION_LOGS.debug("Page Down");
		try {
			// driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(Keys.PAGE_DOWN);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			// ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");

		} catch (Throwable t) {

			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}
		return "Pass";
	}

	public static String pageDown1() {
		APPLICATION_LOGS.debug("Page Down");
		try {
			// driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(Keys.PAGE_DOWN);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,650)");
			// ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");

		} catch (Throwable t) {

			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}
		return "Pass";
	}

//Page Down 2

	public static String pageDown2() {
		APPLICATION_LOGS.debug("Page Down");
		try {
			// driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(Keys.PAGE_DOWN);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,4050)");
			// ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");

		} catch (Throwable t) {

			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}
		return "Pass";
	}

	// Page Down2

	public static String pageUp() {
		APPLICATION_LOGS.debug("Page UP");
		try {
			// driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(Keys.PAGE_DOWN);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-30)");
			// ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");

		} catch (Throwable t) {

			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}
		return "Pass";
	}

	// Scroll Down
	public static String scrollDown() {
		APPLICATION_LOGS.debug("Scrolling page down by Scroll Down");
		try {
			WebElement element = driver.findElement(By.xpath(Objects.getProperty(object)));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(1000);
		} catch (Throwable t) {

			APPLICATION_LOGS.debug("Error while moving on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";
	}

	// Mouse Hover

	public static String mouseHover() {
		APPLICATION_LOGS.debug("Mouse Hover");
		try {
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath(Objects.getProperty(object)));
			action.moveToElement(we).build().perform();
		} catch (Throwable t) {

			APPLICATION_LOGS.debug("Error while hovering on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";
	}

	// Selected check method

	public static String Selected() {
		APPLICATION_LOGS.debug("Verifying isSelected Method");

		try {

			// driver.findElement(By.xpath(Objects.getProperty(object))).isSelected();
			WebElement elem = driver.findElement(By.xpath(Objects.getProperty(object)));
			elem.equals(driver.switchTo().activeElement());
			// driver.switchTo().activeElement().equals();

			APPLICATION_LOGS.debug("Is Selected Method Pass");

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error in display method -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";
	}

	// Selecting From list

	public static String selectFromList() {
		APPLICATION_LOGS.debug("Select Brand for Comparison");

		try {

			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(Objects.getProperty(object)));
			je.executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error in selecting method -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";
	}

	// Window Handling
	/*
	 * public static String windowHandling() {
	 * APPLICATION_LOGS.debug("Window Handling"); try { Set<String> winids=
	 * driver.getWindowHandles(); Iterator<String> iterate = winids.iterator();
	 * 
	 * System.out.println("Window Id:-"+iterate.next());
	 * 
	 * winids= driver.getWindowHandles(); iterate = winids.iterator(); firstwindow=
	 * iterate.next(); String tabwindow= iterate.next();
	 * System.out.println("Window Id2:-"+tabwindow);
	 * driver.switchTo().window(tabwindow); //Thread.sleep(3000); //
	 * actualtext=driver.findElement(By.xpath(Objects.getProperty(object))).getText(
	 * ).split(" "); //driver.findElement(By.linkText("News")).click();
	 * //System.out.println("Actual text:-"+actualtext[0]);
	 * System.out.println("Switch to window");
	 * 
	 * }catch(Throwable t) {
	 * 
	 * APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail";
	 * 
	 * } return "Pass"; }
	 */

	public static String windowHandling() {
		APPLICATION_LOGS.debug("Window Handling");
		try {
			 current_window = driver.getWindowHandle();
			APPLICATION_LOGS.debug("Current Window:-"+current_window);
			Set<String> allwindows = driver.getWindowHandles();
			//System.out.println(allwindows.size());
			APPLICATION_LOGS.debug("Windows Present:-"+allwindows.size());
			int i =0;
			for (String s : allwindows) {
				
                  i=i+1;
                  if(i==2)
                  {
				driver.switchTo().window(s);
				APPLICATION_LOGS.debug("For each loop:-"+allwindows);
				APPLICATION_LOGS.debug("All windows URL:-"+driver.getCurrentUrl());
				break;
                  }
                  APPLICATION_LOGS.debug("For each loop Outside:-"+s);
  				APPLICATION_LOGS.debug("All windows URL Outside:-"+driver.getCurrentUrl());
                   
			}
			
			
		} catch (Throwable t) {

			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";
	}

	// Closing extra window

	public static String closeWindow() {
		try {
			APPLICATION_LOGS.debug("Closing Window");
			driver.close();
			APPLICATION_LOGS.debug("Window Closed");
			APPLICATION_LOGS.debug("Current Window in closeWindow:-"+current_window);
			driver.switchTo().window(current_window);
			APPLICATION_LOGS.debug("Now URL:-" +driver.getCurrentUrl());
             // driver.navigate().to("https://www.91mobiles.com/");
              //APPLICATION_LOGS.debug("Home Page");
			//driver.close();
			APPLICATION_LOGS.debug("Close Extra Window");
			//driver.switchTo().window(current_window);
			//APPLICATION_LOGS.debug("Switch to current window");
			//APPLICATION_LOGS.debug("Current Window:-"+current_window);
			//APPLICATION_LOGS.debug("Current Window URL:-"+driver.getCurrentUrl());
		} catch (Throwable t) {

			APPLICATION_LOGS.debug("Error while closing extra window -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}
	
	public static String redirection() {
		try {
			
              driver.navigate().to("https://www.91mobiles.com/");
              APPLICATION_LOGS.debug("Home Page");
			
		} catch (Throwable t) {

			APPLICATION_LOGS.debug("Error while closing extra window -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}
	
	

	// News readmore link

	public static String newsReadMore() {
		APPLICATION_LOGS.debug("verifying news read more link redirection");
		try {
			String news = driver.findElement(By.xpath(Objects.getProperty(object))).getText().trim();
			APPLICATION_LOGS.debug(news);
			Assert.assertTrue(news.equalsIgnoreCase("News"));

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking read more of news -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}
		return "Pass";
	}

	// Samachar read more

	/*
	 * public static String samacharReadMore() {
	 * APPLICATION_LOGS.debug("verifying news read more link redirection"); try {
	 * String URL = driver.getCurrentUrl(); APPLICATION_LOGS.debug(URL);
	 * Assert.assertEquals(URL, "https://hi.91mobiles.com/");
	 * 
	 * }catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while clicking read more of samachar -"+ object
	 * + t.getMessage()); script_error =
	 * "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail"; } return "Pass"; }
	 */

	// Best Phone Under Rs 5000

	/*
	 * public static String bestPhones() {
	 * APPLICATION_LOGS.debug("Best Phone under Rs 5000"); try { String URL =
	 * driver.getCurrentUrl(); APPLICATION_LOGS.debug(URL); Assert.assertEquals(URL,
	 * "https://www.91mobiles.com/top-10-mobiles-below-5000-in-india");
	 * 
	 * }catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while redirecting to Best Phones -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail"; } return "Pass"; }
	 */

	// Trending Collections

	/*
	 * public static String trendingCollections() {
	 * APPLICATION_LOGS.debug("Trending Collections"); try { String URL =
	 * driver.getCurrentUrl(); APPLICATION_LOGS.debug(URL); Assert.assertEquals(URL,
	 * "https://www.91mobiles.com/top-10-mobiles-in-india");
	 * 
	 * }catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while redirecting to trending collections -"+
	 * object + t.getMessage()); script_error =
	 * "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail"; } return "Pass"; }
	 */

	// Latest Mobiles link

	/*
	 * public static String latestMobilesLink() {
	 * APPLICATION_LOGS.debug("verifying latest mobile link redirection"); try {
	 * String URL = driver.getCurrentUrl(); APPLICATION_LOGS.debug(URL);
	 * Assert.assertEquals(URL, "https://www.91mobiles.com/phonefinder.php");
	 * 
	 * }catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while clicking read more of samachar -"+ object
	 * + t.getMessage()); script_error =
	 * "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail"; } return "Pass"; }
	 */

	// Stories that Matter read more

	public static String reviewReadMore() {
		APPLICATION_LOGS.debug("verifying news read more link redirection");
		try {
			String reviews = driver.findElement(By.xpath(Objects.getProperty(object))).getText().trim();
			APPLICATION_LOGS.debug(reviews);
			Assert.assertTrue(reviews.equalsIgnoreCase("Reviews"));

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking read more of reviews -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}
		return "Pass";
	}

	// scroll widget forward

	public static String widgetForwardSlider() {
		APPLICATION_LOGS.debug("Widget Slider");
		try {
			if (driver.findElement(By.xpath(Objects.getProperty(object))).isEnabled()) {
				APPLICATION_LOGS.debug("Forward slider is enable");
				driver.findElement(By.xpath(Objects.getProperty(object))).click();

			}

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error in forward slider -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}

		return "Pass";
	}

	// scroll widget backward

	public static String widgetBackwardSlider() {
		APPLICATION_LOGS.debug("Widget Slider");
		try {
			if (driver.findElement(By.xpath(Objects.getProperty(object))).isDisplayed()) {
				APPLICATION_LOGS.debug("Backward slider is enable");
				driver.findElement(By.xpath(Objects.getProperty(object))).click();

			}

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error in backward slider-" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}

		return "Pass";
	}

	// Spiliting Price

	public static String getSpilitedPrice() {
		String p1, p2;
		APPLICATION_LOGS.debug("Spiliting Price");
		try {
			p1 = driver.findElement(By.xpath(Objects.getProperty(object))).getText().replace(",", "").trim();
			System.out.println("Price Text1:-" + p1);
			p2 = p1.replace("Rs.", "").trim();
			System.out.println("Price Text 2:-" + p2);
			SpilitedPrice = Integer.parseInt(p2);
			System.out.println("Spilited Price:-" + SpilitedPrice);
			APPLICATION_LOGS.debug("Spilited Price:-" + SpilitedPrice);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while spiliting Price -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Verify price

	// Spiliting Upcoming Price

	public static String getUpcomingSplitedPrice() {
		String p1, p2, p3;
		APPLICATION_LOGS.debug("Spiliting Price");
		try {
			p1 = driver.findElement(By.xpath(Objects.getProperty(object))).getText().replace(",", "").trim();
			System.out.println("Price Text1:-" + p1);
			p2 = p1.replace("Rs.", "").trim();
			p3 = p2.substring(0, 5).trim();
			System.out.println("Price Text 2:-" + p3);
			SpilitedPrice = Integer.parseInt(p3);

			System.out.println("Spilited Price:-" + SpilitedPrice);
			APPLICATION_LOGS.debug("Spilited Price:-" + SpilitedPrice);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while spiliting Price -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Spiliting top deals price

	public static String getTopDealsPrice() {
		String p1, p2;
		APPLICATION_LOGS.debug("Spiliting Price of top deals");
		try {
			APPLICATION_LOGS.debug(
					"Top Deal Price Xpath:-" + driver.findElement(By.xpath(Objects.getProperty(object))).getText());
			p1 = driver.findElement(By.xpath(Objects.getProperty(object))).getText().replace("Rs.", "").trim();
			System.out.println("Price Text1 of try block:-" + p1);
			p2 = p1.replace(",", "");
			// p2 = p1.replace("Rs.", "").trim();
			System.out.println("Price Text 2 of try block:-" + p2);
			SpilitedPrice = Integer.parseInt(p2);
			APPLICATION_LOGS.debug("Top Deals Price:-" + SpilitedPrice);
			System.out.println("Spilited Price:-" + SpilitedPrice);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while spiliting Price -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";
			p1 = driver.findElement(By.xpath(Objects.getProperty(object))).getText().replace(",", "").trim();
			System.out.println("Price Text1 of Catch Block:-" + p1);
			p2 = p1.replace("Rs.", "").trim();
			System.out.println("Price Text 2 of Catch Block:-" + p2);
			SpilitedPrice = Integer.parseInt(p2);
			System.out.println("Spilited Price:-" + SpilitedPrice);

			return "Pass";

		}
		return "Pass";

	}

	// Verifying Price from slider

	public static String verifyPrice() {
		APPLICATION_LOGS.debug("Verifying price");

		try {

			Assert.assertTrue((TextBoxPrice >= SpilitedPrice));

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error verifying price -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";

	}

	// Verify Sort by smaller price

	public static String verifyLowestPrice() {
		APPLICATION_LOGS.debug("Verifying sort by smaller price");

		try {

			Assert.assertTrue((SpilitedPrice >= TextBoxPrice));

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error verifying price -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";

	}

	public static String verifyPriceAround() {
		APPLICATION_LOGS.debug("Verifying price Around");

		try {
			Assert.assertEquals(SpilitedPrice + 1000, TextBoxPrice);

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error verifying price -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";

	}

	// Fetching price from text box

	/*
	 * public static String getSelectedPrice(){
	 * APPLICATION_LOGS.debug("Fetching text box price"); String p1=null,p2; try{
	 * p1=driver.findElement(By.xpath(Objects.getProperty(object))).getAttribute(
	 * "value").replace(",",""); System.out.println("Price Text1:-" +p1); //Price
	 * Text:-Rs.9 000 p2 = p1.trim(); System.out.println("Price Text 2:-"+p2);
	 * Selectedprice = Integer.parseInt(p2);
	 * System.out.println("Selected Price:-"+Selectedprice);
	 * 
	 * }catch(Throwable t){
	 * 
	 * // report error APPLICATION_LOGS.debug("Error verifying price -"+ object +
	 * t.getMessage());
	 * 
	 * return "Fail - Price not verified"; }
	 * 
	 * return "Pass";
	 * 
	 * }
	 */

	// Get price from text box & Replace comma in price selected from price text box

	public static String getTxtBoxPrice() {
		System.out.println("Enter in price text box");
		APPLICATION_LOGS.debug("Replacing comma from price text box");

		try {
			String txtboxprc1, txtboxprc;
			txtboxprc1 = driver.findElement(By.xpath(Objects.getProperty(object))).getAttribute("value").replace(",",
					"");
			// System.out.println("Price Text1:-" +txtboxprc1);
			APPLICATION_LOGS.debug("Price Text1:-" + txtboxprc1);
			TextBoxPrice = Integer.parseInt(txtboxprc1);
			APPLICATION_LOGS.debug("Text Box Price:-" + TextBoxPrice);
			// System.out.println("Text Box Price:-"+TextBoxPrice);

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error verifying price -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";

	}

	// Replace comma

	public static String verifyDetailPagePrice() {

		APPLICATION_LOGS.debug("Replacing comma from price ");

		try {
			String txtboxprc1, txtboxprc;
			txtboxprc1 = driver.findElement(By.xpath(Objects.getProperty(object))).getText().replace(",", "");
			System.out.println("Price Text1:-" + txtboxprc1);
			/*
			 * txtboxprc = txtboxprc1.trim();
			 * System.out.println("Price Text 2:-"+txtboxprc);
			 */
			TextBoxPrice = Integer.parseInt(txtboxprc1);
			System.out.println("Text Box Price:-" + TextBoxPrice);
			APPLICATION_LOGS.debug("Detail Page Price:-" + TextBoxPrice);
			Assert.assertEquals(SpilitedPrice, TextBoxPrice);

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Error verifying price -" + object + t.getMessage());

			return "Fail";
		}

		return "Pass";

	}

	// Market Status

	public static String marketStatus() {
		APPLICATION_LOGS.debug("Market Status");
		try {
			String ms = driver.findElement(By.xpath(Objects.getProperty(object))).getText().trim();
			APPLICATION_LOGS.debug(ms);
			Assert.assertFalse(ms.contains("Available"));

		} catch (Throwable t) {

			// report error
			APPLICATION_LOGS.debug("Market Status is not for upcoming -" + object + t.getMessage());

			return "Fail";
		}
		return "Pass";
	}

	// Actual Count
	public static String actualCount() {
		APPLICATION_LOGS.debug("Counting number of records");
		try {
			List<WebElement> records = driver.findElements(By.xpath(Objects.getProperty(object)));
			System.out.println("Actual Records:-" + records.size());
		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}
		return "Pass";

	}

	/*
	 * //Display count
	 * 
	 * public static String actualCount() {
	 * APPLICATION_LOGS.debug("Counting number of records"); try { WebElement webl =
	 * driver.findElement(By.xpath(Objects.getProperty(object))); JavascriptExecutor
	 * js = (JavascriptExecutor)driver; String text = (String)
	 * js.executeScript(“return arguments[0].text;”, webl); } catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail"; } return "Pass";
	 * 
	 * }
	 * 
	 */

	// Get Text Method

	public static String GetText() {
		APPLICATION_LOGS.debug("Getting Text");
		try {

			expected = driver.findElement(By.xpath(Objects.getProperty(object))).getText().trim();
			APPLICATION_LOGS.debug("Expected Text:-" + expected);
			System.out.println("Get Text:-" + expected);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Get Image Text

	public static String GetImageText() {
		APPLICATION_LOGS.debug("Getting Image Text");
		try {

			expected = driver.findElement(By.xpath(Objects.getProperty(object))).getAttribute("src");
			APPLICATION_LOGS.debug("Expected Image Text:-" + expected);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Verify Image Text

	public static String verifyImageText() {
		APPLICATION_LOGS.debug("Executing verify Image Text");
		try {
			actual = driver.findElement(By.xpath(Objects.getProperty(object))).getAttribute("src");
			APPLICATION_LOGS.debug("Expected Image Text:-" + expected);
			APPLICATION_LOGS.debug("Actual Image Text:-" + actual);
			Assert.assertTrue(actual.equalsIgnoreCase(expected));

		} catch (Throwable t) {
			// error

			APPLICATION_LOGS.debug("Error in text - " + object + t.getMessage());
			APPLICATION_LOGS.debug("Actual - " + actual);
			APPLICATION_LOGS.debug("Expected -" + expected);
			return "Fail";

		}

		return "Pass";

	}

	// Get Link from copy link popup

	public static String GetCopyLink() {
		APPLICATION_LOGS.debug("Copy Link");
		String data = testData.getCellData(currentTest, data_column_name, testRepeat);
		try {

			expected = driver.findElement(By.xpath(Objects.getProperty(object))).getAttribute("value").trim();
			APPLICATION_LOGS.debug("Actual Copy Link:-" + expected);
			APPLICATION_LOGS.debug("Expected Copy Link:-" + data);
			Assert.assertEquals(data, expected);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Input value

	public static String sendText() {
		APPLICATION_LOGS.debug("Sending Text");
		// String data =testData.getCellData(currentTest, data_column_name ,
		// testRepeat);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// APPLICATION_LOGS.debug("Data from Excel:-"+data);
			// driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(data);
			// js.executeScript("document.getElementByXpath('Objects.getProperty(object)').value=data;");
			// APPLICATION_LOGS.debug("Expected Text:-"+expected);

			WebElement searchbox = driver.findElement(By.xpath(Objects.getProperty(object)));
			JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
			myExecutor.executeScript("arguments[0].value='samsung';", searchbox);

			/*
			 * WebElement TextBox =
			 * driver.findElement(By.xpath(Objects.getProperty(object))); String input=
			 * data; TextBox.getAttribute("value"); JavascriptExecutor jst=
			 * (JavascriptExecutor) driver;
			 * jst.executeScript("arguments[1].value = arguments[0]; ", input, TextBox);
			 */

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Input value

	public static String sendBrand() {
		APPLICATION_LOGS.debug("Sending Brand for Comparison");
		// String data =testData.getCellData(currentTest, data_column_name ,
		// testRepeat);
		try {

			String data = testData.getCellData(currentTest, data_column_name, testRepeat);
			driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(data);
			;
			/*
			 * WebElement TextBox
			 * =driver.findElement(By.xpath(Objects.getProperty(object)));
			 * 
			 * String input=data; TextBox.getAttribute("value"); JavascriptExecutor
			 * jst=(JavascriptExecutor) driver;
			 * jst.executeScript("arguments[1].value = arguments[0]; ", input, TextBox);
			 */

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Input from keyboards

	public static String keyboard() {
		APPLICATION_LOGS.debug("Keyboard Enter Key");
		// String data =testData.getCellData(currentTest, data_column_name ,
		// testRepeat);
		try {

			driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(Keys.ENTER);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Store Check on Grid View

	public static String storeGrid() {
		APPLICATION_LOGS.debug("Store Grid Method");
		try {

			List<WebElement> brand = driver.findElements(By.xpath(Objects.getProperty(object)));

			APPLICATION_LOGS.debug("Number of Brand:- " + brand.size());
			System.out.println("Number of Brand:- " + brand.size());
			String cssQuery = ".hover_blue_link";
			String script = "return document.querySelectorAll('" + cssQuery + "').length;";
			Object count = ((JavascriptExecutor) driver).executeScript(script);

			System.out.println(count);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	/*
	 * // Get Deals Like
	 * 
	 * public static String GetLikeText() {
	 * APPLICATION_LOGS.debug("Getting Like from top deals"); try { expectedtext =
	 * driver.findElement(By.xpath(Objects.getProperty(object))).getText().split(" "
	 * ); APPLICATION_LOGS.debug(expectedtext);
	 * 
	 * } catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail";
	 * 
	 * } return "Pass";
	 * 
	 * }
	 */

	// Get deals detail page like

	public static String GetDealsDetailLike() {
		APPLICATION_LOGS.debug("Get like from deals detail page");
		try {
			String like = driver.findElement(By.xpath(Objects.getProperty(object))).getText().replace("(", "");
			String ls = like.replace(")", "").trim();
			APPLICATION_LOGS.debug("Like From Top Deal Details Page:-" + ls);
			Assert.assertEquals(expected, ls);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while spliting like -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	
	public static String GetPriceDropAlertText() {
		APPLICATION_LOGS.debug("Get Text from price drop alert pop up");
		try {
			String al = driver.findElement(By.xpath(Objects.getProperty(object))).getText();
			APPLICATION_LOGS.debug("Text of Price Drop Alert Text:-" + al);
			Assert.assertEquals("Confirm your Subscription", al);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while spliting like -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	
	
	
	// Verify Expected Price

	public static String expectedPriceText() {
		APPLICATION_LOGS.debug("Verify Expected Price");
		try {

			Assert.assertEquals(expected, "Expected Price");

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Click on upcoming & latest mobiles widget

	public static String ulButton() {
		APPLICATION_LOGS.debug("Clicking on upcoming & latest mobiles");
		try {
			driver.findElement(By.xpath(Objects.getProperty(object))).click();

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Upcoming/Latest Mobiles -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";
		}
		return "Pass";
	}

	// Get Splitted Display

	public static String GetCompareDisplayText() {
		APPLICATION_LOGS.debug("Getting Text");
		try {
			expectedtext = driver.findElement(By.xpath(Objects.getProperty(object))).getText().substring(0, 4)
					.split(" ");
			System.out.println("Get Splited Text:-" + expectedtext[0]);
			APPLICATION_LOGS.debug("Getting Splited Text:-" + expectedtext[0]);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Get Splited text

	public static String GetSplitedText() {
		APPLICATION_LOGS.debug("Getting Text");
		try {
			expectedtext = driver.findElement(By.xpath(Objects.getProperty(object))).getText().split(" ");
			System.out.println("Get Splited Text:-" + expectedtext[0]);
			APPLICATION_LOGS.debug("Getting Splited Text:-" + expectedtext[0]);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Verify Splited text

	public static String verifySplitedText() {
		APPLICATION_LOGS.debug("Executing verifySplitedText");
		// String expected=APPTEXT.getProperty(object);
		actualtext = driver.findElement(By.xpath(Objects.getProperty(object))).getText().split(" ");
		APPLICATION_LOGS.debug("Expected Text:-" + expectedtext[0]);
		APPLICATION_LOGS.debug("Actual Text:-" + actualtext[0]);
		try {

			Assert.assertTrue(actualtext[0].equalsIgnoreCase(expectedtext[0]));

		} catch (Throwable t) {
			// error

			APPLICATION_LOGS.debug("Error in text - " + object + t.getMessage());
			APPLICATION_LOGS.debug("Actual - " + actualtext[0]);
			APPLICATION_LOGS.debug("Expected -" + expectedtext[0]);
			return "Fail";

		}

		return "Pass";

	}

//Verify Screen size

	public static String verifySize() {
		APPLICATION_LOGS.debug("Executing verify Screen Size");
		// String expected=APPTEXT.getProperty(object);
		String scrsize = driver.findElement(By.xpath(Objects.getProperty(object))).getText().substring(0, 1);
		int actualtxt = Integer.parseInt(scrsize);
		int expectedtxt = Integer.parseInt(expectedtext[0]);
		APPLICATION_LOGS.debug(expectedtxt);
		APPLICATION_LOGS.debug(actualtxt);
		try {

			Assert.assertTrue(actualtxt >= expectedtxt);

		} catch (Throwable t) {
			// error

			APPLICATION_LOGS.debug("Error in text - " + object + t.getMessage());
			APPLICATION_LOGS.debug("Actual - " + actualtext[0]);
			APPLICATION_LOGS.debug("Expected -" + expectedtext[0]);
			return "Fail";

		}

		return "Pass";

	}

	// Verify Camera Resolution

	public static String GetConversion() {
		APPLICATION_LOGS.debug("Getting Text & Converting to Integer");
		try {
			expectedtext = driver.findElement(By.xpath(Objects.getProperty(object))).getText().split(" ");
			APPLICATION_LOGS.debug("Getting Splited Text for Conversion:-" + expectedtext[0]);
			exptext = Float.parseFloat(expectedtext[0]);

			APPLICATION_LOGS.debug("String to Integer Conversion:-" + exptext);
			System.out.println("Get Conversion:-" + exptext);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	public static String VerifyConversion() {
		APPLICATION_LOGS.debug("Getting Text Converting to Integer & verifying");
		try {
			expectedtext = driver.findElement(By.xpath(Objects.getProperty(object))).getText().split(" ");
			APPLICATION_LOGS.debug("Verify Splited Text after Conversion:-" + expectedtext[0]);
			float verifytext = Float.parseFloat(expectedtext[0]);
			APPLICATION_LOGS.debug("String to Integer Conversion:-" + exptext);
			APPLICATION_LOGS.debug("String to Integer Conversion in verify:-" + verifytext);
			System.out.println("Verify Conversion:-" + verifytext);
			Assert.assertTrue(verifytext >= exptext);
		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";

			return "Fail";

		}
		return "Pass";

	}

	// Verify Density

	public static String verifyDensity() {
		APPLICATION_LOGS.debug("Executing verify Density");
		// String expected=APPTEXT.getProperty(object);
		String scrsize = driver.findElement(By.xpath(Objects.getProperty(object))).getText().substring(0, 3).trim();
		int actualtxt = Integer.parseInt(scrsize);
		int expectedtxt = Integer.parseInt(expectedtext[0]);
		APPLICATION_LOGS.debug(expectedtxt);
		APPLICATION_LOGS.debug(actualtxt);
		try {

			Assert.assertTrue(actualtxt >= expectedtxt);

		} catch (Throwable t) {
			// error

			APPLICATION_LOGS.debug("Error in text - " + object + t.getMessage());
			APPLICATION_LOGS.debug("Actual - " + actualtext[0]);
			APPLICATION_LOGS.debug("Expected -" + expectedtext[0]);
			return "Fail";

		}

		return "Pass";

	}
	// Verify Sim size

	public static String verifySimSize() {
		APPLICATION_LOGS.debug("Executing verify Sim Size");
		// String expected=APPTEXT.getProperty(object);
		String simsize = driver.findElement(By.xpath(Objects.getProperty(object))).getText().substring(6, 10).trim();
		APPLICATION_LOGS.debug("Sim Size:-" + simsize);
		APPLICATION_LOGS.debug("Expected -" + expectedtext[0]);
		try {

			Assert.assertEquals(simsize, expectedtext[0]);

		} catch (Throwable t) {
			// error

			APPLICATION_LOGS.debug("Error in text - " + object + t.getMessage());
			APPLICATION_LOGS.debug("Actual - " + actualtext[0]);
			APPLICATION_LOGS.debug("Expected -" + expectedtext[0]);
			return "Fail";

		}

		return "Pass";

	}

	// verify processor speed

	public static String verifyProcessorSpeed() {
		APPLICATION_LOGS.debug("Executing verify Processor speed");
		// String expected=APPTEXT.getProperty(object);
		String[] pspeed = driver.findElement(By.xpath(Objects.getProperty(object))).getText().split(" ");
		APPLICATION_LOGS.debug("Processor Speed spilit:-" + pspeed[2]);
		String prspeed = pspeed[2].replace("(", "");
		float procspeed = Float.parseFloat(prspeed);
		APPLICATION_LOGS.debug("Processor Speed:-" + procspeed);
		int expectedtxt = Integer.parseInt(expectedtext[0]);
		APPLICATION_LOGS.debug("Expected -" + expectedtxt);
		try {

			Assert.assertTrue(procspeed >= expectedtxt);

		} catch (Throwable t) {
			// error

			APPLICATION_LOGS.debug("Error in text - " + object + t.getMessage());
			APPLICATION_LOGS.debug("Actual - " + actualtext[0]);
			APPLICATION_LOGS.debug("Expected -" + expectedtext[0]);
			return "Fail";

		}

		return "Pass";

	}

	// Verify Breadcrumb
	public static String verifyBreadcrumb() {
		APPLICATION_LOGS.debug("Executing verify breadcrumb Text");
		try {
			String[] actual = driver.findElement(By.xpath(Objects.getProperty(object))).getText().split("›");
			System.out.println("Breadcrumb:-" + actual[1]);
			APPLICATION_LOGS.debug("Expected Text:-" + expectedtext[0]);
			APPLICATION_LOGS.debug("Breadcrumb Text:-" + actual[1].trim());
			System.out.println("Breadcrumb Text:-" + actual[1].trim());
			String[] actualtxt = actual[1].trim().split(" ");
			System.out.println("Actualtxt:-" + actualtxt);
			System.out.println("Actual Text:-" + actualtxt[0]);
			System.out.println("Expected Text:-" + expectedtext[0]);
			Assert.assertTrue(actualtxt[0].equalsIgnoreCase(expectedtext[0]));

		} catch (Throwable t) {
			// error

			APPLICATION_LOGS.debug("Error in text - " + object + t.getMessage());
			// APPLICATION_LOGS.debug("Actual - "+actualtxt[0]);
			APPLICATION_LOGS.debug("Expected -" + expectedtext[0]);
			return "Fail";

		}

		return "Pass";

	}

	// Verify Breadcrumb2
	public static String verifyBreadcrumb2() {
		APPLICATION_LOGS.debug("Executing verify breadcrumb2 Text");
		String data = testData.getCellData(currentTest, data_column_name, testRepeat);
		APPLICATION_LOGS.debug("Breadcrumb from excel:-" + data);
		try {
			String[] actual = driver.findElement(By.xpath(Objects.getProperty(object))).getText().split("›");
			System.out.println("Breadcrumb:-" + actual[2]);
			// APPLICATION_LOGS.debug("Expected Text:-"+expectedtext[0]);
			APPLICATION_LOGS.debug("Breadcrumb Text:-" + actual[2].trim());
			System.out.println("Breadcrumb Text:-" + actual[2].trim());
			String actualtxt = actual[2].trim();
			/*
			 * System.out.println("Actualtxt:-"+actualtxt);
			 * System.out.println("Actual Text:-"+actualtxt[0]);
			 */
			// System.out.println("Expected Text:-"+expectedtext[0]);
			Assert.assertTrue(data.equalsIgnoreCase(actualtxt));

		} catch (Throwable t) {
			// error

			APPLICATION_LOGS.debug("Error in text - " + object + t.getMessage());
			// APPLICATION_LOGS.debug("Actual - "+actualtxt[0]);
			APPLICATION_LOGS.debug("Expected -" + expectedtext[0]);
			return "Fail";

		}

		return "Pass";

	}

	// Verify Text

	public static String verifyText() {
		APPLICATION_LOGS.debug("Executing verifyText");
		try {
			actual = driver.findElement(By.xpath(Objects.getProperty(object))).getText().trim();
			APPLICATION_LOGS.debug("Expected Text:-" + expected);
			APPLICATION_LOGS.debug("Actual Text:-" + actual);
			System.out.println("Verify Text:-" + actual);
			Assert.assertTrue(actual.equalsIgnoreCase(expected));

		} catch (Throwable t) {
			// error

			APPLICATION_LOGS.debug("Error in text - " + object + t.getMessage());
			APPLICATION_LOGS.debug("Actual - " + actual);
			APPLICATION_LOGS.debug("Expected -" + expected);
			return "Fail";
			

		}

		return "Pass";

	}
	// Page scrolling

	public static String scrollPage() {
		APPLICATION_LOGS.debug("Scrolling Page");
		try {
			driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(Keys.PAGE_DOWN);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on an Object -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";
			return "Fail";  //+ t.getMessage()
		}
		return "Pass";
	}

	// Deals Detail Page Price

	public static String dealsDetailPrice() {
		APPLICATION_LOGS.debug("Deals Detail Page Price");
		try {
			String ddp = driver.findElement(By.xpath(Objects.getProperty(object))).getText().trim();
			APPLICATION_LOGS.debug("Deal Details Page Price:-" + ddp);
			String p2 = ddp.replace(",", "").trim();
			int ddpc = Integer.parseInt(p2);
			APPLICATION_LOGS.debug("Deals Detail Page Price:-" + ddpc);
			Assert.assertEquals(SpilitedPrice, ddpc);

		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while converting deals detail price -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";
			// return "Fail -"+ t.getMessage();
			return "Fail";
		}
		return "Pass";
	}

	// Verify top deals view all

	public static String dealsViewAll() {
		APPLICATION_LOGS.debug("Click on View All of Deals");
		try {
			driver.findElement(By.xpath(Objects.getProperty(object))).isSelected();
			APPLICATION_LOGS.debug("View All of deals selected");
		} catch (Throwable t) {
			APPLICATION_LOGS.debug("Error while clicking on view all -" + object + t.getMessage());
			script_error = "Timed out after " + globalwait + " miliseconds";
			return "Fail";
		}
		return "Pass";
	}

	// Verify from breadcrumb

	/*
	 * public static String getBreadcrumbText() {
	 * APPLICATION_LOGS.debug("Breadcrumb Text"); try { String[] txt=
	 * driver.findElement(By.xpath(Objects.getProperty(object))).getText().split(">"
	 * ); APPLICATION_LOGS.debug("Breadcrumb Spilit:-"+txt[2]);
	 * 
	 * 
	 * }catch(Throwable t) { APPLICATION_LOGS.debug("Error in breadcrumb text -"+
	 * object + t.getMessage()); script_error =
	 * "Timed out after "+globalwait+" miliseconds"; return "Fail -"+
	 * t.getMessage(); } return "Pass"; }
	 */

	/*
	 * //Verify Store on deals detail page
	 * 
	 * public static String verifyStore(){
	 * APPLICATION_LOGS.debug("Executing verify Store"); //String
	 * expected=APPTEXT.getProperty(object);
	 * actual=driver.findElement(By.xpath(Objects.getProperty(object))).getText();
	 * APPLICATION_LOGS.debug(expected); APPLICATION_LOGS.debug(actual); try{
	 * 
	 * Assert.assertEquals(actual , expected);
	 * 
	 * }catch(Throwable t){ // error
	 * 
	 * APPLICATION_LOGS.debug("Error in text - "+object);
	 * APPLICATION_LOGS.debug("Actual - "+actual);
	 * APPLICATION_LOGS.debug("Expected -"+ expected); return "Fail -"+
	 * t.getMessage();
	 * 
	 * }
	 * 
	 * return "Pass";
	 * 
	 * 
	 * }
	 */
	/*
	 * 
	 * 
	 * // Clicking Price Around Link
	 * 
	 * public static String clickat() {
	 * APPLICATION_LOGS.debug("Clicking on button"); try { expected =
	 * driver.findElement(By.xpath(Objects.getProperty(object))).getText().trim();
	 * System.out.println("Expected:-" +expected);
	 * driver.findElement(By.xpath(Objects.getProperty(object))).click();
	 * 
	 * } catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail - Button Not Found";
	 * 
	 * } return "Pass";
	 * 
	 * }
	 * 
	 * //Spilit Space public static String trimSpace() {
	 * APPLICATION_LOGS.debug("Clicking on button"); try { expected =
	 * driver.findElement(By.xpath(Objects.getProperty(object))).getText().trim();
	 * System.out.println("Expected:-" +expected);
	 * 
	 * } catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail - Space is not getting trim";
	 * 
	 * } return "Pass"; }
	 * 
	 * //Verify price text at SRP public static String SpilitedPrice() {
	 * APPLICATION_LOGS.debug("Verifying price at SRP after clicking price around");
	 * try { String SpilitedPricetext =
	 * driver.findElement(By.xpath(Objects.getProperty(object))).getText().substring
	 * (3, 4).trim(); System.out.println("Price AfterSpilit:-"+SpilitedPricetext);
	 * int split = Integer.parseInt(SpilitedPricetext); Assert.assertTrue(split>4 &&
	 * split<6); } catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * return "Fail - Price Not Match";
	 * 
	 * } return "Pass";
	 * 
	 * }
	 * 
	 * public static String verifyText(){
	 * APPLICATION_LOGS.debug("Executing verifyText"); //String
	 * expected=APPTEXT.getProperty(object); String[]
	 * actual=driver.findElement(By.xpath(Objects.getProperty(object))).getText().
	 * split(" "); System.out.println("Actual:-"+ actual[0]);
	 * APPLICATION_LOGS.debug(expected); APPLICATION_LOGS.debug(actual[0]); try{
	 * Assert.assertEquals(actual[0] , expected); }catch(Throwable t){ // error
	 * APPLICATION_LOGS.debug("Error in text - "+object);
	 * APPLICATION_LOGS.debug("Actual - "+actual[0]);
	 * APPLICATION_LOGS.debug("Expected -"+ expected); return "Fail -"+
	 * t.getMessage();
	 * 
	 * }
	 * 
	 * return "Pass";
	 * 
	 * 
	 * }
	 * 
	 * // Actual Count public static String actualCount() {
	 * APPLICATION_LOGS.debug("Counting number of records"); try { List<WebElement>
	 * records= driver.findElements(By.xpath(Objects.getProperty(object)));
	 * System.out.println("Actual Records:-"+records); } catch(Throwable t) {
	 * APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail - Button Not Found"; } return "Pass";
	 * 
	 * }
	 */

	// Clicking on a link or an Object

	/*
	 * public static String clickLink() throws AddressException, MessagingException{
	 * APPLICATION_LOGS.debug("Executing clickLink"); try{ //
	 * selenium.isElementPresent(Objects.getProperty(object)); //
	 * selenium.click(Objects.getProperty(object));
	 * driver.findElement(By.xpath(Objects.getProperty(object))).click();
	 * }catch(Throwable t){
	 * 
	 * // Report error in Application logs
	 * APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object +
	 * t.getMessage()); script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail - Link Not Found"; }
	 * 
	 * return "Pass"; }
	 * 
	 * //Input data Keyword
	 * 
	 * public static String input() throws Exception{
	 * 
	 * APPLICATION_LOGS.debug("Executing input Keyword"); // extract the test data
	 * String message = "pass"; String data =testData.getCellData(currentTest,
	 * data_column_name , testRepeat);
	 * 
	 * 
	 * try{ System.out.println("Input keyword data :"+data);
	 * driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(data);
	 * }catch(Exception t){ // report error
	 * APPLICATION_LOGS.debug("Error while wrinting into input -"+ object +
	 * t.getMessage());
	 * 
	 * script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail - "+t.getMessage(); //return "Fail - "+t.getMessage();
	 * 
	 * }
	 * 
	 * 
	 * return "Pass";
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * public static String softAssertTrue() throws Exception{
	 * 
	 * APPLICATION_LOGS.debug("Executing input Keyword"); // extract the test data
	 * String message = "pass"; String data =testData.getCellData(currentTest,
	 * data_column_name , testRepeat);
	 * 
	 * 
	 * try{ System.out.println("Assert keyword data :"+data);
	 * System.out.println(driver.findElement(By.xpath(Objects.getProperty(object))).
	 * getText());
	 * ErrorCollectors.verifyEquals(driver.findElement(By.xpath(Objects.getProperty(
	 * object))).getText(), data);
	 * System.out.println("Data matches expected was : "+driver.findElement(By.xpath
	 * (Objects.getProperty(object))).getText()); }catch(Exception t){ // report
	 * error System.out.println("Inside catch");
	 * APPLICATION_LOGS.debug("Error while wrinting into input -"+ object +
	 * t.getMessage());
	 * 
	 * script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * return "Fail - "+t.getMessage();
	 * 
	 * }
	 * 
	 * 
	 * return "Pass";
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //Verifying text presence
	 * 
	 * 
	 * 
	 * public static String verifyText(){
	 * APPLICATION_LOGS.debug("Executing verifyText"); String
	 * expected=APPTEXT.getProperty(object); String
	 * actual=driver.findElement(By.xpath(Objects.getProperty(object))).getText();
	 * APPLICATION_LOGS.debug(expected); APPLICATION_LOGS.debug(actual); try{
	 * Assert.assertEquals(actual.trim() , expected.trim()); }catch(Throwable t){ //
	 * error APPLICATION_LOGS.debug("Error in text - "+object);
	 * APPLICATION_LOGS.debug("Actual - "+actual);
	 * APPLICATION_LOGS.debug("Expected -"+ expected); return "Fail -"+
	 * t.getMessage();
	 * 
	 * }
	 * 
	 * return "Pass";
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * //verifyTextOnThePage public void verifyTextOnThePage (String expected)
	 * throws InterruptedException{ final WebDriverException exception =new
	 * WebDriverException(); try{
	 * if(driver.findElement(By.xpath(Objects.getProperty(object))).getText().
	 * contains(expected)){ System.out.println(expected +" text is on this page"); }
	 * else{ System.out.println(expected +" text is NOT on this page"); throw new
	 * WebDriverException(exception.getMessage()); }
	 * 
	 * } catch (WebDriverException e) { throw new
	 * WebDriverException(e.getMessage()); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public static String clickButton(){
	 * APPLICATION_LOGS.debug("Executing clickButton Keyword");
	 * 
	 * 
	 * try{ driver.findElement(By.xpath(Objects.getProperty(object))).click();
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while clicking on Button -"+ object +
	 * t.getMessage()); return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * public static String select(){
	 * APPLICATION_LOGS.debug("Executing select Keyword"); // extract the test data
	 * String data =testData.getCellData(currentTest, data_column_name ,
	 * testRepeat);
	 * 
	 * 
	 * 
	 * try{
	 * driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(data);
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while Selecting from droplist -"+ object +
	 * t.getMessage()); return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 */

	/*
	 * 
	 * //Clicking on a link or an Object which contains Pop up in same window
	 * 
	 * public static String clickLink_popUp() throws AddressException,
	 * MessagingException{
	 * 
	 * APPLICATION_LOGS.debug("Executing clickLink"); try{
	 * if(selenium.isElementPresent("//div[@class='gwt-PopupPanel']")){
	 * selenium.click("//a[@class='gwt-Anchor alertLink']");
	 * selenium.isElementPresent(Objects.getProperty(object)); Thread.sleep(5000);
	 * selenium.click(Objects.getProperty(object)); }else{
	 * selenium.isElementPresent(Objects.getProperty(object));
	 * selenium.click(Objects.getProperty(object)); } }catch(Throwable t){
	 * 
	 * // report error APPLICATION_LOGS.debug("Error while clicking on an Object -"+
	 * object + t.getMessage()); script_error =
	 * "Timed out after "+globalwait+" miliseconds"; return "Fail - Link Not Found";
	 * }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 * //Input data Keyword
	 * 
	 * public static String input() throws Exception{
	 * 
	 * APPLICATION_LOGS.debug("Executing input Keyword"); // extract the test data
	 * String message = "pass"; String data =testData.getCellData(currentTest,
	 * data_column_name , testRepeat);
	 * 
	 * 
	 * try{ selenium.isElementPresent(Objects.getProperty(object));
	 * selenium.type(Objects.getProperty(object),data);
	 * System.out.println("Input keyword data :"+data); //
	 * driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(data);
	 * }catch(Exception t){ // report error
	 * APPLICATION_LOGS.debug("Error while wrinting into input -"+ object +
	 * t.getMessage());
	 * 
	 * script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * throw t; //return "Fail - "+t.getMessage();
	 * 
	 * }
	 * 
	 * 
	 * return "Pass";
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * //Input data
	 * 
	 * public static String input_number() throws Exception{
	 * 
	 * APPLICATION_LOGS.debug("Executing input Keyword"); // extract the test data
	 * String message = "pass"; String data =testData.getCellData(currentTest,
	 * data_column_name , testRepeat);
	 * 
	 * 
	 * try{ selenium.isElementPresent(Objects.getProperty(object));
	 * selenium.type(Objects.getProperty(object),(data.replace(".",
	 * "")).replace("E9", ""));
	 * 
	 * }catch(Exception t){ // report error
	 * APPLICATION_LOGS.debug("Error while wrinting into input -"+ object +
	 * t.getMessage());
	 * 
	 * script_error = "Timed out after "+globalwait+" miliseconds";
	 * 
	 * throw t; //return "Fail - "+t.getMessage();
	 * 
	 * }
	 * 
	 * 
	 * return "Pass";
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * //Implement Wait
	 * 
	 * public static String waitfor() throws NumberFormatException,
	 * InterruptedException, AddressException, MessagingException{
	 * APPLICATION_LOGS.debug("Executing wait Keyword"); // extract the test data
	 * String data =testData.getCellData(currentTest, data_column_name ,
	 * testRepeat); try{
	 * 
	 * float test = (Float.parseFloat(data)); int test1 = (int) test;
	 * Thread.sleep(test1); globalwait = test1/1000; }catch(Throwable t){
	 * APPLICATION_LOGS.debug("Error while waiting -"+ object + t.getMessage());
	 * return "Fail - "+t.getMessage(); } return "Pass"; }
	 * 
	 * 
	 * //Clicking on a Button
	 * 
	 * public static String clickButton() throws AddressException,
	 * MessagingException{ APPLICATION_LOGS.debug("Executing clickButton Keyword");
	 * 
	 * 
	 * try{
	 * 
	 * selenium.isElementPresent(Objects.getProperty(object));
	 * selenium.click(Objects.getProperty(object));
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while clicking on Button -"+ object +
	 * t.getMessage()); return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * //Selecting text elements from Drop down list
	 * 
	 * public static String select(){
	 * APPLICATION_LOGS.debug("Executing select Keyword");
	 * 
	 * // extract the test data String data =testData.getCellData(currentTest,
	 * data_column_name , testRepeat);
	 * 
	 * try{
	 * 
	 * selenium.isElementPresent(Objects.getProperty(object));
	 * selenium.select(Objects.getProperty(object),"label="+data);
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while Selecting from droplist -"+ object +
	 * t.getMessage());
	 * 
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 * 
	 * //Selecting numeric elements from Drop down list
	 * 
	 * public static String select_number(){
	 * APPLICATION_LOGS.debug("Executing select Keyword");
	 * 
	 * // extract the test data String data =testData.getCellData(currentTest,
	 * data_column_name , testRepeat);
	 * 
	 * try{
	 * 
	 * 
	 * selenium.isElementPresent(Objects.getProperty(object));
	 * selenium.select(Objects.getProperty(object),"label="+data.replaceAll(
	 * "\\.0*$", ""));
	 * System.out.println("data printed as :"+data.replaceAll("\\.0*$", ""));
	 * }catch(Throwable t){
	 * 
	 * // report error
	 * APPLICATION_LOGS.debug("Error while Selecting from droplist -"+ object +
	 * t.getMessage());
	 * 
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public static String Refresh(){
	 * APPLICATION_LOGS.debug("Executing select Keyword"); // extract the test data
	 * 
	 * 
	 * try{
	 * 
	 * selenium.refresh(); Thread.sleep(10000);
	 * 
	 * }catch(Throwable t){
	 * 
	 * // report error APPLICATION_LOGS.debug("Error while refreshing -"+ object +
	 * t.getMessage());
	 * 
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //Executing type keystrokes
	 * 
	 * public static String typekeys() throws AddressException, MessagingException{
	 * APPLICATION_LOGS.debug("Executing typekeys() Keyword");
	 * 
	 * // extract the test data String data =testData.getCellData(currentTest,
	 * data_column_name , testRepeat);
	 * 
	 * try{
	 * 
	 * 
	 * selenium.typeKeys(Objects.getProperty(object),data);
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while typing data -"+ object + t.getMessage());
	 * 
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * //Executing type keystrokes with current hour
	 * 
	 * public static String typekeys_hrs() throws AddressException,
	 * MessagingException{
	 * 
	 * APPLICATION_LOGS.debug("Executing typekeys_hrs() Keyword");
	 * 
	 * // extract the test data String data =testData.getCellData(currentTest,
	 * data_column_name , testRepeat);
	 * 
	 * try{
	 * 
	 * selenium.typeKeys(Objects.getProperty(object),sHour);
	 * 
	 * }catch(Throwable t){
	 * 
	 * // report error APPLICATION_LOGS.debug("Error while typing data -"+ object +
	 * t.getMessage()); return "Fail - "+t.getMessage();
	 * 
	 * }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * //Executing type keystrokes with current minute
	 * 
	 * public static String typekeys_min() throws AddressException,
	 * MessagingException{
	 * 
	 * APPLICATION_LOGS.debug("Executing typekeys_min() Keyword");
	 * 
	 * 
	 * try{
	 * 
	 * selenium.typeKeys(Objects.getProperty(object),sMin);
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while typing data -"+ object + t.getMessage());
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * //Executing type keystrokes with current second
	 * 
	 * public static String typekeys_sec() throws AddressException,
	 * MessagingException{
	 * APPLICATION_LOGS.debug("Executing typekeys_sec() Keyword");
	 * 
	 * try{
	 * 
	 * selenium.typeKeys(Objects.getProperty(object),sSec);
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while typing data -"+ object + t.getMessage());
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 * 
	 * //Getting text from an object and executing it based on the object
	 * 
	 * public static String GetText() throws AddressException, MessagingException{
	 * APPLICATION_LOGS.debug("Executing GetText Keyword");
	 * 
	 * try{
	 * 
	 * selenium.getText(Objects.getProperty(object));
	 * APPLICATION_LOGS.debug("Got the text for:  "+object+"----"+
	 * selenium.getText(Objects.getProperty(object)));
	 * 
	 * if(object.equals("callid")){
	 * call_id=selenium.getText(Objects.getProperty(object));
	 * 
	 * //setting the test data file to null DriverApp.testData=null; datareader =
	 * new Xlfile_Reader(
	 * "C:\\Selenium2.0\\app\\test\\Framework\\AutomationBvt_Hybrid\\src\\config\\TestData.xlsx"
	 * );
	 * 
	 * //Adding generated call id in Evaluation and Audit
	 * 
	 * datareader.setCellData("EvaluateaCall", "generated_call_id", 2, call_id);
	 * datareader.setCellData("Audit_call", "generated_call_id", 2, call_id);
	 * datareader.setCellData("Calibrations", "generated_call_id", 2, call_id);
	 * //Loading the test data file again DriverApp.testData = new
	 * Xlfile_Reader(System.getProperty("user.dir")+"\\src\\config\\TestData.xlsx");
	 * 
	 * 
	 * }else if(object.equals("evalscore")){ String
	 * app_score=(selenium.getText(Objects.getProperty(object))).replaceAll(
	 * "\\(.+\\)", ""); System.out.println("App score is:"+app_score); float score=
	 * Float.parseFloat(app_score); round = TestUtil.Round(score,2);
	 * System.out.println("First round: "+round);
	 * 
	 * datawriter = new Xlfile_Reader(
	 * "C:\\Selenium2.0\\app\\test\\Framework\\AutomationBvt_Hybrid\\src\\config\\db_data.xlsx"
	 * ); datawriter.setFloatCellData("Evaluation", "QAScore_Application", 2,
	 * round);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }catch(Throwable t){
	 * 
	 * // report error APPLICATION_LOGS.debug("Error while fetching text -"+ object
	 * + t.getMessage()); return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //Verifying text presence
	 * 
	 * public static String verifytext() throws AddressException,
	 * MessagingException{ APPLICATION_LOGS.debug("Executing verifytext() Keyword");
	 * 
	 * try{
	 * 
	 * //selenium.isTextPresent(Objects.getProperty(object));
	 * 
	 * 
	 * if(object.equals("callid")){ selenium.isTextPresent((call_id));
	 * System.out.println("Verifed Text as  :"+call_id); }
	 * 
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while Verifying text presence -"+ object +
	 * t.getMessage());
	 * 
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 * // clicking on an Object that contains certain text
	 * 
	 * public static String containsText_click(){
	 * APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
	 * 
	 * try{
	 * 
	 * String data =testData.getCellData(currentTest, data_column_name ,
	 * testRepeat); selenium.click("//div[contains(text(),'"+data+"')]");
	 * 
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while searching and clicking -"+ object +
	 * t.getMessage()); return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * // Forcefully clicking on an Object
	 * 
	 * public static String clickat() throws AddressException, MessagingException{
	 * APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
	 * 
	 * try{
	 * 
	 * String data =testData.getCellData(currentTest, data_column_name ,
	 * testRepeat); // selenium.click("//div[contains(text(),'"+data+"')]");
	 * selenium.clickAt(Objects.getProperty(object), data);
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while searching and clicking -"+ object +
	 * t.getMessage());
	 * 
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public static String doubleclickat() throws AddressException,
	 * MessagingException{
	 * APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
	 * 
	 * try{
	 * 
	 * String data =testData.getCellData(currentTest, data_column_name ,
	 * testRepeat);
	 * 
	 * selenium.doubleClickAt(Objects.getProperty(object), data);
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while searching and clicking -"+ object +
	 * t.getMessage()); return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 * // Clicking on a object by fireevent keyword
	 * 
	 * public static String fireevent() throws AddressException, MessagingException{
	 * APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
	 * 
	 * try{
	 * 
	 * String data =testData.getCellData(currentTest, data_column_name ,
	 * testRepeat);
	 * 
	 * selenium.fireEvent(Objects.getProperty(object),"click");
	 * 
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while clicking -"+ object + t.getMessage());
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * // Clicking on a object by checkBox keyword
	 * 
	 * public static String checkBox() throws AddressException, MessagingException{
	 * APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
	 * 
	 * try{
	 * 
	 * String data =testData.getCellData(currentTest, data_column_name ,
	 * testRepeat);
	 * 
	 * selenium.check(Objects.getProperty(object));
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while checking -"+ object + t.getMessage());
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * 
	 * 
	 * 
	 * // Clicking on a object by fireevent keyword by getting the data from the
	 * excel file
	 * 
	 * public static String checkelementpresence() throws AddressException,
	 * MessagingException{
	 * APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
	 * 
	 * try{
	 * 
	 * String data =testData.getCellData(currentTest, data_column_name ,
	 * testRepeat);
	 * 
	 * selenium.fireEvent("//table/tbody/tr/td[2]/a[contains(text(),'"+data+"')]",
	 * "click");
	 * 
	 * }catch(Throwable t){ // report error
	 * APPLICATION_LOGS.debug("Error while clicking -"+ object + t.getMessage());
	 * return "Fail - "+t.getMessage(); }
	 * 
	 * return "Pass"; }
	 * 
	 * //
	 * 
	 * 
	 * 
	 */

}
