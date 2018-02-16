package com.fa.demo.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.ActionOptions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;

public class SettingPage extends BasePage {


    final static Logger logger = Logger.getLogger(SettingPage.class);

    private static final By WIFI = MobileBy.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[5]");
    private static final By INFO_BUTTON = MobileBy.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeButton[1]");
    private static final By AUTO = MobileBy.name("Auto");
    private static final By INFO_XPATH = MobileBy.xpath("(//XCUIElementTypeButton[@name=\"More Info\"])[1]");
    private static final By PROXY_VALUE = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"URL\"]");
    private static final By PROXY_VALUE2 = MobileBy.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeTextField[7]");
    private static final By URL = MobileBy.name("URL");
    private static final By BACK = MobileBy.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]");

    public SettingPage() {
        assertCurrentPage(WIFI);
        logger.info("Landed on setting page successfully");
    }

    public SettingPage openWifiOption() {
        clickElement(WIFI);
        return this;
    }

    public SettingPage clickOnMoreOptions() {
        waitAndClickElement(INFO_XPATH, 10);
       // clickElement(INFO_BUTTON);
        return this;
    }

    public SettingPage clickOnAutoandEnterProxy() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
        clickElement(AUTO);
        waitForPresence(URL);
        setValueswithHideKeyboard(PROXY_VALUE2, "https://chls.pro/10.10.60.124.pac");
        clickElement(BACK);
        return this;
    }
}
