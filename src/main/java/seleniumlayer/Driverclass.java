package seleniumlayer;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
public class Driverclass {
	
	public static WebDriver driver;

	
	private static final String chromedriverPath =  System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	private static final String IEdriverPath = "//Drivers//chromedriver.exe";
	private static String Browser = "Chrome";
	public static String URL  ="http://automationpractice.com/index.php";
	
	
	@BeforeSuite
public  WebDriver getbrowser() throws InterruptedException, ClassNotFoundException, SQLException {

		
		System.out.println("*************Starting Execution********************************");
		
		

		if (Browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			
			options.setAcceptInsecureCerts(true);

			// System.setProperty("webdriver.gecko.driver",firefoxdriverPath);
			driver = new FirefoxDriver(options);
		}

		else if (Browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", chromedriverPath);
	
			driver = new ChromeDriver();
			 
		
		}

		else if (Browser.equalsIgnoreCase("ie")) {

			File file = new File(IEdriverPath);
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		
			driver = new InternetExplorerDriver();

		}

		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}

		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.navigate().to(URL);
		// Login into Application

		Thread.sleep(4000);
		// test.log(LogStatus.PASS, "Navigated to the specified URL");
		return driver;



	}



	
	public static void getScreenShotOnCheckpoint(String Methodname, WebDriver driver) throws IOException {
		
		Methodname = Methodname.replace("*", "").replace(":", "").replace(":", "").replace("+", "").replace(" ", "");
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMyyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("MM-dd-yyyy h-mm-ss a");
		String formattedDate1 = sdf1.format(date);
		String formattedDate2 = sdf2.format(date);
		String formattedDate3 = sdf3.format(date);
		String fileSeperator = System.getProperty("file.separator");

		String folderName1 = formattedDate1;
		String folderName2 = formattedDate2;
		String imagePath1 = System.getProperty("user.dir") + "\\Screenshots\\" + folderName1 + fileSeperator;
		String imagePath2 = System.getProperty("user.dir") + "\\Screenshots\\" + folderName1 + fileSeperator + "\\"
				+ folderName2 + fileSeperator;
		String imagePath3 = System.getProperty("user.dir") + "\\test-output\\AdvanceReport\\Screenshots\\";

		String imageName = Methodname.replace("*", "") + "_Checkpoint_" + formattedDate3 + ".jpg";

		File file1 = new File(imagePath1);
		if (!file1.exists()) {
			System.out.println("File created " + file1);
			file1.mkdir();

			File file2 = new File(imagePath2);
			
			if (!file2.exists()) {
				System.out.println("File created " + file2);
				file2.mkdir();
			}
		}

		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(imagePath2 + imageName));
		FileUtils.copyFile(scrFile, new File(imagePath3 + imageName));
		// logger.attachScreenshot("./Screenshots/"+imageName);
		System.out.println("ScreenShot of CheckPoint : " + imagePath2 + imageName);
	
		

	}

	
	public static void clickWebelement(WebElement element, String Webelementname) {

		try {
			

			element.click();
			System.out.println("Clicked on the '" + Webelementname + "'");
			

		} 
		
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			element.click();
			System.out.println("Clicked on the '" + Webelementname + "'");
		}
		
		catch (ElementNotVisibleException e) {

			System.out.println("====Failed==== \"" + Webelementname + "\" field is not present'");

			e.printStackTrace();
		}
		
		
		
	}

	public static void sendKeys(WebElement element, String TestData) {

		try {

			element.clear();
			element.sendKeys(TestData);

			System.out.println("Entered \"" + TestData + "\" in the field  ");
			
			
		}
		
		 catch (ElementNotVisibleException ex) {
				System.out.println("Failed in entering. Not Visible " + TestData);
				ex.printStackTrace();
				
		 }

		
		catch (Exception e) {
			System.out.println("Failed in entering " + TestData);
			e.printStackTrace();

		}
	}

	public static void selectDropdownValue(WebElement element, String Selectvalue) throws Exception {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(Selectvalue);
			System.out.println("Selected \"" + Selectvalue + " \" drop down");
			

		} catch (NoSuchElementException e) {
			System.out.println("====Failed==== \"" + Selectvalue + "\" is not present in Drop Down");
			
			e.printStackTrace();
		}
	}
	
	
	public static void explicitwait(WebElement elem ) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
	}

	public static void WaitForElementPresent(String locator) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		}

		catch (Exception e) {
			System.out.println("===Failed=== Could not find the locator: " + locator);

			e.printStackTrace();
		}

	}

	
	public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
	
	public static void moveMouse(WebElement elem) {
		try {
			Actions act = new Actions(driver);
		
			act.moveToElement(elem).build().perform();
			System.out.println("Moved Mouse over '" + elem + "'");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public static void scrollElementIntoView(WebElement Element) throws Exception {

		// This try block handles Index out of Bound exception
		try {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",Element);

		} catch (Exception e) {
			System.out.println("Could not Scroll Element in View Range: ");

			e.printStackTrace();
		}
	}

	public static void Navigateback() {
		
		driver.navigate().back();
	}
	
	public static void waitMyTime(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

	}


	@AfterSuite
	
public static void AfetrSuite() {
		
		System.out.println("***********Ending Execution****************************");
		
		driver.quit();
	}

	
	
	
}
