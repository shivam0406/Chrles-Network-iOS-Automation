package com.fa.demo.pages;

import com.fa.demo.exceptions.PageNotCurrentException;
import com.fa.demo.utils.TestUtils;
import com.fa.demo.utils.WebDriverFactory;
import io.appium.java_client.ios.IOSDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    final static Logger logger = Logger.getLogger(BasePage.class);
    IOSDriver driver = WebDriverFactory.getIOSDriver();
    final int DEFAULT_WAIT_TIME_FOR_ELEMENT = 30;

    public void assertCurrentPage(By pageIdentifier) {
        try{
            waitForPresence(pageIdentifier);
        } catch (Exception e) {
            throw new PageNotCurrentException(TestUtils.getCallerClassNameFromThread() + " is not the current app", e);
        }
    }

    public void waitForPresence(By locator) {
        waitForPresence(locator, DEFAULT_WAIT_TIME_FOR_ELEMENT);
    }

    public void waitForPresence(By locator, int waitTimeInSec) {
        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSec);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public void waitForNotPresence(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME_FOR_ELEMENT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }


    public void setValueswithHideKeyboard(By locator, String values){
        WebElement element = driver.findElement(locator);
        element.click();
        element.sendKeys(values);
        driver.hideKeyboard();
    }

    public void waitAndClickElement(By locator, int waitTimeInSec) {
        WebElement element = waitAndFindElement(locator, waitTimeInSec);;
        element.click();
    }

    public BasePage syncAction(long milliSec) throws InterruptedException {
        Thread.sleep(milliSec);
        return this;
    }

    public String getText(By locator){
        String conflictName = driver.findElement(locator).getText();
        return conflictName;
    }
    public void clickElement(WebElement element) {
        element.click();
    }

    public boolean isElementPresent(By by) {
        List<WebElement> eleList = driver.findElements(by);
        if (eleList.size() > 0)
            return true;
        return false;
    }

    public WebElement waitAndFindElement(By locator) {
        waitForPresence(locator);
        logger.info("Wait for element succeeded");
        return driver.findElement(locator);
    }

    public WebElement waitAndFindElement(By locator, int waitTimeInSec) {
        waitForPresence(locator, waitTimeInSec);
        logger.info("Wait for element succeeded");
        return driver.findElement(locator);
    }
}
