package org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.steps.Base;

public class BasePage extends Base {


    private final static String USER_EMAIL = "valeriy.testmail";
    private final static String USER_PASSWORD = "RyTmkYO33ui]";


    public BasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//button[contains(text(),'Войти')]")
    WebElement buttonEnterInMail;

    @FindBy(xpath = ".//input[@name='username']")
    WebElement userNameField;

    @FindBy(xpath = ".//span[contains(text(),'Ввести пароль')]")
    WebElement buttonEnterPass;

    @FindBy(xpath = ".//input[@name='password']")
    WebElement passField;

    @FindBy(xpath = ".//button[@data-test-id='submit-button']")
    WebElement buttonEnter;


    /**
     * Ищем iframe окна ввода логина и пароля.
     */
    @FindBy(xpath = ".//iframe[contains(@src,'https://acc')]")
    public WebElement fr1;


    /**
     * Кликаем на кнопку войти в почту.
     */
    public void clickButtonEnterInMail() {
        click(buttonEnterInMail);
    }


    /**
     * Вводим имя аккаунта в поле ввода.
     */
    public void setAccInUserNameField() {
        setText(userNameField, USER_EMAIL);
    }


    /**
     * Нажимаем кнопку ввести пароль.
     */
    public void clickButtonEnterPass() {
        click(buttonEnterPass);
    }


    /**
     * Вводим пароль в полеп ввода пароля.
     */
    public void setPassField() {
        setText(passField, USER_PASSWORD);
    }


    /**
     * Нажимаем кнопку Войти.
     */
    public void clickButtonEnter() {
        click(buttonEnter);
    }
}
