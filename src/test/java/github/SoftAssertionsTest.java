package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SoftAssertionsTest {

    @Test
    public void paragraphCanBeFoundTest() {
        Configuration.startMaximized = true;

        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$(".markdown-body ul li a").findBy(text("Soft assertions")).shouldBe(visible).click();
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byText("Using JUnit5 extend test class:")).parent().sibling(0).$("pre").shouldBe(visible); //Проверяем, что именно блок кода присутствует
    }
}
