package com.udilovAit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {

    @BeforeAll
    static void configuration() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void allFieldsFilledCorrectlyTest() {

        //test data
        String firstName = "Alex";
        String lastName = "Udilov";
        String email = "exsample@exsampleemail.com";
        String gender = "Male";
        String mobileNumber = "9987654321";
        String date = "11";
        String month = "december";
        String year = "2023";
        String subjects = "Biology";
        String hobbies = "Sports";
        String picture = "picture.jpg";
        String currentAddress = "world";
        String state = "NCR";
        String city = "Delhi";

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);

        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();

        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();





        //open("https://demoqa.com/automation-practice-form");
    }
}
