package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SoftAssertionsTest {

    @Test
    public void paragraphCanBeFoundTest() {
        Configuration.browserSize = "1920x1080";

        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        //$$(".markdown-body ul li a").findBy(text("Soft assertions")).click();
        $(byText("Soft assertions")).click();
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byTagAndText("h4","3. Using JUnit5 extend test class:")).sibling(0).$("pre").
                shouldBe(visible);
        //Проверяем, что именно блок кода присутствует
    }
}
