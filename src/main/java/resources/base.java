package resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver driver;

	
	public WebDriver initilizeDriver() {
		System.setProperty("webdriver.chrome.driver", 
			System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		return driver;
	}

}
