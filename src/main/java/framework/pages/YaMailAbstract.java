package framework.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Zakir_Mustafin on 2/3/2017.
 */
//Что за класс? почему абстрактный и не объявлен абстактным, кто наследует?
public class YaMailAbstract {
    protected WebDriver driver;
    protected Logger logger;
    //    protected WebElement webElement;
//    protected WebDriverWait wait;
//    protected String subjectOfLetter = String.valueOf(System.currentTimeMillis());
    protected String addressOfLetter = "samsamitch1@yandex.ru";
    protected String textOfLetter = "Мама мыла раму!!!";

    public YaMailAbstract(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(this.driver, this);
    }



    public WebDriver getDriver() {
        return this.driver;
    }

    public void highlightElement(WebDriver driver, WebElement element)
    {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
// take screenshot here
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }


    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
