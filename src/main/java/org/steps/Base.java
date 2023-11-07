package org.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }


    public String nowWindowHandle(){
        String winHandleBefore = driver.getWindowHandle();

        return winHandleBefore;
    }


    public void click(WebElement element){
        waitVisiblyElements(element);

        element.click();
    }

    public boolean waitVisiblyElements(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }


    public void setText(WebElement element, String text){
        waitVisiblyElements(element);

        element.sendKeys(text);
    }


    public boolean waitVisiblyElements(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }



}
