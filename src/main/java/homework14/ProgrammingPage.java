package homework14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgrammingPage extends AbstractPage{

    @FindBy(xpath = "/html/body/div[1]/main/section[1]/div[3]/div/ul/li[1]/div/div[1]/ul/li[1]/a")
    private WebElement frontEndBasicLink;

    @FindBy(css = "p.profession-bar_title")
    private WebElement professionTitle;

    @FindBy(css = "p.profession-bar_descr")
    private WebElement professionDescription;

    public ProgrammingPage(WebDriver driver) {
        super(driver);
    }

    public FrontEndBasicPage clickToFrontEndBasicLink(){
        frontEndBasicLink.click();
        return new FrontEndBasicPage(driver);
    }
    public String getProfessionTitle(){
        return professionTitle.getText();
    }
    public String getProfessionDescription(){
        return professionDescription.getText();
    }
}
