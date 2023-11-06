package org.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.steps.Base;

public class IncomingPage extends Base {
    public IncomingPage(WebDriver driver) {
        super(driver);
    }


//    @FindBy(xpath = "")


    /**
     * Проверяем наличие письма с указанной темой.
     * @param text
     */
    public void assertTextTranslate(String text) {
        String xpath = ".//span[contains(text(),'" + text + "')]";

        Assert.assertTrue(waitVisiblyElements(xpath));
    }
}
