package com.example.fluentlenium;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.Test;

import com.example.fluentlenium.pages.AddListPage;
import com.example.fluentlenium.pages.DashboardPage;
import com.example.fluentlenium.pages.ListPage;

public class ListTest extends BaseTest {

    @Page
    DashboardPage dashboardPage;

    @Page
    AddListPage addListPage;

    @Page
    ListPage listPage;

    @Test
    public void createList() {
        dashboardPage.header().clickAddListButton();
        addListPage.isAt();
        addListPage.typeName("Guides")
                .clickAddListButton();
        listPage.isAt();
        assertThat(listPage.successAlert()).isDisplayed();
    }
}
