package Selenium_part_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Zakir_Mustafin on 2/3/2017.
 */
public class SignInPage extends YaMailAbstract {

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement pwdInput;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement signInBtn;

//    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        super (driver);
    }

    public InboxMailPage loginToYaMail(String login, String password) {

        System.out.println("Typing user login: " + login);
        highlightElement(driver, loginInput);
        loginInput.clear();
        loginInput.sendKeys(login);

        System.out.println("Typing user password: " + password);
        highlightElement(driver, pwdInput);
        pwdInput.clear();
        pwdInput.sendKeys(password);

        highlightElement(driver, signInBtn);
        signInBtn.click();
        System.out.println("Login is in progress...");

        return new InboxMailPage(driver);

    }
}
