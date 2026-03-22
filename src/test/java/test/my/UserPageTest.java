package test.my;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class UserPageTest {
@Test
    void pageTest()
{  SelenideLogger.addListener("allure", new AllureSelenide());
  open("https://giga.chat");


}
}
