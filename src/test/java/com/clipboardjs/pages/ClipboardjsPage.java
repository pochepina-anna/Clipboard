package com.clipboardjs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс <class>ClipboardjsPage</class>
 */
public class ClipboardjsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='example-target']//button")
    private WebElement clipboardButton;

    @FindBy(xpath = "//*[@id='foo']")
    private WebElement exampleInput;

    public ClipboardjsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getExempleInput(){
        return exampleInput.getAttribute("value");
    }

    public void setExempleInput(String str){
        exampleInput.clear();
        exampleInput.sendKeys(str);
    }

    public void clipboardButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(clipboardButton)).click();
    }
}
