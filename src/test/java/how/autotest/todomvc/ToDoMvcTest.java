package how.autotest.todomvc;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class ToDoMvcTest {
    @Test
    void completesTodo(){
        open("https://todomvc.com/examples/emberjs/");

        $(byXpath("//*[@id='new-todo']")).append("a").pressEnter();
        $(byXpath("//*[@id='new-todo']")).append("b").pressEnter();
        $(byXpath("//*[@id='new-todo']")).append("c").pressEnter();

        $$(byXpath("//*[@id='todo-list']//li")).shouldHave(exactTexts("a","b","c"));

        $(byXpath("//*[@id='todo-list']//li[.//text()='b']//*[@class='toggle']")).click();

        $$(byXpath("//*[@id='todo-list']//li[contains(concat(' ',@class,' '), " +
                "' completed ')]")).shouldHave(exactTexts("b"));
        $$(byXpath("//*[@id='todo-list']//li[not(contains(concat(' ',@class,' '), " +
                "' completed '))]")).shouldHave(exactTexts("a","c"));
    }
}
