package testingGR;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingTableCreation extends SomaAutomation {
	WebDriver driver;

	public ShippingTableCreation(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver createShippingTable(String intend) {

		// Navigation
		driver = new BasePage(driver).hover("/html/body/div[2]/div[2]/div/div/div/ul/li[3]/a",
				"/html/body/div[2]/div[2]/div/div/div/ul/li[3]/ul/li[4]/a",
				"/html/body/div[2]/div[2]/div/div/div/ul/li[3]/ul/li[4]/ul/li[2]/a");

		driver.findElement(By.id("description"))
				.sendKeys("This is my Shipping Table description  " + new Random().nextInt(1000));
		driver.findElement(By.id("rateTypeID")).sendKeys("Total Amount");
		driver.findElement(By.id("intentId")).sendKeys(intend);

		// Date Range
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
//Random
		Random rand = new Random();
		int rando = rand.nextInt((1000 - 100) + 1) + 10;
		String random = Integer.toString(rando);
		int randomNum1 = rand.nextInt((100 - 10) + 1) + 10;
		String n1 = Integer.toString(randomNum1);
		int randomNum2 = rand.nextInt((100 - 10) + 1) + 10;
		String n2 = Integer.toString(randomNum1);
		int randomNum3 = rand.nextInt((100 - 10) + 1) + 10;
		String n3 = Integer.toString(randomNum1);
		int randomNum4 = rand.nextInt((100 - 10) + 1) + 10;
		String n4 = Integer.toString(randomNum1);

		// Shipping Rate Range
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.shippingTablePage div.container section#content div#shippingTable div.row-fluid div.span12 div.btn-group.pull-right button.btn.addShippingEntryButton"))
				.click();
		driver.findElement(By.id("rate-basisQuantity-0")).sendKeys(random);
		driver.findElement(By.id("rate-standardRate-0")).sendKeys(n2);
		driver.findElement(By.id("rate-rushRate-0")).sendKeys(n3);
		driver.findElement(By.id("rate-toDayRate-0")).sendKeys(n4);
		driver.findElement(By.id("rate-sameDateRate-0")).sendKeys(n1);
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.shippingTablePage div.container section#content div#shippingTable div#shippingTableGrid.dataTable table.table tbody tr.edit td button.btn.finishEdit"))
				.click();
		driver.findElement(By.id("BUTTON_save")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("BUTTON_validate")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String shippingTableCode1 = driver.findElement(By.id("shippingTableCode")).getText();
		shippingTableCode = shippingTableCode1;
		return driver;
	}

}
