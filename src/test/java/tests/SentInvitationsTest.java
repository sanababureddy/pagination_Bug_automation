package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.InvitationManagerPage;
import objects.LandingPage;
import objects.MyNetworkPage;
import objects.loginPage;
import resources.base;

public class SentInvitationsTest extends base{
	public WebDriver driver;
	@BeforeTest
	public void invokeBrowser() {
		driver = initilizeDriver();
		driver.get("https://www.linkedin.com/login");
	}
	
	@Test
	public void paginationTest() {
		//login details form Maven command line parameters
		//usage mvn test -Dusername="sana" -Dpassword="123"
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
		loginPage login = new loginPage(driver);
		login.Username().sendKeys(username);
		login.Password().sendKeys(password);
		login.SignIn().click();
		
		LandingPage f=new LandingPage(driver);
		f.MyNetwork().click();
		
		MyNetworkPage mn=new MyNetworkPage(driver);
		mn.Manage().click();
		
		InvitationManagerPage imp = new InvitationManagerPage(driver);
		imp.Sent().click();
		
		int calcPeopleCount = 0;
		
		imp.LoadPageContent();
		calcPeopleCount = imp.withdrawCount();
		while(imp.Next().isEnabled()) {
			imp.Next().click();
			imp.LoadPageContent();
			calcPeopleCount += imp.withdrawCount();
		}
		
		if(imp.totalPeople()==calcPeopleCount) {
			System.out.println("Profiles Visibility is perfect");
		}
		else {
			System.out.println("Some Profiles are not displying");
			System.out.println("Total Profiles Count : "+imp.totalPeople());
			System.out.println("Calculated Profiles Count: "+calcPeopleCount);
		}
		
	}
	
	@AfterTest
	public void closeBrowser() {
		
	}
	

}
