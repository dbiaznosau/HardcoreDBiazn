package CloudCalculationsTest.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudLandingPage {

    public WebDriver driver;
//main page of google cloud service
    public CloudLandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@name='q']")
    WebElement searchButton;

    public void searchButtonPress () {searchButton.click(); }
    public void searchButtonInputText (String text) {searchButton.sendKeys(text);}
    public void searchGo () {searchButton.sendKeys(Keys.ENTER);};
}