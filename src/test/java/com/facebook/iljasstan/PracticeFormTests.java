package com.facebook.iljasstan;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.facebook.iljasstan.TestData.firstName;
import static com.facebook.iljasstan.TestData.lastName;

public class PracticeFormTests {

    @Test
    void practiceFormTest() {
        Configuration.browser = "opera";
        Configuration.startMaximized = true;
        // открыть страницу
        open("https://demoqa.com/automation-practice-form");
        // заполнить поле first name
        // заполнить поле last name
        // заполнить поле email
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("krot@krotov.com");
        // нажать радио-кнопку Male
        $("#gender-radio-1").parent().click();
        // заполнить поле Mobile number
        $("#userNumber").setValue("1234567890");
        //ввести дату рождения:
        //нажать на поле date of birth
        $("#dateOfBirthInput").click();
        //выбрать месяц: ноябрь
        $(".react-datepicker__month-select").selectOption("November");
        //выбрать год 1992
        $(".react-datepicker__year-select").selectOption("1992");
        //выбрать 7 ноября 1992
        $x("//*[@aria-label='Choose Saturday, November 7th, 1992']").click();
        //выбрать subject
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        //выбрать хобби
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-2").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        //загрузить картинку
        $("#uploadPicture").uploadFromClasspath("sezan.jpg");
        //ввести адрес
        $("#currentAddress").setValue("Street, house, flat");
        //проскроллить страницу
        $("#submit").scrollTo();
        //выбрать страну и город
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        // нажать Submit
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text("Krot Krotov"));
        $x("//td[text()='Student Email']").parent().shouldHave(text("krot@krotov.com"));
        $x("//td[text()='Gender']").parent().shouldHave(text("Male"));
        $x("//td[text()='Mobile']").parent().shouldHave(text("1234567890"));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text("07 November,1992"));
        $x("//td[text()='Subjects']").parent().shouldHave(text("Biology, Maths"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Sports, Reading, Music"));
        $x("//td[text()='Picture']").parent().shouldHave(text("sezan.jpg"));
        $x("//td[text()='Address']").parent().shouldHave(text("Street, house, flat"));
        $x("//td[text()='State and City']").parent().shouldHave(text("Rajasthan Jaipur"));
    }
}
