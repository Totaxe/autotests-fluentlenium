package com.example.fluentlenium.pages;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@PageUrl("/login")
public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private FluentWebElement emailInput;

    @FindBy(id = "password")
    private FluentWebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private FluentWebElement submitButton;

    @Override
    public void isAt() {
        super.isAt();
        assertThat(passwordInput).isDisplayed();
    }

    public void logIn(String email, String password) {
        log.info("Log in with username {} and password {}", email, password);
        emailInput.write(email);
        passwordInput.write(password);
        submitButton.click();
    }
}
