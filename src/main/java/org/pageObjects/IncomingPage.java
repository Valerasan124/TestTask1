package org.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.steps.Base;

public class IncomingPage extends Base {
    public IncomingPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = ".//a[contains(@class,'llc llc_normal llc_first')]")
    WebElement firstMail;

    @FindBy(xpath = ".//span[@class='button2__explanation button2__explanation_ellipsis']")
    WebElement selectAllButton;

    @FindBy(xpath = ".//span[@title='Удалить']")
    WebElement deliteButton;

    @FindBy(xpath = ".//span[text()='Писем нет']")
    WebElement findMail;

    @FindBy(xpath = ".//div[@class='layer__submit-button']")
    WebElement clearButton;

    /**
     * Проверяем наличие письма с указанной темой.
     *
     * @param text
     */
    public void assertSubject(String text) {
        String xpath = ".//span[text()='" + text + "']";

        Assert.assertTrue(waitVisiblyElements(xpath));
    }


    /**
     * Ищем элемент с текстом "Писем нет",
     * который свидетельствует об отсутствии писем.
     */
    public void findMailOnPage() {
        waitVisiblyElements(findMail);
    }


    /**
     * Кликаем по первому письму для перехода к его просмотру.
     */
    public void clickFirstMail() {
        click(firstMail);
    }


    /**
     * Кликаем на кнопку "Выделить всё".
     */
    public void clickSelectAllButton() {
        click(selectAllButton);
    }


    /**
     * Кликаем на кнопку удалить.
     */
    public void clickDeliteButton() {
        click(deliteButton);
    }


    /**
     * Кликаем на кнопку очистить.
     */
    public void clickClearButton(){
        click(clearButton);
    }
}
