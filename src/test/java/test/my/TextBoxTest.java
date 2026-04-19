package test.my;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.page.Page.TestBox;
public class TextBoxTest {

    TestBox page = new TestBox();
    Faker faker = new Faker();

    @BeforeAll
    static void setup() {
        // Подключаем Allure Selenide listener
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );

        Configuration.browserSize = "1920x1080";
    }

    @Test
    @Owner("Дядя Миша")
    void textBoxTest() {

        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String address1 = faker.address().city();
        String address2 = faker.address().city();

        page
                .openPage()
                .inputName(name)
                .inputEmail(email)
                .inputCurrentAddress(address1)
                .inputPermanentAddress(address2)
                .inputClick()
                .checkFields(name, email, address1, address2);
    }
} //