package com.example.fluentlenium.pages;

import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;
import lombok.experimental.Accessors;

@PageUrl("/lists/{listId}")
public class ListPage extends BasePage {
    
    @Getter @Accessors(fluent = true)
    @FindBy(className = "alert-success")
    private FluentWebElement successAlert;
}
