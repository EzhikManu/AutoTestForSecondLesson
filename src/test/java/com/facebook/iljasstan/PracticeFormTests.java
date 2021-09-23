package com.facebook.iljasstan;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        $("#firstName").setValue("Krot");
        $("#lastName").setValue("Krotov");
        $("#userEmail").setValue("puya@muya.com");
        // нажать радио-кнопку Male
        $("#gender-radio-1 #::after").click();
        // заполнить поле Mobile number
        $("#userNumber").setValue("1234567890");
        //
        // нажать Submit
        $("#submit").click();
    }
}
