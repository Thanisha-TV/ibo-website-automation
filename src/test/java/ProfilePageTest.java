import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    @Test
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
