package how.autotest.todomvc.dsl;

import how.autotest.selectors.xpath.dsl.Its;
import how.autotest.selectors.xpath.dsl.XDsl;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class Test {
    @org.junit.jupiter.api.Test
    void completesTodo(){
        open("https://todomvc.com/examples/emberjs/");

        $(byXpath(XDsl.returnObject().all().by(Its.id("new-todo")).path())).append("a").pressEnter();
        $(byXpath(XDsl.returnObject().all().by(Its.id("new-todo")).path())).append("b").pressEnter();
        $(byXpath(XDsl.returnObject().all().by(Its.id("new-todo")).path())).append("c").pressEnter();

        $$(byXpath(XDsl.returnObject().all().by(Its.id("todo-list")).descendant("li").path())).shouldHave(exactTexts("a","b","c"));

        $(byXpath(XDsl.returnObject().all().by(Its.id("todo-list")).descendant("li").by(Its.descendantWithText("b")).all().by(Its.cssClassContains("toggle")).path())).click();
        $$(byXpath(XDsl.returnObject().all().by(Its.id("todo-list")).descendant("li").by(Its.cssClassContains("completed")).path())).shouldHave(exactTexts("b"));
        $$(byXpath(XDsl.returnObject().all().by(Its.id("todo-list")).descendant("li").by(Its.not(Its.cssClassContains("completed"))).path())).shouldHave(exactTexts("a","c"));
    }
}
