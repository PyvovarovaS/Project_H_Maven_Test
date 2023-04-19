package homework14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        ItHillelFrontEndBasicCourse scraper = new ItHillelFrontEndBasicCourse(driver);
        scraper.scrapeInstructors();
        List<WebElement> coachesList = driver.findElements(By.xpath("//div[contains(@class, " +
                "'coach-card_name') and h2[text()='Викладачі курсу']]"));
        System.out.println("Список викладачів:");
        for (WebElement coach : coachesList) {
            System.out.println(coach.getText());
        }

        driver.quit();
    }
}
