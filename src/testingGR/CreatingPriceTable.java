package testingGR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CreatingPriceTable {
	WebDriver driver;
	
	public void priceTable() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[3]/a"));
		action.moveToElement(we)
		.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[3]/ul/li[1]/a")))
		.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[3]/ul/li[1]/ul/li[2]/a")))
		.click().build().perform();
	}
}
