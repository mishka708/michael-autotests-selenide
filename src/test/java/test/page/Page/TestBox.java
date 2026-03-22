package test.page.Page;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBox {
    private static final String OPEN_TEST_BOX = "https://demoqa.com/text-box";
    private static final String USER_NAME_INPUT = "#userName";
    private static final String USER_EMAIL_INPUT = "#userEmail";
    private static final String USER_CURRENT_ADDRESS = "#currentAddress";
    private static final String USER_PER_ADDRESS = "#permanentAddress";
    private static final String SUBMIT = "#submit";
    private static final String OUTPUT_NAME =  "#name";
    private static final String OUTPUT_EMAIL =  "#email";
    private static final String OUTPUT_CURRENT_ADDRESS = "#output #currentAddress";
    private static final String OUTPUT_PERMANENT_ADDRESS =  "#output #permanentAddress";


    @Step("Открытие страницы")
    public TestBox openPage() {
        open(OPEN_TEST_BOX);
        return this;
    }
    @Step("Заполняем поле имя")
    public TestBox inputName(String name) {
        $(USER_NAME_INPUT).setValue(name);
        return this;
    }
    @Step("Заполняем поле имейл")
    public TestBox inputEmail(String email) {
        $(USER_EMAIL_INPUT).setValue(email);
        return this;
    }
    @Step("Заполняем адрес регристрации")
    public TestBox inputCurrentAddress(String address1) {
        $(USER_CURRENT_ADDRESS).setValue(address1);
        return this;
    }
    @Step("Запоняем фактический адрес")
    public TestBox inputPermanentAddress(String address2) {
        $(USER_PER_ADDRESS).setValue(address2);
        return this;
    }
    @Step("Щёлкаем кнопку сабмит")
    public TestBox inputClick() {
        $(SUBMIT).click();
        return this;
    }
    @Step("Проверяем вывод")
    public TestBox checkFields(String name, String email, String address1, String address2)
    {
        $(OUTPUT_NAME)
                .shouldHave(Condition.exactText("Name:"+ name));
        $(OUTPUT_EMAIL)
                .shouldHave(Condition.exactText("Email:"+email));
        $(OUTPUT_CURRENT_ADDRESS)
                .shouldHave(Condition.exactText("Current Address :"+address1));
        $(OUTPUT_PERMANENT_ADDRESS)
                .shouldHave(Condition.exactText("Permananet Address :"+address2));
        return this;

    }
}