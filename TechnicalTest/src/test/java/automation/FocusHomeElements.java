package automation;

import org.openqa.selenium.By;

public class FocusHomeElements {

	protected By lblDescription, btnNowHiring, locationsTab;
	protected String qsNowHiring, qsLocationsTab;
	
	public void setUpFocusElements() {
		lblDescription = By.xpath("//*[@id=\"home_top_image\"]/div/div[2]/main/div/div/div[2]/h1");
		btnNowHiring = By.xpath("//*[@id=\"text-4\"]/div/p/a");
		locationsTab = By.xpath("//*[@id=\"menu-item-4726\"]/a/span[2]");
		qsNowHiring = "document.querySelector('#text-4 > div > p > a')";
		qsLocationsTab = "document.querySelector('#menu-item-4726 > a > span.avia-menu-text')";
	}
}
