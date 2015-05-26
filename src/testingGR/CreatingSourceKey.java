package testingGR;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatingSourceKey {
	WebDriver driver;

	public CreatingSourceKey(WebDriver driver) {
		this.driver = driver;
	}

	public String sourceKey(String productline, String pt) {

		// Navigation
		driver = new BasePage(driver)
				.hover("/html/body/div[1]/div[2]/div/div/div/ul/li[7]/a",
						"/html/body/div[1]/div[2]/div/div/div/ul/li[7]/ul/li[1]/a",
						"/html/body/div[1]/div[2]/div/div/div/ul/li[7]/ul/li[1]/ul/li[2]/a");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[1]/div/div/div[1]/table[3]/tbody/tr/td[2]/textarea"))
				.click();
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[1]/div/div/div[1]/table[3]/tbody/tr/td[2]/textarea"))
				.sendKeys(
						"This is my Source Key description  "
								+ new Random().nextInt(1000));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.id("sourceKeyProductLine")).sendKeys(productline);
		// Date
		driver.findElement(By.id("beginDateField")).click();
		driver.findElement(
				By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[4]/a"))
				.click();
		// venue
		driver.findElement(By.id("sourceKeyVenueCode")).sendKeys("53");
		driver.findElement(By.id("sourceKeyOfferType")).sendKeys("CAT");

		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[2]/div[1]/div[1]/table/tbody/tr[2]/td/span/img"))
				.click();
		driver.findElement(By.xpath("/html/body/div[12]/div[1]")).click();
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[2]/div[1]/div[2]/table/tbody/tr[2]/td/span/img"))
				.click();
		driver.findElement(By.xpath("/html/body/div[13]/div[1]")).click();

		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[2]/div[1]/div[3]/table/tbody/tr[2]/td/span/input[3]"))
				.sendKeys(pt);
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[3]/div[1]/table/tbody/tr/td[2]/input[1]"))
				.click();
		driver.findElement(By.id("SaveSourceKey_saveAndValidate")).click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		String sourceKeyCode = driver
				.findElement(
						By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[1]/div/div/div[1]/table[1]/tbody/tr/td[2]"))
				.getText();
		return sourceKeyCode;

	}

}
