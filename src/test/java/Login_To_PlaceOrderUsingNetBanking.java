import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class Login_To_PlaceOrderUsingNetBanking extends base{
    LoginPage loginPage;
    HomePage homePage;
    PdpPage pdpPage;
    CartPage cartPage;
    AddressPage addressPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;
    CCAvenuePage ccAvenuePage;
    public Login_To_PlaceOrderUsingNetBanking()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization("Website");
        loginPage=new LoginPage();
        ccAvenuePage=new CCAvenuePage();
    }
    @Test(description = "Login to Place Order Using Net Banking Journey")
    public void loginToPlaceOrderJourney() throws Exception {
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
        homePage.homePageTitle();
        homePage.changePostcode();
        pdpPage=homePage.searchProduct(prop.getProperty("sku"));
        cartPage=pdpPage.addItemToCart();
        addressPage=cartPage.navigateToAddressPage();
        paymentPage=addressPage.navigateToPaymentPage();
        paymentPage.navigateToConfirmationPage("NET BANKING");
        confirmationPage=ccAvenuePage.paymentProcess();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }

}
