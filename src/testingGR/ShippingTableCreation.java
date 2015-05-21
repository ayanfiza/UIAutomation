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

public class ShippingTableCreation {
	WebDriver driver;
	public String createShippingTable(String browser) {
		String userName = "kgautam_con";
		String password = "KGgr2015";
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Kiran\\Documents\\GR\\eclipse\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} else if (browser.equals("ie")) {
			File file = new File("C:\\Users\\Kiran\\Documents\\GR\\eclipse\\browserDriver\\IEDriverServer.exe");
		       System.setProperty("webdriver.ie.driver", file.getAbsolutePath() );  
		        driver = new InternetExplorerDriver();
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
								.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[3]/ul/li[4]/a")))
				.moveToElement(
						driver.findElement(By
								.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[3]/ul/li[4]/ul/li[2]/a")))
				.click().build().perform();
		driver.findElement(By.id("description")).sendKeys(
				"This is my Shipping Table description  " + new Random().nextInt(101));
		driver.findElement(By.id("rateTypeID")).sendKeys("Total Amount");
		//Shipping Rate Range
		driver.findElement(By.xpath("/html/body/div[3]/section/div[2]/div[1]/div/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[1]/input")).sendKeys("100");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[2]/input")).sendKeys("2.99");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[3]/input")).sendKeys("4.99");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[4]/input")).sendKeys("5.99");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[5]/input")).sendKeys("6.99");
		driver.findElement(By.xpath("/html/body/div[3]/section/div[2]/div[2]/table/tbody/tr/td[6]/button[1]")).click();
		driver.findElement(By.id("BUTTON_save")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("BUTTON_validate")).click();
		String shippingTableCode = driver.findElement(By.id("shippingTableCode"))
				.getText();
		driver.close();
		driver.quit();
		return shippingTableCode;
	}

}
