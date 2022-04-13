import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class Login_To_PlaceOrderUsingWalletJourney extends base{
    LoginPage loginPage;
    HomePage homePage;
    PdpPage pdpPage;
    CartPage cartPage;
    AddressPage addressPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;
    OrdersPage ordersPage;
    public Login_To_PlaceOrderUsingWalletJourney()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization(prop.getProperty("browser"), "Website");
        loginPage=new LoginPage();
    }
    @Test(description = "Login to Place Order Using Wallet Journey")
    public void loginToPlaceOrderJourney() throws Exception {
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
        homePage.homePageTitle();
        homePage.changePostcode();
        pdpPage=homePage.searchProduct(prop.getProperty("sku"));
        cartPage=pdpPage.addItemToCart();
        addressPage=cartPage.navigateToAddressPage();
        paymentPage=addressPage.navigateToPaymentPage();
        confirmationPage=paymentPage.navigateToConfirmationPage("WALLET");
        homePage=confirmationPage.navigateToHomePage();
        ordersPage=homePage.navigateToOrderPage();
        ordersPage.placedOrderDetails();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
