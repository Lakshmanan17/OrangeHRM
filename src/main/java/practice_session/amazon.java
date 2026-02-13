package practice_session;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class amazon {

    @Test
    public void amazon_1() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//button[@class='a-button-text']")).click();
        // ---------------------------
        // 1. Store parent window
        // ---------------------------
        String parentWindow = driver.getWindowHandle();

        // Click the image
       // List<WebElement> imgs = driver.findElements(By.xpath("//img[contains(@alt,'Cushion covers, bedsheets & more')]"));
      //  if (imgs.size() > 0) {
       //     imgs.get(0).click();
      //  } else {
       //     System.out.println("SOFTSPUN image not found!");
           // driver.quit();
       //     return;
       // }

        // ---------------------------
        // 2. Switch to newly opened window
        // ---------------------------
        Set<String> allWindows = driver.getWindowHandles();

        for (String win : allWindows) {
            if (win.equals(parentWindow)) {
                driver.switchTo().window(win);
                
            }
        }

        // ---------------------------
        // 3. Wait for product page button (if exists)
        // ---------------------------
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      //  try {
       //     WebElement continueBtn = wait.until(
        //            ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue shopping']"))
        //    );
        //    continueBtn.click();
       // } catch (Exception e) {
       //     System.out.println("Continue shopping button not found!");
       // }

        // ---------------------------
        // 4. Switch back to parent window
        // ---------------------------
        driver.switchTo().window(parentWindow);

        // ---------------------------
        // 5. Handle dropdown without Select class
        // ---------------------------
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        dropdown.click();

        List<WebElement> options = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("Computers & Accessories")) {
                System.out.println("Selecting: " + option.getText());
                option.click();
                break;
            }
        }
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("mobile");
        
        WebElement searchclick = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchclick.click();

       // driver.quit();
    }
}
