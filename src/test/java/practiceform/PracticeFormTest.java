package practiceform;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("h1.text-center").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Voronov");
        $("#userEmail").setValue("voronov@gmail.com");

        $("#gender-radio-1").parent().$("label").shouldBe(text("Male"));
        $("#gender-radio-1").parent().$("label").click();
//        $("label[for=gender-radio-1]").click();

        $("input#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030")
                .shouldNotHave(cssClass(".react-datepicker__day--outside-month"));

        $("#subjectsInput").setValue("m");
        $(byText("Maths")).shouldBe(visible).click();

        $("#hobbies-checkbox-1").parent().$("label").shouldBe(text("Sports"));
        $("#hobbies-checkbox-1").parent().$("label").click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/78654345.png"));

        $("#currentAddress").setValue("43 Raymouth Rd. Baltemoer, London 3910");
        $("#state").click();
        $(byText("NCR")).shouldBe(visible).click();
        $("#city").click();
        $(byText("Noida")).shouldBe(visible).click();
        $("#submit").click();

    }
}
