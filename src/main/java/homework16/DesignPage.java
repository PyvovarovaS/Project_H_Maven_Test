package homework16;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import java.util.ArrayList;
import java.util.List;

public class DesignPage extends AbstractPage {

    private final SelenideElement webDesignBasicsLink = $(".profession-bar_icon[alt='Основи Web дизайну']");

    private final SelenideElement uIUXDesignProLink = $(".profession-bar_icon[alt='UI/UX Design Pro']");

    private final SelenideElement programmingLink = $x("//*[@id=\"categories\"]/div/ul/li[1]/a");

    private final SelenideElement testingLink = $x("//*[@id=\"categories\"]/div/ul/li[2]/a");

    private final SelenideElement managementLink = $x("//*[@id=\"categories\"]/div/ul/li[3]/a");

    private final SelenideElement marketingLink = $x("//*[@id=\"categories\"]/div/ul/li[4]/a");

    private final SelenideElement designLink = $x("//*[@id=\"categories\"]/div/ul/li[5]/a");

    private final SelenideElement kidsLink = $x("//*[@id=\"categories\"]/div/ul/li[6]/a");

    private final ElementsCollection courses = $$(".block-profession_item");

    private final ElementsCollection opportunities = $$(".opportunities_item");

    private final ElementsCollection opportunitiesHowTo = $$(".opportunities_how-to");

    private final ElementsCollection advantages = $$(".advantages-list_item");

    private final ElementsCollection employment = $$(".block-employment_item");

    private final SelenideElement reviewsLink = $("a.note-bar");
    public List<String> getCoursesTitles() {
        List<String> coursesTitles = new ArrayList<>();
        for (SelenideElement linkToCourse : courses) {
            SelenideElement courseTitle = linkToCourse.$("p.profession-bar_title");
            String title = courseTitle.getText();
            coursesTitles.add(title);
        }
        return coursesTitles;
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
    public WebDesignBasicsPage clickToWebDesignBasicsLink() {
        webDesignBasicsLink.click();
        return new WebDesignBasicsPage();
    }
    public UIUXDesignProPage clickToUIUXDesignProLink() {
        uIUXDesignProLink.click();
        return new UIUXDesignProPage();
    }
}
