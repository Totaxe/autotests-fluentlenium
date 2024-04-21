package com.example.fluentlenium.config;

import org.fluentlenium.configuration.CapabilitiesFactory;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.fluentlenium.configuration.FactoryName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

@FactoryName("browserless")
public class BrowserlessCapabilitiesFactory implements CapabilitiesFactory {

    @Override
    public Capabilities newCapabilities(ConfigurationProperties config) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        // TODO Add window size settings to fluentlenium.properties
        chromeOptions.addArguments("--window-size=1400,900");
        return chromeOptions;
    }
}
