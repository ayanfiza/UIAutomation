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

public class CreatingSourceKey {
	WebDriver driver;
	public String sourceKey(String browser, String productline,
			String pt){
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
		       System.setProperty("webdriver.ie.driver", file.getAbsolutePath() );  
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
				.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[7]/a"));
		action.moveToElement(we)
				.moveToElement(
						driver.findElement(By
								.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[7]/ul/li[1]/a")))
				.moveToElement(
						driver.findElement(By
								.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[7]/ul/li[1]/ul/li[2]/a")))
				.click().build().perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[1]/div/div/div[1]/table[3]/tbody/tr/td[2]/textarea")).sendKeys(
				"This is my Source Key description  " + new Random().nextInt(1000));
		driver.findElement(By.id("sourceKeyProductLine")).sendKeys(productline);
		//Date
		
		
		//venue
		driver.findElement(By.id("beginDateField")).click();
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[4]/a")).click();
		
		driver.findElement(
				By.id("sourceKeyVenueCode"))
				.sendKeys("53");
		driver.findElement(
				By.id("sourceKeyOfferType"))
				.sendKeys("CAT");
		
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[2]/div[1]/div[1]/table/tbody/tr[2]/td/span/img"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[12]/div[1]"))
				.click();
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[2]/div[1]/div[2]/table/tbody/tr[2]/td/span/img"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[13]/div[1]"))
				.click();
		
		
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[2]/div[1]/div[3]/table/tbody/tr[2]/td/span/input[3]"))
				.sendKeys(pt);
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[3]/div[1]/table/tbody/tr/td[2]/input[1]"))
				.click();
		driver.findElement(
				By.id("SaveSourceKey_saveAndValidate"))
				.click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		String sourceKeyCode = driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td/div/form/div[1]/div/div/div[1]/table[1]/tbody/tr/td[2]")).getText();
		return sourceKeyCode;

		
	}

}
