package com.example.fluentlenium.pages;

import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@PageUrl("/lists/create")
public class AddListPage extends BasePage {
    
    @FindBy(id = "name")
    private FluentWebElement nameInput;
    
    @FindBy(css = "button[type=submit]")
    private FluentWebElement addListButton;

    public AddListPage typeName(String name) {
        log.info("Type name: {}", name);
        nameInput.write(name);
        return this;
    }

    public void clickAddListButton() {
        log.info("Click Add List button");
        addListButton.click();
    }
}
