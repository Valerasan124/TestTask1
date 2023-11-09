package org.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.steps.Base;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import static io.ous.jtoml.impl.Token.TokenType.Key;

public class ProfilePage extends Base {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = ".//div[@aria-label='valeriy.testmail@mail.ru']")
    WebElement profileButton;

    @FindBy(xpath = ".//a[contains(@class,'ph-item ph-item__social svelte-1popff4') and contains(@href,'https://id.mail.ru/profile')]")
    WebElement personalDataButton;

    @FindBy(xpath = ".//div[@class='navigationItemBody-0-2-71']//span[contains(text(),'Все настройки')]")
    WebElement allSettingsButton;

    @FindBy(xpath = ".//h4[contains(text(),'Имя и подпись')]")
    WebElement nameSignButton;

    @FindBy(xpath = ".//div[@class='Signature__actions--1bVNA Signature__actionsMain--3S6CG']//button")
    WebElement editButton;

    @FindBy(xpath = ".//div[@contenteditable='true']/div")
    WebElement signField;

    @FindBy(xpath = ".//button[@type='submit']")
    WebElement saveButton;

    @FindBy(xpath = ".//a[contains(text(),'Почта')]")
    WebElement mailButton;



    /**
     * Кликаем на иконку профиля.
     */
    public void clickProfileButton() {
        click(profileButton);
    }


    /**
     * Кликаем на кнопку "Личные данные".
     */
    public void clickPersonalDataButton() {
        click(personalDataButton);
    }


    /**
     * Кликаем по кнопке "Все настройки".
     */
    public void clickAllSettingsButton() {
        click(allSettingsButton);
    }


    /**
     * Кликаем на кнопку "Имя и подпись".
     */
    public void clickNameSignButton() {
        click(nameSignButton);
    }


    /**
     * Кликаем на кнопку редактирования подписи.
     */
    public void clickEditButton() {
        click(editButton);
    }


    /**
     * Вводим новый текст подписи.
     *
     * @param textSign
     */
    public void setSignField(String textSign) {
        setText(signField, textSign);
    }


    /**
     * Удаляем старую подпись после указания новой.
     */
    public void deletePreviousSign() {
        super.sendKeys(signField);
    }


    /**
     * Кликаем на кнопку "Сохранить" в МО "Редактирование подписи"
     */
    public void clickSaveButton() {
        click(saveButton);
    }


    /**
     * Кликаем на кнопку почты
     */
    public void clickMailButton() {
        click(mailButton);
    }


    /**
     * Генерируем случайную последовательность букв для подписи.
     *
     * @return
     */
    public static String randomSign() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}

