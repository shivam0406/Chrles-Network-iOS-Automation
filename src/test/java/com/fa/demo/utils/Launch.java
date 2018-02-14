package com.fa.demo.utils;

import com.fa.demo.AppProperties;
import com.fa.demo.IOSBaseTest;
import com.fa.demo.pages.SettingPage;
import com.fa.demo.utils.WebDriverFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Launch extends IOSBaseTest {

    AppProperties appProperties = null;

    @BeforeClass
    public void beforeClass() throws Exception {
        appProperties = new AppProperties();
        appProperties.loadSampleAppProperties("setting.properties");
        WebDriverFactory.createIOSDriver(appProperties);
        WebDriverFactory.getIOSDriver().launchApp();
    }


@Test
public void test() throws InterruptedException {
    SettingPage settingPage = new SettingPage();
    settingPage
            .openWifiOption()
            .clickOnMoreOptions()
            .clickOnAutoandEnterProxy();
}
}
