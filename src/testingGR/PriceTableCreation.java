package testingGR;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PriceTableCreation extends SomaAutomation {
	WebDriver driver;

	public PriceTableCreation(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver createPriceTable(String productLine, String intend) throws InterruptedException {
		this.driver = new BasePage(driver).hover("/html/body/div[1]/div[2]/div/div/div/ul/li[3]/a",
				"/html/body/div[1]/div[2]/div/div/div/ul/li[3]/ul/li[1]/a",
				"/html/body/div[1]/div[2]/div/div/div/ul/li[3]/ul/li[1]/ul/li[2]/a");

		driver.findElement(By.id("description"))
				.sendKeys("This is my Price Table description  " + new Random().nextInt(1000));
		driver.findElement(By.id("hostProductLineCode")).sendKeys(productLine);
		driver.findElement(By.id("intentId")).sendKeys(intend);
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

		// Searching and adding three products
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[1]/div/div/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/section/div[9]/form/div[2]/div[5]/div/p/a[1]/i")).click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[9]/form/div[2]/div[6]/div/div/div/table/tbody/tr[1]/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[9]/form/div[2]/div[6]/div/div/div/table/tbody/tr[2]/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[9]/form/div[2]/div[6]/div/div/div/table/tbody/tr[3]/td[1]"))
				.click();
		driver.findElement(By.xpath("/html/body/div[3]/section/div[9]/form/div[3]/div/div/p/a")).click();
		// Creating Price Group
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[1]/div/div/button[2]")).click();
		driver.findElement(By.id("newGroupName")).sendKeys("Member");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[8]/form/div[3]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[1]/div/div/button[2]")).click();
		driver.findElement(By.id("newGroupName")).sendKeys("Non-Member");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[8]/form/div[3]/button[1]")).click();
		// First product
		driver.findElement(By.cssSelector("html.k-ff.k-ff40 body.priceTablePage div.container section#content div#priceTable div#priceTableGrid.dataTable table.table tbody tr td span.viewing.controls a.edit"))
				.click();
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[1]/td[2]/input"))
				.sendKeys("2.99");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[1]/td[3]/input"))
				.sendKeys("3.99");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[1]/td[4]/button[1]"))
				.click();
		// Second product
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[2]/td[4]/span/a[1]"))
				.click();
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[2]/td[2]/input"))
				.sendKeys("4.99");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[2]/td[3]/input"))
				.sendKeys("5.99");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[2]/td[4]/button[1]"))
				.click();
		// Third product
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[3]/td[4]/span/a[1]"))
				.click();
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[3]/td[2]/input"))
				.sendKeys("6.99");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[3]/td[3]/input"))
				.sendKeys("7.99");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div[2]/table/tbody/tr[3]/td[4]/button[1]"))
				.click();
		/*
		 * driver.findElement(By.id("BUTTON_save")).click();
		 * driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 */
		driver.findElement(By.id("BUTTON_validate")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String priceCode1 = driver.findElement(By.id("priceCode")).getText();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		priceTableCode = priceCode1;
		// driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a/div/img")).click();
		return driver;
	}
}
