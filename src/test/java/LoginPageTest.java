import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends base{
    LoginPage loginPage;
    public LoginPageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginPage=new LoginPage();
    }
    @Test
    public void validateHomePageTest() throws InterruptedException {
        loginPage.login(prop.getProperty("mobileNumber"));
        loginPage.validateHomePageTitle();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
