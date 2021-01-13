package testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.MyAccountPage;
import pages.WomenPage;
import seleniumlayer.Driverclass;



public class TC1 extends Driverclass {

	@Test(priority = 0)

	public void login() throws Exception {

		Homepage hp = new Homepage(driver);

		hp.Signin();

	}

	
	@Test(priority = 1)

	public void myaddress() throws Exception {
		
		MyAccountPage mc = new MyAccountPage(driver);

	 	waitMyTime(6);

		mc.myaddress();

	}

	@Test(priority = 2)

	public void Womenaction() throws Exception {

		WomenPage wp = new WomenPage(driver);

		Thread.sleep(5000);
		wp.womenpageaction();
		wp.addcartfromProductlist(1);
		
		  Thread.sleep(5000);
		  wp.addcartfromProductlist(2); 
		  Thread.sleep(5000);
		  wp.addcartfromProductlist(3);
		 

		wp.checkout();
		wp.captureorderdetails();

	}

	@AfterClass

	public void signout() throws InterruptedException {

		Homepage hp = new Homepage(driver);

		hp.Signout();

	}

}
