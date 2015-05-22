package testingGR;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class PriceTableCreation {
	WebDriver driver;

	public String createPriceTable(String browser, String productLine, String intend)
			throws InterruptedException {

		String userName = "kgautam_con";
		String password = "KGgr2015";
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Kiran\\Documents\\GR\\eclipse\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} else if (browser.equals("ie")) {
		       System.setProperty("webdriver.ie.driver", "C:\\Users\\Kiran\\Documents\\GR\\eclipse\\browserDriver\\IEDriverServer.exe");
		        driver = new InternetExplorerDriver();
		        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("http://10.92.41.174:8380/soma-webui/home/Home.action");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String title = driver.getTitle();
		if (title.equals("SOMA")) {
			driver.findElement(By.id("username")).sendKeys(userName);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("Login_0")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Assert.assertEquals("Setup Home", driver.getTitle());
		}
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By
				.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[3]/a"));
		action.moveToElement(we)
				.moveToElement(
						driver.findElement(By
								.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[3]/ul/li[1]/a")))
				.moveToElement(
						driver.findElement(By
								.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[3]/ul/li[1]/ul/li[2]/a")))
				.click().build().perform();

		driver.findElement(By.id("description")).sendKeys(
				"This is my Price Table description  " + new Random().nextInt(1000));
		driver.findElement(By.id("hostProductLineCode")).sendKeys(productLine);
		driver.findElement(By.id("intentId")).sendKeys(intend);
		driver.findElement(By.id("startDateInput")).sendKeys("05/19/2015");
		driver.findElement(By.id("endDateInput")).sendKeys("10/19/2015");
		// Searching and adding three products
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[1]/div/div/button[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[8]/form/div[2]/div[4]/div/p/a[1]/i"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[8]/form/div[2]/div[5]/div/div/div/table/tbody/tr[1]/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[8]/form/div[2]/div[5]/div/div/div/table/tbody/tr[2]/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[8]/form/div[2]/div[5]/div/div/div/table/tbody/tr[3]/td[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[8]/form/div[3]/div/div/p/a"))
				.click();
		// Creating Price Group
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[1]/div/div/button[2]"))
				.click();
		driver.findElement(By.id("newGroupName")).sendKeys("Member");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[7]/form/div[3]/button[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[1]/div/div/button[2]"))
				.click();
		driver.findElement(By.id("newGroupName")).sendKeys("Non-Member");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[7]/form/div[3]/button[1]"))
				.click();
		// First product
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[1]/td[4]/span/a[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[1]/td[2]/input"))
				.sendKeys("2.99");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[1]/td[3]/input"))
				.sendKeys("3.99");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[1]"))
				.click();
		// Second product
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[2]/td[4]/span/a[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[2]/td[2]/input"))
				.sendKeys("4.99");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[2]/td[3]/input"))
				.sendKeys("5.99");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[2]/td[4]/button[1]"))
				.click();
		// Third product
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[3]/td[4]/span/a[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[3]/td[2]/input"))
				.sendKeys("6.99");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[3]/td[3]/input"))
				.sendKeys("7.99");
		driver.findElement(
				By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr[3]/td[4]/button[1]"))
				.click();
		driver.findElement(By.id("BUTTON_validate")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String priceTableCode = driver.findElement(By.id("priceCode"))
				.getText();
		driver.close();
		driver.quit();
		return priceTableCode;
	}

}
