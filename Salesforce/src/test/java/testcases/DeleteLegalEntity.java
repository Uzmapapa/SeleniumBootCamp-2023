package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseHooks;

public class DeleteLegalEntity extends BaseHooks  {
	@BeforeTest
    public  void setup() {
        excelFile="DeleteLegalEntity" ;
	}
	@Test (dataProvider = "fetchData")
	public void deleteLegalEntity(String name) throws InterruptedException {
		
	
		WebElement search = driver.findElement(By.xpath("//input[@class='slds-input']"));
		search.click();
		search.sendKeys("legal Entities");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		 WebElement search1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")));
	      search1.sendKeys(name); 
	      search1.sendKeys(Keys.ENTER);
	     Thread.sleep(1000);			
	     driver.findElement(By.xpath("(//a[contains(@class,'slds-button slds-button--icon-x-small')])[1]")).click();
				  WebElement delete =driver.findElement(By.xpath("//a[@title='Delete']"));
				  driver.executeScript("arguments[0].click();", delete);
				  driver.findElement(By.xpath("//span[text()='Delete']")).click();
				  String text = driver
							.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
							.getText();
					System.out.println(text);
					boolean expected = text.contains(name);
					Assert.assertTrue(expected, "legal Entity not deleted");

}
}
