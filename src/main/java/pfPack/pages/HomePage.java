package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class HomePage extends BasePage{

		
	public HomePage(WebDriver driver, ExtentTest eTest) {
		this.driver=driver;
		this.eTest=eTest;
		
	}

	@FindBy(css="span[class^='zicon-apps-calendar']")
	public WebElement Calendar;
	
	@FindBy(css="span[class^='zicon-apps-chat']")
	public WebElement cliq;
	
	@FindBy(css="span[class^='zicon-apps-crm']")
	public WebElement CRM;
	
	@FindBy(css="span[class^='zicon-apps-mail']")
	public WebElement Mail;
	
	@FindBy(css="span[class^='zicon-apps-saleiq']")
	public WebElement SalesIQ;
	
	// Resuable method to verify that user is sucessfully logged in
	
	public boolean verifyDisplayOfHomePage(){
		return(isElementPresent(Mail));
		
			
	}
		
	}
	
	
	


