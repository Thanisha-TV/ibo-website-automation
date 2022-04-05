import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class ConfirmationPageTest extends base{
    LoginPage loginPage;
    HomePage homePage;
    PdpPage pdpPage;
    CartPage cartPage;
    AddressPage addressPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;
    public ConfirmationPageTest()
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
        addressPage=cartPage.navigateToAddressPage();
        paymentPage=addressPage.navigateToPaymentPage();
        confirmationPage=paymentPage.navigateToConfirmationPage("PAY ON DELIVERY");
    }
    @Test(description = "ConfirmationPage- Validate Navigation from Confirmation Page to Home Page")
    @Severity(SeverityLevel.CRITICAL)
    public void validateNavigateToHomePage() throws InterruptedException {
        homePage=confirmationPage.navigateToHomePage();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
