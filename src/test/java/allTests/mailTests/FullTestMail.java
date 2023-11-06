package allTests.mailTests;

import allTests.BaseDriverClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pageObjects.BasePage;
import org.pageObjects.MailPage;

public class FullTestMail extends BaseDriverClass {


    @Test
    public void startTest() {


        getDriver().get("https://mail.ru/");
        getDriver().manage().window().maximize();
        BasePage basePage = new BasePage(getDriver());

        basePage.clickButtonEnterInMail();
        basePage.waitVisiblyElements(".//iframe[contains(@src,'https://acc')]");
        getDriver().switchTo().frame(basePage.fr1);
        basePage.setAccInUserNameField();
        basePage.clickButtonEnterPass();
        basePage.setPassField();
        basePage.clickButtonEnter();
        getDriver().switchTo().defaultContent();

        MailPage mailPage = new MailPage(getDriver());
        mailPage.clickWritLetterButton();
        mailPage.setFieldToWhom("valeriy.testmail@mail.ru");
        mailPage.setFieldSubject("Тема 1");
        mailPage.attachFile("https://docs.google.com/document/d/1zC5-r92sbfPVxEEU5rfG_uiKZxDscSmZ0lZG2z0RK44/edit?usp=sharing");
        mailPage.setTextField("Текст письма");
        mailPage.clickSendLetterButton();

    }
}
