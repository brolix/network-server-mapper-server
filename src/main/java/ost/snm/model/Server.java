package ost.snm.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ost.snm.contracts.Configurable;
import ost.snm.contracts.Hashable;

@Data
@NoArgsConstructor
public class Server implements Configurable, Hashable {

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
        return String.valueOf(hashCode());
    }
}
