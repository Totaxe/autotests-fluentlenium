package com.example.fluentlenium.config;

import java.util.Map;

import org.fluentlenium.configuration.CapabilitiesFactory;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.fluentlenium.configuration.FactoryName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

@FactoryName("selenoid")
public class SelenoidCapabilitiesFactory implements CapabilitiesFactory {

    @Override
    public Capabilities newCapabilities(ConfigurationProperties configuration) {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true));
        return options;
    }
}
