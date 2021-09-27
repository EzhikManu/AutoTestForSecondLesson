package com.facebook.iljasstan.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.facebook.iljasstan.pages.components.Calendar;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            radioGender = $("#gender-radio-1"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            radioSports = $("#hobbies-checkbox-1"),
            radioReading = $("#hobbies-checkbox-2"),
            radioMusic = $("#hobbies-checkbox-3"),
            currentAddressInput = $("#currentAddress"),
            submitButton = $("#submit");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(Condition.text(FORM_TITLE));
    }
    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }
    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }
    public void setUserEmail(String value) {
        userEmailInput.setValue(value);
    }
    public void setRadioGender() {
        radioGender.parent().click();
    }
    public void setUserNumber(String value) {
        userNumberInput.setValue(value);
    }
    public Calendar calendar = new Calendar();

    public void fillSubjects(String value) {
        subjectInput.setValue(value).pressEnter();
    }
    public void chooseSports() {
        radioSports.parent().click();
    }
    public void chooseReading() {
        radioReading.parent().click();
    }
    public void chooseMusic() {
        radioMusic.parent().click();
    }
    public void setCurrentAddress(String value) {
        submitButton.scrollTo();
        currentAddressInput.setValue(value);
    }


}
