package testingGR;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateCustomizatinoOfferFresh {
	WebDriver driver;

	public CreateCustomizatinoOfferFresh (WebDriver driver) {
		this.driver = driver;
	}

	public String customizationOffer(String productline, String priceTableCode,
			String shippingTableCode) {

		driver = new BasePage(driver)
				.hover("/html/body/div[1]/div[2]/div/div/div/ul/li[4]/a",
						"/html/body/div[1]/div[2]/div/div/div/ul/li[4]/ul/li[3]/a",
						"/html/body/div[1]/div[2]/div/div/div/ul/li[4]/ul/li[3]/ul/li[2]/a");

		driver.findElement(By.id("offerDescription")).sendKeys(
				"This is my Kit Customization description  "
						+ new Random().nextInt(1000));
		driver.findElement(By.id("hostProductLineCode")).sendKeys(productline);
		// selecting priceTable

		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[1]/div[3]/div[2]/div[1]/div/div/button"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[4]/form/div[2]/div[2]/div/div/div/input"))
				.sendKeys(priceTableCode);
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[4]/form/div[2]/div[3]/div/p/button"))
				.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[4]/form/div[2]/div[4]/div/div/div/table/tbody/tr/td[3]/a[1]"))
				.click();
		// StratDate EndDate
		driver.findElement(By.id("startDateInput")).sendKeys("05/19/2015");
		driver.findElement(By.id("endDateInput")).sendKeys("10/19/2015");
		// ShippingTable
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[1]/div[3]/div[2]/div[2]/div/div/button"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[5]/form/div[2]/div[1]/div[1]/div/div/input"))
				.sendKeys(shippingTableCode);
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[5]/form/div[2]/div[2]/div/p/button"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[5]/form/div[2]/div[3]/div/div/div/table/tbody/tr/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[5]/form/div[3]/div/div/p/a"))
				.click();

		// Adding Products
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[1]/div[1]/div/div/button[2]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[3]/form/div[2]/div[4]/div/p/button"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[3]/form/div[3]/div/div[1]/a"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[3]/form/div[3]/div/div[2]/p/a"))
				.click();

		// Updating product info
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[1]/div[2]/table/tbody/tr[1]/td[5]/select"))
				.sendKeys("Base");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[1]/div[2]/table/tbody/tr[2]/td[5]/select"))
				.sendKeys("Mandtory");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[1]/div[2]/table/tbody/tr[1]/td[4]/input[1]"))
				.sendKeys("2");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[1]/div[2]/table/tbody/tr[2]/td[4]/input[3]"))
				.sendKeys("5");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[1]/div[2]/table/tbody/tr[3]/td[4]/input[3]"))
				.sendKeys("6");

		// Rules
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[2]/ul/li[2]/a"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[2]/div/div[1]/div[1]/div/select"))
				.sendKeys("Fl");
		driver.findElement(By.id("maxSelect")).sendKeys("5");
		driver.findElement(By.id("ruleValue")).sendKeys("5.99");
		driver.findElement(By.id("BUTTON_validate")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		 WebElement code = driver
				.findElement(
						By.id("custOfferCode"));	 
		 String customizationOfferCode = code.getText();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return customizationOfferCode;

	}

}
