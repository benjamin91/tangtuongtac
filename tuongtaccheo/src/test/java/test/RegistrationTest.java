package test;

import com.aventstack.extentreports.gherkin.model.Scenario;
import libraries.Report;
import libraries.Utils;
import objects.Business;
import objects.UserInfo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.util.Iterator;

public class RegistrationTest extends BaseTest{


    @Test
    public void dangNhap() {
        LoginPage loginPage = new LoginPage(BaseTest.driver);
        loginPage.dangNhap("locnguyen91", "Famozid.110616");
    }

    @Test(dependsOnMethods = "dangNhap")
    public void likePost() throws InterruptedException {
        TuongTacPage tuongTacPage = new TuongTacPage(driver);
        FacebookPage facebookPage = new FacebookPage(driver);
        tuongTacPage.gotoUrl("https://tuongtaccheo.com/kiemtien/");
        int i = 1;
        while (0 < 1) {
            if (i % 20 == 0)
                tuongTacPage.gotoUrl("https://tuongtaccheo.com/kiemtien/");

            Thread.sleep(2000);

            tuongTacPage.clickActionButton();
            tuongTacPage.switchTabBrowser(1);
//            facebookPage.loginFacebook("locfoz01@gmail.com", "Famozid.11062016");

            facebookPage.clickLike();

            tuongTacPage.closeTabBrowser();
            Thread.sleep(1000);

            tuongTacPage.switchTabBrowser(0);

            tuongTacPage.clickActionButton();
        }
    }
}
