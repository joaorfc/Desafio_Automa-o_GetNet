package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DefaultActions {

    int timeout = 20;
    public WebDriver driver;
    private WebDriverWait wait;

    public DefaultActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

    public void navega(String url) {
        this.driver.get(url);
    }

    private By feedBackPanelInfo = By.xpath("//ul[@class='feedbackPanel']/li[@class='feedbackPanelINFO']");

    private  By feedBackPanelModalInfo = By.xpath("//div/div/div/div/div[2]/div/div");

    public void waitForElementPresent(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementEnabled(By locator) {
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator)));
    }

    public void waitForElementVisibled(By locator) {
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public void waitForElementsPresents(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitForElementsVisibles(By locator) {
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfAllElementsLocatedBy(locator),
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
    }

    public void waitAndClick(By elementLocator) {
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(elementLocator),
                ExpectedConditions.visibilityOfElementLocated(elementLocator),
                ExpectedConditions.elementToBeClickable(elementLocator)));
        //driver.findElement(elementLocator).click();
    }

    public void waitElementToBeClickable(By locator) {
        waitForElementsVisibles(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickAndWait(By elementToClick, By elementToWait) {
        waitElementToBeClickable(elementToClick);
        driver.findElement(elementToClick).click();
        waitForElementsVisibles(elementToWait);
    }


    public WebElement getGridConsulta() {
        waitForElementPresent(By.tagName("table"));
        waitForElementsVisibles(By.tagName("table"));
        return driver.findElement(By.tagName("table"));
    }


    public void changeWindowHandle() {

        System.out.println(driver.getWindowHandle());

        for (String winHandle : driver.getWindowHandles()) {
            System.out.println(winHandle);
            driver.switchTo().window(winHandle);
        }
    }

    public String retornaMensagemModalInfo(){
        waitForElementsVisibles(feedBackPanelModalInfo);
        return driver.findElement(feedBackPanelModalInfo).getText();
    }

    public void realizarScroll(int xhorizontal, int xvertical) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + xhorizontal + "," + xvertical + ")");
    }

    public void sleep(Long milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
