import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PdpPageTest extends base{
    LoginPage loginPage;
    public PdpPageTest()
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
