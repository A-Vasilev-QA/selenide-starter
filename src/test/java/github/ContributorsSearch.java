package github;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ContributorsSearch {

    @Test
    void firstContributorShouldBeSolntsev() {
        // открыть страничку selenide
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому элементу в области Contributors
        $(".BorderGrid").$(byText("Contributors"))
                .closest("div").$("li").hover();
        // проверка: в появившемся окошечке (overlay)
        $$(".Popover-message").findBy(visible)
                .shouldHave(text("Andrei Solntsev"));
    }
}
