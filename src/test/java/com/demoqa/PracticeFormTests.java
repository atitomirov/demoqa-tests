package com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {
    @Test
    void successfulRegistrationTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Captain");
        $("#lastName").setValue("America");
        $("#userEmail").setValue("example@mrak.gnu");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8005577744");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__day--0" + "01").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg"));
        $("#currentAddress").setValue("LasVegas");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".table").shouldHave(
                text("Captain America"),
                text("example@mrak.gnu"),
                text("Male"),
                text("8005577744"),
                text("01 January,2000"),
                text("English"),
                text("Sports, Reading, Music"),
                text("1.jpg"),
                text("LasVegas"),
                text("Haryana Karnal")
        );

    }

}
