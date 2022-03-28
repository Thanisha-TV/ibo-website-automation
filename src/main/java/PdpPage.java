import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PdpPage extends base{
    Util obj=new Util();
    @FindBy(xpath = "//span[text()='Add to cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/header[1]/div/div[4]/ul/li[7]/span[1]/a/span")
    WebElement cartLink;

    public PdpPage()
    {
        PageFactory.initElements(driver,this);
    }

    public CartPage addItemToCart() throws InterruptedException {
        Util.scrollTillElement(addToCartButton);
        addToCartButton.click();
        Thread.sleep(10000);
        cartLink.click();
        Thread.sleep(10000);
        return new CartPage();
    }
}
