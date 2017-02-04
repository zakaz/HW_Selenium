package Selenium_part_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Zakir_Mustafin on 2/3/2017.
 */
public class InboxMailPage extends YaMailAbstract{

    @FindBy (xpath = "//span[text()='Входящие']")
    WebElement wordInboxInMailbox;

    @FindBy (linkText = "Написать")
    WebElement buttonCreateNewLetter;

    public InboxMailPage(WebDriver driver){
        super(driver);
    }

    public EnterDetailsOfNewLetter createNewMail(){
        buttonCreateNewLetter.click();

       return new EnterDetailsOfNewLetter (driver);
    }


    public boolean loginIsCorrect(){
        return wordInboxInMailbox.isDisplayed();
    }


}
