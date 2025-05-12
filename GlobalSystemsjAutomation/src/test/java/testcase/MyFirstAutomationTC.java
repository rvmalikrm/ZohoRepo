package testcase;
import org.openqa.selenium.By;

import org.testng.annotations.Test;
import base.BaseTest;
import utilities.ReadXLS;
public class MyFirstAutomationTC extends BaseTest 
{
	@Test(dataProviderClass=ReadXLS.class, dataProvider="zohotestdataprovider")
	public static void LoginTest(String userid, String password) throws InterruptedException 
	{
	driver.findElement(By.xpath(loc.getProperty("Sign_up_link"))).click();//locaters -properties
	Thread.sleep(2000); 
	driver.findElement(By.name(loc.getProperty("email_field"))).sendKeys(userid);
	driver.findElement(By.id(loc.getProperty("next_button"))).click();
	Thread.sleep(2000);
	driver.findElement(By.name(loc.getProperty("password_field"))).sendKeys(password);
	Thread.sleep(2000);
	driver.findElement(By.id(loc.getProperty("final_next_button"))).click();
	Thread.sleep(2000);
	System.out.println("Website  Launched Successfully");
	}
//	@DataProvider(name="testdataprovider")
//	public Object[][] createData1() 
//	{
//		 return new Object[][] 
//		{{ "rm.ravtest91@gmail.com", "Institute@29" },{ "ravtest91@gmail.com", "" },{ "ravtest91@gmail.com", "Institute@29" }};
//	}
}
