package jp.sample;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

public class GoogleTest {

    @Before
    public void before(){
        Configuration.browser = WebDriverRunner.CHROME;

        //chromedriver.exe���_�E�����[�h���āA�v���W�F�N�g�����ɔz�u���邱�ƁB
        //https://sites.google.com/a/chromium.org/chromedriver/downloads
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test
    public void test() {
        open("https://www.google.co.jp/");
        $("#lst-ib").val("selenide").pressEnter();

        $(By.linkText("Selenide: concise UI tests in Java")).click();

        $("body").shouldHave(text("What is Selenide?"));
    }

}
