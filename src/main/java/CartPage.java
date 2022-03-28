import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends base{
    @FindBy(xpath = "//span[text()='Proceed to buy']")
    WebElement proceedButtonToAddressPage;
    public CartPage()
    {
        PageFactory.initElements(driver,this);
    }
    public AddressPage navigateToAddressPage() throws InterruptedException {
        proceedButtonToAddressPage.click();
        Thread.sleep(10000);
        return new AddressPage();
    }
}
