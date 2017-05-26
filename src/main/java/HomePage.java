import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public static String countrySelect = "//div[@class='desktop-country-language-select']";
    public static String propType = "//button[@type='button' and @class='ms-choice']/span[text()='Rent']";
    public static String propTypeDropdown = "//li[@data-value='2' and text()='Rent']";

    public static String rentType = "//button[@type='button' and @class='ms-choice']/span[text()='Monthly']";
    public static String rentTypeDropdown = "//li[@data-value='m' and text()='Monthly']";
    public static String maxPrice = "//button[@type='button' and @class='ms-choice']/span[text()='Max. price']";
    public static String maxPriceDropdown = "//button[@type='button' and @class='ms-choice']/span[text()='Max. price']/../following-sibling::div/ul/li[@data-value='10000']";
    public static String minBed = "//button[@type='button' and @class='ms-choice']/span[text()='Min. bed']";
    public static String minBedDropdown = "//li[@data-value='2' and text()='2 Beds']";

    public static String searchField = "//input[@type='search']";
    public static String searchArea = "marina";
    public static String searchBut = "//button[@type='submit']/div[@class='text']";

    public static String apLink = "//a[text()='Apartments']";
    public static String searchResults = "//ul[@class='serp-result']";
    public static String searchResultLast = "//ul[@class='serp-result']/li[@class='gtm-impression-sent' and last()]//div[@class='image']/a";
    public static String lastItemTitle = "//ul[@class='serp-result']/li[@class='gtm-impression-sent' and last()]//div[@class='listing-content']//a[@title]";

    private static WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    private void selectAndClick(String placeholder, String selection) {
        WebElement propTypeClick = driver.findElement(By.xpath(placeholder));
        propTypeClick.click();
        new WebDriverWait(driver, 5000).until(ExpectedConditions.presenceOfElementLocated(By.xpath(selection)));
        WebElement propTypeRent = driver.findElement(By.xpath(selection));
        Actions actions = new Actions(driver);
        actions.moveToElement(propTypeRent).click().build().perform();

    }

    public void openHomePage(){
        new WebDriverWait(driver, 5000).until(ExpectedConditions.presenceOfElementLocated(By.xpath(countrySelect)));
        new WebDriverWait(driver, 5000).until(ExpectedConditions.presenceOfElementLocated(By.xpath(propType)));
    }

    public void selectSearchParameters(){
        selectAndClick(propType, propTypeDropdown);
        selectAndClick(rentType, rentTypeDropdown);
        selectAndClick(maxPrice, maxPriceDropdown);
        selectAndClick(minBed, minBedDropdown);

        WebElement search = driver.findElement(By.xpath(searchField));
        search.sendKeys(searchArea);
    }

    public void submitSearch(){
        WebElement searchButton = driver.findElement(By.xpath(searchBut));
        searchButton.click();
        new WebDriverWait(driver, 5000).until(ExpectedConditions.presenceOfElementLocated(By.xpath(apLink)));
        new WebDriverWait(driver, 5000).until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResults)));
    }

    public void scrollPage(){
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
    }

    public String clickLastItem(){
        WebElement lastItemResults = driver.findElement(By.xpath(searchResultLast));
        String itemTitle = driver.findElement(By.xpath(lastItemTitle)).getText();
        lastItemResults.click();
        return itemTitle;
    }

}
