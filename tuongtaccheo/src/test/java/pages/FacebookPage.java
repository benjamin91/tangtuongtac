package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage extends BasePage{
    public FacebookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//input[@id='email'])[1]")
    public WebElement emailTextBox;

    @FindBy(xpath = "(//input[@id='pass'])[1]")
    public WebElement passText;

    @FindBy(xpath = "(//input[@value='Log in'])[1]")
    public WebElement loginButton;

    @FindBy(xpath = "(//span[.='Thích'])[1]")
    public WebElement likeButton;

    public void clickLike() {
        click(likeButton);
    }

    public void loginFacebook(String email, String pass) {
        fillIn(emailTextBox, email);
        fillIn(passText, pass);
        click(loginButton);
    }
}
