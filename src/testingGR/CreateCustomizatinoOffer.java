package testingGR;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateCustomizatinoOffer {
	WebDriver driver;

	public CreateCustomizatinoOffer(WebDriver driver) {
		this.driver = driver;
	}

	public String customizationOffer(String productline, String priceTableCode, String shippingTableCode,
			String coCode) {
		// Navigation
		driver = new BasePage(driver).hover("/html/body/div[2]/div[2]/div/div/div/ul/li[4]/a",
				"/html/body/div[2]/div[2]/div/div/div/ul/li[4]/ul/li[3]/a",
				"/html/body/div[2]/div[2]/div/div/div/ul/li[4]/ul/li[3]/ul/li[2]/a");
		driver.findElement(By.id("offerCustomCode")).sendKeys("");
		driver.findElement(By.id("offerDescription"))
				.sendKeys("This is my Kit Customization description  " + new Random().nextInt(1000));
		driver.findElement(By.id("hostProductLineCode")).sendKeys(productline);
		driver.findElement(By.id("offerCustomCode")).sendKeys(coCode);
		// selecting priceTable

		driver.findElement(By.xpath("/html/body/div[3]/section/form/div/div[3]/div[2]/div[1]/div/div/button")).click();
		driver.findElement(By.cssSelector(
				("html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#addPriceTableModal.modal.hide.fade.noData.in form#addPriceTableForm.form-horizontal div.modal-body div.form-horizontal.row-fluid div.span12 div.control-group div.controls input.input-small.priceTableCodeInput")))
				.sendKeys(priceTableCode);
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#addPriceTableModal.modal.hide.fade.noData.in form#addPriceTableForm.form-horizontal div.modal-body div.row-fluid div.span12.form-controls.text-right p button.btn.btn-primary"))
				.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#addPriceTableModal.modal.hide.fade.in.dirty form#addPriceTableForm.form-horizontal div.modal-body div.searchResults div.row-fluid div.span12 div#priceTableSearchResults.dataTable table.table tbody tr td a"))
				.click();
		// StratDate EndDate
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

		// ShippingTable
		driver.findElement(By.id("addShippingTableButton")).click();
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#addShippingTableModal.modal.hide.fade.noData.in form#addShippingTableForm.form-horizontal div.modal-body div.form-horizontal.row-fluid div.span6 div.control-group div.controls input.input-small.shippingTableCodeInput"))
				.sendKeys(shippingTableCode);
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#addShippingTableModal.modal.hide.fade.noData.in form#addShippingTableForm.form-horizontal div.modal-body div.form-horizontal.row-fluid div.span6 div.control-group div.controls select.form-control.shippingTableBasisInput"))
				.sendKeys("Total");

		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#addShippingTableModal.modal.hide.fade.noData.in form#addShippingTableForm.form-horizontal div.modal-body div.row-fluid div.span12.form-controls.text-right p button.btn.btn-primary"))
				.click();
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#addShippingTableModal.modal.hide.fade.in.dirty form#addShippingTableForm.form-horizontal div.modal-body div.searchResults div.row-fluid div.span12 div#shippingTableSearchResults.dataTable table.table tbody tr td"))
				.click();
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#addShippingTableModal.modal.hide.fade.in.dirty form#addShippingTableForm.form-horizontal div.modal-footer div.row-fluid div.span12 p a.btn.btn-primary.addShippingTableButton"))
				.click();

		// Selecting Default Shipping interval
		Random random = new Random();
		int x = random.nextInt(4 - 1 + 1) + 1;
		if (x == 1) {
			Select dropdown = new Select(driver.findElement(By.id("shippingInterval")));
			dropdown.selectByIndex(1);
			
		} else if (x == 2) {
			Select dropdown = new Select(driver.findElement(By.id("shippingInterval")));
			dropdown.selectByIndex(2);

		} else if (x == 3){
			Select dropdown = new Select(driver.findElement(By.id("shippingInterval")));
			dropdown.selectByIndex(3);

		}
		else
		{
			Select dropdown = new Select(driver.findElement(By.id("shippingInterval")));
			dropdown.selectByIndex(4);
		}
		
		// Adding Products
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#productPane.tab-pane.active div.row-fluid div.span12 div.btn-group.pull-right button.btn.promptAddItemsButton"))
				.click();
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#addItemModal.modal.hide.fade.noData.in form#addItemsForm.form-horizontal div.modal-body div.row-fluid div.span12.form-controls p button.btn.btn-primary"))
				.click();
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div.tab-content div#addItemModal.modal.hide.fade.in.dirty form#addItemsForm.form-horizontal div.modal-footer div.row-fluid div.span6.text-left a.btn.btn-primary.selectAllItemsButton"))
				.click();

		// Rules
		driver.findElement(By.cssSelector(
				"html.k-ff.k-ff40 body.customizationOfferPage div.container section#content div#Offers ul#offerTabs.nav.nav-tabs li#fpTab a"))
				.click();
		driver.findElement(By.id("pricingRule")).sendKeys("Fl");
		driver.findElement(By.id("maxSelect")).sendKeys("5");
		driver.findElement(By.id("ruleValue")).sendKeys("5.99");
		driver.findElement(By.id("BUTTON_validate")).click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		WebElement code = driver.findElement(By.cssSelector("html.k-ff.k-ff40 body.customizationOfferPage div.container section#content form#customizationOfferForm.form-horizontal div#basicInfocontainer div.row-fluid div.span8 div.pull-left h4 span#custOfferCode"));
		String customizationOfferCode = code.getText();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return customizationOfferCode;

	}

}
