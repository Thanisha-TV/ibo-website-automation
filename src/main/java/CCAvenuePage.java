import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CCAvenuePage extends base {
    @FindBy(xpath = "//*[@id=\"TransactionForm\"]/div[3]/section/div/div[4]/div[2]/div[3]/div[2]/div[8]/div[1]/ul/li")
    WebElement dropdown;
    @FindBy(xpath = "//*[@id=\"netBanking\"]/li[2]")
    WebElement avenuesTest;
    @FindBy(xpath = "//*[@id=\"TransactionForm\"]/div[3]/section/div/div[4]/div[2]/div[5]/div[2]/div[3]/div[1]/a")
    WebElement confirmPaymentButton;
    @FindBy(xpath = "/html/body/form/table/tbody/tr[8]/td/input")
    WebElement returnButton;
    public CCAvenuePage()
    {
        PageFactory.initElements(driver,this);
    }
    public ConfirmationPage paymentProcess() throws InterruptedException {
        dropdown.click();
        avenuesTest.click();
        confirmPaymentButton.click();
        Thread.sleep(5000);
        returnButton.click();
        Thread.sleep(5000);
        return new ConfirmationPage();
    }
}
