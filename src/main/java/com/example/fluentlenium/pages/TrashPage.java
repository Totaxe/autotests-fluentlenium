package com.example.fluentlenium.pages;

import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.openqa.selenium.support.FindBy;

import com.example.fluentlenium.components.TrashedLinkInfo;

import lombok.Getter;
import lombok.experimental.Accessors;

@PageUrl("/trash")
public class TrashPage extends BasePage {

    @Getter @Accessors(fluent = true)
    @FindBy(css = ".card:nth-of-type(2)")
    private FluentList<TrashedLinkInfo> trashedLinks;
}
