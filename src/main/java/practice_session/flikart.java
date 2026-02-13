package practice_session;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class flikart {
	@Test
	public static void flikat() throws InterruptedException {
        WebDriver driver;

        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open flipkart
        driver.get("https://www.flipkart.com/"); 
       WebElement search= driver.findElement(By.xpath("//div[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input"));
       search.sendKeys("laptop");
       WebElement click= driver.findElement(By.xpath("//div[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/button"));
       click.click();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       Select minselect= new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container']/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[1]/select"))));
       minselect.selectByValue("40000"); 
       
       Select maxselect= new Select(driver.findElement(By.xpath("//div[@id='container']/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select")));
          maxselect.selectByValue("50000"); 
          
         // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         // WebElement roomGuest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container']/div/div[3]/div/div[2]/div[5]/div/div/div/a/div[2]/div[1]/div[1]")));
         //roomGuest.click();
         
         JavascriptExecutor je=(JavascriptExecutor)driver;        
         	
  		WebElement eve1=driver.findElement(By.xpath("//div[@id='container']/div/div[3]/div/div[2]/div[5]/div/div/div/a/div[2]/div[1]/div[1]"));
  		
  		je.executeScript("arguments[0].scrollIntoView(true);",eve1);
  		eve1.click();
          
}
}