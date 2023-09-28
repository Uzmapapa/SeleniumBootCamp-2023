package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseHooks extends DataProviderHandler{
	public ChromeDriver driver;
	public ChromeOptions option;

	@BeforeMethod
	public void preCondition() {

		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("uzmamehamooda.a@gmail.com");
		driver.findElement(By.id("password")).sendKeys("July2683", Keys.ENTER);
		driver.findElement(By.className("slds-icon-waffle")).click();
		WebElement view = driver.findElement(By.xpath("//button[@class='slds-button']"));
		view.click();
		
	}

	@AfterMethod
	public void afterMethod(ITestResult result , Method method) {
		if(!result.isSuccess()) {
			System.out.println(method.getName() + " : was failed");
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File("./image/failedScreenshoot-" + method.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	driver.quit();
	}

}
