import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class AllureListener implements ITestListener {
    private static String getTestMethodName(ITestResult result)
    {
        return result.getMethod().getConstructorOrMethod().getName();
    }
    @Attachment
    public byte[] saveFailureScreenshot(WebDriver driver)
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment(value = "{0}",type = "text/plain")
    public static String saveTextLog(String message)
    {
        return message;
    }
    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass=result.getInstance();
        WebDriver driver=base.driver;
        if(driver instanceof WebDriver)
        {
            System.out.println("Screenshot Captured for Testcase"+ getTestMethodName(result));
            saveFailureScreenshot(driver);
        }
        saveTextLog(getTestMethodName(result)+" Method Failed and Screenshot taken");

    }
    @Override
    public void onStart(ITestContext context) {
        try {
            FileUtils.deleteDirectory(new File("allure-results"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            Thread.sleep(10000);
            Process process = Runtime.getRuntime().exec("allure serve allure-results");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
