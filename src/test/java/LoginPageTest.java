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
    public void validateLogo()
    {
        loginPage.logoCheck();
    }
    @Test
    public void validateDisplayOfShopByCategorySection()
    {
        loginPage.displayOfShopByCategorySection();
    }
    @Test
    public void validateDisplayOfTopBrandsSection()
    {
        loginPage.displayOfTopBrandsSection();
    }
    @Test
    public void validateLoginTest() throws InterruptedException {
        loginPage.login(prop.getProperty("mobileNumber"));
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
