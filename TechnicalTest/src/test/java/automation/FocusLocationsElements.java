package automation;

import org.openqa.selenium.By;

public class FocusLocationsElements {

	protected By northAmerica, centralAmerica, asia, caTitle, asiaTextBlock;
	
	public void setUpFocusLocationsElements() {
		northAmerica= By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[1]");
		centralAmerica = By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[2]");
		asia = By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[3]");
		caTitle = By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[2]/div[2]/div/div/section/div/h2");
		asiaTextBlock = By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[2]/div[3]/div/div/div[2]/section/div/h3");
	}
}
