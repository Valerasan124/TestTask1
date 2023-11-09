package allTests.mailTests;

import allTests.BaseDriverClass;
import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pageObjects.*;
import org.steps.Base;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;


public class FullTestMail extends BaseDriverClass {
    Base base = new Base();

    String mailToWhom = "valeriy.testmail@mail.ru";
    String subject = "Тема Письма";
    String subjectNew = "Новая тема письма";
    String absolutePath = base.getAbsolutePathFile("testDoc.txt");
    String textField = "Текст письма тест тест тест";
    String textFieldNew = "Текст письма после изменения подписи";
    String textSign = ProfilePage.randomSign();



    @Test
    public void startTest() {

        getDriver().get("https://mail.ru/");
        getDriver().manage().window().maximize();

        BasePage basePage = new BasePage(getDriver());

        basePage.clickEnterInMailButton();
        getDriver().switchTo().frame(basePage.fr1);
        basePage.setAccInUserNameField();
        basePage.clickButtonEnterPass();
        basePage.setPassField();
        basePage.clickButtonEnter();
        getDriver().switchTo().defaultContent();


        MailPage mailPage = new MailPage(getDriver());

        mailPage.clickWritLetterButton();
        mailPage.assertMailForm();
        mailPage.setFieldToWhom(mailToWhom);
        mailPage.setFieldSubject(subject);
        mailPage.setAttachFile(absolutePath);
        mailPage.setTextField(textField);
        mailPage.clickSendLetterButton();
        mailPage.clickCloseButton();


        IncomingPage incomingPage = new IncomingPage(getDriver());

        incomingPage.assertSubject(subject);
        incomingPage.clickFirstMail();


        InMailPage inMailPage = new InMailPage(getDriver());

        inMailPage.assertSubject(subject);
        inMailPage.assertTextField(textField);
        inMailPage.clickDownloadAttach();


        ProfilePage profilePage = new ProfilePage(getDriver());

        profilePage.clickProfileButton();
        profilePage.clickPersonalDataButton();
        profilePage.clickAllSettingsButton();

        //Переводим фокус на новую вкладку
        basePage.moveToNextTab(1);

        profilePage.clickNameSignButton();
        profilePage.clickEditButton();
        profilePage.setSignField(textSign);
        profilePage.deletePreviousSign();
        profilePage.clickSaveButton();
        profilePage.clickMailButton();


        mailPage.clickWritLetterButton();
        mailPage.assertMailForm();
        mailPage.setFieldToWhom(mailToWhom);
        mailPage.setFieldSubject(subjectNew);
        mailPage.setAttachFile(absolutePath);
        mailPage.setTextField(textFieldNew);
        mailPage.clickSendLetterButton();
        mailPage.clickCloseButton();


        incomingPage.assertSubject(subjectNew);
        incomingPage.clickFirstMail();


        inMailPage.assertSubject(subjectNew);
        inMailPage.assertTextField(textFieldNew);
        inMailPage.clickDownloadAttach();
        inMailPage.assertSignInMail(textSign);
        inMailPage.clickIncomingButton();


        incomingPage.clickSelectAllButton();
        incomingPage.clickDeliteButton();
        incomingPage.clickClearButton();
        incomingPage.findMailOnPage();
    }
}


