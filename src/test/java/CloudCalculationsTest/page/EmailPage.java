package CloudCalculationsTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
    public WebDriver driver;

    public EmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver= driver; }

        @FindBy (xpath = "//div[@id='eposta_adres']")
        WebElement copyAddressButton;

        @FindBy (xpath = "//li[contains (., 'Google Cloud Platform Price Estimate')]")
        WebElement emailHeader;



        public void copyAddressButtonClick () {copyAddressButton.click();}
        public void emailHeaderClick(){emailHeader.click();}
        //void getPrice (String price) {priceCalculated.getText(price);}

}

