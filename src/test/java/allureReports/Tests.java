package allureReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})
public class Tests extends BaseClass{

	public WebDriver driver;
	
	@BeforeClass 
	public void setUp() {
		BaseClass bs= new BaseClass();
		driver = bs.initialize_driver();
		driver.get("https://itdelta.learn.company-policy.com/");
		
	}
	
	@Severity(SeverityLevel.MINOR)	
	@Test(priority=1, description="Verify Logo presence on Landing Page")
	@Description("Verify Logo presence on Landing Page........")
	@Epic("EP001")
	@Feature("Feature1: Logo")
	@Story("Story:Logo Presence")
	@Step("Verify logo Presence")
	public void logoPresence() throws InterruptedException
	{
		boolean isLogoDisplayed = driver.findElement(By.xpath("//span[@class='block text-white']")).isDisplayed();
		Assert.assertEquals(isLogoDisplayed, true);
	}
	
	@Severity(SeverityLevel.BLOCKER)	
	@Test(priority=2, description="Verify login")
	@Description("Verify login with Valid Credentials........")
	@Epic("EP001")
	@Feature("Feature2: Login")
	@Story("Story:Valid login")
	@Step("Verify login")
	public void loginTest() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@class='whitespace-nowrap text-base font-medium text-gray-500 hover:text-gray-900']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("project2@it-delta.ru");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("159159");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		boolean isTitleDisplayed = driver.findElement(By.xpath("//h2[text()='Learning center']")).isDisplayed();
		Assert.assertEquals(isTitleDisplayed, true);
	}
		
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3, description="Verify user Registration")
	@Description("Verify user Registration........")
	@Epic("EP001")
	@Feature("Feature3: Registration")
	@Story("Story:User registration")

	public void registrationTest()
	{
		throw new SkipException("Skipping this Test");
	}
	

	@AfterClass
	public void tearDown()
	{	
		driver.quit();
	}
	
}
