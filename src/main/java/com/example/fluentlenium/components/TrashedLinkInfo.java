package com.example.fluentlenium.components;

import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;
import lombok.experimental.Accessors;

public class TrashedLinkInfo extends FluentWebElement {

    public TrashedLinkInfo(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }
    
    @Getter @Accessors(fluent = true)
    @FindBy(css = "tbody td:first-child")
    private FluentWebElement linkUrl;
}
