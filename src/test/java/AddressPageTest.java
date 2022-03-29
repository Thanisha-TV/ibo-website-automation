import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    @Test
    public void validateNavigateToPaymentPage() throws InterruptedException {
        addressPage.navigateToPaymentPage();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
