package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumlayer.Driverclass;

public class Homepage extends Driverclass  {
	
	
	
	private WebDriver Homepagedriver;
	
	public Homepage(WebDriver driver) {
	
	    this.Homepagedriver = driver;
	
	}
	
	
	

	public void Signin() throws InterruptedException {
		
		
	WebElement SignIn = 	Homepagedriver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
     clickWebelement(SignIn, "SignIn");
 	waitMyTime(3);
		
		WebElement Username = 	Homepagedriver.findElement(By.xpath("//input[@id='email']"));
		sendKeys(Username, "Piyushwadhwa23@gmail.com");
		
		WebElement password = 	Homepagedriver.findElement(By.xpath("//input[@id='passwd']"));
		
		sendKeys(password, "Test@123");
		
		
		WebElement Submitbtn = 	Homepagedriver.findElement(By.xpath("//*[@id='SubmitLogin']"));

	     clickWebelement(Submitbtn, "Submit Login");

		  
	}
	

	public void Signout() throws InterruptedException {
	
		WebElement Signout = 	Homepagedriver.findElement(By.xpath("//a[@title='Log me out']"));
	     clickWebelement(Signout, "Signout");
	  	waitMyTime(3);

	}

	
	
	
}
