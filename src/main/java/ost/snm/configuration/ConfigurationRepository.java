package ost.snm.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ConfigurationRepository {

    private final int pingDelay;
    private final int pingThreads;

    public ConfigurationRepository(@Value("${manager.ping.timer.delay:4000}") int pingDelay,
                                   @Value("${manager.ping.threads:4}") int pingThreads) {
        this.pingDelay = pingDelay;
        this.pingThreads = pingThreads;
        System.out.println("Ping delay configuration is set to: " + pingDelay);
        System.out.println("Ping threads configuration is set to: " + pingThreads);
    }
}
