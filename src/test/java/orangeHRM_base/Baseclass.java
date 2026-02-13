package orangeHRM_base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class Baseclass {
public Logger logger;
	
	@BeforeClass
	public void setup() {
		logger=Logger.getLogger("orangeHRM");//added logger
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		
	}
}
