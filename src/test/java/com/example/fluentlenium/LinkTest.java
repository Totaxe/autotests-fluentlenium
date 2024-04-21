package com.example.fluentlenium;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

import java.io.IOException;

import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.Test;

import com.example.fluentlenium.pages.AddLinkPage;
import com.example.fluentlenium.pages.AllLinksPage;
import com.example.fluentlenium.pages.DashboardPage;
import com.example.fluentlenium.pages.LinkPage;
import com.example.fluentlenium.pages.TrashPage;
import com.example.fluentlenium.retrofit.entities.Link;
import com.example.fluentlenium.services.TestDataService;

class LinkTest extends BaseTest {

    @Page
    DashboardPage dashboardPage;

    @Page
    LinkPage linkPage;

    @Page
    AddLinkPage addLinkPage;

    @Page
    AllLinksPage allLinksPage;

    @Page
    TrashPage trashPage;

    @Test
    void quickAddLink() {
        dashboardPage.typeUrl("https://google.com")
                .clickQuickAddLinkButton();
        linkPage.isAt();
        assertThat(linkPage.getLinkId()).isEqualTo(1);
        assertThat(linkPage.successAlert()).isDisplayed();
        assertThat(linkPage.linkNameField()).hasAttributeValue("href", "https://google.com/");
    }

    @Test
    void addLink() {
        dashboardPage.header().clickAddLinkButton();
        addLinkPage.isAt();
        addLinkPage.typeUrl("https://youtube.com")
                .typeTitle("Youtube")
                .typeDescription("Video hosting")
                .clickAddLinkButton();
        linkPage.isAt();
        assertThat(linkPage.successAlert()).isDisplayed();
        assertThat(linkPage.linkNameField()).hasAttributeValue("href", "https://youtube.com/");
    }

    @Test
    public void deleteLink() throws IOException {
        TestDataService.createLink(new Link()
                .url("https://amazon.com")
                .title("Amazon")
                .description("Free shipping on millions of items"));
        TestDataService.createLink(new Link()
                .url("https://youtube.com")
                .title("Youtube")
                .description("Video hosting"));

        dashboardPage.header().clickAllLinksButton();
        allLinksPage.isAt();
        assertThat(allLinksPage.links()).hasSize(2);
        allLinksPage.links().get(0).clickDeleteLinkButton();
        assertThat(allLinksPage.links()).hasSize(1);
        allLinksPage.header().clickTrashButton();
        trashPage.isAt();
        assertThat(trashPage.trashedLinks()).hasSize(1);
        assertThat(trashPage.trashedLinks().get(0).linkUrl()).hasText("https://youtube.com");
    }
}
