package practice_session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class google {
	
	@Test
	public void search(){
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
	WebElement element= driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
	element.sendKeys("selenium");
	element.click();
	//driver.close();
	
}
}
