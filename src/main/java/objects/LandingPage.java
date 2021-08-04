package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver){
		this.driver = driver;
	}

	private By mynetwork = By.xpath("//*[text()='My Network']");

	public WebElement MyNetwork() {
		return driver.findElement(mynetwork);
	}
	
}
