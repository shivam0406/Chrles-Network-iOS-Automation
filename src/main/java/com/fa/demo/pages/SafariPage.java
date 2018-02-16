package com.fa.demo.pages;

import io.appium.java_client.MobileBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SafariPage extends BasePage {

    final static Logger logger = Logger.getLogger(SettingPage.class);
    private static final By THRROTTLING = MobileBy.xpath("//html/body/ul/li[1]/a");
   // private static final By THROTTLING_STOPPED = MobileBy.xpath("//html/body/p");
    private static final By ACTIVATE = MobileBy.xpath("//html/body/form[1]/input");
    private static final By PRESET = MobileBy.name("preset");



    public SafariPage navigateTo() {
        driver.get("http://control.charles");
        waitAndClickElement(THRROTTLING, 5);
        System.out.println("Element is present ");
        return this;
    }

    public SafariPage getAllSpeed() {
        waitForPresence(PRESET);
        WebElement element = driver.findElement(By.name("preset"));
        Select select = new Select(element);
        select.selectByIndex(3);
        waitAndClickElement(ACTIVATE, 5);
        return this;
    }

    public SafariPage speedTest() throws InterruptedException {
        driver.get("http://fast.com");
        Thread.sleep(20000);
        System.out.println("Speed Test Done");
        return this;
    }


}
