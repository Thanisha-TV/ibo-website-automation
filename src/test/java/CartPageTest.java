import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends base{
    LoginPage loginPage;
    HomePage homePage;
    PdpPage pdpPage;
    CartPage cartPage;
    public CartPageTest()
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
        cartPage=pdpPage.addItemToCart();
    }
    @Test
    public void validateTotalPriceCheck()
    {
        cartPage.totalPriceCheck();
    }
    @Test
    public void validateDeleteProduct() throws InterruptedException {
        cartPage.deleteProduct();
    }
    @Test
    public void validateNavigateToAddressPage() throws InterruptedException {
        cartPage.navigateToAddressPage();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
