package automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestExecution {
	
	Driver driver;
	GoogleElements google;
	FocusHomeElements focusHome;
	FocusLocationsElements focusLocations;

	@BeforeClass
	public void beforeClass() {
		driver = new Driver();
		google = new GoogleElements();
		focusHome = new FocusHomeElements();
		focusLocations = new FocusLocationsElements();
	}

	@Test (priority = 1)
	public void openBrowserToGoogleStartPage() {
		driver.setUpDriver();
	}
	
	@Test (priority = 2)
	public void searchFocusServices() {
		google.setUpGoogleElements();
		driver.sendText(google.googleSearchBar, "Focus Services");
		driver.waitFor(google.btnSearchWithGoogle);
		driver.click(google.btnSearchWithGoogle);
	}
	
	@Test (priority = 3)
	public void verifyIfFocusURLExistsInSearch() throws MalformedURLException {
		driver.waitFor(google.numOfResults);
		List<WebElement> links = driver.saveReturnedLinks(google.returnedLinks);
		String focusURL = "https://www.focusservices.com/", url = "";
		int index = 0;
		Iterator<WebElement> iterator = links.iterator();
		while(iterator.hasNext()) {
			url = iterator.next().getAttribute("href");
			if(url != null) {
				if(url.equals(focusURL)) {
					break;
				}
			}
			index++;
		}
		Assert.assertEquals(links.get(index).getAttribute("href"), focusURL);
		links.get(index).click();
	}
	
	@Test (priority = 4)
	public void verifyIfNowHiringButtonxists() {
		focusHome.setUpFocusElements();
		driver.waitFor(focusHome.btnNowHiring);
		driver.scrollToAnElement(focusHome.btnNowHiring);
		driver.markElement(focusHome.qsNowHiring);
	}
	
	@Test (priority = 5)
	public void clickOnLocationsTab() {
		driver.waitFor(focusHome.locationsTab);
		driver.markElement(focusHome.qsLocationsTab);
		driver.click(focusHome.locationsTab);
	}
	
	@Test (priority = 6)
	public void assertNorthAmericaLink() {
		String expectedURL = "https://www.focusservices.com/locations/#north-america";
		focusLocations.setUpFocusLocationsElements();
		driver.scrollToAnElement(focusLocations.northAmerica);
		driver.validateLink(focusLocations.northAmerica, expectedURL);
	}
	
	@Test (priority = 7)
	public void validateCentralAmericaLocation() {
		String expectedText = "El Salvador & Nicaragua";
		driver.click(focusLocations.centralAmerica);
		driver.waitFor(focusLocations.caTitle);
		driver.validateText(focusLocations.caTitle, expectedText);
	}
	
	@Test (priority = 8)
	public void validateAsiaLocation() {
		String expectedText = "Bacolod City, Philippines";
		driver.click(focusLocations.asia);
		driver.waitFor(focusLocations.asiaTextBlock);
		driver.validateText(focusLocations.asiaTextBlock, expectedText);
	}

	@AfterClass
	public void afterClass() {
		driver.closeBrowser();
	}

}
