package homework14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItHillelFrontEndBasicCourse {

    private WebDriver driver;

    public ItHillelFrontEndBasicCourse(WebDriver driver) {
        this.driver = driver;
    }

    public void scrapeInstructors() {
        driver.get("https://ithillel.ua/");

        WebElement coursesLink = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div[1]/div[2]" +
                "/div/div/nav/ul/li[2]/button"));
        coursesLink.click();

        WebElement programmingLink = driver.findElement(By.xpath("//*[@id=\"coursesMenuControlPanel\"]" +
                "/ul/li[2]/button"));
        programmingLink.click();

        WebElement frontEndBasicLink = driver.findElement(By.xpath("//*[@id=\"block-202987\"]" +
                "/div/ul/li[1]/a/div/p"));
        frontEndBasicLink.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement sectionProfession = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]" +
                "/main/section[5]"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", sectionProfession);
        WebElement coachesArea = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]/main/section[6]"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", coachesArea);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
