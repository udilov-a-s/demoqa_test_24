package com.udilov.it;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {

    @BeforeAll
    static void configuration() {
        Configuration.browserSize = "640x480";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void allFieldsFilledCorrectlyTest() {

        //test data
        String firstName = "Alex";
        String lastName = "Udilov";
        String email = "example@examplemail.com";
        String gender = "Male";
        String mobileNumber = "9987654321";
        String day = "11";
        String month = "February";
        String year = "2020";
        String subjects = "Biology";
        String hobbies = "Sports";
        String picture = "picture.jpg";
        String currentAddress = "world";
        String state = "NCR";
        String city = "Delhi";

        //Preconditions
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //Name filling
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        //Email filling
        $("#userEmail").setValue(email);

        //Gender filling
        $("#genterWrapper").$(byText(gender)).click();

        //Mobile filling
        $("#userNumber").setValue(mobileNumber);

        //Date of Birth filling
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        String dateSelector = ".react-datepicker__day--0" + day;
        $(dateSelector + "[aria-label *= " + month + "]").click();

        //Subjects filling
        $("#subjectsInput").setValue(subjects).pressEnter();

        //Hobbies filling
        $("#hobbiesWrapper").$(byText(hobbies)).click();

        //Picture filling
        $("#uploadPicture").uploadFromClasspath(picture);

        //Current Address filling
        $("#currentAddress").setValue(currentAddress);

        //State and City filling
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();

        //Results checking
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text(firstName + " " + lastName));
        $(".table").shouldHave(text(email));
        $(".table").shouldHave(text(gender));
        $(".table").shouldHave(text(mobileNumber));
        $(".table").shouldHave(text(day + " " + month + "," + year));
        $(".table").shouldHave(text(subjects));
        $(".table").shouldHave(text(hobbies));
        $(".table").shouldHave(text(picture));
        $(".table").shouldHave(text(currentAddress));
        $(".table").shouldHave(text(state + " " + city));
        $("#closeLargeModal").shouldBe(visible);
    }
}