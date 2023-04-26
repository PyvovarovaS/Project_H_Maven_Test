package homework16;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import java.util.ArrayList;
import java.util.List;

public class TestingPage extends AbstractPage {

    private final SelenideElement qAManualLink = $(".profession-bar_icon[alt='QA Manual']");

    private final SelenideElement qAAutomationJavaLink = $(".profession-bar_icon[alt='QA Automation — Java']");

    private final SelenideElement qAAutomationPythonLink = $(".profession-bar_icon[alt='QA Automation — Python']");

    private final ElementsCollection courses = $$(".block-profession_item");

    private final ElementsCollection additionalCourses = $$(".block-profession_item");

    private final ElementsCollection opportunities = $$(".opportunities_item");

    private final ElementsCollection opportunitiesHowTo = $$(".opportunities_how-to");

    private final ElementsCollection advantages = $$(".advantages-list_item");

    private final ElementsCollection employment = $$(".block-employment_item");

    private final SelenideElement reviewsLink = $("a.note-bar");

    private final SelenideElement programmingLink = $x("//*[@id=\"categories\"]/div/ul/li[1]/a");

    private final SelenideElement testingLink = $x("//*[@id=\"categories\"]/div/ul/li[2]/a");

    private final SelenideElement managementLink = $x("//*[@id=\"categories\"]/div/ul/li[3]/a");

    private final SelenideElement marketingLink = $x("//*[@id=\"categories\"]/div/ul/li[4]/a");

    private final SelenideElement designLink = $x("//*[@id=\"categories\"]/div/ul/li[5]/a");

    private final SelenideElement kidsLink = $x("//*[@id=\"categories\"]/div/ul/li[6]/a");

    public List<String> getCoursesTitles() {
        List<String> coursesTitles = new ArrayList<>();
        for (SelenideElement linkToCourse : courses) {
            SelenideElement courseTitle = linkToCourse.$("p.profession-bar_title");
            String title = courseTitle.getText();
            if (!title.equals("Сертифікація ISTQB для тестувальників")) {
                coursesTitles.add(title);
            }
        }
        return coursesTitles;
    }
    public List<String> getAdditionalCoursesTitles() {
        List<String> additionalCoursesTitles = new ArrayList<>();
        for (SelenideElement linkToAdditionalCourse : additionalCourses) {
            SelenideElement additionalCourseTitle = linkToAdditionalCourse.$("p.profession-bar_title");
            String title = additionalCourseTitle.getText();
            if (title.equals("Сертифікація ISTQB для тестувальників")) {
                additionalCoursesTitles.add(title);
            }
        }
        return additionalCoursesTitles;
    }
    public List<String> getOpportunities() {
        List<String> opportunitiesList = new ArrayList<>();
        for (SelenideElement linkToOpportunities : opportunities) {
            SelenideElement opportunityItemTitle = linkToOpportunities.$(".opportunity-item_title");
            String title = opportunityItemTitle.getText();
            opportunitiesList.add(title);
        }
        return opportunitiesList;
    }
    public void goToCategory (CategoryName categoryName) {
        switch (categoryName) {
            case PROGRAMMING -> programmingLink.click();
            case TESTING -> testingLink.click();
            case MANAGEMENT -> managementLink.click();
            case MARKETING -> marketingLink.click();
            case DESIGN -> designLink.click();
            case KIDS -> kidsLink.click();
            default -> throw new IllegalArgumentException("Invalid category: " + categoryName);
        }
    }
    public QAManualPage clickToQAManualLink() {
        qAManualLink.click();
        return new QAManualPage();
    }
    public QAAutomationJavaPage clickToQAAutomationJavaLink() {
        qAAutomationJavaLink.click();
        return new QAAutomationJavaPage();
    }
    public QAAutomationPythonPage clickToQAAutomationPythonLink() {
        qAAutomationPythonLink.click();
        return new QAAutomationPythonPage();
    }
}
