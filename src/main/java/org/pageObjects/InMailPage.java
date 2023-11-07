package org.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.steps.Base;

public class InMailPage extends Base {
    public InMailPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = ".//a[@data-name='download-link']")
    WebElement downloadAttach;

    @FindBy(xpath = ".//a[contains(@title, 'Входящие')]")
    WebElement incomingButton;

    /**
     * Проверяем что тема в письме соответствует указанно при отправке.
     *
     * @param text
     */
    public void assertSubject(String text) {
        String xpath = ".//h2[contains(text(),'" + text + "')]";

        Assert.assertTrue(waitVisiblyElements(xpath));
    }


    /**
     * Проверяем что текст письма соответствует указанному при отправке.
     *
     * @param text
     */
    public void assertTextField(String text) {
        String xpath = ".//div[contains(text(),'" + text + "')]";

        Assert.assertTrue(waitVisiblyElements(xpath));
    }


    /**
     * Проверяем подпись на соответствие новой.
     * @param text
     */
    public void assertSignInMail(String text) {
        String xpath = ".//div[@data-signature-widget='content']/div[contains(text(),'" + text + "')]";

        Assert.assertTrue(waitVisiblyElements(xpath));
    }


    /**
     * Кликаем по кнопке скачать у аттача.
     */
    public void clickDownloadAttach() {
        click(downloadAttach);
    }


    /**
     * Кликаем на кнопку "входящие" для перехода к письмам.
     */
    public void clickIncomingButton(){
        click(incomingButton);
    }

}


