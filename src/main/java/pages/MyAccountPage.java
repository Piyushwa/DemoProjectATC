package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumlayer.Driverclass;

public class MyAccountPage extends Driverclass {
	
	
	  WebDriver MyAccountPagedriver;
		

	public MyAccountPage(WebDriver driver) {
		
        this.MyAccountPagedriver = driver;
		
		}

	
	public void myaddress() throws Exception {
	
		
      WebElement MyAddress = MyAccountPagedriver.findElement(By.xpath("//span[contains(text(),'My addresses')]"));
		
	clickWebelement(MyAddress, "My Address Button");
    WebElement Addnewadrees = MyAccountPagedriver.findElement(By.xpath("//a[@title='Add an address']"));
	clickWebelement(Addnewadrees, "Add new Address Button");
    WebElement Firstname = MyAccountPagedriver.findElement(By.xpath("//*[@id='firstname']"));
    sendKeys(Firstname, "Test");
    WebElement Lastname = MyAccountPagedriver.findElement(By.xpath("//*[@id='lastname']"));
    sendKeys(Lastname, "User");
   
    
    	WebElement Address = MyAccountPagedriver.findElement(By.xpath("//*[@id='address1']"));
    sendKeys(Address, "TestAddress");



    WebElement city = MyAccountPagedriver.findElement(By.xpath("//*[@id='city']"));
    sendKeys(city, "New York");

    WebElement state = MyAccountPagedriver.findElement(By.xpath("//*[@id='id_state']"));
    
    selectDropdownValue(state, "Alabama");
    
    
    WebElement Zip = MyAccountPagedriver.findElement(By.xpath("//*[@id='postcode']"));

    sendKeys(Zip, "50867");
    
    WebElement Mobile = MyAccountPagedriver.findElement(By.xpath("//*[@id='phone']"));
    
    sendKeys(Mobile, "9999999999");
    
    WebElement phoneMobile = MyAccountPagedriver.findElement(By.xpath("//*[@id='phone_mobile']"));
    
    sendKeys(phoneMobile, "9999999999");


WebElement Additioninfo = MyAccountPagedriver.findElement(By.xpath("//*[@id='other']"));
    
    sendKeys(Additioninfo, "Testinfo");
    
    WebElement alias = MyAccountPagedriver.findElement(By.xpath("//*[@id='alias']"));
    
    sendKeys(alias, "Test1");
    
    
    WebElement Savebtn = MyAccountPagedriver.findElement(By.xpath("//*[@id='submitAddress']"));

    clickWebelement(Savebtn, "Save New Address");


	}
		
		
		
}
