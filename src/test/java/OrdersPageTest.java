import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class OrdersPageTest extends base{
    LoginPage loginPage;
    HomePage homePage;
    OrdersPage ordersPage;
    public OrdersPageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization(prop.getProperty("browser"), "Website");
        loginPage=new LoginPage();
        homePage=loginPage.login(prop.getProperty("mobileNumber"));
        ordersPage=homePage.navigateToOrderPage();
    }
    @Test(description = "OrdersPage- Validate Navigation from Home Page To Orders Page")
    @Severity(SeverityLevel.CRITICAL)
    public void validatePlacedOrderDetails() throws InterruptedException {
        ordersPage.orderDetails();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
