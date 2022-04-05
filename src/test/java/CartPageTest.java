import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
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
        initialization("Website");
        loginPage=new LoginPage();
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
        homePage.changePostcode();
        pdpPage=homePage.searchProduct(prop.getProperty("sku"));
        cartPage=pdpPage.addItemToCart();
    }
    @Test(description = "CartPage- Validate Total Price in Cart Page")
    @Severity(SeverityLevel.CRITICAL)
    public void validateTotalPriceCheck()
    {
        cartPage.totalPriceCheck();
    }
    @Test(description = "CartPage- Validate Delete item in Cart Page")
    @Severity(SeverityLevel.CRITICAL)
    public void validateDeleteProduct() throws InterruptedException {
        cartPage.deleteProduct();
    }
    @Test(description = "CartPage- Validate navigation from Cart tab to address tab")
    @Severity(SeverityLevel.CRITICAL)
    public void validateNavigateToAddressPage() throws InterruptedException {
        cartPage.navigateToAddressPage();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
