package homework15;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Main {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ithillel.ua/courses/testing");

        HillelTestingPage hillelTestingPage = new HillelTestingPage(driver);
        System.out.println(hillelTestingPage.getCoursesTitles());
        System.out.println(hillelTestingPage.getAdditionalCoursesTitles());
        System.out.println(hillelTestingPage.getOpportunities());

        hillelTestingPage.goToCategory("Дизайн");
        driver.quit();
    }
}
