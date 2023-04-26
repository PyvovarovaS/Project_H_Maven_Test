package homework16;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

public class Main {
    public static void main(String[] args) {

        Configuration.baseUrl = ConfigProvider.BASE_URL;
        open("https://ithillel.ua/courses/testing");
        Configuration.browserSize = ConfigProvider.BROWSER_SIZE;

        TestingPage testingPage = new TestingPage();
        System.out.println(testingPage.getCoursesTitles());
        System.out.println(testingPage.getAdditionalCoursesTitles());
        System.out.println(testingPage.getOpportunities());
        testingPage.goToCategory(CategoryName.PROGRAMMING);

        ProgrammingPage programmingPage = new ProgrammingPage();
        System.out.println(programmingPage.getAllProfessionsTitles());
        System.out.println(programmingPage.getOpportunities());
        programmingPage.goToCategory(CategoryName.DESIGN);

        DesignPage designPage = new DesignPage();
        System.out.println(designPage.getCoursesTitles());
        System.out.println(designPage.getOpportunities());

        closeWebDriver();
    }
}
