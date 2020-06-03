package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.util.constant;

public class LoginPage extends BasePage {
	
	

	//@FindBy(id="lid")
	@FindBy(id="login_id")
	public WebElement EmailField;
	
	@FindBy(id="password")
	public WebElement Passwordfield;
	
	@FindBy(id="nextbtn")
	public WebElement NextBtn;
	
	
	@FindBy(className="btn blue")
	public WebElement SignInButton;

	
	//anyother webelement in Login Page
	
	//Constructor
	public LoginPage(WebDriver driver, ExtentTest eTest) {
		this.driver =driver;
		this.eTest =eTest;
		
	}

	public boolean doLogin() throws InterruptedException{
		//selenium code to login into application
		EmailField.sendKeys(constant.USERNAME);
		eTest.log(LogStatus.INFO, "Username got entered into the Email address field on Login Page");
		NextBtn.click();
		eTest.log(LogStatus.INFO, "Click on Next button Login Page");
		Passwordfield.sendKeys(constant.PASSWORD);
		//Thread.sleep(millis, 2000);
		eTest.log(LogStatus.INFO, "Password got entered into the Email address field on Login Page");
		SignInButton.click();
		eTest.log(LogStatus.INFO, "Sign in Button got clicked");
		HomePage homepage =new HomePage(driver,eTest);
		PageFactory.initElements(driver, homepage);
	boolean	loginStatus=  homepage.verifyDisplayOfHomePage();
	 return loginStatus;
	}
	

}
