package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {

    @Test
    void shouldFindSelenideRepositoryPage() {
        //Открыть страницу github.com
        open("https://github.com");
        //ввести в поле поиска "selenide"
        //нажать Enter
        $("[data-test-selector=\"nav-search-input\"]").setValue("selenide").pressEnter();
        //нажать линк от первого результата поиска
        $$(".repo-list li").first().$("a").click();
        //check: в заголовке встречается "selenide/selenide"
        $("h1").shouldHave(text("selenide / selenide"));
    }
}
