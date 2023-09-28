package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseHooks;

public class CreateLegalEntity extends BaseHooks {
	@BeforeTest
    public  void setup() {
        excelFile="CreateLegalEntity" ;
	}
	@Test(dataProvider = "fetchData")
	public void createlegalEntity(String name) {

		WebElement search = driver.findElement(By.xpath("//input[@class='slds-input']"));
		search.click();
		search.sendKeys("legal Entities");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		WebElement inputName = driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
		inputName.sendKeys(name);
		
		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		save.click();
		// driver.executeScript("arguments[0].click();", save);
		String text = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
				.getText();
		
		System.out.println(text);
		boolean expected = text.contains(name);
		Assert.assertTrue(expected, "legal Entity not created");
	}
	

}
