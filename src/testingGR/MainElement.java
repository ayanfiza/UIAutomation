package testingGR;

import org.openqa.selenium.WebDriver;

public class MainElement {
	static SomaLogin login = new SomaLogin();
	static CreatingPriceTable price = new CreatingPriceTable();
	
	public static void main(String[] args) {
		login.openBrowser("firefox");
		price.priceTable();

	}

}
