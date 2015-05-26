package testingGR;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatingPromotionalTemplate extends SomaAutomation {
	WebDriver driver;

	public CreatingPromotionalTemplate(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver promotionalTemplate(String productline, String catalogCode) {

		// Navigation
		driver = new BasePage(driver).hover(
				"/html/body/div[2]/div[2]/div/div/div/ul/li[6]/a",
				"/html/body/div[2]/div[2]/div/div/div/ul/li[6]/ul/li[2]/a");

		// Description
		driver.findElement(By.id("SaveScript_bean_description")).sendKeys(
				"This is my PT description  " + new Random().nextInt(1000));
		// StratDate
		driver.findElement(By.id("SaveScript_bean_beginDate")).click();
		driver.findElement(
				By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[4]/a"))
				.click();

		// productline
		driver.findElement(By.id("SaveScript_script_productLineCode"))
				.sendKeys(productline);
		// search catalog
		driver.findElement(By.id("firstCatalogCodeFilter")).sendKeys(
				catalogCode);
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[2]/div/table/tbody/tr[4]/td/div[1]/table/tbody/tr/td[2]/img"))
				.click();
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[2]/div/table/tbody/tr[4]/td/div[2]/div/table/tbody/tr/td/div/ul/li/img"))
				.click();
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[2]/div/table/tbody/tr[6]/td[1]/table/tbody/tr[2]/td/div[4]/input"))
				.click();
		driver.findElement(By.id("SaveScript_script_clientCode")).sendKeys(
				"046");
		driver.findElement(By.id("SaveScript_script_companyCode")).sendKeys(
				"001");
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[2]/div/table/tbody/tr[10]/td/table/tbody/tr[2]/td/span/table/tbody/tr[2]/td"))
				.click();
		// Help Description. Its all filled with Java scripts so had to do in
		// this way.
		WaitTool.waitForElementPresent(driver,
				By.id("SaveScript_script_helpScreen_ifr"), 10);
		WebElement iframe = driver.findElement(By
				.id("SaveScript_script_helpScreen_ifr"));
		driver.switchTo().frame(iframe);

		WebElement description = driver.findElement(By.cssSelector("body"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerHTML = '<h1>Help Me </h1>'",
				description);
		driver.switchTo().defaultContent();

		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[3]/div[2]/input"))
				.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ptCode = driver.findElement(By.id("SaveScript_code")).getText();
		return driver;
	}
}
