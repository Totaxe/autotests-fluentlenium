package com.example.fluentlenium.pages;

import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@PageUrl("/links/create")
public class AddLinkPage extends BasePage {

    @FindBy(id = "url")
    private FluentWebElement urlInput;

    @FindBy(id = "title")
    private FluentWebElement titleInput;
    
    @FindBy(id = "description")
    private FluentWebElement descriptionInput;
    
    @FindBy(css = "button[type=submit]")
    private FluentWebElement addLinkButton;

    public AddLinkPage typeUrl(String url) {
        log.info("Type url: {}", url);
        urlInput.write(url);
        return this;
    }

    public AddLinkPage typeTitle(String title) {
        log.info("Type title: {}", title);
        titleInput.write(title);
        return this;
    }

    public AddLinkPage typeDescription(String description) {
        log.info("Type description: {}", description);
        descriptionInput.write(description);
        return this;
    }

    public void clickAddLinkButton() {
        log.info("Click Add Link button");
        addLinkButton.click();
    }
}
