package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositoryTest {

    @Test
    void shouldFindSelenideAsFirstRepository(){
        // Open page github.com
        open("https://github.com");
        // Type selenide in search field and press Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // Click the first link in results
        $$("ul.repo-list li").first().$("a").click();
        // Check: header contains selenide/selenide
        $("h2").shouldHave(text("selenide / selenide"));

    }
}