package orangeHRM_Webdriver_Manager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import orangeHRM_constants.Constants;

public class DriverManager {
	 private static final Logger logger = Logger.getLogger(DriverManager.class);

	private static WebDriver driver=null;
	
	
public static WebDriver getDriver() {
		return driver;
	}


public static void launchbrowser() {
		
		try {
         switch(Constants.BROWSER) {
           case "chrome":
            logger.info("Launching"+ Constants.BROWSER);
            // Use ChromeOptions so we can set binary path when Chrome is not in default location
            ChromeOptions options = new ChromeOptions();
            // required in some Selenium/ChromeDriver versions
            options.addArguments("--remote-allow-origins=*");
            // Add arguments to help with Chrome process creation
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

            // PRIORITIZE WebDriverManager to ensure ChromeDriver version matches installed Chrome version
            boolean useLocalDriver = false;
            try {
                logger.info("Using WebDriverManager to auto-download matching ChromeDriver version");
                WebDriverManager.chromedriver().setup();
                logger.info("WebDriverManager setup successful - ChromeDriver version will match installed Chrome");
                useLocalDriver = true;
            } catch (Exception wdmEx) {
                logger.warn("WebDriverManager failed: " + wdmEx.getMessage());
                // Fall back to local driver if WebDriverManager fails
                String driverPath = Constants.CHROME_DRIVER_LOCATION;
                if (driverPath != null && !driverPath.trim().isEmpty() && java.nio.file.Files.exists(java.nio.file.Paths.get(driverPath.trim()))) {
                    logger.info("Falling back to local ChromeDriver from config: " + driverPath);
                    System.setProperty("webdriver.chrome.driver", driverPath.trim());
                    useLocalDriver = true;
                } else {
                    logger.warn("Local ChromeDriver also not found");
                }
            }

            String binaryPath = null;
            if (Constants.CHROME_BINARY_PATH != null && !Constants.CHROME_BINARY_PATH.trim().isEmpty()) {
                binaryPath = Constants.CHROME_BINARY_PATH.trim();
                logger.info("CHROME_BINARY_PATH provided in config: " + binaryPath);
            } else {
                // try common locations on Windows - only chrome.exe files
                java.util.List<String> common = java.util.Arrays.asList(
                        "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
                        "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
                        System.getProperty("user.home") + "\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"
                );
                for (String p : common) {
                    java.nio.file.Path path = java.nio.file.Paths.get(p);
                    // Check that path exists AND is a file (not a directory)
                    if (java.nio.file.Files.exists(path) && java.nio.file.Files.isRegularFile(path)) {
                        binaryPath = p;
                        logger.info("Found Chrome binary at: " + p);
                        break;
                    }
                }
            }

             // Only set binary if the path is a valid executable file (not a directory)
             if (binaryPath != null) {
                 java.nio.file.Path binPath = java.nio.file.Paths.get(binaryPath);
                 if (java.nio.file.Files.exists(binPath) && java.nio.file.Files.isRegularFile(binPath)) {
                     options.setBinary(binaryPath);
                     logger.info("Using Chrome binary: " + binaryPath);
                 } else if (useLocalDriver) {
                     // Path doesn't exist or is not a file, skip binary path and let chromedriver auto-detect
                     logger.info("Chrome binary path is not valid or not a file, will use system Chrome installation");
                 } else {
                     binaryPath = null; // Reset to null to try other methods
                 }
             }

             if (binaryPath == null && useLocalDriver) {
                 // If we have a local driver and no valid binary path, we can proceed
                 // Chrome will be started automatically if available
                 logger.info("No Chrome binary path configured, will use system Chrome installation");
             } else if (binaryPath == null && !useLocalDriver) {
                 // Try locating chrome via PATH using the 'where' command (Windows)
                 try {
                     ProcessBuilder pb = new ProcessBuilder("where", "chrome");
                     pb.redirectErrorStream(true);
                     Process p = pb.start();
                     java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
                     String line;
                     while ((line = r.readLine()) != null) {
                         line = line.trim();
                         if (line.length() > 0) {
                             java.nio.file.Path wPath = java.nio.file.Paths.get(line);
                             if (java.nio.file.Files.exists(wPath) && java.nio.file.Files.isRegularFile(wPath)) {
                                 binaryPath = line;
                                 options.setBinary(binaryPath);
                                 logger.info("Found Chrome binary using 'where': " + binaryPath);
                                 break;
                             }
                         }
                     }
                 } catch (Exception e) {
                     logger.debug("'where chrome' lookup failed: " + e.getMessage());
                 }

                 if (binaryPath == null) {
                     String msg = "Chrome browser not found. Please install Google Chrome or set CHROME_BINARY_PATH in src/test/resources/config.properties with the full path to chrome.exe.\nConfigured path: " + Constants.CHROME_DRIVER_LOCATION;
                     logger.error(msg);
                     throw new RuntimeException(msg);
                 }
             }
           driver = new ChromeDriver(options);
          break;
         case "firefox":
        	 WebDriverManager.firefoxdriver().setup();	
        	 logger.info("Launching"+ Constants.BROWSER);
             driver= new FirefoxDriver();
             break;
         case "opera":
        	 WebDriverManager.operadriver().setup();	
        	 logger.info("Launching"+ Constants.BROWSER);
 //       	 driver = new OperaDriver();
        	 break;
         case "edge":
        	 WebDriverManager.edgedriver().setup();
        	 logger.info("Launching"+ Constants.BROWSER);
        	 driver = new EdgeDriver();
             break;    
          }

		}
		catch(Exception e) {
			logger.error("Failed to initialize WebDriver: " + e.getMessage(), e);
			e.printStackTrace();
			throw new RuntimeException("WebDriver initialization failed: " + e.getMessage(), e);
		}
	}

}
