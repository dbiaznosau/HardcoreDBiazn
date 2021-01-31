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

        @FindBy (xpath = "//div[@id='copy_address']")
        WebElement copyAddressButton;

        @FindBy (xpath = "//div[contains (@class, 'message_top') and contains (., 'Google Cloud Platform Price Estimate')]")
        WebElement emailHeader;

        public void copyAddressButtonClick () {copyAddressButton.click();}
        public void emailHeaderClick(){emailHeader.click();}
}

