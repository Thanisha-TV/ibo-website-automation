import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class Login_To_PlaceOrderUsingBankDepositJourney extends base{
    LoginPage loginPage;
    HomePage homePage;
    PdpPage pdpPage;
    CartPage cartPage;
    AddressPage addressPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;
    public Login_To_PlaceOrderUsingBankDepositJourney()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization(prop.getProperty("browser"), "Website");
        loginPage=new LoginPage();
    }
    @Test(description = "Login to Place Order Using Bank Deposit Journey")
    public void loginToPlaceOrderJourney() throws Exception {
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
        homePage.homePageTitle();
        homePage.changePostcode();
        pdpPage=homePage.searchProduct(prop.getProperty("sku"));
        cartPage=pdpPage.addItemToCart();
        addressPage=cartPage.navigateToAddressPage();
        paymentPage=addressPage.navigateToPaymentPage();
        confirmationPage=paymentPage.navigateToConfirmationPage("BANK DEPOSIT");
        homePage=confirmationPage.navigateToHomePage();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
