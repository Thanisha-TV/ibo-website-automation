import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends base{

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/header[1]/div/div[2]/div/button/p/span[2]")
    WebElement pincodeLink;
    @FindBy(xpath = "//input[@placeholder='Enter Pincode']")
    WebElement pincodeTextBox;
    @FindBy(xpath = "//button[text()='Apply']")
    WebElement applyButton;
    @FindBy(xpath="//input[@placeholder='Search for products or brands']")
    WebElement searchBox;
    @FindBy(xpath = "//img[@alt='Search']")
    WebElement searchIcon;
    @FindBy(xpath = "//span[text()='DELUCCIO [Pack of 2] Dummy Sub-Class']")
    WebElement product;
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    public void changePincode() throws InterruptedException {
        pincodeLink.click();
        pincodeTextBox.sendKeys(prop.getProperty("postcode"));
        applyButton.click();
        Thread.sleep(10000);
    }
    public PdpPage searchProduct(String searchTerm) throws InterruptedException {
        searchBox.sendKeys(searchTerm);
        searchIcon.click();
        Thread.sleep(10000);
        product.click();
        return new PdpPage();
    }
}
