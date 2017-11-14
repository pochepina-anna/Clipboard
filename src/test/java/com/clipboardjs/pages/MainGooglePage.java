package com.clipboardjs.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс <class>MainGooglePage</class>
 */

public class MainGooglePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='lst-ib']")
    private WebElement findInput;

    @FindBy(xpath = "//input[contains(concat(' ',@value,' '),'Поиск в Google')]")
    private WebElement findButton;

    public MainGooglePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void setFindInput(String find){
        findInput.clear();
        findInput.sendKeys(find);
    }

    public String getFindInput(){
        return findInput.getAttribute("value");
    }

    public void findButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(findButton)).click();
    }


}
