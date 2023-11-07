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


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FullTestMail extends BaseDriverClass {
    String mailToWhom = "valeriy.testmail@mail.ru";
    String subject = "Тема Письма";
    String subjectNew = "Новая тема письма";
    String pathToFile = "C:\\testDoc.txt";
    String textField = "Текст письма тест тест тест";
    String textFieldNew = "Текст письма после изменения подписи";
    String textSign = ProfilePage.randomSign();


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
        mailPage.assertMailForm();
        mailPage.setFieldToWhom(mailToWhom);
        mailPage.setFieldSubject(subject);
        getDriver().findElement(By.xpath(".//input[@wfd-id=\"id2\"]")).sendKeys(pathToFile);
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


        Set<String> handles = driver.getWindowHandles();
        if (handles.size() == 2) {
            Iterator<String> itr = handles.iterator();

            String parent_window = itr.next().toString();
            String child_window = itr.next().toString();
            System.out.println(parent_window);
            System.out.println(child_window);

            driver.switchTo().window(child_window);
        }


        profilePage.clickNameSignButton();
        profilePage.clickEditButton();
        profilePage.setSignField(textSign);

        driver.findElement(By.xpath(".//div[@contenteditable='true']/div"))
                .sendKeys(Keys.LEFT_SHIFT, Keys.END, Keys.DELETE);

        profilePage.clickSaveButton();
        profilePage.clickMailButton();


        mailPage.clickWritLetterButton();
        mailPage.assertMailForm();
        mailPage.setFieldToWhom(mailToWhom);
        mailPage.setFieldSubject(subjectNew);
        getDriver().findElement(By.xpath(".//input[@wfd-id=\"id2\"]")).sendKeys(pathToFile);
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


