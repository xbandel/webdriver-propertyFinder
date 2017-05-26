import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class twoBedroomSearchTest {

    static {
    //    System.setProperty("webdriver.chrome.driver", "/home/user/tmp/chromedriver");
    }

    private static WebDriver driver = new ChromeDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, 5000);

    public static String homePageURL = "https://www.propertyfinder.qa/";

    String itemTitle;
    String openedItemTitle;

    @BeforeClass
    public static void setUp() {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void twoBedroomSearchTest() {
        driver.get(homePageURL);
        HomePage homePage = new HomePage(driver);

        homePage.openHomePage();
        homePage.selectSearchParameters();
        homePage.submitSearch();
        homePage.scrollPage();
        itemTitle = homePage.clickLastItem();

       PropertyPage propertyPage = new PropertyPage(driver);
       openedItemTitle = propertyPage.openProperty();

        assertEquals(openedItemTitle, itemTitle);
        assertEquals(driver.findElement(By.xpath(propertyPage.openedItemBed)).getText(), "Bedrooms");
        assertEquals(driver.findElement(By.xpath(propertyPage.openedItemBedroomsNum)).getText(), "2");
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }


}
