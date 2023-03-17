package pages;

import com.aventstack.extentreports.gherkin.model.Then;
import com.aventstack.extentreports.gherkin.model.When;
import libraries.Report;
import libraries.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver) {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Utils.timeout);
        PageFactory.initElements(factory, this);
        this.driver = driver;
    }

    public static void fillIn(WebElement el, String text) {
        el.clear();
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        waitForElementClickable(el);
        el.click();
    }

    public void waitForElementClickable(WebElement el) {
        WebDriverWait wait = new WebDriverWait(this.driver, Utils.timeout);
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    public static void selectItem(WebElement el, String text, String item) throws InterruptedException {
        fillIn(el, text);
        Thread.sleep(2000);
//        waitElementVisible(getElement("xpath", "//div[contains(text(),'" + item + "')]"));
        Utils.getElement("xpath", "//div[contains(text(),'" + item + "')]").click();
    }

    public void selectItem(WebElement el, String item) throws InterruptedException {
        click(el);
        Utils.getElement("xpath", "//div[contains(text(),'" + item + "')]").click();
    }

    public void waitForElementVisible(WebElement el) {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Utils.timeout);
            wait.until(ExpectedConditions.visibilityOf(el));
        } catch (Exception e) {
            this.driver.findElement(Utils.getLocator(el));
        }
    }

    public void waitForElementPresence(WebElement el) {
        WebDriverWait wait = new WebDriverWait(this.driver, Utils.timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(Utils.getLocator(el)));
    }

    public void uploadDocument(WebElement element, String file) {
        Report.scenario.createNode(When.class, "Upload a document to [" + element.getText() + "]");
        fillIn(element, file);
    }

    public void verifyPageContainText(String text) {
        Report.scenario.createNode(Then.class, "Verify text [" + text + "] display on page");
//        waitForElementVisible(Utils.getElement("xpath", "//*[contains(text(),'"+ text +"')]"));
        Assert.assertTrue(Utils.getElement("xpath", "//*[contains(text(),'"+ text +"')]").isDisplayed());
    }

    public void gotoUrl(String url) {
        driver.navigate().to(url);
    }

    public void switchTabBrowser(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public void closeTabBrowser() {
        driver.close();
    }
}
