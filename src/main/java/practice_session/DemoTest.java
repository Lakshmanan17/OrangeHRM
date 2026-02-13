package practice_session;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {
	@Test
	public void searchtable() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement firefoxNetwork = driver.findElement(By.xpath("//table[@id='taskTable']//tr[td[normalize-space()='Firefox']] /td[position() = count(//table[@id='taskTable']//th[normalize-space()='Network (Mbps)']/preceding-sibling::th) + 1 ]"
			));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firefoxNetwork);
		
			System.out.println("Firefox Network Value: " + firefoxNetwork.getText());

	}

}
