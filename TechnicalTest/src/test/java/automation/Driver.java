package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	WebDriver driver;
	private String url = "http://www.google.com/";
	protected List<WebElement> links;

	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void sendText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void waitFor(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(50));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public List<WebElement> saveReturnedLinks(By locator) {
		return driver.findElements(locator);
	}
	
	public void scrollToAnElement(By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
	}
	
	public void validateLink(By locator, String expectedURL) {
		try {
			WebElement link = driver.findElement(locator);
			Assert.assertEquals(link.getAttribute("href"), expectedURL);
		}catch(AssertionError error) {
			System.err.println("\nException on validateLink: "+ error);
		}
	}
	
	public void validateText(By locator, String expectedText) {
		try {
			WebElement actualText = driver.findElement(locator);
			Assert.assertEquals(actualText.getAttribute("innerText"), expectedText);
		}catch(AssertionError error) {
			System.err.println("\nException on validateText: "+ error);
		}
	}

	public void markElement(String querySelector) {
		((JavascriptExecutor) driver).executeScript(querySelector + ".style.border='3px solid red'");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
}
