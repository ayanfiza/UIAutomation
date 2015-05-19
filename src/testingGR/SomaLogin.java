package testingGR;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SomaLogin {
	WebDriver driver;
	public void openBrowser(String browser1) {

		String userName = "kgautam_con";
		String password = "KGgr2015";
		String browser = browser1;
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Kiran\\Documents\\GR\\eclipse\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("ie")) {
			driver = new InternetExplorerDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get("http://10.92.41.174:8380/soma-webui/home/Home.action");
		String title = driver.getTitle();
		if (title.equals("SOMA"))
		{
			driver.findElement(By.id("username")).sendKeys(userName);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("Login_0")).click();
			Assert.assertEquals("Setup Home", driver.getTitle());
		}
		
	}

}
