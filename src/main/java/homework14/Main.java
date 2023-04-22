package homework14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;
import org.openqa.selenium.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigProvider.BASE_URL);

        HillelHomePage hillelHomePage = new HillelHomePage(driver);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 400)");

        ProgrammingPage programmingPage = hillelHomePage.clickToProgrammingCourseLink();
        FrontEndBasicPage frontEndBasicPage = programmingPage.clickToFrontEndBasicLink();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(30))
                .withTimeout(Duration.ofSeconds(10))
                .ignoreAll(List.of(NoSuchElementException.class, ElementClickInterceptedException.class));

        ((JavascriptExecutor) driver).executeScript("window.scrollTo" +
                driver.findElement(By.cssSelector(".-profession")).getLocation());
        WebElement coachList = wait.until(driver1 -> driver1.findElement(By.cssSelector(".coach-list")));
        WebElement cookieAgreementButton = wait.until(driver1 -> driver1.findElement(By.xpath("/html/" +
                "body/div[1]/div[3]/button")));
        frontEndBasicPage.clickToCookieAgreementButton();

        WebElement coachesShowAllButton = wait.until(driver1 -> driver1.findElement(By.id("coachesShowAllButton")));
//        WebElement coachesShowAllButton = driver.findElement(By.id("coachesShowAllButton"));
        wait.until(driver1 -> {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100)");
            return coachesShowAllButton.isEnabled();
        });
        frontEndBasicPage.clickToCoachesShowAllButton();

        Thread.sleep(3000);
        System.out.println(frontEndBasicPage.getCoachesName().toString());

        driver.quit();
    }
}
