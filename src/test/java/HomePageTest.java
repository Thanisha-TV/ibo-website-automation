import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class HomePageTest extends base{
    LoginPage loginPage;
    HomePage homePage;
    public HomePageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage=new LoginPage();
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
    }
    @Test(description = "HomePage- Validate home Page title")
    @Severity(SeverityLevel.NORMAL)
    public void validateHomePageTitle()
    {
        homePage.homePageTitle();
    }
    @Test(description = "HomePage- Validate change Postcode")
    @Severity(SeverityLevel.CRITICAL)
    public void validateChangePostcode() throws InterruptedException {
        homePage.changePostcode();
    }
    @Test(description = "HomePage- Validate Navigation from Home page to Profile Page")
    @Severity(SeverityLevel.MINOR)
    public void validateNavigateToProfilePage() throws InterruptedException {
        homePage.navigateToProfilePage();
    }
    @Test(dependsOnMethods = "validateChangePostcode",description = "HomePage- Validate Search Product Scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void validateSearchProduct() throws InterruptedException {
        homePage.changePostcode();
        homePage.searchProduct(prop.getProperty("sku"));
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
