package testingGR;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingTableCreation extends SomaAutomation {
	WebDriver driver;

	public ShippingTableCreation(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver createShippingTable() {

		// Navigation
		driver = new BasePage(driver)
				.hover("/html/body/div[2]/div[2]/div/div/div/ul/li[3]/a",
						"/html/body/div[2]/div[2]/div/div/div/ul/li[3]/ul/li[4]/a",
						"/html/body/div[2]/div[2]/div/div/div/ul/li[3]/ul/li[4]/ul/li[2]/a");

		driver.findElement(By.id("description")).sendKeys(
				"This is my Shipping Table description  "
						+ new Random().nextInt(1000));
		driver.findElement(By.id("rateTypeID")).sendKeys("Total Amount");

		// Shipping Rate Range
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[1]/div/div/button"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[1]/input"))
				.sendKeys("100");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[2]/input"))
				.sendKeys("2.99");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[3]/input"))
				.sendKeys("4.99");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[4]/input"))
				.sendKeys("5.99");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[5]/input"))
				.sendKeys("6.99");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[6]/button[1]"))
				.click();
		driver.findElement(By.id("BUTTON_save")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("BUTTON_validate")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String shippingTableCode1 = driver.findElement(
				By.id("shippingTableCode")).getText();
		shippingTableCode = shippingTableCode1;
		return driver;
	}

}
