import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class AddressPageTest extends base{
    LoginPage loginPage;
    HomePage homePage;
    PdpPage pdpPage;
    CartPage cartPage;
    AddressPage addressPage;
    public AddressPageTest()
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
    }
    @Test(description = "Validate Navigation from Address tab to Payment tab")
    @Severity(SeverityLevel.CRITICAL)
    public void validateNavigateToPaymentPage() throws InterruptedException {
        addressPage.navigateToPaymentPage();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
