package com.facebook.iljasstan.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.facebook.iljasstan.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class Calendar extends RegistrationPage {
    private SelenideElement
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select");
    public RegistrationPage setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        String selector = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";
        String formattedSelector = String.format(selector, day);
        $(formattedSelector).click();
        return this;
    }

}
