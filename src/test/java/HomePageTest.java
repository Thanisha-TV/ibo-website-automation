import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    @Test
    public void validateHomePageTitle()
    {
        homePage.homePageTitle();
    }
    @Test
    public void validateChangePostcode() throws InterruptedException {
        homePage.changePostcode();
    }
    @Test
    public void validateNavigateToProfilePage() throws InterruptedException {
        homePage.navigateToProfilePage();
    }
    @Test(dependsOnMethods = "validateChangePostcode")
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
