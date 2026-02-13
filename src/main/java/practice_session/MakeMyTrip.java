package practice_session;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MakeMyTrip {

    @Test
    public void trip() throws InterruptedException {
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Close initial login modal if present
            WebElement closeButton = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector("span[data-cy='closeModal']")));
            closeButton.click();

            // Click on Hotels
            WebElement hotel = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Hotels']")));
            hotel.click();

            // Click on Room & Guests box
            WebElement roomGuest = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div/div[1]/div[4]/label")));
            roomGuest.click();

            Thread.sleep(2000); // give time for dropdowns to appear

            // ✅ Select 5 Rooms
            List<WebElement> rooms = driver.findElements(By.xpath("//ul[@class='gstSlct__list']/li"));
            for (WebElement room : rooms) {
                if (room.getText().trim().equals("5")) {
                    room.click();
                    System.out.println("Selected Rooms: " + room.getText());
                    break;
                }
            }

            // ✅ Select 5 Adults
            List<WebElement> adults = driver.findElements(By.xpath("(//ul[@class='gstSlct__list'])[2]/li"));
            for (WebElement adult : adults) {
                if (adult.getText().trim().equals("5")) {
                    adult.click();
                    System.out.println("Selected Adults: " + adult.getText());
                    break;
                }
            }

            // ✅ Select 5 Children
            List<WebElement> children = driver.findElements(By.xpath("(//ul[@class='gstSlct__list'])[3]/li"));
            for (WebElement child : children) {
                if (child.getText().trim().equals("5")) {
                    child.click();
                    System.out.println("Selected Children: " + child.getText());
                    break;
                }
            }

            // ✅ Click Apply
            WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='APPLY']")));
            applyButton.click();

            System.out.println("Apply clicked successfully");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed - " + e.getMessage());
        }

        //driver.quit();
    }
}
