package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvitationManagerPage {
public WebDriver driver;
	
	public InvitationManagerPage(WebDriver driver){
		this.driver = driver;
	}
	
	private By sent = By.xpath("//button[text()='Sent']");
	private By loader = By.className("artdeco-loader");
	private By next = By.cssSelector("[aria-label='Next']");
	private By people = By.className("artdeco-pill__text");
	private By withdraw = By.xpath("//span[text()='Withdraw']");
	
	public WebElement Sent() {
		return driver.findElement(sent);
	}
	
	public WebElement Next() {
		return driver.findElement(next);
	}
	
	public int totalPeople() {
		String s = driver.findElement(people).getText().split(" ")[1];
		s = s.replace("(", "");
		s = s.replace(")", "");
		return Integer.parseInt(s);
	}
	
	public int withdrawCount() {
		return driver.findElements(withdraw).size();
	}
	

	
	public void LoadPageContent() {
		do {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebDriverWait wait = new WebDriverWait(driver,3);
				wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			} catch(Exception e) {
				break;
			}
		}while(true);
		
	}
	
}
