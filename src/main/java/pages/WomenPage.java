package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import seleniumlayer.Driverclass;

public class WomenPage extends Driverclass {

	WebDriver WomenPagedriver;

	public WomenPage(WebDriver driver) {

		this.WomenPagedriver = driver;

	}

	public void womenpageaction() throws Exception {

		WebElement Womenmenu = WomenPagedriver.findElement(By.xpath("//a[@title='Women']"));

		clickWebelement(Womenmenu, "WomenMenu");
		waitMyTime(5);

		WebElement Dresses = WomenPagedriver.findElement(By.xpath("//*[@id='categories_block_left']/div/ul/li[2]/a"));

		clickWebelement(Dresses, "Dresses");

		waitMyTime(5);


		WebElement SummerDresses = WomenPagedriver
				.findElement(By.xpath("//*[@id='categories_block_left']/div/ul/li[3]/a"));

		clickWebelement(SummerDresses, "Summer Dresses");

		WebElement Listicon = WomenPagedriver.findElement(By.xpath("//*[@id='list']/a/i"));

		clickWebelement(Listicon, "ListIcon");

	}

	public void addcartfromProductlist(int number) throws Exception {

		
		WebElement List = WomenPagedriver
				.findElement(By.xpath("//*[@id='center_column']/ul/li[" + number + "]/div/div/div[1]/div/a[1]/img"));

		safeJavaScriptClick(List);
		
		System.out.println("Product list  "+number+ " is Selected");

		WebElement Quantity = WomenPagedriver.findElement(By.xpath("//*[@id='quantity_wanted']"));

		sendKeys(Quantity, "5");

		WebElement Size = WomenPagedriver.findElement(By.xpath("//*[@id='group_1']"));

		selectDropdownValue(Size, "L");

		int numcolor = WomenPagedriver.findElements(By.xpath("//*[@id='color_to_pick_list']/li")).size();

		

		int colorselect = numcolor - 1;

		WebElement colorselected = WomenPagedriver
				.findElement(By.xpath("//*[@id='color_to_pick_list']/li[" + colorselect + "]/a"));

		clickWebelement(colorselected, "colorselect");

		WebElement Addtocart = WomenPagedriver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
		clickWebelement(Addtocart, "Addtocartbtn");

		WebElement continueShopping = WomenPagedriver.findElement(By.xpath("//span[@title='Continue shopping']"));

		clickWebelement(continueShopping, "continueShopping");

		WebElement Summerdressfromcart = WomenPagedriver.findElement(By.xpath("//*[@id='columns']/div[1]/a[4]"));

		clickWebelement(Summerdressfromcart, "Summerdressfromcart");

	}

	public void checkout() throws Exception {

		WebElement Movetocart = WomenPagedriver.findElement(By.xpath("//a[@title='View my shopping cart']"));

		clickWebelement(Movetocart, "Movetocart");

		WebElement Proceedtocart1 = WomenPagedriver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span"));

		scrollElementIntoView(Proceedtocart1);

		waitMyTime(6);

		clickWebelement(Proceedtocart1, "Proceedtocart");
		waitMyTime(6);

		WebElement Proceedtocart2 = WomenPagedriver
				.findElement(By.xpath("//*[@id='center_column']/form/p/button/span"));

		scrollElementIntoView(Proceedtocart2);

		clickWebelement(Proceedtocart2, "Proceedtocart2");

		WebElement Proceedtocart3 = WomenPagedriver.findElement(By.xpath("//*[@id='form']/p/button/span"));

		WebElement Proceedtocart3accept = WomenPagedriver.findElement(By.xpath("//*[@id='cgv']"));
		scrollElementIntoView(Proceedtocart3);
		clickWebelement(Proceedtocart3accept, "Proceedtocart3accept");

		waitMyTime(5);

		clickWebelement(Proceedtocart3, "Proceedtocart");

		WebElement paymenttype = WomenPagedriver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a"));
		scrollElementIntoView(paymenttype);
		clickWebelement(paymenttype, "paymenttype");

		waitMyTime(7);

		WebElement confirmorder = WomenPagedriver.findElement(By.xpath("//*[@id='cart_navigation']/button/span"));

		scrollElementIntoView(confirmorder);

		safeJavaScriptClick(confirmorder);

	}

	public void captureorderdetails() throws Exception {

		WebElement Myaccount = WomenPagedriver.findElement(By.xpath("//a[@title='View my customer account']/span"));
		clickWebelement(Myaccount, "Myaccount");

		WebElement orderdetails = WomenPagedriver.findElement(By.xpath("//a[@title='Orders']/span"));

		clickWebelement(orderdetails, "orderdetails");

		WebElement Orderview = WomenPagedriver.findElement(By.xpath("//*[@id='order-list']/thead/tr/th[1]"));
		scrollElementIntoView(Orderview);

		getScreenShotOnCheckpoint("orderdetails", WomenPagedriver);

	}

}
