package CloudCalculationsTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudSearchResults {
    public WebDriver driver;

    public CloudSearchResults(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//div[@class='gsc-thumbnail-inside']//b[text()[contains (., 'Google Cloud Platform Pricing Calculator')]]")
    WebElement searchResult;

    public void searchResultClick () {searchResult.click(); }


}
