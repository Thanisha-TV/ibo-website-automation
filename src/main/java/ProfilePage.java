import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProfilePage extends base{
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/main/div/div/div/div[2]/div[1]/div/input")
    WebElement username;
    public ProfilePage()
    {
        PageFactory.initElements(driver,this);
    }
    public void usernameCheck()
    {
        String name=username.getAttribute("value");
        Assert.assertEquals(name,"Thanisha M");
    }
}
