package CloudCalculationsTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailMessagePage {
    public WebDriver driver;

    public EmailMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id='mobilepadding']//h3[contains (., 'USD')]")
    WebElement priceCalculated;

    String price;

    {
        price = priceCalculated.getText();
    }
}
