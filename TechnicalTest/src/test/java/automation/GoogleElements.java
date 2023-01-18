package automation;


import org.openqa.selenium.By;

public class GoogleElements {

	protected By googleSearchBar, btnSearchWithGoogle, numOfResults, returnedLinks;
	
	public void setUpGoogleElements() {
		googleSearchBar = By.name("q");
		btnSearchWithGoogle = By.name("btnK");
		numOfResults = By.xpath("//*[@id=\"result-stats\"]");
		returnedLinks = By.tagName("a");
	}

}
