import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyPage {
    public static String openedItemTit = "//header//h1/bdi";
    public static String openedItemBed = "//table[@class='fixed-table']//tr[4]/th";
    public static String openedItemBedroomsNum = "//table[@class='fixed-table']//tr[4]/td";

    private static WebDriver driver;

    public PropertyPage(WebDriver driver) {
        this.driver = driver;

    }

    public String openProperty(){
        new WebDriverWait(driver, 5000).until(ExpectedConditions.presenceOfElementLocated(By.xpath(openedItemTit)));
        String openedItemTitle = driver.findElement(By.xpath(openedItemTit)).getText();
        return openedItemTitle;
    }

}

