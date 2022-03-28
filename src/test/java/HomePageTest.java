import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends base{
    LoginPage loginPage;
    public HomePageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginPage=new LoginPage();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
