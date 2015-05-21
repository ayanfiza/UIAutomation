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

public class CreateCatalog {
	WebDriver driver;
	public String catalog(String browser, String productline,
			String priceTableCode, String shippingTableCode){
		
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
		
		//Navigation
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By
				.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[5]/a"));
		action.moveToElement(we)
				.moveToElement(
						driver.findElement(By
								.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[5]/ul/li[3]/a")))
				.moveToElement(
						driver.findElement(By
								.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[5]/ul/li[3]/ul/li[2]/a")))
				.click().build().perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		
		driver.findElement(By.id("catalogDescription")).sendKeys(
				"This is my catalog description  " + new Random().nextInt(101));
		driver.findElement(By.id("hostProductLineCode")).sendKeys(productline);
		
		//selecting priceTable
		
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[1]/div[2]/div[2]/div[1]/div/div/button"))
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
		// StratDate EndDate
		driver.findElement(By.id("startDateInput")).sendKeys("05/19/2015");
		driver.findElement(By.id("endDateInput")).sendKeys("10/19/2015");
		
		//ShippingTable
		driver.findElement(By.xpath("/html/body/div[3]/section/form/div[1]/div[2]/div[2]/div[2]/div/div/button"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div[3]/section/form/div[3]/div[4]/form/div[2]/div[1]/div[1]/div/div/input"))
				.sendKeys(shippingTableCode);
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
		driver.findElement(By.xpath("/html/body/div[3]/section/form/div[3]/div[1]/div[1]/div[2]/div/button")).click();
		
		driver.findElement(By.xpath("/html/body/div[3]/section/form/div[3]/div[2]/form/div[2]/div[4]/div/p/button")).click();
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

		//Validating
		driver.findElement(By.id("BUTTON_validate")).click();
		String catalogCode = driver.findElement(
				By.id("catalogCode")).getText();
		return catalogCode;

		
		
		
	}

}
