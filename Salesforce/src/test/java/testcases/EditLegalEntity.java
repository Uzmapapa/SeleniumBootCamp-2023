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

public class EditLegalEntity extends BaseHooks {
	@BeforeTest
    public  void setup() {
        excelFile="EditLegalEntity" ;
	}
	@Test (dataProvider = "fetchData")
	public void editLegalEntity(String name , String compName,String descriptionInput) throws InterruptedException {
		
		WebElement search = driver.findElement(By.xpath("//input[@class='slds-input']"));
		search.click();
		search.sendKeys("legal Entities");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		 WebElement search1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")));
	      search1.sendKeys(name); 
	      search1.sendKeys(Keys.ENTER);
	     Thread.sleep(1000);	
//	     WebElement downArrow = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Show more actions']")));
//	     downArrow.click();
	     driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]")).click();
				  WebElement edit =driver.findElement(By.xpath("//a[@title='Edit']"));
				  driver.executeScript("arguments[0].click();", edit);
				  driver.executeScript("document.body.style.zoom='70%'", "");
				
					WebElement status = driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]"));
					driver.executeScript("arguments[0].click();", status);
				
					WebElement statusActive = driver.findElement(By.xpath("//span[text()='Active']"));
					driver.executeScript("arguments[0].click();", statusActive);

				
				  WebElement companyName = driver.findElement(By.xpath("//*[@name='CompanyName']"));
				  companyName.sendKeys(compName);
				  WebElement description = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
				  description.sendKeys(descriptionInput);
				  WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
				  driver.executeScript("arguments[0].click();", save);
				  String text = driver
							.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
							.getText();
					System.out.println(text);
					boolean expected = text.contains(name);
					Assert.assertTrue(expected, "legal Entity not edited");
			

}
}