package testcases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseHooks;

public class SortDashboardByName  extends BaseHooks{
	@Test
	public void sortDashboardByName () throws InterruptedException {
		
		WebElement search = driver.findElement(By.xpath("//input[@class='slds-input']"));
		search.click();
		search.sendKeys("Dashboard");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		WebElement dashboardName = driver.findElement(By.xpath("//span[text()='Dashboard Name']"));
		driver.executeScript("arguments[0].click();", dashboardName);
		List<WebElement> dashName = driver.findElements(By.xpath("//table//tbody/tr/th//a"));
		System.out.println(dashName.size());
		List<String> names = new ArrayList<String>();
		for (WebElement iElement : dashName) {
			String dashNameList = iElement.getText();
			System.out.println(dashNameList);
			names.add(dashNameList);

		}

		Collections.sort(names);
		System.out.println(names);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@title='Dashboard Name']")).click();
		List<WebElement> sortedDashName = driver.findElements(By.xpath("//table//tbody/tr/th//a"));
		System.out.println(sortedDashName.size());
		List<String> namesAfterSorted = new ArrayList<String>();
		for (WebElement iElement : sortedDashName) {

			namesAfterSorted.add(iElement.getText());
		}

		System.out.println(namesAfterSorted);
		Assert.assertEquals(dashName.size(), sortedDashName.size(), "list is not equal");

	}

}
