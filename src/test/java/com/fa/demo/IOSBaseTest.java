package com.fa.demo;

import com.fa.demo.utils.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;

public class IOSBaseTest implements IHookable {

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] screenshotattach(String testMethodName) throws Exception {
        try {
            String currentDir = System.getProperty("user.dir");
            String Screenshotpath = currentDir + "/res/snapshot/";
            File scrFile = ((TakesScreenshot) WebDriverFactory.getIOSDriver()).getScreenshotAs(OutputType.FILE);
            String imgFile = Screenshotpath + testMethodName + Instant.now().toEpochMilli() + ".jpg";
            File imgf = new File(imgFile);
            FileUtils.copyFile(scrFile, new File(imgFile));
            System.out.println("Screenshot captured");
            return toByteArray(imgf);
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot : " + e.getMessage());
        }
        return new byte[0];
    }

    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {

        iHookCallBack.runTestMethod(iTestResult);
        try {
            screenshotattach(iTestResult.getMethod().getMethodName());
        } catch (Exception e) {
            System.out.println("Here is the error" + e);
        }
    }

    @BeforeMethod(alwaysRun=true)
    public void beforeMethod(Method method) {
        //logger.info(" >>>>>>>>> Executing Test case : " + method.getName() + ">>>>>>>>>>");
    }

    @AfterMethod(alwaysRun=true)
    public void afterMethod(Method method) {
       // logger.info(" >>>>>>>>> Execution completed for Test case : " + method.getName() + ">>>>>>>>>>");
    }

    private static byte[] toByteArray(File file) throws IOException {
        return Files.readAllBytes(Paths.get(file.getPath()));
    }

    @AfterClass
    public void afterClass() {
        WebDriverFactory.quitDriver();
    }
}