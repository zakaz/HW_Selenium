package Selenium_part_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Zakir_Mustafin on 2/3/2017.
 */
public class YaMailAbstract {
    protected WebDriver driver;
//    protected WebDriverWait wait;
//    protected String subjectOfLetter = String.valueOf(System.currentTimeMillis());
    protected String addressOfLetter = "samsamitch1@yandex.ru";
    protected String textOfLetter = "Мама мыла раму!!!";


    public YaMailAbstract(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
