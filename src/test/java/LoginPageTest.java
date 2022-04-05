import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class LoginPageTest extends base{
    LoginPage loginPage;
    public LoginPageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization("Website");
        loginPage=new LoginPage();
    }

    @Test(description = "LoginPage- Validate Logo on Website")
    @Severity(SeverityLevel.CRITICAL)
    public void validateLogo()
    {
        loginPage.logoCheck();
    }
    @Test(description = "LoginPage- Validate Display of Shop By Category section")
    @Severity(SeverityLevel.CRITICAL)
    public void validateDisplayOfShopByCategorySection()
    {
        loginPage.displayOfShopByCategorySection();
    }
    @Test(description = "LoginPage- Validate Display of Top Brands section")
    @Severity(SeverityLevel.CRITICAL)
    public void validateDisplayOfTopBrandsSection()
    {
        loginPage.displayOfTopBrandsSection();
    }
    @Test(description = "LoginPage- Validate Login Test")
    @Severity(SeverityLevel.BLOCKER)
    public void validateLoginTest() throws InterruptedException {
        loginPage.login(prop.getProperty("mobileNumber"));
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
