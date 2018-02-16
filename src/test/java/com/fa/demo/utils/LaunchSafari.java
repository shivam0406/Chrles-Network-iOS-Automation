package com.fa.demo.utils;

import com.fa.demo.AppProperties;
import com.fa.demo.IOSBaseTest;
import com.fa.demo.pages.SafariPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchSafari extends IOSBaseTest {

    AppProperties appProperties = null;

    @BeforeClass
    public void beforeClass() throws Exception {
        appProperties = new AppProperties();
        appProperties.loadSampleAppProperties("safari.properties");
        WebDriverFactory.createIOSDriver(appProperties);
        WebDriverFactory.getIOSDriver().launchApp();
    }


    @Test
    public void test() throws InterruptedException {
        SafariPage safariPage = new SafariPage();
        safariPage
                .navigateTo()
                .getAllSpeed()
                .speedTest();
        Thread.sleep(10000);
        System.out.println("Launched safari");
    }
}