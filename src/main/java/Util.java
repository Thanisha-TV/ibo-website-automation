import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Util extends base{
    public static void scrollTillElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
}
