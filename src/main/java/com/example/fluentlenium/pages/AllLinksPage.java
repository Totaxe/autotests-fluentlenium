package com.example.fluentlenium.pages;

import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.openqa.selenium.support.FindBy;

import com.example.fluentlenium.components.LinkInfo;

import lombok.Getter;
import lombok.experimental.Accessors;

@PageUrl("/links")
public class AllLinksPage extends BasePage {
    
    @Getter @Accessors(fluent = true)
    @FindBy(css = ".link-wrapper > .card")
    private FluentList<LinkInfo> links;
}
