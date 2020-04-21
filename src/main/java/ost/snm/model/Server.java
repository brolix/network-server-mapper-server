package ost.snm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ost.snm.contracts.Configurable;
import ost.snm.contracts.Hashable;

@Document
@Getter
@NoArgsConstructor
public class Server implements Configurable, Hashable {

    @Id
    private String id;

    private byte ip;
    private JsonSettings settings;

    public Server(byte ip, JsonSettings settings) {
        this.ip = ip;
        this.settings = settings;
    }

    @Override
    public JsonSettings getSettings() {
        return this.settings;
    }

    @Override
    public String getHash() {
        return id;
    }
}
