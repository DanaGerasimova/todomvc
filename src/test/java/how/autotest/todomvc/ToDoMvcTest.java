package how.autotest.todomvc;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class ToDoMvcTest {
    @Test
    void completesTodo(){
        open("https://todomvc.com/examples/emberjs/");

        $("#new-todo").append("a").pressEnter();
        $("#new-todo").append("b").pressEnter();
        $("#new-todo").append("c").pressEnter();

        $$(".todo-list>li").shouldHave(exactTexts("a","b","c"));

        $(".todo-list>li:nth-child(2)>div>.toggle").click();

        $$(".todo-list>.completed").shouldHave(exactTexts("b"));

        $(".todo-list>li").shouldHave(exactText("a"));
        $(".todo-list>li:nth-child(3)").shouldHave(exactText("c"));
    }
}
