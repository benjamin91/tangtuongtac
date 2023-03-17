package pages;

import com.aventstack.extentreports.gherkin.model.When;
import libraries.Report;
import objects.Business;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TuongTacPage extends BasePage{
    public TuongTacPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='dspost']//button")
    public List<WebElement> actionButtons;

    public void clickActionButton() {
        click(actionButtons.get(0));
    }
}
