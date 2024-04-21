package com.example.fluentlenium.components;

import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Header extends FluentWebElement {

    public Header(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

    @FindBy(partialLinkText = "Add Link")
    private FluentWebElement addLinkButton;

    @FindBy(linkText = "All Links")
    private FluentWebElement allLinksButton;

    @FindBy(linkText = "Lists")
    private FluentWebElement listsButton;
    
    @FindBy(linkText = "Add List")
    private FluentWebElement addListButton;

    @FindBy(css = "a[title='Trash']")
    private FluentWebElement trashButton;

    @FindBy(xpath = "(//ul[contains(@class, 'navbar-nav')])[2]/li[3]")
    private FluentWebElement profileButton;
    
    @FindBy(linkText = "Export")
    private FluentWebElement exportButton;

    public void clickAddLinkButton() {
        log.info("Click Add Link button");
        addLinkButton.click();
    }

    public void clickAllLinksButton() {
        log.info("Click All Links button");
        allLinksButton.click();
    }

    public void clickTrashButton() {
        log.info("Click Trash button");
        trashButton.click();
    }

    public void clickAddListButton() {
        log.info("Click Add List button");
        listsButton.click();
        addListButton.click();
    }

    public void clickExportButton() {
        log.info("Click Export button");
        profileButton.click();
        exportButton.click();
    }
}
