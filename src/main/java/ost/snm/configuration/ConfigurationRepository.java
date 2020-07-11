package ost.snm.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Getter
@Component
public class ConfigurationRepository {

    private final int pingDelay;
    private final int pingThreads;
    private File pingPathSerialize;

    public ConfigurationRepository(@Value("${manager.ping.timer.delay:4000}") int pingDelay,
                                   @Value("${manager.ping.threads:4}") int pingThreads,
                                   @Value("${manager.ping.path.serialize}") String pingPathSerialize) {
        this.pingDelay = pingDelay;
        this.pingThreads = pingThreads;
        this.pingPathSerialize = new File(pingPathSerialize);
        System.out.println("Ping delay configuration is set to: " + pingDelay);
        System.out.println("Ping threads configuration is set to: " + pingThreads);
        System.out.println("Ping Serialization path is set to : "+pingPathSerialize);
    }
}
