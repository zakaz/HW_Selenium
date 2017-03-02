package framework.environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.util.Strings;

import javax.naming.ConfigurationException;
import java.net.MalformedURLException;

import static framework.environment.EnvBase.gridHubUrl;

/**
 * Created by admin1 on 25/2/17.
 */
public class WebDriverFactory {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private WebDriverFactory(){}

    /**
     * Returns WebDriver instance for the current thread if it is already created or creates a new one
     * @return WebDriver instance
     * @throws ConfigurationException if incorrect WebDriver properties have been provided
     */
    public static synchronized WebDriver getDriver() throws ConfigurationException {
        WebDriver driver = drivers.get();
        if (!isDriverAlive()){
            driver = createDriver();
            drivers.set(driver);
        }
        return driver;
    }

    /**
     * Closes current WebDriver instance
     */
    public static synchronized void closeDriver(){
        WebDriver driver = drivers.get();
        if (driver != null){
            driver.quit();
            drivers.remove();
        }
    }

    private static synchronized boolean isDriverAlive(){
        WebDriver driver = drivers.get();
        return driver != null && !driver.getWindowHandles().isEmpty();
    }

    private static WebDriver createDriver() throws ConfigurationException{
        String driverName = System.getProperty("driverName", "CHROME");
        WebDriver driver;

        switch (driverName.toUpperCase()) {
            case "REMOTE":
                driver = initRemoteDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "...":
               // driver  = ...;
                break;
            default:
                throw new ConfigurationException("Unknown driver name: " + driverName);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver initRemoteDriver() throws ConfigurationException {
        String gridHubURL = System.getProperty("gridHubURL");
        if (Strings.isNullOrEmpty(gridHubURL)) {
            throw new ConfigurationException("No gridHubURL address is specified.");
            gridHubURL = gridHubUrl;
        }
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        try {
            WebDriver driver = new RemoteWebDriver(new URL(gridHubURL), capabilities);

            return driver;
        } catch (MalformedURLException e) {
            throw new ConfigurationException("Incorrect gridHubURL address is specified: " + gridHubURL);
        }
    }

}
