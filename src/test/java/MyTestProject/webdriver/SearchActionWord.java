package MyTestProject.webdriver;

    import com.sun.deploy.util.JVMParameters;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchActionWord {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\PDP\\SourceCode\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //maximize the window

        driver.manage().window().maximize();
        //delete cookies
        driver.manage().deleteAllCookies();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        String URL = "https://www.google.com/";
        driver.get(URL);
        //Finding the Search Element
        WebElement inputSearch = driver.findElement(By.tagName("input"));
        inputSearch.sendKeys("ducks");
        //Send Keys to hit the enter button
        driver.findElement(By.tagName("input")).sendKeys(Keys.ENTER);
        //Using List element to capture all the search results
        //Loop through the results and find the first matching record of 'Ducks'
        List<WebElement> searchList = driver.findElements(By.id("rso"));
        System.out.println("List element" + searchList);
        for (int i = 0; i < searchList.size(); i++) {
            System.out.println(searchList.get(i).getText());
            if (searchList.get(i).getText().contains("Ducks")) {
                System.out.println("Search Result Test Case: PASSED");
            }
            //Closing the driver closed the browser
            driver.close();

        }
    }
}
