package practiceform;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import practiceform.pages.PracticeFormPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormUsingPageObjectTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    File tempPic = new File("src/test/resources/78654345.png");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        practiceFormPage.openPage();

        practiceFormPage.setFirstName("Egor");
        practiceFormPage.setLastName("Voronov");
        practiceFormPage.setUserEmail("voronov@gmail.com");

        practiceFormPage.setGender("Male");
        practiceFormPage.setUserNumber("88005553535");

        practiceFormPage.setBirthDate("6", "30", "2008");

        practiceFormPage.setSubject("Maths");
        practiceFormPage.setHobbies("Sports");

        practiceFormPage.uploadPicture(tempPic);

        practiceFormPage.setCurrentAddress("43 Raymouth Rd. Baltemoer, London 3910");
        practiceFormPage.setState("NCR");
        practiceFormPage.setCity("Noida");
        $("#submit").click();

    }
}
