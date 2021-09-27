package com.facebook.iljasstan;

import com.codeborne.selenide.Configuration;
import com.facebook.iljasstan.pages.RegistrationPage;
import com.facebook.iljasstan.pages.components.Calendar;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.facebook.iljasstan.TestData.*;


public class PracticeFormWithPageObjectsTests {
    RegistrationPage page = new RegistrationPage();

    @Test
    void practiceFormTest() {
        Configuration.browser = "opera";
        Configuration.startMaximized = true;
        page.openPage();
        page.setFirstName(firstName);
        page.setLastName(lastName);
        page.setUserEmail(userEmail);
        page.setRadioGender();
        page.setUserNumber(userNumber);
        page.calendar.setDate("07","November", "1992");
        page.fillSubjects(subject1);
        page.fillSubjects(subject2);
        page.chooseSports();
        page.chooseReading();
        page.chooseMusic();
        //$("#uploadPicture").uploadFromClasspath("sezan.jpg");
        page.setCurrentAddress(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text("Krot Krotov"));
        $x("//td[text()='Student Email']").parent().shouldHave(text("krot@krotov.com"));
        $x("//td[text()='Gender']").parent().shouldHave(text("Male"));
        $x("//td[text()='Mobile']").parent().shouldHave(text("1234567890"));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text("07 November,1992"));
        $x("//td[text()='Subjects']").parent().shouldHave(text("Biology, Maths"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Sports, Reading, Music"));
        //$x("//td[text()='Picture']").parent().shouldHave(text("sezan.jpg"));
        $x("//td[text()='Address']").parent().shouldHave(text("Street, house, flat"));
        $x("//td[text()='State and City']").parent().shouldHave(text("Rajasthan Jaipur"));
    }

}
