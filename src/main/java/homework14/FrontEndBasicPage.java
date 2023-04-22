package homework14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FrontEndBasicPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"coachesSection\"]")
    private WebElement coachesSection;

    @FindBy(id = "coachesShowAllButton")
    private WebElement coachesShowAllButton;

    @FindBy(xpath = "/html/body/div[1]/div[3]/button")
    private WebElement cookieAgreementButton;
    public FrontEndBasicPage(WebDriver driver) {
        super(driver);
    }
    public void clickToCoachesShowAllButton() {
        coachesShowAllButton.click();
    }
    public void clickToCookieAgreementButton() {
        cookieAgreementButton.click();
    }
    public List<String> getCoachesName() {
    List<WebElement> coachListItems = driver.findElements(By.cssSelector(".coach-list_item"));
    List<String> coachesName = coachListItems.stream()
            .map(we -> we.findElement(By.cssSelector(".coach-card_name")))
            .map(coachCard -> coachCard.getText())
            .toList();
    return coachesName;
    }
}
