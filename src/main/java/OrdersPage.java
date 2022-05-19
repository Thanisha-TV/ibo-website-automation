import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrdersPage extends base{
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/main/ul/li[1]/div/div[2]/div/div/div[2]/span")
    WebElement orderText;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/main/ul/li[1]/div/div[2]/div/span/img")
    WebElement orderDetailsLink;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/aside/div/div/div[1]/div[5]/div[1]")
    WebElement paidByIBOWalletText;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/aside/div/div/div[1]/div[5]/div[2]")
    WebElement walletTotalPrice;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/div[1]/div[2]/div[1]/div[4]/div/span[2]")
    WebElement totalPrice;
    public OrdersPage()
    {
        PageFactory.initElements(driver,this);
    }
    public void placedOrderDetails() throws InterruptedException {
        String orderNumText=orderText.getText();
        Assert.assertEquals(orderNumText,"Order ID : "+ConfirmationPage.orderNum);
        Thread.sleep(5000);
        orderDetailsLink.click();
        Thread.sleep(5000);
        String text=paidByIBOWalletText.getText();
        Assert.assertEquals(text,"Paid by IBO Wallet");
        Thread.sleep(5000);
        String price=walletTotalPrice.getText();
        Assert.assertEquals(price,"₹515");
        Thread.sleep(5000);
    }
    public void orderDetails() throws InterruptedException {
        orderDetailsLink.click();
        Thread.sleep(5000);
        String price=totalPrice.getText();
        Assert.assertNotNull(price);
        Thread.sleep(5000);
    }
}
