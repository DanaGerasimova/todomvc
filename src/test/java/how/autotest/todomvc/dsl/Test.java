package how.autotest.todomvc.dsl;

import how.autotest.selectors.xpath.dsl.Its;
import how.autotest.selectors.xpath.dsl.X;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class Test {
    @org.junit.jupiter.api.Test
    void completesTodo(){
        open("https://todomvc.com/examples/emberjs/");

        $(byXpath(X.all().by(Its.id("new-todo"))
                .path())).append("a").pressEnter();
        $(byXpath(X.all().by(Its.id("new-todo"))
                .path())).append("b").pressEnter();
        $(byXpath(X.all().by(Its.id("new-todo"))
                .path())).append("c").pressEnter();

        $$(byXpath(X.all().by(Its.id("todo-list")).descendant("li")
                .path())).shouldHave(exactTexts("a","b","c"));

        $(byXpath(X.all().by(Its.id("todo-list"))
                .descendant("li").by(Its.descendantWithText("b")).descendant("*")
                .by(Its.cssClassContains("toggle"))
                .path())).click();

        $$(byXpath(X.all().by(Its.id("todo-list"))
                .descendant("li").by(Its.cssClassContains("completed"))
                .path())).shouldHave(exactTexts("b"));

        $$(byXpath(X.all().by(Its.id("todo-list"))
                .descendant("li").byNot(Its.cssClassContains("completed"))
                .path())).shouldHave(exactTexts("a","c"));
    }
}
