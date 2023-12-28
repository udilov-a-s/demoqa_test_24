package com.udilovAit;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    public  class demoqaTest() {
        
    }
    @Test
    void firstTest() {

        //test data
        String firstName = "Alex";
        String lastName = "Udilov";
        String email = "exsample@exsamplemail.com";
        String gender = "Male";
        String mobileNumber = "9987654321";
        String date = "11";
        String month = "december";
        String year = "2023";
        String subjects = "Biology";
        String hobbies = "Sports";
        String picture = "picture.jpg";
        String currentAddress = "world";





        open("https://demoqa.com/automation-practice-form");
    }
}
