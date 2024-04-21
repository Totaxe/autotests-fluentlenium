package com.example.fluentlenium.pages;

import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@PageUrl("/dashboard")
public class DashboardPage extends BasePage {

    @FindBy(id = "url")
    private FluentWebElement urlInput;

    @FindBy(css = "#url ~ button")
    private FluentWebElement quickAddLinkButton;

    public DashboardPage typeUrl(String url) {
        log.info("Type url: {}", url);
        urlInput.write(url);
        return this;
    }

    public void clickQuickAddLinkButton() {
        log.info("Click Quick Add Link button");
        quickAddLinkButton.click();
    }
}
