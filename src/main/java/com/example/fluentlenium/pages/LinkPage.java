package com.example.fluentlenium.pages;

import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;
import lombok.experimental.Accessors;

@PageUrl("/links/{linkId}")
public class LinkPage extends BasePage {

    @Getter @Accessors(fluent = true)
    @FindBy(css = ".alert-success")
    private FluentWebElement successAlert;

    @Getter @Accessors(fluent = true)
    @FindBy(xpath = "(//main//a)[1]")
    private FluentWebElement linkNameField;

    public int getLinkId() {
        return Integer.valueOf(getParam("linkId"));
    }
}
