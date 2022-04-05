import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_To_PlaceOrderUsingWalletJourney extends base{
    LoginPage loginPage;
    HomePage homePage;
    PdpPage pdpPage;
    CartPage cartPage;
    AddressPage addressPage;
    PaymentPage paymentPage;
    public Login_To_PlaceOrderUsingWalletJourney()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization("Website");
        loginPage=new LoginPage();
    }
    @Test(description = "Login to Place Order Journey")
    public void loginToPlaceOrderJourney() throws Exception {
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
        homePage.homePageTitle();
        homePage.changePostcode();
        pdpPage=homePage.searchProduct(prop.getProperty("sku"));
        cartPage=pdpPage.addItemToCart();
        addressPage=cartPage.navigateToAddressPage();
        paymentPage=addressPage.navigateToPaymentPage();
        //paymentPage.navigateToConfirmationPage("PAY ON DELIVERY");
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }

}
