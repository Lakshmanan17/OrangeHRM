package practice_session;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FlikartLaptopSearch {

    @Test
    public void flikat() throws InterruptedException {
        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Flipkart
        driver.get("https://www.flipkart.com");

        // Close login popup if appears
        try {
            WebElement closePopup = driver.findElement(By.cssSelector("/html/body/div[4]/div/span"));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Login popup not shown.");
        }

        // Search "laptop"
        WebElement searchBox = driver.findElement(By.xpath("//div[@id='container']/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input"));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        // Wait for results to load
       //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a._1fQZEK")));

        Thread.sleep(5000);
        Select minselect= new Select(driver.findElement(By.xpath("//div[@id='container']/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[1]/select")));
        minselect.selectByValue("40000"); 
        
        Select maxselect= new Select(driver.findElement(By.xpath("//div[@id='container']/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select")));
           maxselect.selectByValue("50000"); 
        
        
        // Get list of laptops
        List<WebElement> laptops = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));

        if (laptops.size() >= 4) {
        	// Click on the 4th laptop (index 3)
            String parentWindow = driver.getWindowHandle();
            try {
                // Re-locate the 4th laptop just before click
                WebElement fourthLaptop = driver.findElements(By.xpath("//div[@class='KzDlHZ']")).get(3);
                fourthLaptop.click();
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element error, trying again...");
                WebElement fourthLaptop = driver.findElements(By.xpath("//div[@class='KzDlHZ']")).get(3);
                fourthLaptop.click();
            }

            // Switch to new tab/window
            Set<String> allWindows = driver.getWindowHandles();
            for (String win : allWindows) {
                if (!win.equals(parentWindow)) {
                    driver.switchTo().window(win);
                    break;
                }
            }
            Thread.sleep(3000); // Optional: use WebDriverWait

            // Get and print laptop name and price
            try {
                WebElement nameElement = driver.findElement(By.cssSelector("#container > div > div._39kFie.N3De93.JxFEK3._48O0EI > div.DOjaWF.YJG4Cf > div.DOjaWF.gdgoEp.col-8-12 > div:nth-child(3) > div > div:nth-child(1) > h1 > span"));
                WebElement priceElement = driver.findElement(By.cssSelector("#container > div > div._39kFie.N3De93.JxFEK3._48O0EI > div.DOjaWF.YJG4Cf > div.DOjaWF.gdgoEp.col-8-12 > div:nth-child(3) > div > div.x\\+7QT1 > div.UOCQB1 > div > div.Nx9bqj.CxhGGd.yKS4la"));

                System.out.println("Laptop Name: " + nameElement.getText());
                System.out.println("Price: " + priceElement.getText());
            } catch (Exception e) {
                System.out.println("Failed to fetch laptop details.");
            }

        } else {
            System.out.println("Less than 4 laptops found.");
        }

        // Close browser
       // driver.quit();
    }
}
