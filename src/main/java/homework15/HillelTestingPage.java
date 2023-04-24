package homework15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HillelTestingPage extends AbstractPage {

    @FindBy(css = ".profession-bar_icon[alt='QA Manual']")
    private WebElement qAManualLink;

    @FindBy(css = ".profession-bar_icon[alt='QA Automation — Java']")
    private WebElement qAAutomationJavaLink;

    @FindBy(css = ".profession-bar_icon[alt='QA Automation — Python']")
    private WebElement qAAutomationPythonLink;

    @FindBy(css = ".block-profession_item")
    private List<WebElement> courses;

    @FindBy(css = ".block-profession_item")
    private List<WebElement> additionalCourses;

    @FindBy(css = ".opportunities_item")
    private List<WebElement> opportunities;

    @FindBy(css = ".opportunities_how-to")
    private List<WebElement> opportunitiesHowTo;

    @FindBy(css = ".advantages-list_item")
    private List<WebElement> advantages;

    @FindBy(css = ".block-employment_item")
    private List<WebElement> employment;

    @FindBy(css = "a.note-bar")
    private WebElement reviewsLink;

    @FindBy(xpath = "//*[@id=\"categories\"]/div/ul/li[1]/a")
    private WebElement programmingLink;

    @FindBy(xpath = "//*[@id=\"categories\"]/div/ul/li[2]/a")
    private WebElement testingLink;

    @FindBy(xpath = "//*[@id=\"categories\"]/div/ul/li[3]/a")
    private WebElement managementLink;

    @FindBy(xpath = "//*[@id=\"categories\"]/div/ul/li[4]/a")
    private WebElement marketingLink;

    @FindBy(xpath = "//*[@id=\"categories\"]/div/ul/li[5]/a")
    private WebElement designLink;

    @FindBy(xpath = "//*[@id=\"categories\"]/div/ul/li[6]/a")
    private WebElement kidsLink;

    public HillelTestingPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getCoursesTitles() {
        List<String> coursesTitles = new ArrayList<>();
        for (WebElement linkToCourse : courses) {
            WebElement courseTitle = linkToCourse.findElement(By.cssSelector("p.profession-bar_title"));
            String title = courseTitle.getText();
            if (!title.equals("Сертифікація ISTQB для тестувальників")) {
                coursesTitles.add(title);
            }
        }
        return coursesTitles;
    }
    public List<String> getAdditionalCoursesTitles() {
        List<String> additionalCoursesTitles = new ArrayList<>();
        for (WebElement linkToAdditionalCourse : additionalCourses) {
            WebElement additionalCourseTitle = linkToAdditionalCourse.findElement
                    (By.cssSelector("p.profession-bar_title"));
            String title = additionalCourseTitle.getText();
            if (title.equals("Сертифікація ISTQB для тестувальників")) {
                additionalCoursesTitles.add(title);
            }
        }
            return additionalCoursesTitles;
    }
        public List<String> getOpportunities () {
            List<String> opportunitiesList = new ArrayList<>();
            for (WebElement linkToOpportunities : opportunities) {
                WebElement opportunityItemTitle = linkToOpportunities.findElement(By.cssSelector
                        (".opportunity-item_title"));
                String title = opportunityItemTitle.getText();
                opportunitiesList.add(title);
            }
            return opportunitiesList;
        }
        public QAManualPage clickToQAManualLink () {
            qAManualLink.click();
            return new QAManualPage(driver);
        }
        public QAAutomationJavaPage clickToQAAutomationJavaLink () {
            qAAutomationJavaLink.click();
            return new QAAutomationJavaPage(driver);
        }
        public QAAutomationPythonPage clickToQAAutomationPythonLink () {
            qAAutomationPythonLink.click();
            return new QAAutomationPythonPage(driver);
        }

        public void goToCategory (String category){
            switch (category) {
                case "Програмування":
                    programmingLink.click();
                    break;
                case "Менеджмент":
                    managementLink.click();
                    break;
                case "Маркетинг":
                    marketingLink.click();
                    break;
                case "Дизайн":
                    designLink.click();
                    break;
                case "Дитячі курси":
                    kidsLink.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid category: " + category);
            }
        }
    }
