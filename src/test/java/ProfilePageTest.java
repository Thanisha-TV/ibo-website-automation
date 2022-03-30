import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class ProfilePageTest extends base{
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    public ProfilePageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage=new LoginPage();
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
        profilePage=homePage.navigateToProfilePage();
    }
    @Test(description = "Validate Username in Profile Page")
    @Severity(SeverityLevel.MINOR)
    public void validateUsernameCheck()
    {
        profilePage.usernameCheck();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
