package practice_session;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class sene_demo {
	@Test
	public static void sene() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.senegence.com/");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20)); 
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@class='menu__item grandparent kids-6 appco_bg']//following-sibling:: span[text()='Makeup']"))));
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		
		
	}

}
