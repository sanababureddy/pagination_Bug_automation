package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver driver;
	
	public loginPage(WebDriver driver){
		this.driver = driver;
	}
	
	private By username = By.id("username");
	private By password = By.id("password");
	private By login = By.cssSelector("[aria-label='Sign in']");
	
	public WebElement Username() {
		return driver.findElement(username);
	}
	
	public WebElement Password() {
		return driver.findElement(password);
	}
	
	public WebElement SignIn() {
		return driver.findElement(login);
	}

}
