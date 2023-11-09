package org.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Base() {

    }


    /**
     * Получаем абсолютный путь до файла в папке resources
     * @param path
     * @return
     */
    public String getAbsolutePathFile(String path) {
        URL res = getClass().getClassLoader().getResource(path);
        File file;

        {
            try {
                file = Paths.get(res.toURI()).toFile();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        String absolutePath = file.getAbsolutePath();
        return absolutePath;
    }


    /**
     * Метод клика по элементу
     *
     * @param element
     */
    public void click(WebElement element) {
        waitVisiblyElements(element);

        element.click();
    }


    /**
     * Метод ожидания элемента на странице
     *
     * @return
     */
    public boolean waitVisiblyElements(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * Метод ввода текста в элемент страницы
     *
     * @param element
     * @param text
     */
    public void setText(WebElement element, String text) {
        waitVisiblyElements(element);

        element.sendKeys(text);
    }


    /**
     * Очищаем элементы справа от курсоа.
     */
    public void sendKeys(WebElement element) {
        element.sendKeys(Keys.LEFT_SHIFT, Keys.END, Keys.DELETE);
    }


    /**
     * Прикрепляем файл
     */
    public void attachFile(WebElement element, String dir) {
        element.sendKeys(dir);
    }


    /**
     * Метод ожидания элемента на странице по xpath
     *
     * @param xpath
     * @return
     */
    public boolean waitVisiblyElements(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * Метод переключения на нужную вкладку. Вернёт список вкладок.
     *
     * @param number
     * @return
     */
    public ArrayList<String> moveToNextTab(int number) {

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(number));

        return tabs;
    }


    /**
     * Метод переключения на новую вкладку. Вернёт список вкладок.
     *
     * @param
     * @return
     */
    public ArrayList<String> moveToNextTab() {

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return tabs;
    }


    /**
     * Закроет текущюю вкладку и переведёт фокус на предыдущую
     */
    public void closeNewTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));

    }


}
