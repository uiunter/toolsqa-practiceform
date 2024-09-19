package demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("h1.text-center").shouldHave(text("Text Box"));
        $("#userName").setValue("Egor Voronov");
        $("#userEmail").setValue("test@gmail.com");
        $("#currentAddress").setValue("Current Address");
        $("#permanentAddress").setValue("Permanent Address");

        $("#submit").click();
        $("#output").shouldBe(visible);
    }
}
