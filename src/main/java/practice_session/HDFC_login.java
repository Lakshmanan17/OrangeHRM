package practice_session;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
@Test
public class HDFC_login {
	public static void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       
        driver.get("https://www.hdfcbank.com/");
        String parentwindow= driver.getWindowHandle();
     WebElement click= driver.findElement(By.xpath("//button[text()='Login' and @class='btn btn-primary btnLogin jsOpenmenu active']"));
     Actions action =new Actions(driver);
     action.moveToElement(click).perform();
        
      driver.findElement(By.xpath("//a[text()='NetBanking']")).click();
     Set<String>allwindows= driver.getWindowHandles();
      for(String handle:allwindows) {
    	  if(!handle.equals(parentwindow)) {
    		  driver.switchTo().window(handle);
    		  
    	  }
      }
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement knowMoreLink = wait.until(ExpectedConditions.elementToBeClickable(
          By.xpath("//a[contains(text(),'Know More')]")
      ));
      knowMoreLink.click();


      String Secondwindow= driver.getWindowHandle();
      Set<String>windowAfterclick= driver.getWindowHandles();
      for(String handle:windowAfterclick) {
    	  if(!handle.equals(parentwindow)&&!!handle.equals(Secondwindow)) {
    		  driver.switchTo().window(handle);
    		  
    	  }
      }
      
      List<WebElement> languages=driver.findElements(By.xpath("//div[@id=\"main\"]/div[2]/div[13]/div/div/div/div/div/div/div/div[2]/div[4]/div[3]/div/div/div/div/p/a"));
	for(WebElement lang:languages) {   
		System.out.println(lang.getText());
	}
	}

}
