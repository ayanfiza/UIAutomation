package testingGR;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class CreatingPromotionalTemplate {
	WebDriver driver;

	public String promotionalTemplate(String browser, String productline,
			String catalogCode) {
		String userName = "kgautam_con";
		String password = "KGgr2015";
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Kiran\\Documents\\GR\\eclipse\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} else if (browser.equals("ie")) {
			File file = new File(
					"C:\\Users\\Kiran\\Documents\\GR\\eclipse\\browserDriver\\IEDriverServer32.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("http://10.92.41.174:8380/soma-webui/home/Home.action");
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
				.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[6]/a"));
		action.moveToElement(we)
				.moveToElement(
						driver.findElement(By
								.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[6]/ul/li[2]/a")))
				.click().build().perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

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
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String ptCode = driver.findElement(By.id("SaveScript_code")).getText();
		driver.close();
		driver.quit();
		return ptCode;
	}
}
