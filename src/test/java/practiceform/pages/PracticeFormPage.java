package practiceform.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import practiceform.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private final CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement
        firstName = $("#firstName"),
        lastName = $("#lastName"),
        userEmail = $("#userEmail"),
        gender = $("#genterWrapper"),
        hobby = $("#hobbiesWrapper"),
        userNumber = $("input#userNumber"),
        dateOfBirthInput = $("#dateOfBirthInput"),
        subject = $("#subjectsInput"),
        currentAddress = $("#currentAddress"),
        state = $("#state"),
        city = $("#city"),
        uploadPicButton = $("#uploadPicture"),
        submitButton = $("#submit");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        String TITLE_TEXT = "Practice Form";
        $("h1.text-center").shouldHave(text(TITLE_TEXT));
    }

    public void setFirstName(String value) {
        firstName.setValue(value);
    }

    public void setLastName(String value) {
        lastName.setValue(value);
    }

    public void setUserEmail(String value) {
        userEmail.setValue(value);
    }

    private void selectValueInWrapperSection(SelenideElement wrapperSection, String value) {
        wrapperSection.$(byText(value)).click();
    }

    public void setGender(String value) {
        selectValueInWrapperSection(gender, value);
    }

    public void setHobbies(String value) {
        selectValueInWrapperSection(hobby, value);
    }

    public void setUserNumber(String value) {
        userNumber.setValue(value);
    }

    public void setBirthDate(String month, String day, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(month, day, year);
    }

    public void setSubject(String value) {
        subject.setValue(value.substring(0,1));
        $(byText(value)).shouldBe(visible).click();
    }

    public void setCurrentAddress(String value) {
        currentAddress.setValue(value);
    }

    public void setState(String value) {
        state.click();
        $(byText(value)).shouldBe(visible).click();
    }

    public void setCity(String value) {
        city.click();
        $(byText(value)).shouldBe(visible).click();
    }

    public void uploadPicture(File file) {
        uploadPicButton.uploadFile(file);
    }

    public void submit() {
        submitButton.click();
    }

}
