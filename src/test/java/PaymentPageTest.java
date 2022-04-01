import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class PaymentPageTest extends base{
    LoginPage loginPage;
    HomePage homePage;
    PdpPage pdpPage;
    CartPage cartPage;
    AddressPage addressPage;
    PaymentPage paymentPage;
    public PaymentPageTest()
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
        addressPage=cartPage.navigateToAddressPage();
        paymentPage=addressPage.navigateToPaymentPage();
    }
    @Test(description = "PaymentPage- Validate payment Option")
    @Severity(SeverityLevel.CRITICAL)
    public void validatePaymentOption() throws InterruptedException {
        paymentPage.paymentOption();
    }
    @Test(description = "PaymentPage- Validate Navigation from Payment Page to Confirmation Page")
    @Severity(SeverityLevel.CRITICAL)
    public void validateNavigateToConfirmationPage() throws InterruptedException {
        paymentPage.navigateToConfirmationPage();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
