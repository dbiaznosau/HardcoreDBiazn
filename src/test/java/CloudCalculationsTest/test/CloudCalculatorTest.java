package CloudCalculationsTest.test;

import CloudCalculationsTest.page.CloudCalculator;
import CloudCalculationsTest.page.CloudLandingPage;
import CloudCalculationsTest.page.CloudSearchResults;
import CloudCalculationsTest.page.EmailPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CloudCalculatorTest {

    public static WebDriver calculatorDriver;
    public static WebDriver emailDriver;

    @BeforeClass
    public static void init() {
        calculatorPageWindow();
        emailPageWindow();
    }
    /*
        Here I will open two browser windows at the start of the testing process.
        I think, in the next cases I can move call of the second window to the middle the case,
         but his time I decided to leave it as is.
     */
    public static void calculatorPageWindow() {
        calculatorDriver = new ChromeDriver();
        calculatorDriver.manage().window().maximize();
        calculatorDriver.get(ConfProperties.getProperty("cloudPage"));
        }

    public static void emailPageWindow() {
        emailDriver = new ChromeDriver();
        emailDriver.manage().window().maximize();
        emailDriver.get(ConfProperties.getProperty("emailServicePage"));
        emailDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

    @Test
    public void cloudCalculatorTest(){

        //landing page for Google Cloud
        new WebDriverWait(calculatorDriver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        CloudLandingPage cloudLandingPage = new CloudLandingPage(calculatorDriver);

        cloudLandingPage.searchButtonPress();
        cloudLandingPage.searchButtonInputText(ConfProperties.getProperty("searchRequest"));
        cloudLandingPage.searchGo();

        //search results page
        new WebDriverWait(calculatorDriver, 15).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='gsc-thumbnail-inside']//b[text()[contains (., 'Google Cloud Platform Pricing Calculator')]]")));

        CloudSearchResults cloudSearchResults = new CloudSearchResults(calculatorDriver);
        cloudSearchResults.searchResultClick();

        //calculator page
        //wait until main iFrame is loaded
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        //switch to the frame that contains necessary elements
        calculatorDriver.switchTo().frame(calculatorDriver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        calculatorDriver.switchTo().frame(calculatorDriver.findElement(By.xpath("//iframe[@id='myFrame']")));

        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//md-tab-item[child::div[contains(.,'Compute Engine')]]")));

        //start to enter required data into the fields
        CloudCalculator cloudCalculator = new CloudCalculator(calculatorDriver);

        cloudCalculator.computerEngineSelect();

        cloudCalculator.numberOfInstancesClick();
        cloudCalculator.numberOfInstancesInput("4");

        cloudCalculator.operatingSystemLabelClick();
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_65']")));
        cloudCalculator.operatingSystemOptionSelect();

        cloudCalculator.machineClassClick();
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_78']")));
        cloudCalculator.machineClassOptionSelect();

        cloudCalculator.seriesClick();
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_188']")));
        cloudCalculator.seriesOptionSelect();

        cloudCalculator.machineTypeLabelClick();
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_360']")));
        cloudCalculator.machineTypeOptionSelect();

        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@ng-if='listingCtrl.showComputeEngine']//*[contains(text(), 'Add GPUs.')]")));
        cloudCalculator.addGpuCheckboxClick();

        cloudCalculator.numberOfGpuClick();
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_399']")));
        cloudCalculator.numberOfGpuSelect();

        cloudCalculator.gpuTypeClick();
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_406']")));
        cloudCalculator.gpuTypeSelect();

        cloudCalculator.localSSDClick();
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_381']")));
        cloudCalculator.localSSDSelect();

        cloudCalculator.datacenterClick();
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_205']")));
        cloudCalculator.datacenterSelect();

        cloudCalculator.commitUsageClick();

        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_97']")));
        cloudCalculator.commitUsageSelect();


        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@name='ComputeEngineForm']//*[@aria-label='Add to Estimate']")));
        cloudCalculator.estimateButtonClick();

        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='resultBlock']")));
        cloudCalculator.emailEstimateButtonClick();

        //check that email form is opened
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@name='emailForm']")));

        //create new emailPage element to call procedures
        EmailPage emailPage = new EmailPage(emailDriver);

        //click Copy Email button
        emailPage.copyAddressButtonClick();

        //paste copied email address
        cloudCalculator.sendEmailFieldInput(Keys.CONTROL + "v"); //get temporary email

        //send email to pasted address
        new WebDriverWait(calculatorDriver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains (.,'Send Email')]")));
        cloudCalculator.sendEmailButtonClick();

        //open email with price
        new WebDriverWait(emailDriver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains (@class, 'message_top') and contains (., 'Google Cloud Platform Price Estimate')]")));
        emailPage.emailHeaderClick();

        //compare that text on the calculator page has sent price in it
        String priceDisplayed = calculatorDriver.findElement(By.xpath("//*[@id='resultBlock']//h2[contains (., 'USD')]")).getText();
        String priceEmailed = emailDriver.findElement(By.xpath("//*[@id='mobilepadding']//h3[contains (., 'USD')]")).getText();
        boolean compareResults = priceDisplayed.indexOf(priceEmailed) !=1;

        //added sout to check what information is compared
        System.out.println("Price in calculator is " + priceDisplayed);
        System.out.println("Price in email is " + priceEmailed);

        Assert.assertTrue("Prices are different!", compareResults);

    }

    @AfterClass
    public static void tearDown () {
        calculatorDriver.quit();
        emailDriver.quit();
    }
}
