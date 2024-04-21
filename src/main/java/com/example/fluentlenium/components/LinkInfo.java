package com.example.fluentlenium.components;

import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkInfo extends FluentWebElement {

    public LinkInfo(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }
    
    @Getter @Accessors(fluent = true)
    @FindBy(css = ".link-thumbnail-list-holder ~ div a")
    private FluentWebElement titleLink;

    @FindBy(css = "button[title='Delete Link']")
    private FluentWebElement deleteLinkButton;

    public void clickDeleteLinkButton() {
        log.info("Click Delete Link button");
        deleteLinkButton.click();
    }
}
