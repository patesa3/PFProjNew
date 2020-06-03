package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.util.constant;

public class LaunchPage extends BasePage {
	//locating element via PageFactory Model
	//WebElement customers ==> webElement
	//className="zh.customers" == > Locator value of className
	
	
	@FindBy(className="zh.customers")
	public WebElement customers;
	
	@FindBy(className="zh.support")
	public WebElement Support;
	
	@FindBy(className="zh-login")
	public WebElement Login;
	
	@FindBy(className="zh.singnup")
	public WebElement SignUp;
	
	//create constructor
	
	public LaunchPage(WebDriver driver, ExtentTest eTest) {
		this.driver =driver;
		this.eTest = eTest;
		
	}

	public boolean goToLoginPage() throws InterruptedException{
		//selenium code to logon page
		driver.get(constant.APP_URL);
		eTest.log(LogStatus.INFO, "Sucessfully application URL "+constant.APP_URL+" got opened");
		Login.click();
		eTest.log(LogStatus.INFO, "Login Element clicked");
		LoginPage  loginpage = new LoginPage(driver,eTest);
		PageFactory.initElements(driver, loginpage);
		boolean loginStatus= loginpage.doLogin();
		return loginStatus;
		
	}
	
	//other Resusable Methods
	
}
