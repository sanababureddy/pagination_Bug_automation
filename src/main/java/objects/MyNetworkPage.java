package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyNetworkPage {
public WebDriver driver;
	
	public MyNetworkPage(WebDriver driver){
		this.driver = driver;
	}
	
	private By manage = By.cssSelector("[aria-label *='Manage all invitations']");
	
	public WebElement Manage() {
		return driver.findElement(manage);
	}
}
