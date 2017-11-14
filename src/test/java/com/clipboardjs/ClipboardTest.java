package com.clipboardjs;

import com.clipboardjs.helpers.DriverSetUp;
import com.clipboardjs.pages.ClipboardjsPage;
import com.clipboardjs.pages.MainGooglePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

/**
 * Класс <class>ClipboardTest</class>
 */
public class ClipboardTest extends DriverSetUp {

    private static final String URL_CLIPBOARD = "https://clipboardjs.com/";
    private static final String URL_GOOGLE = "https://www.google.com/";

    private ClipboardjsPage clipboardjsPage = new ClipboardjsPage(driver);
    private MainGooglePage mainGooglePage = new MainGooglePage(driver);

    @Test
    public void clipboardGetSet()throws Exception {
        openMainPage(driver,URL_CLIPBOARD);
        clipboardjsPage.clipboardButtonClick();
        Assert.assertTrue("ClipboardText and InputText is not equal!",getData().equals(clipboardjsPage.getExempleInput()));
        openMainPage(driver,URL_GOOGLE);
        setData("ClipboardText");
        mainGooglePage.setFindInput(getData());
        System.out.println("Input="+mainGooglePage.getFindInput());
        mainGooglePage.findButtonClick();
        Assert.assertTrue("ClipboardText and FindText is not equal!",getData().equals(mainGooglePage.getFindInput()));
    }

    private void openMainPage(WebDriver driver, String url) {
        driver.get(url);
    }

    public void setData(String data){
        StringSelection stringSelection = new StringSelection(data);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public String getData() throws Exception {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }
}
