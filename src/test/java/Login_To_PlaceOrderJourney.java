import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_To_PlaceOrderJourney extends base{
    LoginPage loginPage;
    HomePage homePage;
    PdpPage pdpPage;
    CartPage cartPage;
    AddressPage addressPage;
    PaymentPage paymentPage;
    public Login_To_PlaceOrderJourney()
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
    public void loginToPlaceOrderJourney() throws Exception {
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
        loginPage.validateHomePageTitle();
        homePage.changePincode();
        pdpPage=homePage.searchProduct(prop.getProperty("sku"));
        cartPage=pdpPage.addItemToCart();
        addressPage=cartPage.navigateToAddressPage();
        paymentPage=addressPage.navigateToPaymentPage();
        paymentPage.navigateToConfirmationPage();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }

}
