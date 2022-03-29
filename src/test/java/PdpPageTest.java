import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        initialization();
        loginPage=new LoginPage();
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
        homePage.changePostcode();
        pdpPage=homePage.searchProduct(prop.getProperty("sku"));
    }
    @Test
    public void validatePriceDisplay()
    {
        pdpPage.priceDisplay();
    }
    @Test
    public void validateUpdateQuantity() throws InterruptedException {
        pdpPage.updateQuantity();
    }
    @Test
    public void validateAddItemToCart() throws InterruptedException {
        pdpPage.addItemToCart();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
