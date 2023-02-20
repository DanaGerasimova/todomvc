package how.autotest.todomvc_using_dsl;

import how.autotest.helpers.XDsl;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class ToDoMvcTest {
    @Test
    void completesTodo(){
        open("https://todomvc.com/examples/emberjs/");

        $(byXpath(new XDsl().all().id("new-todo").path())).append("a").pressEnter();
        $(byXpath(new XDsl().all().id("new-todo").path())).append("b").pressEnter();
        $(byXpath(new XDsl().all().id("new-todo").path())).append("c").pressEnter();

        $$(byXpath(new XDsl().all().id("todo-list").descendant("li").path())).shouldHave(exactTexts("a","b","c"));

        $(byXpath(new XDsl().all().id("todo-list").descendant("li").descendantWithText("b").all().cssClassContains("toggle").path())).click();
        $$(byXpath(new XDsl().all().id("todo-list").descendant("li").cssClassContains("completed").path())).shouldHave(exactTexts("b"));
        $$(byXpath(new XDsl().all().id("todo-list").descendant("li").cssClassNotContains("completed").path())).shouldHave(exactTexts("a","c"));
    }
}
