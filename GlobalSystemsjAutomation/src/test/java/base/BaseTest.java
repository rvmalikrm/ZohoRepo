package base;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
public class BaseTest {
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static Properties loc=new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	@BeforeMethod
	public  void setup() throws IOException {
		if(driver==null) {
			 fr=new FileReader(System.getProperty("user.dir")+"\\\\src\\\\test\\\\resources\\\\configfiles\\\\config.properties");
			 fr1=new FileReader(System.getProperty("user.dir")+"\\\\src\\\\test\\\\resources\\\\configfiles\\\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
			 // driver.get("https://www.zoho.com");
			 driver.get(prop.getProperty("testUrl"));
			 
			 driver.manage().window().maximize();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			// driver.get("https://www.zoho.com");
			driver.get(prop.getProperty("testUrl"));
			driver.manage().window().maximize();
		}	
	}
	@AfterMethod
	public  void teardown() {
		driver.quit();
		
	}

}
