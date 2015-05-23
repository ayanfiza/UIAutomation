package testingGR;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver login(String browser) {
		String userName = "kgautam_con";
		String password = "KGgr2015";

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Kiran\\Documents\\GR\\eclipse\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} else if (browser.equals("ie")) {
			File file = new File(
					"C:\\Users\\Kiran\\Documents\\GR\\eclipse\\browserDriver\\IEDriverServer.exe");
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

		return driver;
	}

	public WebDriver hover(String path1, String path2, String path3) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(path1));
		action.moveToElement(we)
				.moveToElement(driver.findElement(By.xpath(path2)))
				.moveToElement(driver.findElement(By.xpath(path3))).click()
				.build().perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver hover(String path1, String path2) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(path1));
		action.moveToElement(we)
				.moveToElement(driver.findElement(By.xpath(path2))).click()
				.build().perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver;
	}

}
