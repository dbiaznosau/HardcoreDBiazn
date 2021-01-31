package CloudCalculationsTest.test;

import CloudCalculationsTest.page.CloudCalculator;
import com.sun.istack.internal.NotNull;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass {
    public static WebDriver driver;
    public static WebDriver driver2;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cloud.google.com/products/calculator");
        driver2 = new ChromeDriver();
        driver2.manage().window().maximize();
        driver2.get("https://10minutemail.com");}


        @Test
        public void TestClass () {
            //calculator page
            //wait until main iFrame is loaded
            new WebDriverWait(driver, 10).until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
            //switch to the frame that contains necessary elements
            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='myFrame']")));



            CloudCalculator cloudCalculator = new CloudCalculator(driver);

            cloudCalculator.seriesClick();
            cloudCalculator.seriesOptionSelect();

            cloudCalculator.machineTypeLabelClick();
            cloudCalculator.machineTypeOptionSelect();

            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@ng-if='listingCtrl.showComputeEngine']//*[contains(text(), 'Add GPUs.')]")));
            cloudCalculator.addGpuCheckboxClick();

            cloudCalculator.numberOfGpuClick();
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_399']")));
            cloudCalculator.numberOfGpuSelect();

            String mainTabName = driver.getWindowHandle();
            String emailTab = driver2.getWindowHandle();
            System.out.println(mainTabName);
            System.out.println(emailTab);


        }
    }
