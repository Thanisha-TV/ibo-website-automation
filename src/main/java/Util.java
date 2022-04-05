import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util extends base{
    public static void scrollTillElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public static void dropdownSelectValue(WebElement element,String value)
    {
        Select s =new Select(element);
        s.selectByVisibleText(value);
    }
}
