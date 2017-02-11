import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by Zakir_Mustafin on 2/11/2017.
 * !!!!!!!!!CODE IS NOT RELATED TO HOMEWORKS, JUST FOR TRAINING!!!!
 */
public class DebugTest {
    private static final String DROPPABLE_TEST_URL = "http://jqueryui.com/droppable/";
    private static WebDriver driver;

    @BeforeClass
    public void setUp() {
        // setting up initial WebDriver/browser options
//		driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zakir_mustafin@epam.com\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "Drag and drop (element-to-element")
    public void droppable() throws InterruptedException {
        // navigating to test url
        driver.get(DROPPABLE_TEST_URL);

        // switching to frame containing web elements
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

//        WebElement draggable = driver.findElement(By.id("draggable"));
//        WebElement droppable = driver.findElement(By.id("droppable"));

        // perform drag-and-drop action
//        new Actions(driver).dragAndDrop(draggable, droppable).build().perform();
        Thread.sleep(3000);
        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.xpath("//h1[@class='entry-title']"))).build().perform();

        // freeze for a while to demonstrate action result
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() {
//        driver.quit(); // to be used for chrome; fails for firefox for the latest versions
    }

}
