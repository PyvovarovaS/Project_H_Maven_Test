package homework16;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgrammingPage extends AbstractPage {

    private final SelenideElement frontEndBasicLink = $(".profession-bar_icon[alt='Front-end Basic']");

    private final SelenideElement frontEndProLink = $(".profession-bar_icon[alt='Front-end Pro']");

    private final SelenideElement reactLink = $(".profession-bar_icon[alt='React']");

    private final SelenideElement programmingLink = $x("//*[@id=\"categories\"]/div/ul/li[1]/a");

    private final SelenideElement testingLink = $x("//*[@id=\"categories\"]/div/ul/li[2]/a");

    private final SelenideElement managementLink = $x("//*[@id=\"categories\"]/div/ul/li[3]/a");

    private final SelenideElement marketingLink = $x("//*[@id=\"categories\"]/div/ul/li[4]/a");

    private final SelenideElement designLink = $x("//*[@id=\"categories\"]/div/ul/li[5]/a");

    private final SelenideElement kidsLink = $x("//*[@id=\"categories\"]/div/ul/li[6]/a");

    private final SelenideElement frontEndSubcategory = $x("//*[@id=\"categories\"]/div[2]/ul/li[1]/button");

    private final SelenideElement javaSubcategory = $x("//*[@id=\"categories\"]/div[2]/ul/li[2]/button");

    private final SelenideElement phpSubcategory = $x("//*[@id=\"categories\"]/div[2]/ul/li[3]/button");

    private final SelenideElement pythonSubcategory = $x("//*[@id=\"categories\"]/div[2]/ul/li[4]/button");

    private final SelenideElement devOpsSubcategory = $x("//*[@id=\"categories\"]/div[2]/ul/li[5]/button");

    private final SelenideElement hiTechSubcategory = $x("//*[@id=\"categories\"]/div[2]/ul/li[6]/button");

    private final SelenideElement cSharpSubcategory = $x("//*[@id=\"categories\"]/div[2]/ul/li[7]/button");

    private final ElementsCollection professions = $$(".block-profession_item");

    private final ElementsCollection opportunities = $$(".opportunities_item");

    private final ElementsCollection opportunitiesHowTo = $$(".opportunities_how-to");

    private final ElementsCollection advantages = $$(".advantages-list_item");

    private final ElementsCollection employment = $$(".block-employment_item");

    private final SelenideElement reviewsLink = $("a.note-bar");

    public List<String> getAllProfessionsTitles() {
        List<String> allProfessionsTitles = new ArrayList<>();
        for (SelenideElement subcategory : Arrays.asList(frontEndSubcategory, javaSubcategory, phpSubcategory,
                pythonSubcategory, devOpsSubcategory, hiTechSubcategory, cSharpSubcategory)) {
            subcategory.click();
            allProfessionsTitles.addAll(getProfessionsTitles());
        }
        return allProfessionsTitles;
    }

    private List<String> getProfessionsTitles() {
        List<String> professionsTitles = new ArrayList<>();
        for (SelenideElement profession : professions) {
            String title = profession.$("p.profession-bar_title").getText();
            if (!title.isEmpty()) {
                professionsTitles.add(title);
            }
        }
        return professionsTitles;
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
}

