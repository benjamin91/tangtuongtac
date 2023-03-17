package pages;

import com.aventstack.extentreports.gherkin.model.When;
import libraries.Report;
import libraries.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='name']")
    public WebElement userNameTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement DangNhapButton;

    public void dangNhap(String userName, String password) {
        fillIn(userNameTextBox, userName);
        fillIn(passwordTextBox, password);
        click(DangNhapButton);
    }
}
