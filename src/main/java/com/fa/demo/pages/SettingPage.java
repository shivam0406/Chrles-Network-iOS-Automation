package com.fa.demo.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.ActionOptions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

import java.util.HashMap;

public class SettingPage extends BasePage {


    final static Logger logger = Logger.getLogger(SettingPage.class);

    private static final By WIFI = MobileBy.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[5]");
    private static final By INFO_BUTTON = MobileBy.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeButton[1]");
    private static final By AUTO = MobileBy.name("Auto");
    private static final By PROXY_VALUE = MobileBy.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeTextField[7]/XCUIElementTypeTextField[1]");
    private static final By PROXY_VALUE2 = MobileBy.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeTextField[7]/XCUIElementTypeTextField[1]/XCUIElementTypeTextField[1]");
    private static final By URL = MobileBy.name("URL");
    private static final By BACK = MobileBy.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]");

    public SettingPage() {
        assertCurrentPage(WIFI);
        logger.info("Lended on setting page successfully");
    }

    public SettingPage openWifiOption() {
        clickElement(WIFI);
        return this;
    }

    public SettingPage clickOnMoreOptions() {
        waitAndClickElement(INFO_BUTTON, 5);
       // clickElement(INFO_BUTTON);
        return this;
    }

    public SettingPage clickOnAutoandEnterProxy() throws InterruptedException {
       // driver.performTouchAction(new TouchAction(driver)).press(200,200).waitAction().moveTo(400,400).release().perform();
//        String d = new Dictionary<string, string> { { "direction", "left" } };
//        driver.ExecuteScript("mobile: swipe", d);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        HashMap<String, String> scrollObject = new HashMap<String, String>();
//        scrollObject()
        Thread.sleep(10000);
        //driver.performTouchAction()
        clickElement(AUTO);
        waitForPresence(URL);
        Point p = driver.findElement(URL).getLocation();
        System.out.println(p);
       // waitForPresence(PROXY_VALUE2);
        setValueswithHideKeyboard(PROXY_VALUE,"https://chls.pro/192.168.0.107.pac");
        return this;
    }

}
