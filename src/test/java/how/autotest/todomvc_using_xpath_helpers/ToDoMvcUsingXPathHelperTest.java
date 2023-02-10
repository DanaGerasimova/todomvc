package how.autotest.todomvc_using_xpath_helpers;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static how.autotest.todomvc_using_xpath_helpers.XPathHelper.*;

public class ToDoMvcUsingXPathHelperTest {
    @Test
    void completesTodoUsingXPathHelper(){
        open("https://todomvc.com/examples/emberjs/");

        $(byXpath(id("new-todo"))).append("a").pressEnter();
        $(byXpath(id("new-todo"))).append("b").pressEnter();
        $(byXpath(id("new-todo"))).append("c").pressEnter();

        $$(byXpath(id("todo-list") + child("li"))).shouldHave(exactTexts("a","b","c"));

        $(byXpath(id("todo-list") + child("li") + "[.//text()='b']//*[" + containsClassName("toggle") + "]")).click();

        $$(byXpath(id("todo-list") + child("li") + "[" + containsClassName("completed") + "]")).shouldHave(exactTexts("b"));
        $$(byXpath(id("todo-list") + child("li") + "[not(" + containsClassName("completed") + ")]")).shouldHave(exactTexts("a","c"));
    }
}
