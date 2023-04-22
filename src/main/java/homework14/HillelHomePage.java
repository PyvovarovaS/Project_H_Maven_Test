package homework14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HillelHomePage extends AbstractPage{

    @FindBy(xpath = "/html/body/div[1]/main/section[2]")
    private WebElement coursesSection;

    @FindBy(css = ".course-cat-bar_icon[alt='Програмування']")
    private WebElement programmingCourseLink;

    @FindBy(css = "p.course-cat-bar_label")
    private WebElement courseLabel;

    @FindBy(css = "p.course-cat-bar_descr")
    private WebElement courseDescription;

    @FindBy(css = "img.course-cat-bar_icon")
    private WebElement courseIcon;

    public HillelHomePage(WebDriver driver) {
        super(driver);
    }

    public ProgrammingPage clickToProgrammingCourseLink(){
        programmingCourseLink.click();
        return new ProgrammingPage(driver);
    }
    public String getCourseLabel(){
        return courseLabel.getText();
    }
    public String getCourseDescription(){
        return courseDescription.getText();
    }
}
