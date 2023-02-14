package how.autotest.todomvc_using_xpath_helpers;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static how.autotest.helpers.XPath.*;

public class ToDoMvcTest {
    @Test
    void completesTodo(){
        open("https://todomvc.com/examples/emberjs/");

        $(byXpath(id("new-todo"))).append("a").pressEnter();
        $(byXpath(id("new-todo"))).append("b").pressEnter();
        $(byXpath(id("new-todo"))).append("c").pressEnter();

        $$(byXpath(id("todo-list") + descendant("li"))).shouldHave(exactTexts("a","b","c"));

        $(byXpath(id("todo-list") + descendant("li") + "[.//text()='b']//*[" + predicateCssClass("toggle") + "]")).click();

        $$(byXpath(id("todo-list") + descendant("li") + "[" + predicateCssClass("completed") + "]")).shouldHave(exactTexts("b"));
        $$(byXpath(id("todo-list") + descendant("li") + "[not(" + predicateCssClass("completed") + ")]")).shouldHave(exactTexts("a","c"));
    }
}
