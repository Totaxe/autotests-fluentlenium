package com.example.fluentlenium.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.support.FindBy;

import com.example.fluentlenium.components.Header;

import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasePage extends FluentPage {

    @Getter @Accessors(fluent = true)
    @FindBy(css = "nav.navbar")
    private Header header;

    @Override
    public void isAt() {
        log.info("Check that {} is loaded", this.getClass().getSimpleName());
        super.isAt();
    }
}
