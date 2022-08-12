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
        // Open https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Drag rectangle А on place of В
        $("#column-a").dragAndDropTo($("#column-b"));
        sleep(300);
        // Check that rectangles have changed their places
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }
}
