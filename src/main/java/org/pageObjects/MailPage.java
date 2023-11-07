package org.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.steps.Base;

public class MailPage extends Base {

    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//span[@class='compose-button__wrapper']")
    WebElement writLetterButton;

    @FindBy(xpath = ".//span[contains(text(),'Отправить')]")
    WebElement sendLetterButton;

    @FindBy(xpath = ".//input[@tabindex='100']")
    WebElement fieldToWhom;

    @FindBy(xpath = ".//input[@tabindex='400']")
    WebElement fieldSubject;

    @FindBy(xpath = ".//button[@tabindex='500']")
    WebElement attachFileButton;

    @FindBy(xpath = ".//div[@role='textbox']/div")
    WebElement textField;

    @FindBy(xpath = ".//div[@data-signature-widget='content']")
    WebElement signField;

    @FindBy(xpath = ".//span[@title='Закрыть']")
    WebElement closeButton;


    /**
     * Нажимаем кнопку "Написать письмо".
     */
    public void clickWritLetterButton() {
        click(writLetterButton);
    }



    public void assertMailForm(){
        String xpath = ".//span[contains(text(),'Отправить')]";

        Assert.assertTrue(waitVisiblyElements(xpath));
    }




    /**
     * Вводим значение в поле "Кому".
     *
     * @param toWhom
     */
    public void setFieldToWhom(String toWhom) {
        setText(fieldToWhom, toWhom);
    }


    /**
     * Вводим значение в поле "Тема".
     *
     * @param subject
     */
    public void setFieldSubject(String subject) {
        setText(fieldSubject, subject);
    }


    /**
     * Указываем ссылку на файл. И прикрепляем
     *
     * @param urlFile
     */
    public void attachFile(String urlFile) {
        setText(attachFileButton, urlFile);
    }


    /**
     * Вводим текст письма в поле ввода.
     */
    public void setTextField(String textMail){
        setText(textField, textMail);
    }


    /**
     * Кликаем на кнопку "отправить".
     */
    public void clickSendLetterButton(){
        click(sendLetterButton);
    }


    /**
     * Кликаем по крестику всплывающего окна после отправки письма.
     */
    public void clickCloseButton(){
        click(closeButton);
    }

}
