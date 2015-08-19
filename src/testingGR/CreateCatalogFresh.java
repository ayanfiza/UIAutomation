package testingGR;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCatalogFresh extends SomaAutomation {
	WebDriver driver;

	public CreateCatalogFresh (WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver catalog(String productline, String priceTableCode,
			String shippingTableCode) {

		// Navigation
		driver = new BasePage(driver)
				.hover("/html/body/div[1]/div[2]/div/div/div/ul/li[5]/a",
						"/html/body/div[1]/div[2]/div/div/div/ul/li[5]/ul/li[3]/a",
						"/html/body/div[1]/div[2]/div/div/div/ul/li[5]/ul/li[3]/ul/li[2]/a");

		driver.findElement(By.id("catalogDescription"))
				.sendKeys(
						"This is my catalog description  "
								+ new Random().nextInt(1000));
		driver.findElement(By.id("hostProductLineCode")).sendKeys(productline);

		// selecting priceTable

		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[1]/div[3]/div[2]/div[1]/div/div/button"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[3]/form/div[2]/div[2]/div/div/div/input"))
				.sendKeys(priceTableCode);
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[3]/form/div[2]/div[3]/div/p/button"))
				.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[3]/form/div[2]/div[4]/div/div/div/table/tbody/tr/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[3]/form/div[3]/div/div/p/a"))
				.click();

				// Start and End Date
						String startDate = new SimpleDateFormat("MMddyyyy").format(new Date());
						Calendar cal = Calendar.getInstance();
						cal.add(Calendar.MONDAY, 1);
						SimpleDateFormat format1 = new SimpleDateFormat("MMddyyyy");
						String endDate = format1.format(cal.getTime());
						driver.findElement(By.id("startDateInput")).click();
						driver.findElement(By.id("startDateInput")).sendKeys(startDate);
						driver.findElement(By.id("endDateInput")).click();
						driver.findElement(By.id("endDateInput")).sendKeys(endDate);
						
		driver.findElement(By.id("catalogDescription")).click();
		// ShippingTable
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[1]/div[3]/div[2]/div[2]/div/div/button"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[4]/form/div[2]/div[1]/div[1]/div/div/input"))
				.sendKeys(shippingTableCode);
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[4]/form/div[2]/div[1]/div[2]/div/div/select"))
				.sendKeys("Total");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[4]/form/div[2]/div[2]/div/p/button"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[4]/form/div[2]/div[3]/div/div/div/table/tbody/tr/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[4]/form/div[3]/div/div/p/a"))
				.click();

		// Adding Products
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[1]/div[1]/div[2]/div/button"))
				.click();

		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[2]/form/div[2]/div[4]/div/p/button"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[2]/form/div[2]/div[5]/div/div/div/table/tbody/tr[1]/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[2]/form/div[2]/div[5]/div/div/div/table/tbody/tr[2]/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[2]/form/div[2]/div[5]/div/div/div/table/tbody/tr[3]/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[2]/form/div[3]/div/div/p/a"))
				.click();

		// Validating
		driver.findElement(By.id("BUTTON_validate")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String catalogCode1 = driver
				.findElement(
						By.id("catalogCode"))
				.getText();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		catalogCode = catalogCode1;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;

	}

}
