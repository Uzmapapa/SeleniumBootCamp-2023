package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseHooks;

public class LegalEntityWithoutMandatoryFields extends BaseHooks{
	@BeforeTest
    public  void setup() {
        excelFile="NoMandatoryField" ;
	}
	@Test (dataProvider = "fetchData")

	public void entityWithoutMandatoryFields(String compName,String descriptionInput) {
	
	WebElement search = driver.findElement(By.xpath("//input[@class='slds-input']"));
	search.click();
	search.sendKeys("legal Entities");
	driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
	driver.findElement(By.xpath("//div[@title='New']")).click();
	
	WebElement status = driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]"));
	driver.executeScript("arguments[0].click();", status);

	WebElement statusActive = driver.findElement(By.xpath("//span[text()='Active']"));
	driver.executeScript("arguments[0].click();", statusActive);


  WebElement companyName = driver.findElement(By.xpath("//*[@name='CompanyName']"));
  companyName.sendKeys(compName);
  WebElement description = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
  description.sendKeys( descriptionInput);
 
	WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	save.click();
	
	String alertMessge = driver.findElement(By.xpath("//*[text()='Review the following fields']")).getText();
	 String name = driver.findElement(By.xpath("//input[@name='Name']/following::div[starts-with(@id, 'help-message')]")).getText();
	
	System.out.println(alertMessge);
	System.out.println(name + " : Mandatory");
	boolean expected = name.contains("Complete");
	Assert.assertTrue(expected, "legal Entity mandatory field");
	
	}
}
