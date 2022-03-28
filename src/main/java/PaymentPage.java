import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends base{
    @FindBy(xpath = "//*[@id=\"payment-frame\"]/div/main/div/aside/div/div/div/div[2]/button")
    WebElement proceedButton;
    public PaymentPage()
    {
        PageFactory.initElements(driver,this);
    }
    public void navigateToConfirmationPage() throws InterruptedException {
        proceedButton.click();
        Thread.sleep(10000);
    }
}
