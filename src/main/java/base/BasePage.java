package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.function.Function;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions act;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) this.driver;
        act = new Actions(this.driver);
    }


//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    JavascriptExecutor js = (JavascriptExecutor) driver;



    public WebElement getElement(By locator){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        //driver.findElement(locator).click();
        element.click();
    }

    public void click(WebElement ele){
        //driver.findElement(locator).click();
        ele.click();
    }

    public void type(By locator, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        getElement(locator).sendKeys(value);
    }
    public void typeAndEnter(By locator, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        getElement(locator).sendKeys(value + Keys.ENTER);
    }

    public void moveToElement(By locator){
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        act.moveToElement(ele).perform();
    }

    public void dblClick(By locator){
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        act.doubleClick(ele).perform();
    }

    public void scrollToElment(WebElement element){

        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void scrollToBottom(){

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollToTop(){

        js.executeScript("window.scrollTo(0,0)");
    }
}
