package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DragNDropTest {
    @Test
    public void userCanDragNDropTest() {
        Configuration.browserSize = "1920x1080";
        //Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // - Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        sleep(300);
        // - Проверьте, что прямоугольники действительно поменялись
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }
}
