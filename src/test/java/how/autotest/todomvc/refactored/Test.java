package how.autotest.todomvc.refactored;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static how.autotest.selectors.xpath.utils.XPath.*;

public class Test {
    @org.junit.jupiter.api.Test
    void completesTodo(){
        open("https://todomvc.com/examples/emberjs/");

        $(byXpath(id("new-todo"))).append("a").pressEnter();
        $(byXpath(id("new-todo"))).append("b").pressEnter();
        $(byXpath(id("new-todo"))).append("c").pressEnter();

        $$(byXpath(id("todo-list") + descendant("li"))).shouldHave(exactTexts("a","b","c"));

        $(byXpath(id("todo-list") + descendant("li") + "[.//text()='b']//*[" + cssClass("toggle") + "]")).click();

        $$(byXpath(id("todo-list") + descendant("li") + "[" + cssClass("completed") + "]")).shouldHave(exactTexts("b"));
        $$(byXpath(id("todo-list") + descendant("li") + "[not(" + cssClass("completed") + ")]")).shouldHave(exactTexts("a","c"));
    }
}
