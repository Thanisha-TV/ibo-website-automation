import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class PdpPageTest extends base{
    LoginPage loginPage;
    HomePage homePage;
    PdpPage pdpPage;
    public PdpPageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization(prop.getProperty("browser"), "Website");
        loginPage=new LoginPage();
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
        homePage.changePostcode();
        pdpPage=homePage.searchProduct(prop.getProperty("sku"));
    }
    @Test(description = "PdpPage- Validate Price Display")
    @Severity(SeverityLevel.CRITICAL)
    public void validatePriceDisplay()
    {
        pdpPage.priceDisplay();
    }
    @Test(description = "PdpPage- Validate Update Quantity")
    @Severity(SeverityLevel.CRITICAL)
    public void validateUpdateQuantity() throws InterruptedException {
        pdpPage.updateQuantity();
    }
    @Test(description = "PdpPage- Validate Add to Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void validateAddItemToCart() throws InterruptedException {
        pdpPage.addItemToCart();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
