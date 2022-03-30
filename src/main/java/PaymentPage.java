import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PaymentPage extends base{
    @FindBy(xpath = "//*[@id=\"payment-frame\"]/div/main/div/aside/div/div/div/div[2]/button")
    WebElement proceedButton;
    @FindBy(xpath = "//*[@id=\"OFFLINE\"]")
    WebElement bankDepositRadioButton;
    @FindBy(xpath = "//span[text()='Bank Deposit']")
    WebElement bankDepositText;
    public PaymentPage()
    {
        PageFactory.initElements(driver,this);
    }
    public void paymentOption() throws InterruptedException {
        bankDepositRadioButton.click();
        Thread.sleep(10000);
        Assert.assertTrue(bankDepositRadioButton.isSelected());
        Assert.assertEquals(bankDepositText.getText(),"Bank Deposit");
    }
    public void navigateToConfirmationPage() throws InterruptedException {
        bankDepositRadioButton.click();
        Thread.sleep(10000);
        proceedButton.click();
        Thread.sleep(10000);
    }
}
